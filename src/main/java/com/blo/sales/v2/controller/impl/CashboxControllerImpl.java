package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IActivesCostsController;
import com.blo.sales.v2.controller.ICashboxController;
import com.blo.sales.v2.controller.ICashboxesActivesCostsController;
import com.blo.sales.v2.controller.ICashboxesSalesController;
import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.controller.pojos.PojoIntCashbox;
import com.blo.sales.v2.controller.pojos.PojoIntCashboxesActivesCosts;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxes;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesDetails;
import com.blo.sales.v2.controller.pojos.enums.CashboxStatusIntEnum;
import com.blo.sales.v2.controller.pojos.enums.SalesStatusIntEnum;
import com.blo.sales.v2.model.ICashboxModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CashboxControllerImpl implements ICashboxController {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxControllerImpl.class.getName());
    
    @Inject
    private IActivesCostsController activesCostsController;
    
    @Inject
    private ICashboxModel model;
    
    @Inject
    private ICashboxesActivesCostsController cashboxesAactivesCostsController;
    
    @Inject
    private ISalesController salesController;
    
    @Inject
    private ICashboxesSalesController cashboxesSalesController;
    
    @Override
    public PojoIntCashbox addCashbox(PojoIntCashbox cashbox) throws BloSalesV2Exception {
        logger.info("creando caja de dinero");
        return model.addCashbox(cashbox);
    }

    @Override
    public PojoIntCashbox getOpenCashbox() throws BloSalesV2Exception {
        logger.info("recuperando caja abierta");
        return model.getOpenCashbox();
    }

    @Override
    public PojoIntCashbox updateCAshbox(PojoIntCashbox cashbox, long idCashbox) throws BloSalesV2Exception {
        logger.info("actualizando cashbox byId = %s", idCashbox);
        return model.updateCashbox(cashbox, idCashbox);
    }
    
    @Override
    public WrapperPojoIntCashboxes getAllCashboxes() throws BloSalesV2Exception {
        logger.info("recuperando todas las cashbox");
        return model.getAllCashboxes();
    }

    @Override
    public PojoIntCashbox closeCashbox(PojoIntCashbox cashbox, WrapperPojoIntActivesCosts activesCosts) throws BloSalesV2Exception {
        cashbox.setStatus(CashboxStatusIntEnum.CLOSE);
        logger.info("cerrando caja %s", String.valueOf(cashbox));
        updateCAshbox(cashbox, cashbox.getIdCashbox());
        logger.info("guardando costos %s", activesCosts.getActivesCosts().size());
        if (activesCosts.getActivesCosts() != null && !activesCosts.getActivesCosts().isEmpty()) {
            final var saved = activesCostsController.addActiveCost(activesCosts);
            logger.info("se han guardado los activos y costos %s", saved.getActivesCosts().size());
            // guardar las relaciones
            for (final var ac: saved.getActivesCosts()) {
                final var item = new PojoIntCashboxesActivesCosts();
                item.setFkActivesCosts(ac.getIdActiveCosts());
                item.setFkCashbox(cashbox.getIdCashbox());
                item.setTimestamp(cashbox.getTimestamp());
                final var relationSaved = cashboxesAactivesCostsController.addRelationship(item);
                logger.info("relacion guardada en la db [%s]", String.valueOf(relationSaved));
            }
        }
        // cerrar ventas del dia
        logger.info("cerrando ventas del dia");
        final var sales = salesController.retrieveSalesDataByStatus(SalesStatusIntEnum.CLOSE);
        if (sales.getSales() != null && !sales.getSales().isEmpty()) {
            for (final var s: sales.getSales()) {
                salesController.setCashboxSale(s.getIdSale());
                // guardando relacion caja de dinero - venta
                cashboxesSalesController.addCashboxSale(cashbox.getIdCashbox(), s.getIdSale());
            }
        }
        return cashbox;
    }

    @Override
    public WrapperPojoIntCashboxesDetails getCashboxesDetail() throws BloSalesV2Exception {
        logger.info("recuperando detalles de caja");
        return model.getCashboxesDetail();
    }

}

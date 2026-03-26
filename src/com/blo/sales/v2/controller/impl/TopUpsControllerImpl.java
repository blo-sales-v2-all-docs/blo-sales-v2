package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.controller.ITopUpsController;
import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.model.ITopUpModel;
import com.blo.sales.v2.model.impl.TopUpModelImpl;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;

public class TopUpsControllerImpl implements ITopUpsController {
    
    private static final GUILogger logger = GUILogger.getLogger(TopUpsControllerImpl.class.getName());
    
    private static final ITopUpModel model = TopUpModelImpl.getInstance();
    
    private static final IMobileCompanyController mobileCompanyController = MobileCompanyControllerImpl.getInstance();
    
    private static final ISalesController salesController = SalesControllerImpl.getInstance();
    
    private static TopUpsControllerImpl instance;
    
    private TopUpsControllerImpl() { }
    
    public static TopUpsControllerImpl getInstance() {
        if (instance == null) {
            instance = new TopUpsControllerImpl();
        }
        return instance;
    }

    @Override
    public PojoIntTopUp addTopUp(PojoIntTopUp data, long idCompany) throws BloSalesV2Exception {
        logger.log(String.format("guardando recarga telefonica", String.valueOf(data)));
        final var companyFound = mobileCompanyController.getCompanyMobileById(idCompany);
        logger.log(String.format("Compania encontrada %s", String.valueOf(companyFound)));
        BloSalesV2Utils.validateRule(companyFound == null, BloSalesV2Utils.CODE_COMPANY_NOT_FOUND, BloSalesV2Utils.ERROR_COMPANY_NOT_FOUND);
        data.setFkMobileCompany(companyFound);
        // guardando comision
        salesController.registerTopUpComission(data.getFkUser().getIdUser());
        logger.log("comision guardada");
        return model.addTopUp(data);
    }

    @Override
    public WrapperPojoIntTopUp closeTopUps(WrapperPojoIntTopUp topUps) throws BloSalesV2Exception {
        logger.log(String.format("actualizando topUps %s", topUps.getTopUps().size()));
        if (topUps.getTopUps() != null && !topUps.getTopUps().isEmpty()) {
            for(final var element: topUps.getTopUps()) {
                element.setChecked(true);
                model.updateTopUp(element, element.getIdTopUp());
            }
            logger.log("Se han cerrado las recargas");
        }
        return topUps;
    }

    @Override
    public WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception {
        logger.log(String.format("buscando recargas por estatus %s", String.valueOf(status)));
        return model.getTopUpsByStatus(status);
    }
}

package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import jakarta.inject.Singleton;
import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.model.IOrdersVendorsModel;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import java.time.LocalDate;

@Singleton
public class OrdersVendorsControllerImpl implements IOrdersVendorsController {
    
    private static final GUILogger logger = GUILogger.getLogger(OrdersVendorsControllerImpl.class.getName());
    
    @Inject
    private IOrdersVendorsModel model;
    
    @Inject
    private IDBTransactionManagerController dbTransactionManager;

    @Override
    public PojoIntOrderVendor highOrder(PojoIntOrderVendor order) throws BloSalesV2Exception {
        try {
            // desactivar la funcion para guardar en la db
            dbTransactionManager.disableAutocommit();
            logger.info("guardando orden %s", String.valueOf(order));
            // validar que sea fecha valida
            final var deadLine = LocalDate.parse(order.getDeadline());
            final var now = LocalDate.now();
            BloSalesV2Utils.validateRule(deadLine.isBefore(now), BloSalesV2Utils.CODE_ORDER_IS_BEFORE_NOW, BloSalesV2Utils.ERROR_ORDER_IS_BEFORE_NOW);
            // setter invoice como PENDING
            order.setStatusOrder(StatusMovementProviderIntEnum.PENDIG);
            order.setTimestamp(BloSalesV2Utils.getTimestamp());
            order.setInvoice(StatusMovementProviderIntEnum.PENDIG.toString());
            // se guarda orden
            final var orderSaved = model.addOrder(order);
            logger.info("Orden guardada %s", String.valueOf(orderSaved));
            dbTransactionManager.doCommit();
            return orderSaved;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbTransactionManager.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbTransactionManager.enableAutocommit();
        }
    }

    @Override
    public PojoIntOrderVendor closeOrder(StatusMovementProviderIntEnum reason, String invoice, long idOrder) throws BloSalesV2Exception {
        try {
            // desactivar la funcion para guardar en la db
            dbTransactionManager.disableAutocommit();
            // recuperar orden
            final var orderFound = getOrderById(idOrder);
            BloSalesV2Utils.validateRule(orderFound == null, BloSalesV2Utils.CODE_ORDER_NOT_FOUND, BloSalesV2Utils.ERROR_ORDER_NOT_FOUND);
            orderFound.setStatusOrder(reason);
            if (reason.equals(StatusMovementProviderIntEnum.CANCELLED)) {
                orderFound.setInvoice(BloSalesV2Utils.N_A);
            }
            if (reason.equals(StatusMovementProviderIntEnum.DELIVERED)) {
                orderFound.setInvoice(invoice);
            }
            orderFound.setTimestamp(BloSalesV2Utils.getTimestamp());
            logger.info("guardando informacion de orden %s", String.valueOf(orderFound));
            final var orderUpdated = model.updateOrder(orderFound);
            logger.info("informacion actualizada %s", String.valueOf(orderUpdated));
            dbTransactionManager.doCommit();
            return orderUpdated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbTransactionManager.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbTransactionManager.enableAutocommit();
        }
    }

    @Override
    public WrapperPojoIntOrdersVendors getOrders() throws BloSalesV2Exception {
        logger.info("recuperando todas las ordenes");
        return model.getOrders();
    }

    @Override
    public PojoIntOrderVendor getOrderById(long idOrder) throws BloSalesV2Exception {
        logger.info("recuperando orden por id=%s", idOrder);
        return model.getOrderById(idOrder);
    }

}
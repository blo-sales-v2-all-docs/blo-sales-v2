package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.model.IVendorsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class VendorsControllerImpl implements IVendorsController {
    
    private static final GUILogger logger = GUILogger.getLogger(VendorsControllerImpl.class.getName());
    
    @Inject
    private IVendorsModel vendorsModel;
    
    @Inject
    private IDBTransactionManagerController dbt;

    @Override
    public PojoIntVendor addVendor(PojoIntVendor vendor) throws BloSalesV2Exception {
        try {
            logger.info("guardando proveedor %s", String.valueOf(vendor));
            if (vendor.getVisitDays().equals("[]")) {
                logger.error("Dias de visita no deben estar vacios");
                throw new BloSalesV2Exception(BloSalesV2Utils.CODE_VENDOR_VISIT_DAYS_NOT_EMPTY, BloSalesV2Utils.ERROR_VENDOR_VISIT_DAYS_NOT_EMPTY);
            }
            dbt.disableAutocommit();
            final var contactVendor = getVendorByContact(vendor.getContact());
            BloSalesV2Utils.validateRule(contactVendor != null, BloSalesV2Utils.CODE_VENDOR_CONTACT_EXISTS, BloSalesV2Utils.ERROR_VENDOR_CONTACT_EXISTS);
            vendor.setTimestamp(BloSalesV2Utils.getTimestamp());
            final var vendorSaved = vendorsModel.addVendor(vendor);
            dbt.doCommit();
            logger.info("proveedor guardado %s", String.valueOf(vendorSaved));
            return vendorSaved;
        } catch(BloSalesV2Exception e) {
            dbt.doRollback();
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(e.getCode(), e.getMessage());
        } finally {
            dbt.enableAutocommit();
        }
    }

    @Override
    public PojoIntVendor getVendorByContact(String contact) throws BloSalesV2Exception {
        logger.info("recuperando informacion de proveedor por contacto: %s", contact);
        return vendorsModel.getVendorByContact(contact);
    }

    @Override
    public PojoIntVendor getVendorById(long id) throws BloSalesV2Exception {
        logger.info("recuperando informacion de proveedor por id: %s", id);
        return vendorsModel.getVendorById(id);
    }

    @Override
    public WrapperPojoIntVendors getAllVendors() throws BloSalesV2Exception {
        logger.info("recuperando a todos los proveedores");
        return vendorsModel.getAllVendors();
    }

    @Override
    public PojoIntVendor updateVendor(PojoIntVendor vendorData, long idVendor) throws BloSalesV2Exception {
        try {
            logger.info("actualizando informacion de proveedor proveedor %s", String.valueOf(vendorData));
            dbt.disableAutocommit();
            final var vendorFound = getVendorById(idVendor);
            logger.info("proveedor encontrado %s", String.valueOf(vendorFound));
            BloSalesV2Utils.validateRule(vendorFound == null, BloSalesV2Utils.CODE_VENDOR_NOT_EXITS, BloSalesV2Utils.ERROR_VENDOR_NOT_EXITS);
            vendorFound.setBrand(vendorData.getBrand());
            vendorFound.setContact(vendorData.getContact());
            vendorFound.setTimestamp(BloSalesV2Utils.getTimestamp());
            vendorFound.setVisitDays(vendorData.getVisitDays());
            vendorFound.setPreSale(vendorData.isPreSale());
            final var debtorUpdated = vendorsModel.updateVendor(vendorData, idVendor);
            logger.info("datos de proveedor actualizado [%s]", String.valueOf(debtorUpdated));
            dbt.doCommit();
            return debtorUpdated;
        } catch(BloSalesV2Exception e) {
            dbt.doRollback();
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(e.getCode(), e.getMessage());
        } finally {
            dbt.enableAutocommit();
        }
    }
    
}

package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.controller.pojos.enums.VisitIntEnum;
import com.blo.sales.v2.model.IVendorsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
            dbt.disableAutocommit();
            
            logger.info("guardando proveedor %s", String.valueOf(vendor));
            
            BloSalesV2Utils.validateRule(
                    vendor.isPerWeek() && vendor.getVisitDays().equals(BloSalesV2Utils.JSON_EMPTY_ARRAY),
                    BloSalesV2Utils.CODE_VENDOR_VISIT_DAYS_NOT_EMPTY,
                    BloSalesV2Utils.ERROR_VENDOR_VISIT_DAYS_NOT_EMPTY
            );
            
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
            vendorFound.setVisits(VisitIntEnum.valueOf(vendorData.getVisits().name()));
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

    @Override
    public WrapperPojoIntVendors getVendorsFromToday() throws BloSalesV2Exception {
        try {
            final var allVendors = getAllVendors();
            if (allVendors.getVendors() != null && !allVendors.getVendors().isEmpty()) {
                final var gson = new Gson();
                // proveedores por semana
                final var today = LocalDate.now();
                final var translate = Locale.forLanguageTag("es-ES");
                logger.info("fecha de hoy %s", today);
                final var day = today.getDayOfWeek().getDisplayName(TextStyle.FULL, translate).toLowerCase();
                final var vendorsToDay = allVendors.getVendors().stream().
                        filter(v -> v.isPerWeek()).
                        filter(vendor -> !List.of(gson.fromJson(vendor.getVisitDays(), String[].class)).stream().
                                            map(String::toLowerCase).
                                            filter(d -> d.equals(day)).
                                            toList().
                                            isEmpty()
                        ).collect(Collectors.toList());
                logger.info("proveedores del dia %s", vendorsToDay.size());
                // proveedores por mes
                final var vendorsByMonth = allVendors.getVendors().stream()
                    .filter(v -> !v.isPerWeek()) // Filtra solo los que NO son semanales (mensuales)
                    .filter(vendor -> {
                        try {
                            // fecha del vendendor parseada
                            final var parsedDateFromVendor = 
                                    LocalDateTime.parse(vendor.getTimestamp(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                            // día de visita
                            final var dayOfVisitCalendar = parsedDateFromVendor.getDayOfMonth();
                            // día actual
                            final var currentDayOfMonth = today.getDayOfMonth();
                            // ultimo dia del mes
                            final var lastDayOfMonth = YearMonth.from(parsedDateFromVendor).lengthOfMonth();
                            if (currentDayOfMonth == lastDayOfMonth) {
                                return dayOfVisitCalendar >= currentDayOfMonth;
                            }
                            return dayOfVisitCalendar == currentDayOfMonth;
                        } catch (Exception e) {
                            return false; 
                        }
                    }).
                    collect(Collectors.toList());
                logger.info("vendedores que pasaran el dia de hoy por día del mes %s", vendorsByMonth.size());
                 vendorsToDay.addAll(vendorsByMonth);
                 logger.info("proveedores que pasarán hoy %s", vendorsToDay.size());
                 allVendors.setVendors(vendorsToDay);
            }
            return allVendors;
        } catch(BloSalesV2Exception e) {
            dbt.doRollback();
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(e.getCode(), e.getMessage());
        }
    }
    
}

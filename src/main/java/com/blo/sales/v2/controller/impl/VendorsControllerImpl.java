package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.controller.pojos.enums.VisitIntEnum;
import com.blo.sales.v2.model.IVendorsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.components.CheckboxDays;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private IOrdersVendorsController ordersVendorsController;
    
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
            vendorFound.setReminder(vendorData.getReminder());
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
    public WrapperPojoIntVendors addOrderVendorAsDraft() throws BloSalesV2Exception {
        try {
            final var allVendors = getAllVendors();
            if (allVendors.getVendors() != null && !allVendors.getVendors().isEmpty()) {
                final Gson gson = new Gson();
                final LocalDate today = LocalDate.now();
                final List<PojoIntVendor> vendorsFiltered = allVendors.getVendors().stream().
                    // filtra los que tienen recordatorio
                    filter(v -> {
                        if (v.getReminder().isBlank() || v.getReminder().equals(BloSalesV2Utils.JSON_EMPTY_ARRAY)) {
                            return false;
                        }
                        try {
                            // 2. Deserializar
                            String[] days = gson.fromJson(v.getReminder(), String[].class);
                            // 3. Confirmar que el arreglo no sea nulo y tenga al menos un elemento
                            return days != null && days.length > 0;
                        } catch (Exception e) {
                            // Prevenir fallos si el JSON está malformado
                            return false;
                        }
                    }).
                    // filtrar los proveedores que pasaran hoy
                    filter(v -> {
                        // caso cuando el recordatorio es mensua y por fechas
                        if (v.getVisits().compareTo(VisitIntEnum.MONTHLY) == 0 && BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.ONLY_NUMBERS, v.getReminder())) {
                            final int numberCurrentMonth = today.getMonthValue();
                            final int visitDay = Integer.parseInt(gson.fromJson(v.getVisitDays(), String[].class)[0]);
                            // true si la visita está programada para el último día del mes 30 || 31
                            final boolean isEndOfMonthVisit = visitDay >= 30;
                            // true si el día de hoy es el último día del mes
                            boolean isLastDayOfMonth = today.getDayOfMonth() == today.lengthOfMonth();
                            // regresa true si el día de visita es mayor o igual a 30 y es el último día de mes
                            if (numberCurrentMonth == 2 && isEndOfMonthVisit) {
                                return isLastDayOfMonth;
                            }
                            return isEndOfMonthVisit && isLastDayOfMonth;
                        }
                        // dia de hoy en español
                        final String dayOnSpanish = BloSalesV2Utils.removeAccentsAndLowercase(today.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
                        final List<String> visitDays = Arrays.asList(gson.fromJson(v.getReminder(), String[].class));
                        if (visitDays.isEmpty()) {
                            return false;
                        }
                        return visitDays.stream()
                            .filter(s -> !s.isBlank())
                            .map(BloSalesV2Utils::removeAccentsAndLowercase)
                            .filter(s -> s.equals(dayOnSpanish)).findAny().isPresent();
                    }).collect(Collectors.toList());
                
                if (vendorsFiltered != null && !vendorsFiltered.isEmpty()) {
                    logger.info("abriendo orden en borrador");
                    PojoIntOrderVendor orderVendor = null;
                    for (final PojoIntVendor vendor: vendorsFiltered) {
                        orderVendor = new PojoIntOrderVendor();
                        orderVendor.setAmount(BigDecimal.ZERO);
                        orderVendor.setBrand(vendor.getBrand());
                        // se agrega un día después de la fecha que se abre la nota
                        orderVendor.setDeadline(
                                today.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        );
                        orderVendor.setFkVendor(vendor.getIdVendor());
                        orderVendor.setStatusOrder(StatusMovementProviderIntEnum.DRAFT);
                        orderVendor.setProductsInfo(BloSalesV2Utils.EMPTY_STRING);
                        ordersVendorsController.highOrder(orderVendor);
                    }
                    allVendors.setVendors(vendorsFiltered);
                }
            }
            logger.info("proveedores recordatorio de hoy: %s", allVendors.getVendors().size());
            return allVendors;
        } catch(BloSalesV2Exception e) {
            dbt.doRollback();
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(e.getCode(), e.getMessage());
        }
    }

    @Override
    public PojoIntVendor deleteVendor(long idVendor) throws BloSalesV2Exception {
        try {
            logger.info("eliminando proveedor por id %s", idVendor);
            dbt.disableAutocommit();
            final var vendorFound = getVendorById(idVendor);
            logger.info("proveedor encontrado %s", String.valueOf(vendorFound));
            BloSalesV2Utils.validateRule(vendorFound == null, BloSalesV2Utils.CODE_VENDOR_NOT_EXITS, BloSalesV2Utils.ERROR_VENDOR_NOT_EXITS);
            vendorFound.setEnabled(false);
            final var debtorUpdated = vendorsModel.updateVendor(vendorFound, idVendor);
            logger.info("proveedor eliminado [%s]", String.valueOf(debtorUpdated));
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

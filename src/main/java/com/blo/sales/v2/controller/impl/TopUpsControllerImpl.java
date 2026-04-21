package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IAccountsController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.controller.ITopUpsController;
import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.AccountsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.model.ITopUpModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;

@Singleton
public class TopUpsControllerImpl implements ITopUpsController {
    
    private static final GUILogger logger = GUILogger.getLogger(TopUpsControllerImpl.class.getName());
    
    @Inject
    private ITopUpModel model;
    
    @Inject
    private IMobileCompanyController mobileCompanyController;
    
    @Inject
    private IAccountsController accountsController;
    
    @Inject
    private ISalesController salesController;
    
    @Inject
    private IDBTransactionManagerController dbtc;

    @Override
    public PojoIntTopUp addTopUp(PojoIntTopUp data, long idCompany) throws BloSalesV2Exception {
        try {
            logger.info("guardando recarga telefonica", String.valueOf(data));
            dbtc.disableAutocommit();
            final var companyFound = mobileCompanyController.getCompanyMobileById(idCompany);
            logger.info("Compania encontrada %s", String.valueOf(companyFound));
            BloSalesV2Utils.validateRule(companyFound == null, BloSalesV2Utils.CODE_COMPANY_NOT_FOUND, BloSalesV2Utils.ERROR_COMPANY_NOT_FOUND);
            data.setFkMobileCompany(companyFound);
            // guardando comision + monto de recarga
            salesController.registerTopUpComission(data.getFkUser().getIdUser(), data.getAmount());
            logger.info("comision guardada");
            // restar dinero de cuenta digital
            final var walletDigital = accountsController.getAccountById(AccountsIntEnum.DIGITAL_WALLET.getId());
            logger.info("moviendo dinero digital a dinero fisico");
            accountsController.substractMoneyNotCommit(
                    walletDigital.getIdAccount(),
                    data.getFkUser().getIdUser(),
                    data.getAmount(),
                    data.getReference()
            );
            logger.info("se ha restado dinero de cuenta digital a cashbox");
            final var topUpSaved = model.addTopUp(data);
            dbtc.doCommit();
            logger.info("recarga guardada %s", String.valueOf(topUpSaved));
            return topUpSaved;
        } catch(BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtc.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtc.enableAutocommit();
        }
    }

    @Override
    public WrapperPojoIntTopUp closeTopUps(WrapperPojoIntTopUp topUps) throws BloSalesV2Exception {
        try {
            logger.info("actualizando topUps %s", topUps.getTopUps().size());
            dbtc.disableAutocommit();
            if (topUps.getTopUps() != null && !topUps.getTopUps().isEmpty()) {
                for(final var element: topUps.getTopUps()) {
                    element.setChecked(true);
                    model.updateTopUp(element, element.getIdTopUp());
                }
                logger.info("Se han cerrado las recargas");
            }
            return topUps;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtc.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtc.enableAutocommit();
        }
    }

    @Override
    public WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception {
        logger.info("buscando recargas por estatus %s", String.valueOf(status));
        return model.getTopUpsByStatus(status);
    }
}

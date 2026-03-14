package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;

public class PojoTopUp {
    
    private long idTopUp;
    
    private PojoLoggedInUser fkUser;
    
    private PojoMobileCompany fkMobileCompany;
    
    private BigDecimal amount;
    
    private boolean checked;
    
    private String phoneNumber;
    
    private String timestamp;

    public long getIdTopUp() {
        return idTopUp;
    }

    public void setIdTopUp(long idTopUp) {
        this.idTopUp = idTopUp;
    }

    public PojoLoggedInUser getFkUser() {
        return fkUser;
    }

    public void setFkUser(PojoLoggedInUser fkUser) {
        this.fkUser = fkUser;
    }

    public PojoMobileCompany getFkMobileCompany() {
        return fkMobileCompany;
    }

    public void setFkMobileCompany(PojoMobileCompany fkMobileCompany) {
        this.fkMobileCompany = fkMobileCompany;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PojoTopUp{" + "idTopUp=" + idTopUp + ", fkUser=" + fkUser + ", fkMobileCompany=" + fkMobileCompany + ", amount=" + amount + ", checked=" + checked + ", phoneNumber=" + phoneNumber + ", timestamp=" + timestamp + '}';
    }
}

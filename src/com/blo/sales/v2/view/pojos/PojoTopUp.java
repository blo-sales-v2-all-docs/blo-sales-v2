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
        StringBuilder sb = new StringBuilder();
        sb.append("PojoTopUp{");
        sb.append("idTopUp=").append(idTopUp);
        sb.append(", fkUser=").append(fkUser);
        sb.append(", fkMobileCompany=").append(fkMobileCompany);
        sb.append(", amount=").append(amount);
        sb.append(", checked=").append(checked);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }

    
}

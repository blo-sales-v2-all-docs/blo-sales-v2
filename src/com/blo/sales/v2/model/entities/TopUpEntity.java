package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;

public class TopUpEntity {
    
    private long id_top_up;
    
    private UserEntity fk_user;
    
    private MobileCompanyEntity fk_mobile_company;
    
    private BigDecimal amount;
    
    private boolean checked;
    
    private String phone_number;
    
    private String timestamp;

    public long getId_top_up() {
        return id_top_up;
    }

    public void setId_top_up(long id_top_up) {
        this.id_top_up = id_top_up;
    }

    public UserEntity getFk_user() {
        return fk_user;
    }

    public void setFk_user(UserEntity fk_user) {
        this.fk_user = fk_user;
    }

    public MobileCompanyEntity getFk_mobile_company() {
        return fk_mobile_company;
    }

    public void setFk_mobile_company(MobileCompanyEntity fk_mobile_company) {
        this.fk_mobile_company = fk_mobile_company;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TopUpEntity{" + "id_top_up=" + id_top_up + ", fk_user=" + fk_user + ", fk_mobile_company=" + fk_mobile_company + ", amount=" + amount + ", checked=" + checked + ", phone_number=" + phone_number + ", timestamp=" + timestamp + '}';
    }
}

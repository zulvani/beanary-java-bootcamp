package com.beanary.bootcamp.java.basic.workflow;

import java.math.BigDecimal;

public class Transaction {

    private BigDecimal totalBrutto;
    private BigDecimal discountAmount;
    private BigDecimal discountPercentage;

    public BigDecimal getTotalBrutto() {
        return totalBrutto;
    }

    public void setTotalBrutto(BigDecimal totalBrutto) {
        this.totalBrutto = totalBrutto;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}

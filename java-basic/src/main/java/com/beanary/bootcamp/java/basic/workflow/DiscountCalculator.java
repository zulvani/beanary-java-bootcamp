package com.beanary.bootcamp.java.basic.workflow;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("discountCalculator")
public class DiscountCalculator extends PluginProcessor {
    @Override
    Object process(Object... parameters) {
        if(parameters[0] instanceof Transaction){
            Transaction t = (Transaction) parameters[0];
            t.setDiscountAmount((new BigDecimal("100").divide(t.getTotalBrutto())).multiply(t.getTotalBrutto()));
        }
        return null;
    }
}

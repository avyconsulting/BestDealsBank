package com.hsbc.bestdealsbank.service.calculators;

import javax.inject.Inject;
import javax.inject.Named;

import com.hsbc.bestdealsbank.domain.CalculatorResponse;
import com.hsbc.bestdealsbank.domain.DealDetails;
import com.hsbc.bestdealsbank.service.decorator.ExchangeRateDecorator;

@Named("compound")
public class CompoundInterestCalculator implements InterestCalculator {

    private final ExchangeRateDecorator decorator;

    @Inject
    public CompoundInterestCalculator(ExchangeRateDecorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public CalculatorResponse calculate(DealDetails deals) {

        double amount = deals.getPrinciple().doubleValue() * Math.pow(1.0 + deals.getRate().doubleValue() / 100.0, deals.getNoOfYears()) - deals.getPrinciple().doubleValue();
        Double converted = decorator.convert(amount);
        
        return new CalculatorResponse(amount, converted);
    }


}

package com.hsbc.bestdealsbank.service.calculators;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hsbc.bestdealsbank.bootstrap.ApplicationModule;
import com.hsbc.bestdealsbank.domain.CalculatorResponse;
import com.hsbc.bestdealsbank.domain.DealDetails;
import com.hsbc.bestdealsbank.service.calculators.SimpleInterestCalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JukitoRunner.class)
public class SimpleInterestCalculatorTest {

    public static class TestModule extends org.jukito.TestModule {

        @Override
        protected void configureTest() {
            install(new ApplicationModule());
        }
    }

    @Inject
    SimpleInterestCalculator underTest;

    @Test
    public void shouldReturnCalculateRateInUsd() throws Exception {

        DealDetails dealDetails = new DealDetails(BigDecimal.valueOf(2000), 1, BigDecimal.valueOf(3));

        CalculatorResponse calculatorResponse = underTest.calculate(dealDetails);

        assertThat(String.format("%.2f", calculatorResponse.getAmount()), is("300.00"));
        assertThat(String.format("%.2f", calculatorResponse.getConverted()), is("387.84"));
    }
}

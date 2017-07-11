package com.hsbc.bestdealsbank.service.calculators;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hsbc.bestdealsbank.bootstrap.ApplicationModule;
import com.hsbc.bestdealsbank.domain.CalculatorResponse;
import com.hsbc.bestdealsbank.domain.DealDetails;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JukitoRunner.class)
public class CompoundInterestCalculatorTest {

    public static class TestModule extends org.jukito.TestModule {

        @Override
        protected void configureTest() {
            install(new ApplicationModule());
        }
    }

    @Inject
    CompoundInterestCalculator underTest;

    @Test
    public void shouldReturnFinalAmount() throws Exception {

        DealDetails dealDetails = new DealDetails(BigDecimal.valueOf(2000), 1, BigDecimal.valueOf(3));

        CalculatorResponse result = underTest.calculate(dealDetails);

        assertThat(String.format("%.2f", result.getAmount()), is("318.55"));
        assertThat(String.format("%.2f", result.getConverted()), is("411.82"));
    }

}

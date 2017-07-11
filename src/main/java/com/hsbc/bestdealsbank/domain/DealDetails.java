package com.hsbc.bestdealsbank.domain;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("dealDetails")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealDetails {

    private BigDecimal principle;
    private int noOfYears;
    private BigDecimal rate;

    @JsonCreator
    public DealDetails(@JsonProperty("principle") BigDecimal principle,
                    @JsonProperty("noOfYears") int noOfYears,
                    @JsonProperty("rate") BigDecimal rate) {
        this.principle = principle;
        this.noOfYears = noOfYears;
        this.rate = rate;
    }

    /**
     * @return the principle
     */
    public BigDecimal getPrinciple() {
        return this.principle;
    }

    /**
     * @return the noOfYears
     */
    public int getNoOfYears() {
        return this.noOfYears;
    }

    /**
     * @return the rate
     */
    public BigDecimal getRate() {
        return this.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.principle, this.noOfYears, this.rate);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DealDetails)) {
            return false;
        }
        DealDetails deals = (DealDetails) obj;

        return Objects.equals(deals.getPrinciple(), this.principle) &&
                        Objects.equals(deals.getNoOfYears(), this.noOfYears) &&
                        Objects.equals(deals.getRate(), this.rate);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                        .append("principleAmount : ")
                        .append(principle)
                        .append(", rate : ")
                        .append(rate)
                        .append(", noOfYears : ")
                        .append(noOfYears)
                        .toString();
    }

}

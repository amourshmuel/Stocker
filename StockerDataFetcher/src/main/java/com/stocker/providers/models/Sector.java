package com.stocker.providers.models;

import com.stocker.utils.serializer.csv.DoubleConverter;
import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

/**
 * Created by AmourWin7 on 12/16/2016.
 */
@CsvDataType()
public class Sector {
    @CsvField(pos = 1)
    private String industry;
    @CsvField(pos =2 , converterType = DoubleConverter.class)
    private Double one_day_price_chg_prct;
    @CsvField(pos = 3)
    private String market_cap;
    @CsvField(pos = 4, converterType = DoubleConverter.class)
    private Double pe;
    @CsvField(pos = 5, converterType = DoubleConverter.class)
    private Double roe;
    @CsvField(pos = 6, converterType = DoubleConverter.class)
    private Double div_yield_prct;
    @CsvField(pos = 7, converterType = DoubleConverter.class)
    private Double debt_to_equity;
    @CsvField(pos = 8, converterType = DoubleConverter.class)
    private Double price_to_book;
    @CsvField(pos = 9, converterType = DoubleConverter.class)
    private Double net_profit_margin_mrq;
    @CsvField(pos = 10, converterType = DoubleConverter.class)
    private  Double price_to_free_cash_flow_mrq;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Double getOne_day_price_chg_prct() {
        return one_day_price_chg_prct;
    }

    public void setOne_day_price_chg_prct(Double one_day_price_chg_prct) {
        this.one_day_price_chg_prct = one_day_price_chg_prct;
    }

    public String getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(String market_cap) {
        this.market_cap = market_cap;
    }

    public Double getPe() {
        return pe;
    }

    public void setPe(Double pe) {
        this.pe = pe;
    }

    public Double getRoe() {
        return roe;
    }

    public void setRoe(Double roe) {
        this.roe = roe;
    }

    public Double getDiv_yield_prct() {
        return div_yield_prct;
    }

    public void setDiv_yield_prct(Double div_yield_prct) {
        this.div_yield_prct = div_yield_prct;
    }

    public Double getDebt_to_equity() {
        return debt_to_equity;
    }

    public void setDebt_to_equity(Double debt_to_equity) {
        this.debt_to_equity = debt_to_equity;
    }

    public Double getPrice_to_book() {
        return price_to_book;
    }

    public void setPrice_to_book(Double price_to_book) {
        this.price_to_book = price_to_book;
    }

    public Double getNet_profit_margin_mrq() {
        return net_profit_margin_mrq;
    }

    public void setNet_profit_margin_mrq(Double net_profit_margin_mrq) {
        this.net_profit_margin_mrq = net_profit_margin_mrq;
    }

    public Double getPrice_to_free_cash_flow_mrq() {
        return price_to_free_cash_flow_mrq;
    }

    public void setPrice_to_free_cash_flow_mrq(Double price_to_free_cash_flow_mrq) {
        this.price_to_free_cash_flow_mrq = price_to_free_cash_flow_mrq;
    }
}

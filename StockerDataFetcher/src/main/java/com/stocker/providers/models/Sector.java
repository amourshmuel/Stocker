package com.stocker.providers.models;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

/**
 * Created by AmourWin7 on 12/16/2016.
 */
@CsvDataType()
public class Sector {
    @CsvField(pos = 1)
    private String industry;
    private  float one_day_price_chg_prct;
    private  float market_cap;
    private  float pe;
    private  float roe;
    private  float div_yield_prct;
    private  float debt_to_equity;
    private  float price_to_book;
    private  float net_profit_margin_mrq;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public float getOne_day_price_chg_prct() {
        return one_day_price_chg_prct;
    }

    public void setOne_day_price_chg_prct(float one_day_price_chg_prct) {
        this.one_day_price_chg_prct = one_day_price_chg_prct;
    }

    public float getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(float market_cap) {
        this.market_cap = market_cap;
    }

    public float getPe() {
        return pe;
    }

    public void setPe(float pe) {
        this.pe = pe;
    }

    public float getRoe() {
        return roe;
    }

    public void setRoe(float roe) {
        this.roe = roe;
    }

    public float getDiv_yield_prct() {
        return div_yield_prct;
    }

    public void setDiv_yield_prct(float div_yield_prct) {
        this.div_yield_prct = div_yield_prct;
    }

    public float getDebt_to_equity() {
        return debt_to_equity;
    }

    public void setDebt_to_equity(float debt_to_equity) {
        this.debt_to_equity = debt_to_equity;
    }

    public float getPrice_to_book() {
        return price_to_book;
    }

    public void setPrice_to_book(float price_to_book) {
        this.price_to_book = price_to_book;
    }

    public float getNet_profit_margin_mrq() {
        return net_profit_margin_mrq;
    }

    public void setNet_profit_margin_mrq(float net_profit_margin_mrq) {
        this.net_profit_margin_mrq = net_profit_margin_mrq;
    }

    public float getPrice_to_free_cash_flow_mrq() {
        return price_to_free_cash_flow_mrq;
    }

    public void setPrice_to_free_cash_flow_mrq(float price_to_free_cash_flow_mrq) {
        this.price_to_free_cash_flow_mrq = price_to_free_cash_flow_mrq;
    }

    private  float price_to_free_cash_flow_mrq;
}

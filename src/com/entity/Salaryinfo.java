package com.entity;

// Generated 2013-8-23 15:06:50 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * Salaryinfo generated by hbm2java
 */
public class Salaryinfo implements java.io.Serializable {

    private Integer salaryId;
    private Employeeinfo employeeinfo;
    private String syear;
    private String smonth;
    private BigDecimal sbase;
    private BigDecimal sextra;
    private BigDecimal sholiday;
    private BigDecimal sabsence;
    private BigDecimal stotal;
    private int sstate;

    public Salaryinfo() {
    }

    public Salaryinfo(Employeeinfo employeeinfo, String syear, String smonth, BigDecimal sbase, BigDecimal sextra, BigDecimal sholiday,
            BigDecimal sabsence, BigDecimal stotal, char sstate) {
        this.employeeinfo = employeeinfo;
        this.syear = syear;
        this.smonth = smonth;
        this.sbase = sbase;
        this.sextra = sextra;
        this.sholiday = sholiday;
        this.sabsence = sabsence;
        this.stotal = stotal;
        this.sstate = sstate;
    }

    public Integer getSalaryId() {
        return this.salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Employeeinfo getEmployeeinfo() {
        return this.employeeinfo;
    }

    public void setEmployeeinfo(Employeeinfo employeeinfo) {
        this.employeeinfo = employeeinfo;
    }

    public String getSyear() {
        return this.syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }

    public String getSmonth() {
        return this.smonth;
    }

    public void setSmonth(String smonth) {
        this.smonth = smonth;
    }

    public BigDecimal getSbase() {
        return this.sbase;
    }

    public void setSbase(BigDecimal sbase) {
        this.sbase = sbase;
    }

    public BigDecimal getSextra() {
        return this.sextra;
    }

    public void setSextra(BigDecimal sextra) {
        this.sextra = sextra;
    }

    public BigDecimal getSholiday() {
        return this.sholiday;
    }

    public void setSholiday(BigDecimal sholiday) {
        this.sholiday = sholiday;
    }

    public BigDecimal getSabsence() {
        return this.sabsence;
    }

    public void setSabsence(BigDecimal sabsence) {
        this.sabsence = sabsence;
    }

    public BigDecimal getStotal() {
        return this.stotal;
    }

    public void setStotal(BigDecimal stotal) {
        this.stotal = stotal;
    }

    public int getSstate() {
        return sstate;
    }

    public void setSstate(int sstate) {
        this.sstate = sstate;
    }

}

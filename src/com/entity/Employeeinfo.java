package com.entity;

// Generated 2013-8-23 15:06:50 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Employeeinfo generated by hbm2java
 */
public class Employeeinfo implements java.io.Serializable {

    private String empId;
    private Departmentinfo departmentinfo;
    private String empName;
    private String empSex;
    private Date empBirth;
    private String empEmail;
    private String empRoll;
    private BigDecimal empSalary;
    private String empTel;
    private String empPic;
    private String empBio;
    private Boolean empState;
    private Set extraworks = new HashSet(0);
    private Set attendanceinfos = new HashSet(0);
    private Set salaryinfos = new HashSet(0);
    private Set holsinfos = new HashSet(0);
    private Userinfo userinfo;

    public Employeeinfo() {
    }

    public Employeeinfo(String empId, Departmentinfo departmentinfo, String empName, String empSex, Date empBirth, String empEmail, String empRoll,
            BigDecimal empSalary, String empTel) {
        this.empId = empId;
        this.departmentinfo = departmentinfo;
        this.empName = empName;
        this.empSex = empSex;
        this.empBirth = empBirth;
        this.empEmail = empEmail;
        this.empRoll = empRoll;
        this.empSalary = empSalary;
        this.empTel = empTel;
    }

    public Employeeinfo(String empId, Departmentinfo departmentinfo, String empName, String empSex, Date empBirth, String empEmail, String empRoll,
            BigDecimal empSalary, String empTel, String empPic, String empBio, Boolean empState, Set extraworks, Set attendanceinfos,
            Set salaryinfos, Set holsinfos, Userinfo userinfo) {
        this.empId = empId;
        this.departmentinfo = departmentinfo;
        this.empName = empName;
        this.empSex = empSex;
        this.empBirth = empBirth;
        this.empEmail = empEmail;
        this.empRoll = empRoll;
        this.empSalary = empSalary;
        this.empTel = empTel;
        this.empPic = empPic;
        this.empBio = empBio;
        this.empState = empState;
        this.extraworks = extraworks;
        this.attendanceinfos = attendanceinfos;
        this.salaryinfos = salaryinfos;
        this.holsinfos = holsinfos;
        this.userinfo = userinfo;
    }

    public String getEmpId() {
        return this.empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Departmentinfo getDepartmentinfo() {
        return this.departmentinfo;
    }

    public void setDepartmentinfo(Departmentinfo departmentinfo) {
        this.departmentinfo = departmentinfo;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return this.empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Date getEmpBirth() {
        return this.empBirth;
    }

    public void setEmpBirth(Date empBirth) {
        this.empBirth = empBirth;
    }

    public String getEmpEmail() {
        return this.empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpRoll() {
        return this.empRoll;
    }

    public void setEmpRoll(String empRoll) {
        this.empRoll = empRoll;
    }

    public BigDecimal getEmpSalary() {
        return this.empSalary;
    }

    public void setEmpSalary(BigDecimal empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpTel() {
        return this.empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public String getEmpPic() {
        return this.empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getEmpBio() {
        return this.empBio;
    }

    public void setEmpBio(String empBio) {
        this.empBio = empBio;
    }

    public Boolean getEmpState() {
        return this.empState;
    }

    public void setEmpState(Boolean empState) {
        this.empState = empState;
    }

    public Set getExtraworks() {
        return this.extraworks;
    }

    public void setExtraworks(Set extraworks) {
        this.extraworks = extraworks;
    }

    public Set getAttendanceinfos() {
        return this.attendanceinfos;
    }

    public void setAttendanceinfos(Set attendanceinfos) {
        this.attendanceinfos = attendanceinfos;
    }

    public Set getSalaryinfos() {
        return this.salaryinfos;
    }

    public void setSalaryinfos(Set salaryinfos) {
        this.salaryinfos = salaryinfos;
    }

    public Set getHolsinfos() {
        return this.holsinfos;
    }

    public void setHolsinfos(Set holsinfos) {
        this.holsinfos = holsinfos;
    }

    public Userinfo getUserinfo() {
        return this.userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

}

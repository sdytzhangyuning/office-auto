package com.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.biz.IbaseBiz;
import com.entity.Departmentinfo;
import com.entity.Salaryinfo;
import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class salaryAction extends ActionSupport {

    private IbaseBiz<Salaryinfo> baseBiz;
    private Salaryinfo salary;
    private IbaseBiz<Departmentinfo> departBiz;
    private Map<String, Object> departList;
    private List<Salaryinfo> salarys;
    private int salId;
    private int currenPage = 1;
    private int size = 3;
    private String hql = "from Salaryinfo s where 1=1";
    private int maxPage;
    private int totalMessage;
    private Userinfo user;
    private String salaryMonth;
    private String result;
    private String departId = "";

    public void getPage(String hql) {
        totalMessage = baseBiz.findList(hql).size();
        maxPage = (totalMessage - 1) / size + 1;
    }

    public String salUI() {
        Date now = new Date();
        int year = now.getYear() + 1900;
        int opyear = Integer.parseInt(salaryMonth.substring(0, 4));
        if (year < opyear) {
            this.result = this.getText("yearError");
            return "salUIError";
        }
        int month = now.getMonth() + 1;
        int opmonth = Integer.parseInt(salaryMonth.substring(5, 7));
        if (opmonth >= month) {
            this.result = this.getText("monthError");
            return "salUIError";
        }
        ActionContext.getContext().getSession().put("salaryMonth", salaryMonth);
        return "salUI";
    }

    public String findMonthPageList() {
        if (!"".equals(departId)) {
            hql += " and s.employeeinfo.departmentinfo.departId = " + departId;
        }
        salaryMonth = (String) ActionContext.getContext().getSession().get("salaryMonth");
        System.out.println(salaryMonth);
        String year = salaryMonth.substring(0, 4);
        String month = salaryMonth.substring(5, 7);
        System.out.println(year);
        System.out.println(month);
        hql += " and s.syear = '" + year + "' and s.smonth = '" + month + "'";
        System.out.println(hql);
        getPage(hql);
        salarys = baseBiz.findPageList(hql, currenPage, size);
        return "findMonthPageList";
    }

    public String addSalUI() {

        return "addSalUI";
    }

    public String addSal() {
        Boolean flag = baseBiz.add(salary);
        if (flag) {
            return "addSalOk";
        }
        return "Error";
    }

    public String dellSal() {
        Boolean flag = baseBiz.dell(new Salaryinfo(), salId);
        if (flag) {
            return "dellSalOk";
        }
        return "Error";
    }

    public String updateSalUI() {
        salary = baseBiz.getById(new Salaryinfo(), salId);
        return "updateSalUI";
    }

    public String updateSal() {
        salary = baseBiz.getById(new Salaryinfo(), salId);
        salary.setSstate(1);
        Boolean flag = baseBiz.update(salary);
        if (flag) {
            return "updateSalOk";
        }
        return "Error";
    }

    public String findSalList() {
        user = (Userinfo) ActionContext.getContext().getSession().get("loginuser");
        hql = hql + " and s.employeeinfo.empId = " + user.getEmpId();
        System.out.println(user.getEmpId());
        System.out.println(hql);
        getPage(hql);
        if (0 == currenPage) {
            currenPage = 1;
        }
        salarys = baseBiz.findPageList(hql, currenPage, size);
        return "findSalList";
    }

    public String findSalPageList() {
        getPage(hql);
        if (0 == currenPage) {
            currenPage = 1;
        } else if (currenPage > maxPage) {
            currenPage = maxPage;
        }
        salarys = baseBiz.findPageList(hql, currenPage, size);
        return "findSalPageList";
    }

    public Salaryinfo getSalary() {
        return salary;
    }

    public void setSalary(Salaryinfo salary) {
        this.salary = salary;
    }

    public int getIndex() {
        return currenPage;
    }

    public void setIndex(int index) {
        this.currenPage = index;
    }

    public List<Salaryinfo> getSalarys() {
        return salarys;
    }

    public int getPageCount() {
        return maxPage;
    }

    public void setBaseBiz(IbaseBiz<Salaryinfo> baseBiz) {
        this.baseBiz = baseBiz;
    }

    public void setSalId(int salId) {
        this.salId = salId;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrenPage() {
        return currenPage;
    }

    public void setCurrenPage(int currenPage) {
        this.currenPage = currenPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public int getTotalMessage() {
        return totalMessage;
    }

    public void setDepartBiz(IbaseBiz<Departmentinfo> departBiz) {
        this.departBiz = departBiz;
    }

    public String getResult() {
        return result;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public Map<String, Object> getDepartList() {
        List<Departmentinfo> list = departBiz.findList("from Departmentinfo");
        departList = new HashMap<String, Object>();
        departList.put("", "all");
        for (Departmentinfo d : list) {
            departList.put(d.getDepartId(), d.getDepartName());
        }
        return departList;
    }
}

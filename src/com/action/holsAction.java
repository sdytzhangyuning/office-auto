package com.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.biz.IbaseBiz;
import com.entity.Departmentinfo;
import com.entity.Employeeinfo;
import com.entity.Holsinfo;
import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class holsAction extends ActionSupport {

    private IbaseBiz<Holsinfo> baseBiz;
    private IbaseBiz<Employeeinfo> empBiz;
    private IbaseBiz<Departmentinfo> departBiz;
    private Map<String, Object> departList;
    private Holsinfo hols;
    private List<Holsinfo> holss;
    private int holsId;
    private int currenPage = 1;
    private int size = 3;
    private String hql = "from Holsinfo h where 1=1";
    private int maxPage;
    private int totalMessage;
    private int holsState = -1;
    private String departId = "";

    public void getPage(String hql) {
        totalMessage = baseBiz.findList(hql).size();
        maxPage = (totalMessage - 1) / size + 1;
    }

    public String addHolsUI() {

        return "addHolsUI";
    }

    public String addHols() {
        Userinfo user = (Userinfo) ActionContext.getContext().getSession().get("loginuser");
        Employeeinfo emp = empBiz.getById(new Employeeinfo(), user.getEmpId());
        emp.setEmpId(user.getEmpId());
        hols.setEmployeeinfo(emp);
        hols.setApplyTime(new Date());
        long l = hols.getEndTime().getTime() - hols.getStartTime().getTime();
        int day = (int) (l / (24 * 60 * 60 * 1000)) + 1;
        hols.setHoldays((byte) day);
        Boolean flag = baseBiz.add(hols);
        if (flag) {
            return "addHolsOk";
        }
        return "Error";
    }

    public String dellHols() {
        Boolean flag = baseBiz.dell(new Holsinfo(), holsId);
        if (flag) {
            return "dellHolsOk";
        }
        return "Error";
    }

    public String updateHolsUI() {
        hols = baseBiz.getById(new Holsinfo(), holsId);
        return "updateHolsUI";
    }

    public String updateHols() {
        hols = baseBiz.getById(new Holsinfo(), holsId);
        hols.setHolsState(holsState);
        Boolean flag = baseBiz.update(hols);
        if (flag) {
            return "updateHolsOk";
        }
        return "Error";
    }

    public String adminHols() {
        if (!"".equals(departId)) {
            hql += " and h.employeeinfo.departmentinfo.departId = " + departId;
        }

        if (-1 != holsState) {
            hql += " and h.holsState = " + holsState;
        }
        getPage(hql);
        holss = baseBiz.findPageList(hql, currenPage, size);
        return "adminHols";
    }

    public String findHolsPageList() {
        Userinfo user = (Userinfo) ActionContext.getContext().getSession().get("loginuser");
        hql += " and h.employeeinfo.empId = " + user.getEmpId();
        getPage(hql);
        holss = baseBiz.findPageList(hql, currenPage, size);
        return "findHolsPageList";
    }

    public Holsinfo getHols() {
        return hols;
    }

    public void setHols(Holsinfo hols) {
        this.hols = hols;
    }

    public List<Holsinfo> getHolss() {
        return holss;
    }

    public void setBaseBiz(IbaseBiz<Holsinfo> baseBiz) {
        this.baseBiz = baseBiz;
    }

    public void setHolsId(int holsId) {
        this.holsId = holsId;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setEmpBiz(IbaseBiz<Employeeinfo> empBiz) {
        this.empBiz = empBiz;
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

    public void setHolsState(int holsState) {
        this.holsState = holsState;
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

    public Map getStateList() {
        Map map = new HashMap();
        map.put(0, "no pro");
        map.put(1, "approval");
        map.put(2, "recall");
        map.put(3, "refuse");
        return map;

    }
}

package com.action;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.biz.IbaseBiz;
import com.entity.Attendanceinfo;
import com.entity.Departmentinfo;
import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class attendanceAction extends ActionSupport {

    private IbaseBiz<Attendanceinfo> baseBiz;
    private IbaseBiz<Departmentinfo> departBiz;
    private Map<String, Object> departList;
    private Attendanceinfo attendance;
    private List<Attendanceinfo> attendances;
    private int atdId;
    private String hql = "from Attendanceinfo a where 1=1";
    private int index = 1;
    private int size = 3;
    private int PageCount;
    private int totalMessage;
    private String from_day;
    private String to_day;
    private int attendState = -1;
    private String departId;
    private int attendType = -1;
    private Date opDate;
    private String result;

    public String addAtdUI() {
        getPage(hql);
        System.out.println(hql);
        attendances = baseBiz.findPageList(hql, index, size);
        return "addAtdUI";
    }

    public String addAtd() {
        attendance.setAttendTime(new Date());
        attendance.setAttendState(1);
        Boolean flag = baseBiz.add(attendance);
        if (flag) {
            return "addAtdOk";
        }
        return "Error";
    }

    public String dellAtd() {
        Boolean flag = baseBiz.dell(new Attendanceinfo(), atdId);
        if (flag) {
            return "dellAtdOk";
        }
        return "Error";
    }

    public String updateAtdUI() {
        attendance = baseBiz.getById(new Attendanceinfo(), atdId);
        return "updateAtdUI";
    }

    public String updateAtd() {
        attendance = baseBiz.getById(new Attendanceinfo(), atdId);
        attendance.setAttendState(1);
        Boolean flag = baseBiz.update(attendance);
        if (flag) {
            return "updateAtdOk";
        }
        return "Error";
    }

    public String findAtdPageList() {
        getPage(hql);
        attendances = baseBiz.findPageList(hql, index, size);
        return "findAtdPageList";
    }

    public String findAtdList() {
        getPage(hql);
        System.out.println(hql);
        attendances = baseBiz.findPageList(hql, index, size);
        return "findAtdList";
    }

    public String findConditionAtdList() {
        if (!"".equals(departId)) {
            hql += " and a.employeeinfo.departmentinfo.departId = " + departId;
        }
        if (-1 != attendType) {
            hql += " and a.attendState = " + attendType;
        }
        if (!to_day.equals("")) {
            hql = hql + " and a.attendTime <= '" + to_day + "'";
        }
        if (!from_day.equals("")) {
            hql = hql + " and a.attendTime >= '" + from_day + "'";
        }
        System.out.println("hql ++  " + hql);
        getPage(hql);
        attendances = baseBiz.findPageList(hql, index, size);
        return "findConditionAtdList";
    }

    public String findTodayAtdUI() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String staDate = date + " 00:00:00";
        String endDate = date + " 23:59:59";
        hql = "from Attendanceinfo a where a.attendTime <= '" + endDate + "' and a.attendTime >= '" + staDate + "'";
        System.out.println(hql);
        getPage(hql);
        attendances = baseBiz.findPageList(hql, index, size);
        return "findTodayAtdUI";
    }

    public String findTodayAtd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String staDate = date + " 00:00:00";
        String endDate = date + " 23:59:59";
        hql = "from Attendanceinfo a where a.attendTime <= '" + endDate + "' and a.attendTime >= '" + staDate + "'";
        if (!"".equals(departId)) {
            hql += " and a.employeeinfo.departmentinfo.departId = " + departId;
        }
        if (-1 != attendType) {
            hql += " and a.attendState = " + attendType;
        }
        System.out.println("hql ===" + hql);
        getPage(hql);
        attendances = baseBiz.findPageList(hql, index, size);
        return "findTodayAtd";
    }

    public String getByTimePageList() {

        Userinfo user = (Userinfo) ActionContext.getContext().getSession().get("loginuser");
        hql = "from Attendanceinfo a where a.employeeinfo.empId = " + user.getEmpId();
        if (attendState != -1) {
            hql = hql + " and a.attendState=" + attendState;
        }
        if (!(to_day.equals(""))) {
            hql = hql + " and a.attendTime <= '" + to_day + "'";
        }
        if (!(from_day.equals(""))) {
            hql = hql + " and a.attendTime >= '" + from_day + "'";
        }
        getPage(hql);
        if (0 == index) {
            index = 1;
        } else if (index > PageCount) {
            index = PageCount;
        }
        attendances = baseBiz.findPageList(hql, index, size);
        return "ByTimePageList";
    }

    public String dayAdtOpUI() {
        Date date = new Date();
        if (opDate.after(date)) {
            this.result = this.getText("dayAdtError");
            return "dayAdtOpUIError";
        }
        return "dayAdtOpUIOK";
    }

    public Map getStateList() {
        Map map = new HashMap();
        map.put(-1, "all);
        map.put(0, "no sign");
        map.put(1, "on");
        map.put(2, "sign");
        return map;
    }

    public void getPage(String hql) {
        totalMessage = baseBiz.findList(hql).size();
        PageCount = (totalMessage - 1) / size + 1;
    }

    public Attendanceinfo getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendanceinfo attendance) {
        this.attendance = attendance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Attendanceinfo> getAttendances() {
        return attendances;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setBaseBiz(IbaseBiz<Attendanceinfo> baseBiz) {
        this.baseBiz = baseBiz;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFrom_day(String from_day) {
        this.from_day = from_day;
    }

    public void setTo_day(String to_day) {
        this.to_day = to_day;
    }

    public int getTotalMessage() {
        return totalMessage;
    }

    public void setAttendState(int attendState) {
        this.attendState = attendState;
    }

    public Map<String, Object> getDepartList() {
        List<Departmentinfo> list = departBiz.findList("from Departmentinfo");
        departList = new HashMap<String, Object>();
        departList.put("", "全部");
        for (Departmentinfo d : list) {
            departList.put(d.getDepartId(), d.getDepartName());
        }
        return departList;
    }

    public void setDepartBiz(IbaseBiz<Departmentinfo> departBiz) {
        this.departBiz = departBiz;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public void setAttendType(int attendType) {
        this.attendType = attendType;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    public String getResult() {
        return result;
    }

    public void setAtdId(Integer atdId) {
        this.atdId = atdId;
    }

}

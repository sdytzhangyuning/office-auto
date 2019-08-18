package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.biz.IbaseBiz;
import com.entity.Departmentinfo;
import com.entity.Employeeinfo;
import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class empAction extends ActionSupport {

    private IbaseBiz<Employeeinfo> baseBiz;
    private IbaseBiz<Departmentinfo> departBiz;
    private Map<String, Object> departList;
    private Employeeinfo emp;
    private List<Employeeinfo> emps;
    private int index;
    private String empId;
    private String empName;
    private String departId;
    private int downSalary;
    private int upSalary;
    private int size = 15;
    private int PageCount;
    private int totalMessage;
    private int orderBySalary;
    private int orderByAge;
    private File upload;
    private String uploadFileName;

    public void getPage(String hql) {
        totalMessage = baseBiz.findList(hql).size();
        PageCount = (totalMessage - 1) / size + 1;
    }

    public String addEmpUI() {

        return "addEmpUI";
    }

    public String searchEmp() {
        return "searchEmp";
    }

    public String addEmp() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            if (upload != null) {
                String save = ServletActionContext.getServletContext().getRealPath("/impimage/" + this.uploadFileName);
                fis = new FileInputStream(upload);
                fos = new FileOutputStream(save);
                IOUtils.copy(fis, fos);
                fos.flush();
                fos.close();
                fis.close();
                emp.setEmpPic("impimage/" + this.uploadFileName);
            }
            emp.setEmpState(true);
            Boolean flag = baseBiz.add(emp);
            if (flag) {
                return "addEmpOk";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "Error";
    }

    public String empDetail() {
        emp = baseBiz.getById(new Employeeinfo(), empId);
        return "empDetail";
    }

    public String dellEmp() {
        Boolean flag = baseBiz.dell(new Employeeinfo(), empId);
        if (flag) {
            return "dellEmpOl";
        }
        return "Error";
    }

    public String empDet() {
        Userinfo user = (Userinfo) ActionContext.getContext().getSession().get("loginuser");
        emp = baseBiz.getById(new Employeeinfo(), user.getEmpId());
        return "empDet";
    }

    public String updateEmpUI() {
        emp = baseBiz.getById(new Employeeinfo(), empId);
        return "updateEmpUI";
    }

    public String updateEmp() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            if (upload != null) {
                String save = ServletActionContext.getServletContext().getRealPath("/impimage/" + this.uploadFileName);
                fis = new FileInputStream(upload);
                fos = new FileOutputStream(save);
                IOUtils.copy(fis, fos);
                fos.flush();
                fos.close();
                fis.close();
                emp.setEmpPic("impimage/" + this.uploadFileName);
            }
            Boolean flag = baseBiz.update(emp);
            if (flag) {
                return "updateEmpOk";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "Error";
    }

    public String findEmpPageList() {
        String hql = "from Employeeinfo";
        if (-1 == orderByAge) {
            hql = "from Employeeinfo e ORDER BY e.empBirth DESC";
            orderByAge = 0;
        } else if (1 == orderByAge) {
            hql = "from Employeeinfo e ORDER BY e.empBirth";
            orderByAge = 0;
        }

        if (-1 == orderBySalary) {
            hql = "from Employeeinfo e ORDER BY e.empSalary DESC";
            orderBySalary = 0;
        } else if (1 == orderBySalary) {
            hql = "from Employeeinfo e ORDER BY e.empSalary";
            orderBySalary = 0;
        }
        getPage(hql);
        if (0 == index) {
            index = 1;
        }
        emps = baseBiz.findPageList(hql, index, size);
        return "findEmpPageList";
    }

    public String searchEmpList() {
        String hql = "from Employeeinfo e where 1=1";
        if (!"".equals(empId)) {
            hql += " and e.empId = " + this.empId;
        }
        if (!"".equals(departId)) {
            hql += " and e.departmentinfo.departId = " + this.departId;
        }
        if (!"".equals(empName)) {
            hql += " and e.empName LIkE '%" + this.empName + "%' ";
        }

        if (0 != downSalary) {
            hql += " and e.empSalary > " + this.downSalary;
        }
        if (0 != upSalary) {
            hql += " and e.empSalary < " + this.upSalary;
        }
        System.out.println("hql ++    " + hql);
        getPage(hql);
        if (0 == index) {
            index = 1;
        }
        emps = baseBiz.findPageList(hql, index, size);
        return "searchEmpList";
    }

    public Employeeinfo getEmp() {
        return emp;
    }

    public void setEmp(Employeeinfo emp) {
        this.emp = emp;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Employeeinfo> getEmps() {
        return emps;
    }

    public void setBaseBiz(IbaseBiz<Employeeinfo> baseBiz) {
        this.baseBiz = baseBiz;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageCount() {
        return PageCount;
    }

    public int getTotalMessage() {
        return totalMessage;
    }

    public void setOrderBySalary(int orderBySalary) {
        this.orderBySalary = orderBySalary;
    }

    public void setOrderByAge(int orderByAge) {
        this.orderByAge = orderByAge;
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

    public void setDepartBiz(IbaseBiz<Departmentinfo> departBiz) {
        this.departBiz = departBiz;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public Map<String, Object> getGenderList() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("m", "m");
        map.put("f", "f");
        return map;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpDep(String departId) {
        this.departId = departId;
    }

    public void setDownSalary(int downSalary) {
        this.downSalary = downSalary;
    }

    public void setUpSalary(int upSalary) {
        this.upSalary = upSalary;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

}

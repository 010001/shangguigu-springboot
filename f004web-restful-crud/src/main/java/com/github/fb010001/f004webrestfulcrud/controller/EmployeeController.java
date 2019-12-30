package com.github.fb010001.f004webrestfulcrud.controller;

import com.github.fb010001.f004webrestfulcrud.dao.EmployeeDao;
import com.github.fb010001.f004webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/***
 *@Title 员工ｃｏｎｔｒｏｌｌｅｒ
 *＠author    fangbin
 *@Date 19-12-28 下午12:36
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    /**
     * 查询所有员工返回列表页面
     * @return
     */
    @GetMapping("/list")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        //放到请求域中
        Map<String,Object> resultOps = new HashMap<>();
        resultOps.put("flag",true);
        resultOps.put("msg","查询成功");
        resultOps.put("resData",all);
        model.addAllAttributes(resultOps);
        /**
         * thtmeleaf会自动拼接串
         * classpath:/templates/ XXX.html
         * classpath:/templates/emp/list.html
         */
        return "emp/list";

    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    /**
     * 跳转到员工添加页面
     * @return
     */
    @GetMapping("/add")
    public String toAddEmp(){
        return "emp/add";
    }
}

package com.github.fb010001.f004webrestfulcrud.controller;

import com.github.fb010001.f004webrestfulcrud.dao.DepartmentDao;
import com.github.fb010001.f004webrestfulcrud.dao.EmployeeDao;
import com.github.fb010001.f004webrestfulcrud.entities.Department;
import com.github.fb010001.f004webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private DepartmentDao departmentDao;
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
    public String toAddEmp(Model model){
        //　跳转到员工添加页面之前，需要先调用查询部门列表的接口查询部门列表信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }


    //跳转到修改页面,查出员工信息并回显
    @GetMapping("/{id}")
    public String toEditPage(@PathVariable("id") Integer empId,Model model){
        //
        Employee employee = employeeDao.get(empId);
        model.addAttribute("emp",employee);

        //页面显示所有部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //回到修改页面
        //add页面是修改　添加二合一页面
        return "emp/add";
    }


    /*业务逻辑编写*/

    @PostMapping("/add")
    public String addEmp(Employee employee){
        System.out.println("新员工信息：　" + employee);
        employeeDao.save(employee);
        //redirect 重定向到一个地址　斜杠　/ 代表当前项目路径
        //forward 转发到一个地址
        return "redirect:/emp/list";
    }

    /**
     * 员工更新
     * @param employee
     * @return
     */
    @PutMapping
    public String updateEmp(Employee employee){

        System.out.println(employee);
        return "redirect:/emp/list";
    }

    /**
     * 员工删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emp/list";
    }

}

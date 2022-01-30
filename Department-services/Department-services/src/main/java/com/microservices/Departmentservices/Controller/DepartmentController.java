package com.microservices.Departmentservices.Controller;

import com.microservices.Departmentservices.Entity.Department;
import com.microservices.Departmentservices.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService ;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public  Department getDepartmentById(@PathVariable("id") Long departmentId){

        return departmentService.findDepartmentById(departmentId);


    }

}

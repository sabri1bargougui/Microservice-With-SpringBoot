package com.microservices.Usersservices.Controller;

import com.microservices.Usersservices.Entity.User;
import com.microservices.Usersservices.Service.UserService;
import com.microservices.Usersservices.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {

        return userService.getUserWithDepartment(userId);
    }
}

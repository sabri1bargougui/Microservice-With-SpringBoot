package com.microservices.Usersservices.Service;

import com.microservices.Usersservices.Entity.User;
import com.microservices.Usersservices.Repository.UserRepository;
import com.microservices.Usersservices.VO.Department;
import com.microservices.Usersservices.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICES/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}


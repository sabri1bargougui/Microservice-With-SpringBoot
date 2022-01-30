package com.microservices.Departmentservices.Repository;

import com.microservices.Departmentservices.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {


    Department findByDepartmentId(Long departmentId);
}

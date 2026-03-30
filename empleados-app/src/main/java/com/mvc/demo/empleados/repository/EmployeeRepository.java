package com.mvc.demo.empleados.repository;

import org.springframework.data.repository.CrudRepository;
import com.mvc.demo.empleados.model.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

}
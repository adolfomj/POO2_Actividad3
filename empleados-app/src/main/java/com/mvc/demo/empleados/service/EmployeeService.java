package com.mvc.demo.empleados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvc.demo.empleados.model.EmployeeEntity;
import com.mvc.demo.empleados.repository.EmployeeRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    
// Método que obtiene todos los empleados desde el repositorio.
// Se utiliza programación funcional (Streams y Lambdas) para ordenar
// la lista de empleados por nombre antes de retornarla.
    
    public List<EmployeeEntity> getAllEmployees() {
    return ((List<EmployeeEntity>) repository.findAll())
            .stream()
            .sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
            .toList();
}

    public EmployeeEntity getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = repository.findById(id);
        return employee.orElse(null);
    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
        
        //validación
        if(entity.getEmail() == null || entity.getEmail().isEmpty()){
        throw new RuntimeException("El email es obligatorio");
            }
        return repository.save(entity);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
package com.mvc.demo.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mvc.demo.empleados.model.EmployeeEntity;
import com.mvc.demo.empleados.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // LISTAR EMPLEADOS
    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "list-employees";
    }

    // MOSTRAR FORMULARIO
    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new EmployeeEntity());
        return "add-edit-employee";
    }

    // GUARDAR EMPLEADO
    @PostMapping("/save")
    public String createOrUpdateEmployee(@ModelAttribute EmployeeEntity employee) {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }

    // ELIMINAR EMPLEADO
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}
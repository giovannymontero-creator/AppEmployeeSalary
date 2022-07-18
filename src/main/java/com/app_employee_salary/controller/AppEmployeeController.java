package com.app_employee_salary.controller;

import com.app_employee_salary.model.Data;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/*------------------------------------------------------------
Descripción: Este servicio rest consume el web service de empleados para consultar el sueldo total
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
17/07/2022    Gmontero                         Creación
*/
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AppEmployeeController {

    private final Logger log = LoggerFactory.getLogger(AppEmployeeController.class);
    private String url1 = "http://dummy.restapiexample.com/api/v1/employees";
    private String url2 = "http://dummy.restapiexample.com/api/v1/employee";
        
    @Autowired
    private RestTemplate empleadoRest; 
    
    @GetMapping("/employees")
    public List<Data> getListResults(){
    	Data[] employees = empleadoRest.getForObject(url1, Data[].class);
    	for(Data e: employees) {
    		e.setEmployee_salary_annual(e.getEmployee_salary());
    	}
    	return Arrays.asList(employees);   	
    }
    
    @GetMapping("/employee/{id}")
    public Data getResultId(@PathVariable int id){
    	String urliD = url2 + "/" + id; 
    	Data employee = empleadoRest.getForObject(urliD, Data.class);
    	employee.setEmployee_salary_annual(employee.getEmployee_salary());
    	return employee;   	
    }
}

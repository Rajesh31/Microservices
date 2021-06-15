package com.rajesh.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.departmentservice.entity.Department;
import com.rajesh.departmentservice.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment of the DepartmentService");
		return departmentRepository.save(department);
		
	}


	public Department findByDepartmentId(Long departmentId) {
		log.info("Inside findByDepartmentId of the DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}

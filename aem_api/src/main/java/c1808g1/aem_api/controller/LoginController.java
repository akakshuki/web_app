package c1808g1.aem_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import c1808g1.Models.UserLoginDTO;
import c1808g1.Models.HeThong.RoleDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.HeThong.Role;
import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;
import c1808g1.aem_api.service.HeThong.RoleService;
import c1808g1.aem_api.service.QuanLyHoSo.EmployeeService;
import c1808g1.aem_api.service.QuanLyHoSo.FCService;
import c1808g1.aem_api.service.QuanLyHoSo.StudentService;

public class LoginController {
	private RoleService roleSv;
	private StudentService stuSv;
	private FCService fcSv;
	private EmployeeService empSv;

	@Autowired
	public LoginController(RoleService roleSv,StudentService stuSv,FCService fcSv,EmployeeService empSv) {
		this.roleSv = roleSv;
		this.stuSv=stuSv;
		this.fcSv=fcSv;
		this.empSv=empSv;
	}


}

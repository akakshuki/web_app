package c1808g1.aem_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import c1808g1.Models.UserLoginDTO;
import c1808g1.Models.HeThong.RoleDTO;
import c1808g1.Models.QuanLiHoSo.EmployeeDTO;
import c1808g1.Models.QuanLiHoSo.FCDTO;
import c1808g1.Models.QuanLiHoSo.StudentDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.HeThong.Role;
import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;
import c1808g1.aem_api.models.QuanLyHoSo.FCModel;
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
	public LoginController(RoleService roleSv, StudentService stuSv, FCService fcSv, EmployeeService empSv) {
		this.roleSv = roleSv;
		this.stuSv = stuSv;
		this.fcSv = fcSv;
		this.empSv = empSv;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserLoginDTO> checkUserLogin(int id_role, String email, String password) {
//		Role role = roleSv.findRoleById(id_role);
//		RoleDTO roleDTO = ModelMapperConfig.modelMapper.map(role, RoleDTO.class);
		UserLoginDTO ul = new UserLoginDTO();
		String full_name = null;
		if (id_role == 1) {
			var data = stuSv.ListStudentByEmailAndPassword(email, password);
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				StudentDTO studto = ModelMapperConfig.modelMapper.map(data, StudentDTO.class);
				full_name = studto.getFull_name();
				String creator = full_name.substring(0, full_name.lastIndexOf(" "));
				ul.setId_user(studto.getId_student());
				ul.setName_user(studto.getFull_name());
				ul.setEmail(email);
				ul.setId_role(id_role);
				ul.setCreator(creator);
				ul.setList_role(null);
				ul.setImage_student(studto.getImage_student());
				return new ResponseEntity<>(ul, HttpStatus.OK);
			}
		} else if (id_role == 2) {
			var data = fcSv.ListFCByEmailAndPassword(email, password);
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				FCDTO fcdto = ModelMapperConfig.modelMapper.map(data, FCDTO.class);
				full_name = fcdto.getName_fc();
				String creator = full_name.substring(0, full_name.lastIndexOf(" "));
				ul.setId_user(fcdto.getId_fc());
				ul.setName_user(fcdto.getName_fc());
				ul.setEmail(email);
				ul.setId_role(id_role);
				ul.setCreator(creator);
				ul.setList_role(fcdto.getList_role());
				ul.setImage_student(null);
				return new ResponseEntity<>(ul, HttpStatus.OK);
			}
		} else if (id_role == 3) {
			var data = empSv.ListEmployeeByEmailAndPassword(email, password);
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				EmployeeDTO empdto = ModelMapperConfig.modelMapper.map(data, EmployeeDTO.class);
				full_name = empdto.getName_emp();
				String creator = full_name.substring(0, full_name.lastIndexOf(" "));
				ul.setId_user(empdto.getId_emp());
				ul.setName_user(empdto.getName_emp());
				ul.setEmail(email);
				ul.setId_role(id_role);
				ul.setCreator(creator);
				ul.setList_role(empdto.getList_role());
				ul.setImage_student(null);
				return new ResponseEntity<>(ul, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/rspass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> resetPassword(int id_role, String id_user, String oldpass, String newpass) {
		if (id_role == 1) {
			var data = stuSv.ListStudentById(id_user);
			if (data == null) {
				return new ResponseEntity<>("Not found account!", HttpStatus.NO_CONTENT);
			} else {
				StudentDTO studto = ModelMapperConfig.modelMapper.map(data, StudentDTO.class);
				if (studto.getPassword() == oldpass) {
					StudentModel stu = stuSv.ListStudentById(id_user);
					stu.setPassword(newpass);
					stuSv.save(stu);
					return new ResponseEntity<>("Reset password success!", HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Wrong password, please try again!", HttpStatus.NO_CONTENT);
				}
			}
		} else if (id_role == 2) {
			var data = fcSv.ListFCById(id_user);
			if (data == null) {
				return new ResponseEntity<>("Not found account!", HttpStatus.NO_CONTENT);
			} else {
				FCDTO studto = ModelMapperConfig.modelMapper.map(data, FCDTO.class);
				if (studto.getPassword() == oldpass) {
					FCModel stu = fcSv.ListFCById(id_user);
					stu.setPassword(newpass);
					fcSv.save(stu);
					return new ResponseEntity<>("Reset password success!", HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Wrong password, please try again!", HttpStatus.NO_CONTENT);
				}
			}
		} else if (id_role == 3) {
			var data = empSv.ListEmployeeById(id_user);
			if (data == null) {
				return new ResponseEntity<>("Not found account!", HttpStatus.NO_CONTENT);
			} else {
				EmployeeDTO studto = ModelMapperConfig.modelMapper.map(data, EmployeeDTO.class);
				if (studto.getPassword() == oldpass) {
					EmployeeModel stu = empSv.ListEmployeeById(id_user);
					stu.setPassword(newpass);
					empSv.save(stu);
					return new ResponseEntity<>("Reset password success!", HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Wrong password, please try again!", HttpStatus.NO_CONTENT);
				}
			}
		} else {
			return new ResponseEntity<>("Error has been occured, please try again!", HttpStatus.NO_CONTENT);
		}
	}
}

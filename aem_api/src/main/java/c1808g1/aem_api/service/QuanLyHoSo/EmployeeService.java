package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;

public interface EmployeeService {
	List<EmployeeModel> ListAllEmployee();
	EmployeeModel ListEmployeeById(String id_emp);
	void save(EmployeeModel employee);
	void delete(EmployeeModel employee);
}
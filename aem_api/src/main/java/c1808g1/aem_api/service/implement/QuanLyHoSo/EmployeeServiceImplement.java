package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;
import c1808g1.aem_api.repository.QuanLyHoSo.EmployeeRepository;
import c1808g1.aem_api.service.QuanLyHoSo.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService{
	private EmployeeRepository EmpRepo;
	
	@Autowired
	public EmployeeServiceImplement ( EmployeeRepository EmpRepo) {
		this.EmpRepo = EmpRepo;
	}
	
	@Override
	public List<EmployeeModel> ListAllEmployee(){
		return (List<EmployeeModel>) EmpRepo.findAll();
	}
	
	@Override
	public EmployeeModel ListEmployeeById(String id_emp){
		return  EmpRepo.findById(id_emp).get();
	}
	
	@Override
	public void save(EmployeeModel employee) {
		EmpRepo.save(employee);
	}
	
	@Override
	public void delete(EmployeeModel employee) {
		EmpRepo.delete(employee);
	}
}



package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.GradeSalaryFcModel;
import c1808g1.aem_api.repository.QuanLyHoSo.GradeSalaryFcRepository;
import c1808g1.aem_api.service.QuanLyHoSo.GradeSalaryFcService;

@Service
public class GradeSalaryFcServiceImplement implements GradeSalaryFcService{
	private GradeSalaryFcRepository salaryRepo;
	
	@Autowired
	public GradeSalaryFcServiceImplement(GradeSalaryFcRepository salaryRepo) {
		this.salaryRepo=salaryRepo;
	}
	
	@Override
	public List<GradeSalaryFcModel> findAllGradeSalaryFc(){
		return (List<GradeSalaryFcModel>) salaryRepo.findAll();
	}
	
	@Override
	public GradeSalaryFcModel findGradeSalaryFcById(Integer id){
		return salaryRepo.findById(id).get();
	}
	
	@Override
	public void save(GradeSalaryFcModel salary){
		salaryRepo.save(salary);
	}
	
	@Override
	public void remove(GradeSalaryFcModel salary){
		salaryRepo.delete(salary);
	}
}

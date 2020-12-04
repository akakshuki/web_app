package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.StatusStudentModel;
import c1808g1.aem_api.repository.QuanLyHoSo.StatusStudentRepository;
import c1808g1.aem_api.service.QuanLyHoSo.StatusStudentService;

@Service
public class StatusStudentServiceImplement implements StatusStudentService{
	private StatusStudentRepository stastuRepo;
	
	@Autowired
	public StatusStudentServiceImplement(StatusStudentRepository stastuRepo) {
		this.stastuRepo=stastuRepo;
	}
	
	@Override
	public List<StatusStudentModel> findAllStatusStudent(){
		return (List<StatusStudentModel>) stastuRepo.findAll();
	}
	
	@Override
	public StatusStudentModel findStatusStudentById(Integer id){
		return stastuRepo.findById(id).get();
	}
	
	@Override
	public void save(StatusStudentModel stastu){
		stastuRepo.save(stastu);
	}
	
	@Override
	public void remove(StatusStudentModel stastu){
		stastuRepo.delete(stastu);
	}
}

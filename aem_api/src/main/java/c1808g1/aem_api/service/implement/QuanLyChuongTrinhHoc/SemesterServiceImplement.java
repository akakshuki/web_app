package c1808g1.aem_api.service.implement.QuanLyChuongTrinhHoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Semester;
import c1808g1.aem_api.repository.QuanLyChuongTrinhHoc.SemesterRepository;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.SemesterServices;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterServiceImplement implements SemesterServices {
	private SemesterRepository smtRepo;
	
	@Autowired
	public SemesterServiceImplement (SemesterRepository smtRepo) {
		this.smtRepo = smtRepo;
	}
	
	@Override
	public List<Semester> findAllSemester(){
		return (List<Semester>) smtRepo.findAll();
	}
	
	@Override
	public Optional<Semester> findById(Integer id){
		return smtRepo.findById(id);
	}
	
	@Override
	public void	save(Semester semester) {
		smtRepo.save(semester);
	}
	
	@Override
	public void remove(Semester semester) {
		smtRepo.delete(semester);
	}
}

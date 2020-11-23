package c1808g1.aem_api.service.implement.QuanLyChuongTrinhHoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Subject;
import c1808g1.aem_api.repository.QuanLyChuongTrinhHoc.SubjectRepository;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.SubjectServices;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImplement implements SubjectServices {
	private SubjectRepository subRepo;
	
	@Autowired
	public SubjectServiceImplement (SubjectRepository subRepo) {
		this.subRepo = subRepo;
	}
	
	@Override
	public List<Subject> findAllSubject(){
		return (List<Subject>) subRepo.findAll();
	}
	
	@Override
	public Optional<Subject> findById(String id){
		return subRepo.findById(id);
	}
	
	@Override
	public void	save(Subject subject) {
		subRepo.save(subject);
	}
	
	@Override
	public void remove(Subject subject) {
		subRepo.delete(subject);
	}
}

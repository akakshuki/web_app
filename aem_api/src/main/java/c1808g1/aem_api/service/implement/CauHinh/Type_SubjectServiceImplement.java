package c1808g1.aem_api.service.implement.CauHinh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.CauHinh.Type_Subject;
import c1808g1.aem_api.repository.CauHinh.Type_SubjectRepository;
import c1808g1.aem_api.service.CauHinh.Type_SubjectServices;

import java.util.List;
import java.util.Optional;

@Service
public class Type_SubjectServiceImplement implements Type_SubjectServices {
	private Type_SubjectRepository tysubRepo;
	
	@Autowired
	public Type_SubjectServiceImplement (Type_SubjectRepository tysubRepo) {
		this.tysubRepo = tysubRepo;
	}
	
	@Override
	public List<Type_Subject> findAllType_Subject(){
		return (List<Type_Subject>) tysubRepo.findAll();
	}
	
	@Override
	public Type_Subject findType_SubjectById(Integer id){
		return tysubRepo.findById(id).get();
	}
	
	@Override
	public void	save(Type_Subject type_subject) {
		tysubRepo.save(type_subject);
	}
	
	@Override
	public void remove(Type_Subject type_subject) {
		tysubRepo.delete(type_subject);
	}
}

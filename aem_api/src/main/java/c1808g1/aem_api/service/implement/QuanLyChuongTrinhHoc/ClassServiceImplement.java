package c1808g1.aem_api.service.implement.QuanLyChuongTrinhHoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Class;
import c1808g1.aem_api.repository.QuanLyChuongTrinhHoc.ClassRepository;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.ClassServices;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImplement implements ClassServices {
	private ClassRepository classRepo;
	
	@Autowired
	public ClassServiceImplement (ClassRepository classRepo) {
		this.classRepo = classRepo;
	}
	
	@Override
	public List<Class> findAllClass(){
		return (List<Class>) classRepo.findAll();
	}
	
	@Override
	public Optional<Class> findById(String id){
		return classRepo.findById(id);
	}
	
	@Override
	public void	save(Class Class) {
		classRepo.save(Class);
	}
	
	@Override
	public void remove(Class Class) {
		classRepo.delete(Class);
	}
}

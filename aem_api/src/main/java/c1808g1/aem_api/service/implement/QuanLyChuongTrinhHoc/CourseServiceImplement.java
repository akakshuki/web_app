package c1808g1.aem_api.service.implement.QuanLyChuongTrinhHoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Course;
import c1808g1.aem_api.repository.QuanLyChuongTrinhHoc.CourseRepository;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.CourseServices;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplement implements CourseServices {
	private CourseRepository cosRepo;
	
	@Autowired
	public CourseServiceImplement (CourseRepository cosRepo) {
		this.cosRepo = cosRepo;
	}
	
	@Override
	public List<Course> findAllCourse(){
		return (List<Course>) cosRepo.findAll();
	}
	
	@Override
	public Optional<Course> findById(Integer id){
		return cosRepo.findById(id);
	}
	
	@Override
	public void	save(Course Course) {
		cosRepo.save(Course);
	}
	
	@Override
	public void remove(Course Course) {
		cosRepo.delete(Course);
	}
}

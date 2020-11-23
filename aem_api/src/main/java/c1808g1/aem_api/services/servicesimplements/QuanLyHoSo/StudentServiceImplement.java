package c1808g1.aem_api.services.servicesimplements.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;
import c1808g1.aem_api.repositories.QuanLyHoSo.StudentRepository;
import c1808g1.aem_api.services.QuanLyHoSo.StudentService;

@Service
public class StudentServiceImplement implements StudentService{
	private StudentRepository StuRepo;

	@Autowired
	public StudentServiceImplement (StudentRepository StuRepo) {
		this.StuRepo = StuRepo;
	}
	
	@Override
	public List<StudentModel> ListAllStudent(){
		return (List<StudentModel>) StuRepo.findAll();
	}
	
	@Override
	public Optional<StudentModel> ListStudentById(String id_student){
		return (Optional<StudentModel>) StuRepo.findById(id_student);
	}
	
	@Override
	public void save(StudentModel student) {
		StuRepo.save(student);
	}
	
	@Override
	public void delete(StudentModel student) {
		StuRepo.delete(student);
	}

	}
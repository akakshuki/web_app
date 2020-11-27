package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;
import c1808g1.aem_api.repository.QuanLyHoSo.StudentRepository;
import c1808g1.aem_api.service.QuanLyHoSo.StudentService;

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
	public StudentModel ListStudentById(String id_student){
		return StuRepo.findById(id_student).get();
	}
	
	@Override
	public StudentModel ListStudentByEmailAndPassword(String email,String password){
		return StuRepo.findByEmailAndPassword(email, password);
	}
	
	@Override
	public StudentModel ListStudentByMobileMac(String mobile){
		return StuRepo.findByMobileMac(mobile);
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
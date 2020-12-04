package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;

public interface StudentService {
	List<StudentModel> ListAllStudent();
	StudentModel ListStudentByEmailAndPassword(String email, String password);
	StudentModel ListStudentById(String id_student);
	StudentModel ListStudentByMobileMac(String mobile);
	void save(StudentModel student);
	void delete(StudentModel student);
}

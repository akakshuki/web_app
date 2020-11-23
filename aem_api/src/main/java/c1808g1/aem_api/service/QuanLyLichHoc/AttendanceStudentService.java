package c1808g1.aem_api.service.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;

public interface AttendanceStudentService {
	List<AttendanceStudentModel> ListAllAttendanceStudent();
	AttendanceStudentModel ListAttendanceStudentById(Integer id);
	void save(AttendanceStudentModel asm);
	void delete(AttendanceStudentModel asm);
}

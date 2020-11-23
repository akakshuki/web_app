package c1808g1.aem_api.services.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;

public interface AttendanceStudentService {
	List<AttendanceStudentModel> ListAllAttendanceStudent();
	Optional<AttendanceStudentModel> ListAttendanceStudentById(Integer id);
	void save(AttendanceStudentModel asm);
	void delete(AttendanceStudentModel asm);
}

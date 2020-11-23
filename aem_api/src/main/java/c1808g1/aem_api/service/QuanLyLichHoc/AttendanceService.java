package c1808g1.aem_api.service.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceModel;

public interface AttendanceService {
	List<AttendanceModel> ListAllAttendance();
	AttendanceModel ListAttendanceById(Integer id);
	void save(AttendanceModel am);
	void delete(AttendanceModel am);

}

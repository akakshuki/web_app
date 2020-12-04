package c1808g1.aem_api.service.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceFCModel;

public interface AttendanceFCService {
	List<AttendanceFCModel> ListAllAttendanceFC();
	AttendanceFCModel ListAttendanceFCById(Integer id);
	void save(AttendanceFCModel afcm);
	void delete(AttendanceFCModel afcm);
	
}

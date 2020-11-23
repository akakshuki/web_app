package c1808g1.aem_api.service.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyLichHoc.ScheduleModel;

public interface ScheduleService {
	List<ScheduleModel> ListAllSchedule();
	Optional<ScheduleModel> ListScheduleById(Integer id);
	void save(ScheduleModel sm);
	void delete(ScheduleModel sm);
}

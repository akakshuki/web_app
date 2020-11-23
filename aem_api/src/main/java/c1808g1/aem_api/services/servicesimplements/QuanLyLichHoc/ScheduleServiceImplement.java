package c1808g1.aem_api.services.servicesimplements.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.ScheduleModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.ScheduleRepository;
import c1808g1.aem_api.services.QuanLyLichHoc.ScheduleService;

@Service
public class ScheduleServiceImplement implements ScheduleService{
	private ScheduleRepository SRepo;

	@Override
	public List<ScheduleModel> ListAllSchedule() {
		return (List<ScheduleModel>) SRepo.findAll();
	}

	@Override
	public Optional<ScheduleModel> ListScheduleById(Integer id) {
		return (Optional<ScheduleModel>) SRepo.findById(id);
	}

	@Override
	public void save(ScheduleModel sm) {
		SRepo.save(sm);
	}

	@Override
	public void delete(ScheduleModel sm) {
		SRepo.delete(sm);
	}
}

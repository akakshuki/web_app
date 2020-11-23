package c1808g1.aem_api.services.servicesimplements.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceFCModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.AttendanceFCRepository;
import c1808g1.aem_api.services.QuanLyLichHoc.AttendanceFCService;

@Service
public class AttendanceFCServiceImplement implements AttendanceFCService{
	private AttendanceFCRepository AFCRepo;

	@Override
	public List<AttendanceFCModel> ListAllAttendanceFC() {
		return (List<AttendanceFCModel>) AFCRepo.findAll();
	}

	@Override
	public Optional<AttendanceFCModel> ListAttendanceFCById(Integer id) {
		return (Optional<AttendanceFCModel>) AFCRepo.findById(id);
	}

	@Override
	public void save(AttendanceFCModel afcm) {
		AFCRepo.save(afcm);
	}

	@Override
	public void delete(AttendanceFCModel afcm) {
		AFCRepo.delete(afcm);
	}
}

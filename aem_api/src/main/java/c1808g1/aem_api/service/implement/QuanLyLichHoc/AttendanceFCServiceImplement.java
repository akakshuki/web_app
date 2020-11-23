package c1808g1.aem_api.service.implement.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceFCModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.AttendanceFCRepository;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceFCService;

@Service
public class AttendanceFCServiceImplement implements AttendanceFCService{
	private AttendanceFCRepository AFCRepo;

	@Override
	public List<AttendanceFCModel> ListAllAttendanceFC() {
		return (List<AttendanceFCModel>) AFCRepo.findAll();
	}

	@Override
	public AttendanceFCModel ListAttendanceFCById(Integer id) {
		return AFCRepo.findById(id).get();
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

package c1808g1.aem_api.services.servicesimplements.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.AttendanceRepository;
import c1808g1.aem_api.services.QuanLyLichHoc.AttendanceService;

@Service
public class AttendanceServiceImplement implements AttendanceService{
	private AttendanceRepository ARepo;

	@Override
	public List<AttendanceModel> ListAllAttendance() {
		return (List<AttendanceModel>) ARepo.findAll();
	}

	@Override
	public Optional<AttendanceModel> ListAttendanceById(Integer id) {
		return (Optional<AttendanceModel>) ARepo.findById(id);
	}

	@Override
	public void save(AttendanceModel am) {
		ARepo.save(am);
	}

	@Override
	public void delete(AttendanceModel am) {
		ARepo.delete(am);
	}
}

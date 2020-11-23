package c1808g1.aem_api.service.implement.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.AttendanceRepository;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceService;

@Service
public class AttendanceServiceImplement implements AttendanceService{
	private AttendanceRepository ARepo;
	
	
	@Autowired
	public AttendanceServiceImplement(AttendanceRepository aRepo) {
		this.ARepo = aRepo;
	}

	@Override
	public List<AttendanceModel> ListAllAttendance() {
		return (List<AttendanceModel>) ARepo.findAll();
	}

	@Override
	public AttendanceModel ListAttendanceById(Integer id) {
		return  ARepo.findById(id).get();
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

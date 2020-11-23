package c1808g1.aem_api.service.implement.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.AttendanceStudentRepository;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceStudentService;

@Service
public class AttendanceStudentServiceImplement implements AttendanceStudentService{
	private AttendanceStudentRepository ASRepo;
	
	@Override
	public List<AttendanceStudentModel> ListAllAttendanceStudent() {
		return (List<AttendanceStudentModel>) ASRepo.findAll();
	}

	@Override
	public AttendanceStudentModel ListAttendanceStudentById(Integer id) {
		return ASRepo.findById(id).get();
	}

	@Override
	public void save(AttendanceStudentModel asm) {
		ASRepo.save(asm);
	}

	@Override
	public void delete(AttendanceStudentModel asm) {
		ASRepo.delete(asm);
	}

}

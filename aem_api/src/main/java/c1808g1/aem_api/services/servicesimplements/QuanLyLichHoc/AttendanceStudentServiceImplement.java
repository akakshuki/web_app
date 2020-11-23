package c1808g1.aem_api.services.servicesimplements.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;
import c1808g1.aem_api.repositories.QuanLyLichHoc.AttendanceStudentRepository;
import c1808g1.aem_api.services.QuanLyLichHoc.AttendanceStudentService;

@Service
public class AttendanceStudentServiceImplement implements AttendanceStudentService{
	private AttendanceStudentRepository ASRepo;
	
	@Override
	public List<AttendanceStudentModel> ListAllAttendanceStudent() {
		return (List<AttendanceStudentModel>) ASRepo.findAll();
	}

	@Override
	public Optional<AttendanceStudentModel> ListAttendanceStudentById(Integer id) {
		return (Optional<AttendanceStudentModel>) ASRepo.findById(id);
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

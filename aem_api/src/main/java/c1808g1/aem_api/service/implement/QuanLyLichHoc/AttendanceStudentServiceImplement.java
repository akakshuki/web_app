package c1808g1.aem_api.service.implement.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;
import c1808g1.aem_api.repository.QuanLyLichHoc.AttendanceStudentRepository;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceStudentService;

@Service
public class AttendanceStudentServiceImplement implements AttendanceStudentService{
	private AttendanceStudentRepository ASRepo;
	
	
	@Autowired
	public AttendanceStudentServiceImplement(AttendanceStudentRepository aSRepo) {
		ASRepo = aSRepo;
	}

	@Override
	public List<AttendanceStudentModel> getAllAttendanceStudent() {
		return (List<AttendanceStudentModel>) ASRepo.findAll();
	}

	@Override
	public AttendanceStudentModel getAttendanceStudentById(Integer id) {
		return ASRepo.findById(id).get();
	}

	@Override
	public void save(AttendanceStudentModel asm) {
		//ASRepo.insertAttendanceStudent(asm.getAttendance_id(), asm.getStudent_id(),asm.getCheck_in(),asm.getCheck_out(),asm.getMinute_late(),asm.getMinute_leave_early(),asm.getStatus_id(),asm.getNote() );
		ASRepo.save(asm);
	}

	@Override
	public void delete(AttendanceStudentModel asm) {
		ASRepo.delete(asm);
	}

}

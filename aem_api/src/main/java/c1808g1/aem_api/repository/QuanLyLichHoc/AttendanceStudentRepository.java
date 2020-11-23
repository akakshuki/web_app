package c1808g1.aem_api.repository.QuanLyLichHoc;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;

@Repository
public interface AttendanceStudentRepository extends JpaRepository<AttendanceStudentModel, Integer> {
	@Query(value = "insert into attendance_student (attendance_id,student_id,check_in,check_out,minute_late,minute_leave_early,status_id,note) values (:attendance_id,:student_id,:check_in,:check_out,:minute_late,:minute_leave_early,:status_id,:note)", nativeQuery = true)
	AttendanceStudentModel insertAttendanceStudent(@Param("attendance_id") int attendance_id, @Param("student_id") String student_id,
			@Param("check_in") Timestamp check_in, @Param("check_out") Timestamp check_out,
			@Param("minute_late") int minute_late, @Param("minute_leave_early") int minute_leave_early,
			@Param("status_id") int status_id, @Param("note") String note);
}

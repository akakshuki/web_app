package c1808g1.aem_api.repository.QuanLyLichHoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceModel;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceModel,Integer>{

}

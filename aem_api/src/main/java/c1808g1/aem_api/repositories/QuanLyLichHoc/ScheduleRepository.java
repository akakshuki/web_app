package c1808g1.aem_api.repositories.QuanLyLichHoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyLichHoc.ScheduleModel;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleModel,Integer>{

}

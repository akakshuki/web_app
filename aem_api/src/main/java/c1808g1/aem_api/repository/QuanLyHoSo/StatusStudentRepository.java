package c1808g1.aem_api.repository.QuanLyHoSo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyHoSo.StatusStudentModel;

@Repository
public interface StatusStudentRepository extends JpaRepository<StatusStudentModel, Integer>{

}

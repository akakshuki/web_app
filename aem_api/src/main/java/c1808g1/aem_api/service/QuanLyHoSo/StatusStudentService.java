package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.StatusStudentModel;

public interface StatusStudentService {
	List<StatusStudentModel> findAllStatusStudent();
	Optional<StatusStudentModel> findStatusStudentById(Integer id);
	void save(StatusStudentModel stastu);
	void remove(StatusStudentModel stastu);
}

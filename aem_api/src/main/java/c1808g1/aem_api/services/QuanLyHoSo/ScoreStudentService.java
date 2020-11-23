package c1808g1.aem_api.services.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.ScoreStudentModel;

public interface ScoreStudentService {
	List<ScoreStudentModel> ListAllScoreStudent();
	Optional<ScoreStudentModel> ListScoreStudentById(Integer id);
	void save(ScoreStudentModel ssm);
	void delete(ScoreStudentModel ssm);
}

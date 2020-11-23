package c1808g1.aem_api.services.DonTu;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.DonTu.RegisExamModel;

public interface RegisExamService {
	List<RegisExamModel> ListAllRegisExam();
	Optional<RegisExamModel> ListRegisExamById(Integer id);
	void save(RegisExamModel rem);
	void delete(RegisExamModel rem);
}

package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.ScoreFCModel;

public interface ScoreFCService {
	List<ScoreFCModel> ListAllScoreFC();
	Optional<ScoreFCModel> ListScoreFCById(Integer id);
	void save(ScoreFCModel sfcm);
	void delete(ScoreFCModel sfcm);
}

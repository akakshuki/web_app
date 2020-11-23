package c1808g1.aem_api.services.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.FCModel;

public interface FCService {
	List<FCModel> ListAllFC();
	Optional<FCModel> ListFCById(String id_fc);
	void save(FCModel fc);
	void delete(FCModel fc);
}

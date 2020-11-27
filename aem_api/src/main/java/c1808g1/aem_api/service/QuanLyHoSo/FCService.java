package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.FCModel;

public interface FCService {
	List<FCModel> ListAllFC();
	FCModel ListFCById(String id_fc);
	FCModel ListFCByEmailAndPassword(String email,String password);
	void save(FCModel fc);
	void delete(FCModel fc);
}

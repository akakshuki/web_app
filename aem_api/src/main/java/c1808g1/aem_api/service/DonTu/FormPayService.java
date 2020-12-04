package c1808g1.aem_api.service.DonTu;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.DonTu.FormPayModel;

public interface FormPayService {
	List<FormPayModel> ListAllFormPay();
	FormPayModel ListFormPayById(Integer id);
	void save(FormPayModel fpm);	
	void delete(FormPayModel fpm);
}

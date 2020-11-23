package c1808g1.aem_api.service.CauHinh;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.CauHinh.SkuModel;

public interface SkuService {
	List<SkuModel> findAllSku();
	SkuModel findSkuById(Integer id);
	void save(SkuModel skuModel);
	void remove(SkuModel skuModel);
}

package c1808g1.aem_api.service.DonTu;

import java.util.*;

import c1808g1.aem_api.models.DonTu.ExemptionMs;

public interface ExemptionMsService {
	List<ExemptionMs> findAllExemptionMs();
	Optional<ExemptionMs> findById(Integer id);
	void save(ExemptionMs ems);
	void remove(ExemptionMs ems);
}

package c1808g1.aem_api.service.implement.DonTu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.DonTu.ExemptionMs;
import c1808g1.aem_api.repository.DonTu.ExemptionMsRepository;
import c1808g1.aem_api.service.DonTu.ExemptionMsService;

@Service
public class ExemptionMsServiceImplement implements ExemptionMsService {
	private ExemptionMsRepository emsrepo;

	@Autowired
	public ExemptionMsServiceImplement(ExemptionMsRepository emsrepo) {
		this.emsrepo = emsrepo;
	}
	@Override
	public List<ExemptionMs> findAllExemptionMs() {
		 
		return (List<ExemptionMs>) emsrepo.findAll();
	}

	@Override
	public ExemptionMs findExemptionMsById(Integer id) {
		 
		return emsrepo.findById(id).get();
	}

	@Override
	public void save(ExemptionMs ems) {
		 
		emsrepo.save(ems);
	}

	@Override
	public void remove(ExemptionMs ems) {
		 
		emsrepo.delete(ems);
	}

}

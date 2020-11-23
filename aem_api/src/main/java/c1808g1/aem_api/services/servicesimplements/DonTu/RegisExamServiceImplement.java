package c1808g1.aem_api.services.servicesimplements.DonTu;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.DonTu.RegisExamModel;
import c1808g1.aem_api.repositories.DonTu.RegisExamRepository;
import c1808g1.aem_api.services.DonTu.RegisExamService;

@Service
public class RegisExamServiceImplement implements RegisExamService{
	private RegisExamRepository RERepo;

	@Override
	public Optional<RegisExamModel> ListRegisExamById(Integer id) {
		return (Optional<RegisExamModel>) RERepo.findById(id);
	}

	@Override
	public void save(RegisExamModel rem) {
		RERepo.save(rem);
	}

	@Override
	public void delete(RegisExamModel rem) {
		RERepo.delete(rem);
	}

	@Override
	public List<RegisExamModel> ListAllRegisExam() {
		return (List<RegisExamModel>) RERepo.findAll();
	}
}

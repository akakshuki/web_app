package c1808g1.aem_api.service.implement.DonTu;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.DonTu.RegisExamModel;
import c1808g1.aem_api.repository.DonTu.RegisExamRepository;
import c1808g1.aem_api.service.DonTu.RegisExamService;

@Service
public class RegisExamServiceImplement implements RegisExamService{
	private RegisExamRepository RERepo;

	@Override
	public RegisExamModel ListRegisExamById(Integer id) {
		return RERepo.findById(id).get();
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

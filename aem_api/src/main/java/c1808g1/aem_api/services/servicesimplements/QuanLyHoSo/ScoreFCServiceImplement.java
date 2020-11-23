package c1808g1.aem_api.services.servicesimplements.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.ScoreFCModel;
import c1808g1.aem_api.repository.QuanLyHoSo.ScoreFCRepository;
import c1808g1.aem_api.services.QuanLyHoSo.ScoreFCService;

@Service
public class ScoreFCServiceImplement implements ScoreFCService{
	private ScoreFCRepository SFCRepo;
	
	@Override
	public List<ScoreFCModel> ListAllScoreFC() {
		return (List<ScoreFCModel>) SFCRepo.findAll();
	}

	@Override
	public Optional<ScoreFCModel> ListScoreFCById(Integer id) {
		return (Optional<ScoreFCModel>) SFCRepo.findById(id);
	}

	@Override
	public void save(ScoreFCModel sfcm) {
		SFCRepo.save(sfcm);
	}

	@Override
	public void delete(ScoreFCModel sfcm) {
		SFCRepo.delete(sfcm);
	}

}

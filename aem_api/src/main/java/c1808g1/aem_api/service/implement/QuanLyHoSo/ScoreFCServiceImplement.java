package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.ScoreFCModel;
import c1808g1.aem_api.repository.QuanLyHoSo.PermissionRoleRepository;
import c1808g1.aem_api.repository.QuanLyHoSo.ScoreFCRepository;
import c1808g1.aem_api.service.QuanLyHoSo.ScoreFCService;

@Service
public class ScoreFCServiceImplement implements ScoreFCService{
	private ScoreFCRepository SFCRepo;
	
	@Autowired
	public ScoreFCServiceImplement(ScoreFCRepository SFCRepo) {
		this.SFCRepo=SFCRepo;
	}
	
	@Override
	public List<ScoreFCModel> ListAllScoreFC() {
		return (List<ScoreFCModel>) SFCRepo.findAll();
	}

	@Override
	public ScoreFCModel ListScoreFCById(Integer id) {
		return SFCRepo.findById(id).get();
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

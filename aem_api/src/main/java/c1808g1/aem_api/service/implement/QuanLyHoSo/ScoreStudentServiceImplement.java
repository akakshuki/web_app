package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.ScoreStudentModel;
import c1808g1.aem_api.repository.QuanLyHoSo.ScoreStudentRepository;
import c1808g1.aem_api.repository.QuanLyHoSo.StudentRepository;
import c1808g1.aem_api.service.QuanLyHoSo.ScoreStudentService;

@Service
public class ScoreStudentServiceImplement implements ScoreStudentService{
	private ScoreStudentRepository SSRepo;
	
	@Autowired
	public ScoreStudentServiceImplement (ScoreStudentRepository SSRepo) {
		this.SSRepo = SSRepo;
	}
	
	@Override
	public List<ScoreStudentModel> ListAllScoreStudent() {
		return (List<ScoreStudentModel>) SSRepo.findAll();
	}

	@Override
	public ScoreStudentModel ListScoreStudentById(Integer id) {
		return SSRepo.findById(id).get();
	}

	@Override
	public void save(ScoreStudentModel ssm) {
		SSRepo.save(ssm);
	}

	@Override
	public void delete(ScoreStudentModel ssm) {
		SSRepo.delete(ssm);
	}

}

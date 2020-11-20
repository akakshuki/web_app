package c1808g1.aem_api.service.implement.CauHinh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.CauHinh.ShiftStudyModel;
import c1808g1.aem_api.repository.CauHinh.ShiftStudyRepository;
import c1808g1.aem_api.service.CauHinh.ShiftStudyService;

@Service
public class ShiftStudyServiceImplement implements ShiftStudyService{
	private ShiftStudyRepository shiftRepo;
	
	@Autowired
	public ShiftStudyServiceImplement(ShiftStudyRepository shiftRepo) {
		this.shiftRepo=shiftRepo;
	}
	
	@Override
	public List<ShiftStudyModel> findAllShift(){
		return (List<ShiftStudyModel>) shiftRepo.findAll();
	}
	
	@Override
	public Optional<ShiftStudyModel> findShiftById(Integer id){
		return shiftRepo.findById(id);
	}
	
	@Override
	public void save(ShiftStudyModel ShiftStudyModel){
		shiftRepo.save(ShiftStudyModel);
	}
	
	@Override
	public void remove(ShiftStudyModel ShiftStudyModel){
		shiftRepo.delete(ShiftStudyModel);
	}
}

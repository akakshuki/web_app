package c1808g1.aem_api.service.implement.CauHinh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.CauHinh.StatusModel;
import c1808g1.aem_api.repository.CauHinh.StatusRepository;
import c1808g1.aem_api.service.CauHinh.StatusService;

@Service
public class StatusServiceImplement implements StatusService{
	private StatusRepository statusRepo;
	
	@Autowired
	public StatusServiceImplement(StatusRepository statusRepo) {
		this.statusRepo=statusRepo;
	}
	
	@Override
	public List<StatusModel> findAllStatus(){
		return (List<StatusModel>) statusRepo.findAll();
	}
	
	@Override
	public List<StatusModel> findStatusByGroupType(int group_type){
		return (List<StatusModel>) statusRepo.findByGroup_Type(group_type);
	}
	
	@Override
	public StatusModel findStatusById(Integer id){
		return statusRepo.findById(id).get();
	}
	
	@Override
	public void save(StatusModel stat){
		statusRepo.save(stat);
	}
	
	@Override
	public void remove(StatusModel stat){
		statusRepo.delete(stat);
	}
}

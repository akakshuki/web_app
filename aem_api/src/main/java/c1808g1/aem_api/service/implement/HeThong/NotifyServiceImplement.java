package c1808g1.aem_api.service.implement.HeThong;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.HeThong.NotifyModel;
import c1808g1.aem_api.repository.HeThong.NotifyRepository;
import c1808g1.aem_api.service.HeThong.NotifyService;

@Service
public class NotifyServiceImplement implements NotifyService{
	private NotifyRepository notifyRepo;
	
	@Autowired
	public NotifyServiceImplement(NotifyRepository notifyRepo) {
		this.notifyRepo=notifyRepo;
	}
	
	@Override
	public List<NotifyModel> findAllNotify(){
		return (List<NotifyModel>) notifyRepo.findAll();
	}
	
	@Override
	public NotifyModel findNotifyById(Integer id){
		return notifyRepo.findById(id).get();
	}
	
	@Override
	public void save(NotifyModel notify){
		notifyRepo.save(notify);
	}
	
	@Override
	public void remove(NotifyModel notify){
		notifyRepo.delete(notify);
	}
}

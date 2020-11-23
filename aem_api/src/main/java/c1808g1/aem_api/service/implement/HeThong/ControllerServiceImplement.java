package c1808g1.aem_api.service.implement.HeThong;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.HeThong.Controller;
import c1808g1.aem_api.repository.HeThong.ControllerRepository;
import c1808g1.aem_api.service.HeThong.ControllerService;



@Service
public class ControllerServiceImplement implements ControllerService {
	private ControllerRepository clrepo;

	@Autowired
	public ControllerServiceImplement(ControllerRepository clrepo) {
		this.clrepo = clrepo;
	}
	@Override
	public List<Controller> findAllController() {
		 
		return (List<Controller>) clrepo.findAll();
	}

	@Override
	public Controller findControllerById(String id) {
		 
		return clrepo.findById(id).get();
	}

	@Override
	public void save(Controller cl) {
		 
		clrepo.save(cl);
	}

	@Override
	public void remove(Controller cl) {
		 
		clrepo.delete(cl);
	}
}
package c1808g1.aem_api.service.HeThong;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.HeThong.Controller;

public interface ControllerService {
	List<Controller> findAllController();
	Controller findControllerById(String id);
	void save(Controller cl);
	void remove(Controller cl);
}

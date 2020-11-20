package c1808g1.aem_api.service.HeThong;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.HeThong.*;

public interface RoleService {
	List<Role> findAllRole();
	Optional<Role> findById(Integer id);
	void save(Role rs);
	void remove(Role rs);
}

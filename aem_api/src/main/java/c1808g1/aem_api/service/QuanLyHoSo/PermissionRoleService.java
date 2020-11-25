package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.PermissionRoleModel;


public interface PermissionRoleService {
	List<PermissionRoleModel> findAllPermissionRole();
	PermissionRoleModel findPermissionRoleById(Integer id);
	void save(PermissionRoleModel pr);
	void remove(PermissionRoleModel pr);
}

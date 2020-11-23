package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.PermissionRoleModel;
import c1808g1.aem_api.repository.QuanLyHoSo.PermissionRoleRepository;
import c1808g1.aem_api.service.QuanLyHoSo.PermissionRoleService;

@Service
public class PermissionRoleServiceImplement implements PermissionRoleService{
	private PermissionRoleRepository prRepo;
	
	@Autowired
	public PermissionRoleServiceImplement(PermissionRoleRepository prRepo) {
		this.prRepo=prRepo;
	}
	
	@Override
	public List<PermissionRoleModel> findAllPermissionRole(){
		return (List<PermissionRoleModel>) prRepo.findAll();
	}
	
	@Override
	public Optional<PermissionRoleModel> findPermissionRoleById(Integer id){
		return prRepo.findById(id);
	}
	
	@Override
	public void save(PermissionRoleModel holi){
		prRepo.save(holi);
	}
	
	@Override
	public void remove(PermissionRoleModel holi){
		prRepo.delete(holi);
	}
}

package c1808g1.aem_api.repository.QuanLyHoSo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyHoSo.PermissionRoleModel;

@Repository
public interface PermissionRoleRepository extends JpaRepository<PermissionRoleModel, Integer>{

}

package c1808g1.aem_api.repository.HeThong;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.HeThong.Controller;



@Repository
public interface ControllerRepository  extends JpaRepository<Controller,String>{
	@Query(value="select * from controller u where u.menu_root =:menu", nativeQuery=true)
	List<Controller> findByMenu_Root(@Param("menu") String menu_root);
}

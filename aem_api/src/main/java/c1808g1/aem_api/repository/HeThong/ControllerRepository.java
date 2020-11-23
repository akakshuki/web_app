package c1808g1.aem_api.repository.HeThong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.HeThong.Controller;



@Repository
public interface ControllerRepository  extends JpaRepository<Controller,String>{

}

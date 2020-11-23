package c1808g1.aem_api.repositories.QuanLyHoSo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,String>{

}
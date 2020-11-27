package c1808g1.aem_api.repository.QuanLyHoSo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,String>{
	@Query(value = "select * from employee s where s.email_emp=:email and s.password=:password", nativeQuery = true)
	EmployeeModel findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
package c1808g1.aem_api.repository.QuanLyHoSo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyHoSo.FCModel;

@Repository
public interface FCRepository extends JpaRepository<FCModel,String>{
	@Query(value = "select * from fc s where s.email_school=:email and s.password=:password", nativeQuery = true)
	FCModel findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}





package c1808g1.aem_api.repository.QuanLyHoSo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,String>{
	@Query(value = "select * from student s where s.email_school=:email and s.password=:password", nativeQuery = true)
	StudentModel findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	@Query(value = "select * from student s where s.mobile_mac=:mobile", nativeQuery = true)
	StudentModel findByMobileMac(@Param("mobile") String mobile);
}
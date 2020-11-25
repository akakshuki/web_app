package c1808g1.aem_api.repository.CauHinh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.CauHinh.StatusModel;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Integer>{
	@Query(value="select * from status u where u.group_type =:type", nativeQuery=true)
	List<StatusModel> findByGroup_Type(@Param("type") int group_type);
}

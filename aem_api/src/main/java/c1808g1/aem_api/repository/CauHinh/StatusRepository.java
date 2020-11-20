package c1808g1.aem_api.repository.CauHinh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.CauHinh.StatusModel;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Integer>{

}

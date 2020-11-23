package c1808g1.aem_api.repositories.DonTu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.DonTu.RegisExamModel;

@Repository
public interface RegisExamRepository extends JpaRepository<RegisExamModel,Integer>{

}

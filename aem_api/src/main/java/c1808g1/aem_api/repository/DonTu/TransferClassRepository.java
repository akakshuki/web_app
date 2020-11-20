package c1808g1.aem_api.repository.DonTu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.DonTu.TransferClass;



@Repository
public interface TransferClassRepository extends JpaRepository<TransferClass,Integer>{

}

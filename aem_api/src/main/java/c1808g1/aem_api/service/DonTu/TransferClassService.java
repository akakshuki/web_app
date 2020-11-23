package c1808g1.aem_api.service.DonTu;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.DonTu.TransferClass;

public interface TransferClassService {
	List<TransferClass> findAllTransferClass();
	Optional<TransferClass> findById(Integer id);
	void save(TransferClass tcs);
	void remove(TransferClass tcs);
}

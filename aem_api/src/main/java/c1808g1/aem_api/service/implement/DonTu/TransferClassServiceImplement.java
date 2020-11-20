package c1808g1.aem_api.service.implement.DonTu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.DonTu.TransferClass;
import c1808g1.aem_api.repository.DonTu.TransferClassRepository;
import c1808g1.aem_api.service.DonTu.TransferClassService;



@Service
public class TransferClassServiceImplement implements TransferClassService {
	private TransferClassRepository tfcrepo;

	@Autowired
	public TransferClassServiceImplement(TransferClassRepository tfcrepo) {
		this.tfcrepo = tfcrepo;
	}
	@Override
	public List<TransferClass> findAllTransferClass() {
		// TODO Auto-generated method stub
		return (List<TransferClass>) tfcrepo.findAll();
	}

	@Override
	public Optional<TransferClass> findById(Integer id) {
		// TODO Auto-generated method stub
		return tfcrepo.findById(id);
	}

	@Override
	public void save(TransferClass tfc) {
		// TODO Auto-generated method stub
		tfcrepo.save(tfc);
	}

	@Override
	public void remove(TransferClass tfc) {
		// TODO Auto-generated method stub
		tfcrepo.delete(tfc);
	}
}
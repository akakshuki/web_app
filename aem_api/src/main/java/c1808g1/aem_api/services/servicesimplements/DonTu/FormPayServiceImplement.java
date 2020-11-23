package c1808g1.aem_api.services.servicesimplements.DonTu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.DonTu.FormPayModel;
import c1808g1.aem_api.repository.DonTu.FormPayRepository;
import c1808g1.aem_api.services.DonTu.FormPayService;

@Service
public class FormPayServiceImplement implements FormPayService{
	private FormPayRepository FPRepo;
	
	@Autowired
	public FormPayServiceImplement (FormPayRepository FPRepo) {
		this.FPRepo = FPRepo;
	}
	
	@Override
	public List<FormPayModel> ListAllFormPay() {
		return (List<FormPayModel>) FPRepo.findAll();
	}
	@Override
	public Optional<c1808g1.aem_api.models.DonTu.FormPayModel> ListFormPayById(Integer id) {
		return (Optional<FormPayModel>) FPRepo.findById(id);
	}
	@Override
	public void save(c1808g1.aem_api.models.DonTu.FormPayModel fpm) {
		FPRepo.save(fpm);
	}
	@Override
	public void delete(c1808g1.aem_api.models.DonTu.FormPayModel fpm) {
		FPRepo.delete(fpm);
	}
}

package c1808g1.aem_api.service.implement.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.QuanLyHoSo.FCModel;
import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;
import c1808g1.aem_api.repository.QuanLyHoSo.FCRepository;
import c1808g1.aem_api.service.QuanLyHoSo.FCService;

@Service
public class FCServiceImplement implements FCService{
	private FCRepository FCRepo;
	
	@Autowired
	public FCServiceImplement ( FCRepository FCRepo) {
		this.FCRepo = FCRepo;
	}
	
	@Override
	public List<FCModel> ListAllFC(){
		return (List<FCModel>) FCRepo.findAll();
	}
	
	@Override
	public FCModel ListFCById(String id_fc){
		return FCRepo.findById(id_fc).get();
	}
	
	@Override
	public FCModel ListFCByEmailAndPassword(String email,String password){
		return FCRepo.findByEmailAndPassword(email, password);
	}
	
	@Override
	public void save(FCModel fc) {
		FCRepo.save(fc);
	}
	
	@Override
	public void delete(FCModel fc) {
		FCRepo.delete(fc);
	}


}
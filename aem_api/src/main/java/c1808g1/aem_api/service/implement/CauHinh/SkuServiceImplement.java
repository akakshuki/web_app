package c1808g1.aem_api.service.implement.CauHinh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.CauHinh.SkuModel;
import c1808g1.aem_api.repository.CauHinh.SkuRepository;
import c1808g1.aem_api.service.CauHinh.SkuService;

@Service
public class SkuServiceImplement implements SkuService{
	private SkuRepository skuRepo;
	
	@Autowired
	public SkuServiceImplement(SkuRepository skuRepo) {
		this.skuRepo=skuRepo;
	}
	
	@Override
	public List<SkuModel> findAllSku(){
		return (List<SkuModel>) skuRepo.findAll();
	}
	
	@Override
	public SkuModel findSkuById(Integer id){
		return skuRepo.findById(id).get();
	}
	
	@Override
	public void save(SkuModel skuModel){
		skuRepo.save(skuModel);
	}
	
	@Override
	public void remove(SkuModel skuModel){
		skuRepo.delete(skuModel);
	}
}

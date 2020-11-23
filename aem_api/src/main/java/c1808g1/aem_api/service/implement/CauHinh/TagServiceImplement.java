package c1808g1.aem_api.service.implement.CauHinh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.CauHinh.TagModel;
import c1808g1.aem_api.repository.CauHinh.TagRepository;
import c1808g1.aem_api.service.CauHinh.TagService;

@Service
public class TagServiceImplement implements TagService{
	private TagRepository tagRepo;
	
	@Autowired
	public TagServiceImplement(TagRepository tagRepo) {
		this.tagRepo=tagRepo;
	}
	
	@Override
	public List<TagModel> findAllTag(){
		return (List<TagModel>) tagRepo.findAll();
	}
	
	@Override
	public TagModel findTagById(String id){
		return tagRepo.findById(id).get();
	}
	
	@Override
	public void save(TagModel tag){
		tagRepo.save(tag);
	}
	
	@Override
	public void remove(TagModel tag){
		tagRepo.delete(tag);
	}
}

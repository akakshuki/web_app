package c1808g1.aem_api.service.CauHinh;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.CauHinh.TagModel;

public interface TagService {
	List<TagModel> findAllTag();
	Optional<TagModel> findTagById(String id);
	void save(TagModel tag);
	void remove(TagModel tag);
}

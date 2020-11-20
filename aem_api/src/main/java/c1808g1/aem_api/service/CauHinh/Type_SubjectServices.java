package c1808g1.aem_api.service.CauHinh;
import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.CauHinh.Type_Subject;

public interface Type_SubjectServices {
	List<Type_Subject> findAllType_Subject();
	Optional<Type_Subject> findById(Integer id);
	void save(Type_Subject type_subject);
	void remove(Type_Subject type_subject);
}

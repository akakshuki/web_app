package c1808g1.aem_api.service.QuanLyChuongTrinhHoc;
import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Subject;

public interface SubjectServices {
	List<Subject> findAllSubject();
	Optional<Subject> findById(Integer id);
	void save(Subject subject);
	void remove(Subject subject);
}
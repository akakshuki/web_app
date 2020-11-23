package c1808g1.aem_api.service.QuanLyChuongTrinhHoc;
import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Class;

public interface ClassServices {
	List<Class> findAllClass();
	Optional<Class> findById(String id);
	void save(Class classV);
	void remove(Class classV);
}

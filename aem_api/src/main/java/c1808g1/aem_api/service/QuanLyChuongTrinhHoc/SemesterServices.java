package c1808g1.aem_api.service.QuanLyChuongTrinhHoc;
import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Semester;

public interface SemesterServices {
	List<Semester> findAllSemester();
	Optional<Semester> findById(Integer id);
	void save(Semester semester);
	void remove(Semester semester);
}

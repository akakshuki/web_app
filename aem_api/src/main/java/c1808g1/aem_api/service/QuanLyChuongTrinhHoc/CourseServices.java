package c1808g1.aem_api.service.QuanLyChuongTrinhHoc;
import java.util.List;

import java.util.Optional;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Course;

public interface CourseServices {
	List<Course> findAllCourse();
	Course findById(String id);
	void save(Course course);
	void remove(Course course);
}

package c1808g1.aem_api.repository.QuanLyChuongTrinhHoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}

package c1808g1.aem_api.repository.QuanLyChuongTrinhHoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}

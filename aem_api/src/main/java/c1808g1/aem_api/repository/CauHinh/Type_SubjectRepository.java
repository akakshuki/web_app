package c1808g1.aem_api.repository.CauHinh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.CauHinh.Type_Subject;

@Repository
public interface Type_SubjectRepository extends JpaRepository<Type_Subject, Integer> {

}
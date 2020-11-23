package c1808g1.aem_api.repository.CauHinh;

import java.util.Date;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.CauHinh.HolidayModel;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayModel, Integer>{
    // @Query("select h from holiday h where h.date_off=?1")
    // HolidayModel findByDate_Off(Date date_off);
}

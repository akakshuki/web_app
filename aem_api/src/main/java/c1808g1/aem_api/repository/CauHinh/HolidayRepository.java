package c1808g1.aem_api.repository.CauHinh;


import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import c1808g1.aem_api.models.CauHinh.HolidayModel;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayModel, Integer>{
     @Query(value="select * from holiday h where h.date_off=:date",nativeQuery = true)
     HolidayModel findByDate_Off(@Param("date") Date date);
}

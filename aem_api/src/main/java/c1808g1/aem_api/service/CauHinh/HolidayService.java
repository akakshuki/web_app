package c1808g1.aem_api.service.CauHinh;

import java.sql.Date;
import java.util.List;

import c1808g1.aem_api.models.CauHinh.HolidayModel;

public interface HolidayService {
	List<HolidayModel> findAllHoliday();
	HolidayModel findHolidayById(Integer id);
	HolidayModel findHolidayByDateOff(Date date);
	void save(HolidayModel holi);
	void remove(HolidayModel holi);
}

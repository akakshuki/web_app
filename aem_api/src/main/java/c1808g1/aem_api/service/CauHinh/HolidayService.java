package c1808g1.aem_api.service.CauHinh;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.CauHinh.HolidayModel;

public interface HolidayService {
	List<HolidayModel> findAllHoliday();
	Optional<HolidayModel> findHolidayById(Integer id);
	// HolidayModel findHolidayByDateOff(Date date_off);
	void save(HolidayModel holi);
	void remove(HolidayModel holi);
}

package c1808g1.aem_api.service.implement.CauHinh;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.CauHinh.HolidayModel;
import c1808g1.aem_api.repository.CauHinh.HolidayRepository;
import c1808g1.aem_api.service.CauHinh.HolidayService;


@Service
public class HolidayServiceImplement implements HolidayService{
	private HolidayRepository holiRepo;
	
	@Autowired
	public HolidayServiceImplement(HolidayRepository holiRepo) {
		this.holiRepo=holiRepo;
	}
	
	@Override
	public List<HolidayModel> findAllHoliday(){
		return (List<HolidayModel>) holiRepo.findAll();
	}
	
	@Override
	public Optional<HolidayModel> findHolidayById(Integer id){
		return holiRepo.findById(id);
	}
	// @Override
	// public HolidayModel findHolidayByDateOff(Date id){
	// 	return holiRepo.findByDate_Off(id);
	// }
	
	@Override
	public void save(HolidayModel holi){
		holiRepo.save(holi);
	}
	
	@Override
	public void remove(HolidayModel holi){
		holiRepo.delete(holi);
	}
}

package c1808g1.aem_api.DAO.CauHinh;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import c1808g1.aem_api.models.CauHinh.HolidayModel;
import c1808g1.aem_api.service.CauHinh.HolidayService;

public class NgayNghiDAO {
    private HolidayService holiSv;
    @Autowired
	public NgayNghiDAO(HolidayService holiSv) {
		this.holiSv = holiSv;
	}
    public List<HolidayModel> getAll(){
        return holiSv.findAllHoliday();
    }
    public HolidayModel findById(int id){
        return holiSv.findHolidayById(id).get();
    }
    // public HolidayModel findByDateOff(Date dateOff){
    //     return holiSv.findHolidayByDateOff(dateOff);
    // }
}

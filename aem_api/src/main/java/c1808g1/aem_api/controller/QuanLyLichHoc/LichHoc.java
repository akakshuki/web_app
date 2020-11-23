package c1808g1.aem_api.controller.QuanLyLichHoc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import c1808g1.aem_api.models.QuanLyLichHoc.ScheduleModel;
import c1808g1.aem_api.services.QuanLyLichHoc.ScheduleService;


@RestController
@RequestMapping("api/dontu/lichhocapi")
public class LichHoc {
	private ScheduleService SSv;

	@Autowired
	public LichHoc (ScheduleService SSv) {
		this.SSv = SSv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduleModel>> ListAllSchedule(){
		List<ScheduleModel> lsd = SSv.ListAllSchedule();
		if (lsd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsd,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getScheduleById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleModel> ListScheduleById(@PathVariable("id") Integer id){
		Optional<ScheduleModel> osd = SSv.ListScheduleById(id);
		if(!osd.isPresent()) {
			return new ResponseEntity<>(osd.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(osd.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleModel> CreateSchedule(@RequestBody ScheduleModel sdm, UriComponentsBuilder builder){
		SSv.save(sdm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(sdm.getId()).toUri());
		return new ResponseEntity<>(sdm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ScheduleModel> updateSchedule(@PathVariable("id") Integer id,@RequestBody ScheduleModel usdm) {
        Optional<ScheduleModel> currentSchedule = SSv.ListScheduleById(id);

        if (!currentSchedule.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSchedule.get().setId(usdm.getId());
        currentSchedule.get().setList_fc(usdm.getList_fc());
        currentSchedule.get().setSubject_id(usdm.getSubject_id());
        currentSchedule.get().setClass_id(usdm.getClass_id());
        currentSchedule.get().setShift_id(usdm.getShift_id());
        currentSchedule.get().setBrand_id(usdm.getBrand_id());
        currentSchedule.get().setStart_date(usdm.getStart_date());
        currentSchedule.get().setEnd_date(usdm.getEnd_date());
        currentSchedule.get().setNote(usdm.getNote());
        currentSchedule.get().setList_student(usdm.getList_student());
        currentSchedule.get().setCoef_salary(usdm.getCoef_salary());
        currentSchedule.get().setCurrent_session(usdm.getCurrent_session());
        currentSchedule.get().setMax_session(usdm.getMax_session());

        SSv.save(currentSchedule.get());
        return new ResponseEntity<>(currentSchedule.get(), HttpStatus.OK);
    }

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ScheduleModel> deleteSchedule(@PathVariable("id") Integer id) {
		Optional<ScheduleModel> dsd = SSv.ListScheduleById(id);
		if (!dsd.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		SSv.delete(dsd.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
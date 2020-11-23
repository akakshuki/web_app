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

import c1808g1.Models.QuanLiLichHoc.ScheduleDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyLichHoc.ScheduleModel;
import c1808g1.aem_api.service.QuanLyLichHoc.ScheduleService;


@RestController
@RequestMapping("/api/dontu/lichhocapi")
public class LichHocController {
	private ScheduleService SSv;

	@Autowired
	public LichHocController (ScheduleService SSv) {
		this.SSv = SSv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduleDTO>> ListAllSchedule(){
		List<ScheduleModel> sm = SSv.ListAllSchedule();
		List<ScheduleDTO> sdto = ModelMapperConfig.mapList(sm, ScheduleDTO.class);
		if (sdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getScheduleById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleDTO> ListScheduleById(@PathVariable("id") Integer id){
		var data = SSv.ListScheduleById(id);
		ScheduleDTO sdto = ModelMapperConfig.modelMapper.map(data , ScheduleDTO.class);
		if(sdto == null){
			return new ResponseEntity<>(sdto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sdto , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleDTO> CreateSchedule(@RequestBody ScheduleDTO sdto, UriComponentsBuilder builder){
		ScheduleModel sm = ModelMapperConfig.modelMapper.map(sdto, ScheduleModel.class);
		SSv.save(sm);
		sdto.setId(sm.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(sdto.getId()).toUri());
		return new ResponseEntity<>(sdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable("id") Integer id,@RequestBody ScheduleDTO sdto) {
        ScheduleModel currentSchedule = SSv.ListScheduleById(id);

        if (currentSchedule == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSchedule.setId(sdto.getId());
        currentSchedule.setList_fc(sdto.getList_fc());
        currentSchedule.setSubject_id(sdto.getSubject_id());
        currentSchedule.setClass_id(sdto.getClass_id());
        currentSchedule.setShift_id(sdto.getShift_id());
        currentSchedule.setBrand_id(sdto.getBrand_id());
        currentSchedule.setStart_date(sdto.getStart_date());
        currentSchedule.setEnd_date(sdto.getEnd_date());
        currentSchedule.setNote(sdto.getNote());
        currentSchedule.setList_student(sdto.getList_student());
        currentSchedule.setCoef_salary(sdto.getCoef_salary());
        currentSchedule.setCurrent_session(sdto.getCurrent_session());
        currentSchedule.setMax_session(sdto.getMax_session());

        SSv.save(currentSchedule);
        return new ResponseEntity<>(sdto,HttpStatus.OK);
    }

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ScheduleModel> deleteSchedule(@PathVariable("id") Integer id) {
		ScheduleModel sm = SSv.ListScheduleById(id);
		if (sm == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

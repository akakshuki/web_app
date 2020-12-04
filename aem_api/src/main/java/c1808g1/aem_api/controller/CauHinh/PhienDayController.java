package c1808g1.aem_api.controller.CauHinh;

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

import c1808g1.Models.CauHinh.ShiftStudyDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.ShiftStudyModel;
import c1808g1.aem_api.service.CauHinh.ShiftStudyService;


@RestController
@RequestMapping("/api/cauhinh/shiftstudyapi")
public class PhienDayController {
	private ShiftStudyService shiftSv;
    @Autowired
	public PhienDayController(ShiftStudyService shiftSv) {
		this.shiftSv = shiftSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<ShiftStudyDTO>> findAllshift() {
		List<ShiftStudyModel> listshift = shiftSv.findAllShiftStudy();
		// List<ShiftStudyDTO> lsshift = listshift.stream().map(shift -> ModelMapperConfig.modelMapper.map(shift, ShiftStudyDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<ShiftStudyDTO> lsshift = ModelMapperConfig.mapList(listshift, ShiftStudyDTO.class);
		if (lsshift.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsshift, HttpStatus.OK);
	}

	@RequestMapping(value = "/getShiftStudyById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShiftStudyDTO> getshiftById(@PathVariable("id") Integer id) {
		var data = shiftSv.findShiftStudyById(id);
		//mapper từ entity -> DTO
		ShiftStudyDTO shift = ModelMapperConfig.modelMapper.map(data, ShiftStudyDTO.class);

		if (shift == null) {
			return new ResponseEntity<>(shift, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(shift, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShiftStudyDTO> createshift(@RequestBody ShiftStudyDTO shift, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		ShiftStudyModel shiftModel = ModelMapperConfig.modelMapper.map(shift, ShiftStudyModel.class);
		shiftSv.save(shiftModel);
		shift.setId(shiftModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/shift/{id}").buildAndExpand(shift.getId()).toUri());
		return new ResponseEntity<>(shift, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ShiftStudyDTO> updateshift(@PathVariable("id") Integer id, @RequestBody ShiftStudyDTO shift) {
		ShiftStudyModel currentshift = shiftSv.findShiftStudyById(id);
		
		if (currentshift == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentshift.setId(shift.getId());
		currentshift.setName_shift(shift.getName_shift());
		currentshift.setStart_time(shift.getStart_time());
		currentshift.setEnd_time(shift.getEnd_time());
		currentshift.setAllow_late(shift.getAllow_late());;
		currentshift.setAllow_leave_early(shift.getAllow_leave_early());;
		currentshift.setEven_or_odd(shift.getEven_or_odd());;
		currentshift.setNote(shift.getNote());


		shiftSv.save(currentshift);
		return new ResponseEntity<>(shift, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ShiftStudyModel> deleteshift(@PathVariable("id") Integer id) {
		ShiftStudyModel shift = shiftSv.findShiftStudyById(id);
		if (shift == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		shiftSv.remove(shift);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

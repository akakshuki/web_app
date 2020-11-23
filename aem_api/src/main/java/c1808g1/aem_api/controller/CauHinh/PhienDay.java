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

import c1808g1.aem_api.models.CauHinh.ShiftStudyModel;
import c1808g1.aem_api.service.CauHinh.ShiftStudyService;


@RestController
@RequestMapping("/cauhinh/shiftapi")
public class PhienDay {
	private ShiftStudyService shiftSv;

	@Autowired
	public PhienDay(ShiftStudyService shiftSv) {
		this.shiftSv = shiftSv;
	}

	@RequestMapping(value = "/shift", method = RequestMethod.GET)
	public ResponseEntity<List<ShiftStudyModel>> findAllshift() {
		List<ShiftStudyModel> shift = shiftSv.findAllShift();
		if (shift.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(shift, HttpStatus.OK);
	}

	@RequestMapping(value = "/shift/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShiftStudyModel> getshiftById(@PathVariable("id") Integer id) {
		Optional<ShiftStudyModel> shift = shiftSv.findShiftById(id);

		if (!shift.isPresent()) {
			return new ResponseEntity<>(shift.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(shift.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/shift", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShiftStudyModel> createshift(@RequestBody ShiftStudyModel shift, UriComponentsBuilder builder) {
		shiftSv.save(shift);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/shift/{id}").buildAndExpand(shift.getId()).toUri());
		return new ResponseEntity<>(shift, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/shift/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ShiftStudyModel> updateshift(@PathVariable("id") Integer id, @RequestBody ShiftStudyModel shift) {
		Optional<ShiftStudyModel> currentshift = shiftSv.findShiftById(id);

		if (!currentshift.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentshift.get().setId(shift.getId());
		currentshift.get().setName_shift(shift.getName_shift());
		currentshift.get().setStart_time(shift.getStart_time());
		currentshift.get().setEnd_time(shift.getEnd_time());
		currentshift.get().setAllow_late(shift.getAllow_late());;
		currentshift.get().setAllow_leave_early(shift.getAllow_leave_early());;
		currentshift.get().setEven_or_odd(shift.getEven_or_odd());;
		currentshift.get().setNote(shift.getNote());

		shiftSv.save(currentshift.get());
		return new ResponseEntity<>(currentshift.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/shift/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ShiftStudyModel> deleteshift(@PathVariable("id") Integer id) {
		Optional<ShiftStudyModel> shift = shiftSv.findShiftById(id);
		if (!shift.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		shiftSv.remove(shift.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

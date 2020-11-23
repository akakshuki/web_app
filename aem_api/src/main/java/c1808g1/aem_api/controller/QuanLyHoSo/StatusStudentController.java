package c1808g1.aem_api.controller.QuanLyHoSo;

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

import c1808g1.aem_api.models.QuanLyHoSo.StatusStudentModel;
import c1808g1.aem_api.service.QuanLyHoSo.StatusStudentService;

@RestController
@RequestMapping("/cauhinh/status_student_api")
public class StatusStudentController {
	private StatusStudentService StatusStudentSv;

	@Autowired
	public StatusStudentController(StatusStudentService StatusStudentSv) {
		this.StatusStudentSv = StatusStudentSv;
	}

	@RequestMapping(value = "/StatusStudentController", method = RequestMethod.GET)
	public ResponseEntity<List<StatusStudentModel>> findAllStatusStudent() {
		List<StatusStudentModel> StatusStudent = StatusStudentSv.findAllStatusStudent();
		if (StatusStudent.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(StatusStudent, HttpStatus.OK);
	}

	@RequestMapping(value = "/StatusStudentController/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusStudentModel> getStatusStudentById(@PathVariable("id") Integer id) {
		Optional<StatusStudentModel> StatusStudent = StatusStudentSv.findStatusStudentById(id);

		if (!StatusStudent.isPresent()) {
			return new ResponseEntity<>(StatusStudent.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(StatusStudent.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/StatusStudentController", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusStudentModel> createStatusStudent(@RequestBody StatusStudentModel StatusStudent,
			UriComponentsBuilder builder) {
		StatusStudentSv.save(StatusStudent);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/StatusStudentController/{id}").buildAndExpand(StatusStudent.getId()).toUri());
		return new ResponseEntity<>(StatusStudent, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/StatusStudentController/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StatusStudentModel> updateStatusStudent(@PathVariable("id") Integer id,
			@RequestBody StatusStudentModel StatusStudent) {
		Optional<StatusStudentModel> currentStatusStudent = StatusStudentSv.findStatusStudentById(id);

		if (!currentStatusStudent.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentStatusStudent.get().setId(StatusStudent.getId());
		currentStatusStudent.get().setStudent_id(StatusStudent.getStudent_id());
		currentStatusStudent.get().setStatus_id(StatusStudent.getStatus_id());
		currentStatusStudent.get().setStart_date(StatusStudent.getStart_date());
		currentStatusStudent.get().setEnd_date(StatusStudent.getEnd_date());
		currentStatusStudent.get().setNote(StatusStudent.getNote());
		currentStatusStudent.get().setCreator(StatusStudent.getCreator());
		currentStatusStudent.get().setDate_create(StatusStudent.getDate_create());

		StatusStudentSv.save(currentStatusStudent.get());
		return new ResponseEntity<>(currentStatusStudent.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/StatusStudentController/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StatusStudentModel> deleteStatusStudent(@PathVariable("id") Integer id) {
		Optional<StatusStudentModel> StatusStudent = StatusStudentSv.findStatusStudentById(id);
		if (!StatusStudent.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StatusStudentSv.remove(StatusStudent.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

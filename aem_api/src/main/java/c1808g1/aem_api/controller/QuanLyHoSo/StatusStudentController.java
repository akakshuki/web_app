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

import c1808g1.Models.QuanLiHoSo.StatusStudentDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyHoSo.StatusStudentModel;
import c1808g1.aem_api.service.QuanLyHoSo.StatusStudentService;

@RestController
@RequestMapping("/api/quanlyhoso/status_student_api")
public class StatusStudentController {
	private StatusStudentService ssSv;
    @Autowired
	public StatusStudentController(StatusStudentService ssSv) {
		this.ssSv = ssSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<StatusStudentDTO>> findAllss() {
		List<StatusStudentModel> listss = ssSv.findAllStatusStudent();
		// List<StatusStudentDTO> lsss = listss.stream().map(ss -> ModelMapperConfig.modelMapper.map(ss, StatusStudentDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<StatusStudentDTO> lsss = ModelMapperConfig.mapList(listss, StatusStudentDTO.class);
		if (lsss.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsss, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStatusStudentById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusStudentDTO> getssById(@PathVariable("id") Integer id) {
		var data = ssSv.findStatusStudentById(id);
		//mapper từ entity -> DTO
		StatusStudentDTO ss = ModelMapperConfig.modelMapper.map(data, StatusStudentDTO.class);

		if (ss == null) {
			return new ResponseEntity<>(ss, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ss, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusStudentDTO> createss(@RequestBody StatusStudentDTO ss, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		StatusStudentModel ssModel = ModelMapperConfig.modelMapper.map(ss, StatusStudentModel.class);
		ssSv.save(ssModel);
		ss.setId(ssModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/ss/{id}").buildAndExpand(ss.getId()).toUri());
		return new ResponseEntity<>(ss, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StatusStudentDTO> updatess(@PathVariable("id") Integer id, @RequestBody StatusStudentDTO ss) {
		StatusStudentModel currentStatusStudent = ssSv.findStatusStudentById(id);
		
		if (currentStatusStudent == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentStatusStudent.setId(ss.getId());
		currentStatusStudent.setStudent_id(ss.getStudent_id());
		currentStatusStudent.setStatus_id(ss.getStatus_id());
		currentStatusStudent.setStart_date(ss.getStart_date());
		currentStatusStudent.setEnd_date(ss.getEnd_date());
		currentStatusStudent.setNote(ss.getNote());
		currentStatusStudent.setCreator(ss.getCreator());
		currentStatusStudent.setDate_create(ss.getDate_create());

		ssSv.save(currentStatusStudent);
		return new ResponseEntity<>(ss, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StatusStudentModel> deletess(@PathVariable("id") Integer id) {
		StatusStudentModel ss = ssSv.findStatusStudentById(id);
		if (ss == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ssSv.remove(ss);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

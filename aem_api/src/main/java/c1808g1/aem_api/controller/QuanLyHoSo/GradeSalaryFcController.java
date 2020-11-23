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

import c1808g1.aem_api.models.QuanLyHoSo.GradeSalaryFcModel;
import c1808g1.aem_api.service.QuanLyHoSo.GradeSalaryFcService;



@RestController
@RequestMapping("/cauhinh/grade_salary_fc_api")
public class GradeSalaryFcController {
private GradeSalaryFcService GradeSalaryFcSv;
	
	@Autowired
	public GradeSalaryFcController(GradeSalaryFcService GradeSalaryFcSv) {
		this.GradeSalaryFcSv=GradeSalaryFcSv;
	}
	@RequestMapping(value = "/GradeSalaryFcController", method = RequestMethod.GET)
	public ResponseEntity<List<GradeSalaryFcModel>> findAllGradeSalaryFc() {
		List<GradeSalaryFcModel> GradeSalaryFc = GradeSalaryFcSv.findAllGradeSalaryFc();
		if (GradeSalaryFc.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(GradeSalaryFc, HttpStatus.OK);
	}

	@RequestMapping(value = "/GradeSalaryFcController/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GradeSalaryFcModel> getGradeSalaryFcById(@PathVariable("id") Integer id) {
		Optional<GradeSalaryFcModel> GradeSalaryFc = GradeSalaryFcSv.findGradeSalaryFcById(id);

		if (!GradeSalaryFc.isPresent()) {
			return new ResponseEntity<>(GradeSalaryFc.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(GradeSalaryFc.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/GradeSalaryFcController", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GradeSalaryFcModel> createGradeSalaryFc(@RequestBody GradeSalaryFcModel GradeSalaryFc, UriComponentsBuilder builder) {
		GradeSalaryFcSv.save(GradeSalaryFc);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/GradeSalaryFcController/{id}").buildAndExpand(GradeSalaryFc.getId()).toUri());
		return new ResponseEntity<>(GradeSalaryFc, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/GradeSalaryFcController/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GradeSalaryFcModel> updateGradeSalaryFc(@PathVariable("id") Integer id, @RequestBody GradeSalaryFcModel GradeSalaryFc) {
		Optional<GradeSalaryFcModel> currentGradeSalaryFc = GradeSalaryFcSv.findGradeSalaryFcById(id);

		if (!currentGradeSalaryFc.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentGradeSalaryFc.get().setId(GradeSalaryFc.getId());
		currentGradeSalaryFc.get().setFc_id(GradeSalaryFc.getFc_id());
		currentGradeSalaryFc.get().setHour_salary(GradeSalaryFc.getHour_salary());
		currentGradeSalaryFc.get().setStart_date(GradeSalaryFc.getStart_date());
		currentGradeSalaryFc.get().setDate_create(GradeSalaryFc.getDate_create());

		GradeSalaryFcSv.save(currentGradeSalaryFc.get());
		return new ResponseEntity<>(currentGradeSalaryFc.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/GradeSalaryFcController/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GradeSalaryFcModel> deleteGradeSalaryFc(@PathVariable("id") Integer id) {
		Optional<GradeSalaryFcModel> GradeSalaryFc = GradeSalaryFcSv.findGradeSalaryFcById(id);
		if (!GradeSalaryFc.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		GradeSalaryFcSv.remove(GradeSalaryFc.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

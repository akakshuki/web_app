package c1808g1.aem_api.controller.DonTu;

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

import c1808g1.aem_api.models.DonTu.ExemptionMs;
import c1808g1.aem_api.service.DonTu.ExemptionMsService;

@RestController
@RequestMapping("/dontu/exemptionmsapi")
public class MienNghiaVuController {
	private ExemptionMsService emsSv;

	@Autowired
	public MienNghiaVuController(ExemptionMsService emsSv) {
		this.emsSv = emsSv;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<List<ExemptionMs>> findAllExemptionMs() {
		List<ExemptionMs> ExemptionMss =emsSv.findAllExemptionMs();
		if (ExemptionMss.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ExemptionMss, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExemptionMs> getExemptionMsById(@PathVariable("id") Integer id) {
		Optional<ExemptionMs> ExemptionMs = emsSv.findById(id);

		if (!ExemptionMs.isPresent()) {
			return new ResponseEntity<>(ExemptionMs.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ExemptionMs.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ExemptionMs> createExemptionMs(@RequestBody ExemptionMs ExemptionMs, UriComponentsBuilder builder) {
		emsSv.save(ExemptionMs);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/ExemptionMss/{id}").buildAndExpand(ExemptionMs.getId()).toUri());
		return new ResponseEntity<>(ExemptionMs, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ExemptionMs> updateExemptionMs(@PathVariable("id") Integer id, @RequestBody ExemptionMs ExemptionMs) {
		Optional<ExemptionMs> currentExemptionMs = emsSv.findById(id);

		if (!currentExemptionMs.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentExemptionMs.get().setStudentid(ExemptionMs.getStudentid());
		currentExemptionMs.get().setExpirationdate(ExemptionMs.getExpirationdate());
		currentExemptionMs.get().setMonthstart(ExemptionMs.getMonthstart());
		currentExemptionMs.get().setYearstart(ExemptionMs.getYearstart());
		currentExemptionMs.get().setMonthend(ExemptionMs.getMonthend());
		currentExemptionMs.get().setYearend(ExemptionMs.getYearend());
		currentExemptionMs.get().setPathfile(ExemptionMs.getPathfile());
		currentExemptionMs.get().setCreator(ExemptionMs.getCreator());
		currentExemptionMs.get().setDatecreate(ExemptionMs.getDatecreate());
		currentExemptionMs.get().setConfirmed(ExemptionMs.getConfirmed());
		currentExemptionMs.get().setDateconfirm(ExemptionMs.getDateconfirm());
		currentExemptionMs.get().setCreatorconfirm(ExemptionMs.getCreatorconfirm());

		emsSv.save(currentExemptionMs.get());
		return new ResponseEntity<>(currentExemptionMs.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ExemptionMs> deleteExemptionMs(@PathVariable("id") Integer id) {
		Optional<ExemptionMs> ExemptionMs = emsSv.findById(id);
		if (!ExemptionMs.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		emsSv.remove(ExemptionMs.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

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

import c1808g1.Models.DonTu.ExemptionMsDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.DonTu.ExemptionMs;

import c1808g1.aem_api.service.DonTu.ExemptionMsService;


@RestController
@RequestMapping("/api/dontu/exemptionmsapi")
public class MienNghiaVuController {
	private ExemptionMsService emsSv;

	@Autowired
	public MienNghiaVuController(ExemptionMsService emsSv) {
		this.emsSv = emsSv;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<ExemptionMsDTO>> findAllExemptionMs() {
		List<ExemptionMs> listems = emsSv.findAllExemptionMs();

		//mapper từ list entity -> list DTO
		List<ExemptionMsDTO> listemsd = ModelMapperConfig.mapList(listems, ExemptionMsDTO.class);
		if (listemsd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listemsd, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getExemptionMsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExemptionMsDTO> getExemptionMsById(@PathVariable("id") Integer id) {
		var data = emsSv.findExemptionMsById(id);
		//mapper từ entity -> DTO
		ExemptionMsDTO emsd = ModelMapperConfig.modelMapper.map(data, ExemptionMsDTO.class);

		if (emsd == null) {
			return new ResponseEntity<>(emsd, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(emsd, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ExemptionMsDTO> createExemptionMs(@RequestBody ExemptionMsDTO emsd, UriComponentsBuilder builder) {
		ExemptionMs ems = ModelMapperConfig.modelMapper.map(emsd, ExemptionMs.class);
		emsSv.save(ems);
		emsd.setId(ems.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/emsd/{id}").buildAndExpand(emsd.getId()).toUri());
		return new ResponseEntity<>(emsd, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ExemptionMsDTO> updateExemptionMs(@PathVariable("id") Integer id, @RequestBody ExemptionMsDTO emsd) {
		ExemptionMs ems = emsSv.findExemptionMsById(id);
		
		if (ems == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		ems.setId(emsd.getId());
		ems.setStudentid(emsd.getStudentid());
		ems.setExpirationdate(emsd.getExpirationdate());
		ems.setMonthstart(emsd.getMonthstart());
		ems.setYearstart(emsd.getYearstart());
		ems.setMonthend(emsd.getMonthend());
		ems.setYearend(emsd.getYearend());
		ems.setNote(emsd.getNote());
		ems.setCreator(emsd.getCreator());
		ems.setDatecreate(emsd.getDatecreate());
		ems.setConfirmed(emsd.getConfirmed());
		ems.setCreatorconfirm(emsd.getCreatorconfirm());
		ems.setDateconfirm(emsd.getDateconfirm());
		emsSv.save(ems);
		return new ResponseEntity<>(emsd, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ExemptionMs> deleteExemptionMs(@PathVariable("id") Integer id) {
		ExemptionMs tfc = emsSv.findExemptionMsById(id);
		if (tfc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		emsSv.remove(tfc);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}

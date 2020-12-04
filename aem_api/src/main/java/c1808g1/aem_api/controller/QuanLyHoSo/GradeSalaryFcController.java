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

import c1808g1.Models.QuanLiHoSo.GradeSalaryFcDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyHoSo.GradeSalaryFcModel;
import c1808g1.aem_api.service.QuanLyHoSo.GradeSalaryFcService;



@RestController
@RequestMapping("/api/cauhinh/grade_salary_fc_api")
public class GradeSalaryFcController {
	private GradeSalaryFcService gsfcSv;
    @Autowired
	public GradeSalaryFcController(GradeSalaryFcService gsfcSv) {
		this.gsfcSv = gsfcSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<GradeSalaryFcDTO>> findAllgsfc() {
		List<GradeSalaryFcModel> listgsfc = gsfcSv.findAllGradeSalaryFc();
		// List<GradeSalaryFcDTO> lsgsfc = listgsfc.stream().map(gsfc -> ModelMapperConfig.modelMapper.map(gsfc, GradeSalaryFcDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<GradeSalaryFcDTO> lsgsfc = ModelMapperConfig.mapList(listgsfc, GradeSalaryFcDTO.class);
		if (lsgsfc.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsgsfc, HttpStatus.OK);
	}

	@RequestMapping(value = "/getGradeSalaryFcById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GradeSalaryFcDTO> getgsfcById(@PathVariable("id") Integer id) {
		var data = gsfcSv.findGradeSalaryFcById(id);
		//mapper từ entity -> DTO
		GradeSalaryFcDTO gsfc = ModelMapperConfig.modelMapper.map(data, GradeSalaryFcDTO.class);

		if (gsfc == null) {
			return new ResponseEntity<>(gsfc, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(gsfc, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GradeSalaryFcDTO> creategsfc(@RequestBody GradeSalaryFcDTO gsfc, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		GradeSalaryFcModel gsfcModel = ModelMapperConfig.modelMapper.map(gsfc, GradeSalaryFcModel.class);
		gsfcSv.save(gsfcModel);
		gsfc.setId(gsfcModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/gsfc/{id}").buildAndExpand(gsfc.getId()).toUri());
		return new ResponseEntity<>(gsfc, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GradeSalaryFcDTO> updategsfc(@PathVariable("id") Integer id, @RequestBody GradeSalaryFcDTO gsfc) {
		GradeSalaryFcModel currentGradeSalaryFc = gsfcSv.findGradeSalaryFcById(id);
		
		if (currentGradeSalaryFc == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentGradeSalaryFc.setId(gsfc.getId());
		currentGradeSalaryFc.setFc_id(gsfc.getFc_id());
		currentGradeSalaryFc.setHour_salary(gsfc.getHour_salary());
		currentGradeSalaryFc.setStart_date(gsfc.getStart_date());
		currentGradeSalaryFc.setDate_create(gsfc.getDate_create());

		gsfcSv.save(currentGradeSalaryFc);
		return new ResponseEntity<>(gsfc, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GradeSalaryFcModel> deletegsfc(@PathVariable("id") Integer id) {
		GradeSalaryFcModel gsfc = gsfcSv.findGradeSalaryFcById(id);
		if (gsfc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		gsfcSv.remove(gsfc);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

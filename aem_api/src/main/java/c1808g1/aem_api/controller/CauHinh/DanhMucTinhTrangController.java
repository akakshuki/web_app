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

import c1808g1.Models.CauHinh.StatusDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.StatusModel;
import c1808g1.aem_api.models.CauHinh.StatusModel;
import c1808g1.aem_api.service.CauHinh.StatusService;
import c1808g1.aem_api.service.CauHinh.StatusService;

@RestController
@RequestMapping("/api/cauhinh/statusapi")
public class DanhMucTinhTrangController {
	private StatusService statusSv;
    @Autowired
	public DanhMucTinhTrangController(StatusService statusSv) {
		this.statusSv = statusSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<StatusDTO>> findAllstatus() {
		List<StatusModel> liststatus = statusSv.findAllStatus();
		// List<StatusDTO> lsstatus = liststatus.stream().map(status -> ModelMapperConfig.modelMapper.map(status, StatusDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<StatusDTO> lsstatus = ModelMapperConfig.mapList(liststatus, StatusDTO.class);
		if (lsstatus.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsstatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStatusById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusDTO> getstatusById(@PathVariable("id") int id) {
		var data = statusSv.findStatusById(id);
		//mapper từ entity -> DTO
		StatusDTO status = ModelMapperConfig.modelMapper.map(data, StatusDTO.class);

		if (status == null) {
			return new ResponseEntity<>(status, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStatusByGroupType/{group_type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StatusDTO>> getstatusByGroupType(@PathVariable("group_type") int type) {
		var data = statusSv.findStatusByGroupType(type);
		//mapper từ entity -> DTO
		List<StatusDTO> status = ModelMapperConfig.mapList(data, StatusDTO.class);

		if (status == null) {
			return new ResponseEntity<>(status, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusDTO> createstatus(@RequestBody StatusDTO status, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		StatusModel statusModel = ModelMapperConfig.modelMapper.map(status, StatusModel.class);
		statusSv.save(statusModel);
		status.setId(statusModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/status/{id}").buildAndExpand(status.getId()).toUri());
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StatusDTO> updatestatus(@PathVariable("id") int id, @RequestBody StatusDTO status) {
		StatusModel currentStatus = statusSv.findStatusById(id);
		
		if (currentStatus == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentStatus.setId(status.getId());
		currentStatus.setName_status(status.getName_status());
		currentStatus.setGroup_type(status.getGroup_type());
		currentStatus.setActive(status.getActive());


		statusSv.save(currentStatus);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StatusModel> deletestatus(@PathVariable("id") Integer id) {
		StatusModel status = statusSv.findStatusById(id);
		if (status == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		statusSv.remove(status);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

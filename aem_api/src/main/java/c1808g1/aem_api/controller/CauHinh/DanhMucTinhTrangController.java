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

import c1808g1.aem_api.models.CauHinh.StatusModel;
import c1808g1.aem_api.service.CauHinh.StatusService;

@RestController
@RequestMapping("/cauhinh/statusapi")
public class DanhMucTinhTrangController {
	private StatusService statusSv;

	@Autowired
	public DanhMucTinhTrangController(StatusService statusSv) {
		this.statusSv = statusSv;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<List<StatusModel>> findAllStatus() {
		List<StatusModel> statusModel = statusSv.findAllStatus();
		if (statusModel.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(statusModel, HttpStatus.OK);
	}

	@RequestMapping(value = "/status/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusModel> getStatusById(@PathVariable("id") Integer id) {
		Optional<StatusModel> statusModel = statusSv.findStatusById(id);

		if (!statusModel.isPresent()) {
			return new ResponseEntity<>(statusModel.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(statusModel.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusModel> createStatus(@RequestBody StatusModel statusModel, UriComponentsBuilder builder) {
		statusSv.save(statusModel);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/status/{id}").buildAndExpand(statusModel.getId()).toUri());
		return new ResponseEntity<>(statusModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/status/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StatusModel> updateStatus(@PathVariable("id") Integer id, @RequestBody StatusModel statusModel) {
		Optional<StatusModel> currentstatus = statusSv.findStatusById(id);

		if (!currentstatus.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentstatus.get().setId(statusModel.getId());
		currentstatus.get().setName_status(statusModel.getName_status());
		currentstatus.get().setGroup_type(statusModel.getGroup_type());
		currentstatus.get().setActive(statusModel.getActive());

		statusSv.save(currentstatus.get());
		return new ResponseEntity<>(currentstatus.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/status/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StatusModel> deleteStatus(@PathVariable("id") Integer id) {
		Optional<StatusModel> statusModel = statusSv.findStatusById(id);
		if (!statusModel.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		statusSv.remove(statusModel.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

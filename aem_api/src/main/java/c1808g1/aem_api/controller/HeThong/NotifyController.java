package c1808g1.aem_api.controller.HeThong;

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

import c1808g1.Models.HeThong.NotifyDTO;
import c1808g1.aem_api.config.ModelMapperConfig;

import c1808g1.aem_api.models.HeThong.NotifyModel;
import c1808g1.aem_api.service.HeThong.NotifyService;

@RestController
@RequestMapping("/api/cauhinh/notifyapi")
public class NotifyController {
	private NotifyService notifySv;
	
	@Autowired
	public NotifyController(NotifyService notifySv) {
		this.notifySv=notifySv;
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<NotifyDTO>> findAllNotify() {
		List<NotifyModel> listntf = notifySv.findAllNotify();

		//mapper từ list entity -> list DTO
		List<NotifyDTO> listntfd = ModelMapperConfig.mapList(listntf, NotifyDTO.class);
		if (listntfd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listntfd, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getNotifyById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotifyDTO> getNotifyById(@PathVariable("id") int id) {
		var data = notifySv.findNotifyById(id);
		//mapper từ entity -> DTO
		NotifyDTO tfc = ModelMapperConfig.modelMapper.map(data, NotifyDTO.class);

		if (tfc == null) {
			return new ResponseEntity<>(tfc, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tfc, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<NotifyDTO> create(@RequestBody NotifyDTO ntfd, UriComponentsBuilder builder) {
		NotifyModel ntf = ModelMapperConfig.modelMapper.map(ntfd, NotifyModel.class);
		notifySv.save(ntf);
		ntfd.setId(ntf.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/ntf/{id}").buildAndExpand(ntfd.getId()).toUri());
		return new ResponseEntity<>(ntfd, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NotifyDTO> updateNotify(@PathVariable("id") int id, @RequestBody NotifyDTO ntfd) {
		NotifyModel ntf = notifySv.findNotifyById(id);
		
		if (ntf == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		ntf.setId(ntfd.getId());
		ntf.setUrl(ntfd.getUrl());
		ntf.setReceiver_id(ntfd.getReceiver_id());
		ntf.setTitle(ntfd.getTitle());
		ntf.setSeen(ntfd.getSeen());
		ntf.setNote(ntfd.getNote());

		notifySv.save(ntf);
		return new ResponseEntity<>(ntfd, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NotifyModel> deleteNotify(@PathVariable("id") int id) {
		NotifyModel tfc = notifySv.findNotifyById(id);
		if (tfc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		//holiSv.remove(holi.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

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

import c1808g1.aem_api.models.HeThong.NotifyModel;
import c1808g1.aem_api.service.HeThong.NotifyService;

@RestController
@RequestMapping("/cauhinh/notifyapi")
public class NotifyController {
	private NotifyService notifySv;
	
	@Autowired
	public NotifyController(NotifyService notifySv) {
		this.notifySv=notifySv;
	}
	@RequestMapping(value = "/notify", method = RequestMethod.GET)
	public ResponseEntity<List<NotifyModel>> findAllnotify() {
		List<NotifyModel> notify = notifySv.findAllNotify();
		if (notify.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(notify, HttpStatus.OK);
	}

	@RequestMapping(value = "/notify/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotifyModel> getnotifyById(@PathVariable("id") Integer id) {
		Optional<NotifyModel> notify = notifySv.findNotifyById(id);

		if (!notify.isPresent()) {
			return new ResponseEntity<>(notify.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(notify.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/notify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotifyModel> createnotify(@RequestBody NotifyModel notify, UriComponentsBuilder builder) {
		notifySv.save(notify);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/notify/{id}").buildAndExpand(notify.getId()).toUri());
		return new ResponseEntity<>(notify, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/notify/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NotifyModel> updatenotify(@PathVariable("id") Integer id, @RequestBody NotifyModel notify) {
		Optional<NotifyModel> currentnotify = notifySv.findNotifyById(id);

		if (!currentnotify.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentnotify.get().setId(notify.getId());
		currentnotify.get().setReceiver_id(notify.getReceiver_id());
		currentnotify.get().setUrl(notify.getUrl());
		currentnotify.get().setTitle(notify.getTitle());
		currentnotify.get().setSeen(notify.getSeen());
		currentnotify.get().setNote(notify.getNote());

		notifySv.save(currentnotify.get());
		return new ResponseEntity<>(currentnotify.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/notify/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NotifyModel> deletenotify(@PathVariable("id") Integer id) {
		Optional<c1808g1.aem_api.models.HeThong.NotifyModel> notify = notifySv.findNotifyById(id);
		if (!notify.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		notifySv.remove(notify.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

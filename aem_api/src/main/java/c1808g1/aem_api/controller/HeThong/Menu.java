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

import c1808g1.aem_api.models.HeThong.Controller;
import c1808g1.aem_api.service.HeThong.ControllerService;


@RestController
@RequestMapping("/hethong/Controllerapi")
public class Menu {
	private ControllerService clSv;

	@Autowired
	public Menu(ControllerService clSv) {
		this.clSv = clSv;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<List<Controller>> findAllController() {
		List<Controller> cl =clSv.findAllController();
		if (cl.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cl, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Controller> getControllerById(@PathVariable("id") String id) {
		Optional<Controller> cl = clSv.findById(id);

		if (!cl.isPresent()) {
			return new ResponseEntity<>(cl.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cl.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Controller> createController(@RequestBody Controller cl, UriComponentsBuilder builder) {
		clSv.save(cl);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/Controllers/{id}").buildAndExpand(cl.getIdcontroller()).toUri());
		return new ResponseEntity<>(cl, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Controller> updateController(@PathVariable("id") String id, @RequestBody Controller cl) {
		Optional<Controller> currentController = clSv.findById(id);

		if (!currentController.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		currentController.get().setIdcontroller(cl.getIdcontroller());
		currentController.get().setNamecontroller(cl.getNamecontroller());
		currentController.get().setActive(cl.getActive());
		currentController.get().setMenuroot(cl.getMenuroot());


		clSv.save(currentController.get());
		return new ResponseEntity<>(currentController.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Controller> deleteController(@PathVariable("id") String id) {
		Optional<Controller> cl = clSv.findById(id);
		if (!cl.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clSv.remove(cl.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

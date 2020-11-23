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

import c1808g1.Models.HeThong.ControllerDTO;
import c1808g1.aem_api.config.ModelMapperConfig;

import c1808g1.aem_api.models.HeThong.Controller;
import c1808g1.aem_api.service.HeThong.ControllerService;


@RestController
@RequestMapping("/api/hethong/Controllerapi")
public class MenuController {
	private ControllerService clSv;

	@Autowired
	public MenuController(ControllerService clSv) {
		this.clSv = clSv;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<ControllerDTO>> findAllController() {
		List<Controller> listcl = clSv.findAllController();

		//mapper từ list entity -> list DTO
		List<ControllerDTO> listcld = ModelMapperConfig.mapList(listcl, ControllerDTO.class);
		if (listcld.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listcld, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getControllerById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ControllerDTO> getControllerById(@PathVariable("id") String id) {
		var data = clSv.findControllerById(id);
		//mapper từ entity -> DTO
		ControllerDTO tfc = ModelMapperConfig.modelMapper.map(data, ControllerDTO.class);

		if (tfc == null) {
			return new ResponseEntity<>(tfc, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tfc, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ControllerDTO> createController(@RequestBody ControllerDTO cld, UriComponentsBuilder builder) {
		Controller cl = ModelMapperConfig.modelMapper.map(cld, Controller.class);
		clSv.save(cl);
		cld.setIdcontroller(cl.getIdcontroller());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/cl/{id}").buildAndExpand(cld.getIdcontroller()).toUri());
		return new ResponseEntity<>(cld, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ControllerDTO> updateController(@PathVariable("id") String id, @RequestBody ControllerDTO cld) {
		Controller cl = clSv.findControllerById(id);
		
		if (cl == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		cl.setIdcontroller(cld.getIdcontroller());
		cl.setNamecontroller(cld.getNamecontroller());
		cl.setActive(cld.getActive());
		cl.setMenuroot(cld.getMenuroot());

		clSv.save(cl);
		return new ResponseEntity<>(cld, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Controller> deleteController(@PathVariable("id") String id) {
		Controller tfc = clSv.findControllerById(id);
		if (tfc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		//holiSv.remove(holi.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

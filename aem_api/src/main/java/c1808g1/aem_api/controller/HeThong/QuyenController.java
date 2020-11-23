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

import c1808g1.aem_api.models.HeThong.Role;
import c1808g1.aem_api.service.HeThong.RoleService;



@RestController
@RequestMapping("/hethong/Roleapi")
public class QuyenController {
	private RoleService rSv;

	@Autowired
	public QuyenController(RoleService rSv) {
		this.rSv = rSv;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> findAllRole() {
		List<Role> Roles =rSv.findAllRole();
		if (Roles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(Roles, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id) {
		Optional<Role> Role = rSv.findById(id);

		if (!Role.isPresent()) {
			return new ResponseEntity<>(Role.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(Role.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Role> createRole(@RequestBody Role Role, UriComponentsBuilder builder) {
		rSv.save(Role);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/Roles/{id}").buildAndExpand(Role.getId()).toUri());
		return new ResponseEntity<>(Role, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Role> updateRole(@PathVariable("id") Integer id, @RequestBody Role Role) {
		Optional<Role> currentRole = rSv.findById(id);

		if (!currentRole.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		currentRole.get().setId(Role.getId());
		currentRole.get().setNamerole(Role.getNamerole());
		currentRole.get().setAllowedit(Role.isAllowedit());
		currentRole.get().setAllowdelete(Role.isAllowdelete());

		rSv.save(currentRole.get());
		return new ResponseEntity<>(currentRole.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Role> deleteRole(@PathVariable("id") Integer id) {
		Optional<Role> Role = rSv.findById(id);
		if (!Role.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		rSv.remove(Role.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

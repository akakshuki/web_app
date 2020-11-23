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

import c1808g1.aem_api.models.QuanLyHoSo.PermissionRoleModel;
import c1808g1.aem_api.service.QuanLyHoSo.PermissionRoleService;

@RestController
@RequestMapping("/api/cauhinh/permission_role_api")
public class PermissionRoleController {
	private PermissionRoleService PermissionRoleSv;

	@Autowired
	public PermissionRoleController(PermissionRoleService PermissionRoleSv) {
		this.PermissionRoleSv = PermissionRoleSv;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<PermissionRoleModel>> findAllPermissionRole() {
		List<PermissionRoleModel> PermissionRole = PermissionRoleSv.findAllPermissionRole();
		if (PermissionRole.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(PermissionRole, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPermissionRoleById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionRoleModel> getPermissionRoleById(@PathVariable("id") Integer id) {
		Optional<PermissionRoleModel> PermissionRole = PermissionRoleSv.findPermissionRoleById(id);

		if (!PermissionRole.isPresent()) {
			return new ResponseEntity<>(PermissionRole.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(PermissionRole.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionRoleModel> createPermissionRole(@RequestBody PermissionRoleModel PermissionRole,
			UriComponentsBuilder builder) {
		PermissionRoleSv.save(PermissionRole);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/PermissionRoleController/{id}").buildAndExpand(PermissionRole.getId()).toUri());
		return new ResponseEntity<>(PermissionRole, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PermissionRoleModel> updatePermissionRole(@PathVariable("id") Integer id,
			@RequestBody PermissionRoleModel PermissionRole) {
		Optional<PermissionRoleModel> currentPermissionRole = PermissionRoleSv.findPermissionRoleById(id);

		if (!currentPermissionRole.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentPermissionRole.get().setId(PermissionRole.getId());
		currentPermissionRole.get().setRole_id(PermissionRole.getRole_id());
		currentPermissionRole.get().setController_id(PermissionRole.getController_id());
		currentPermissionRole.get().setList_action(PermissionRole.getList_action());

		PermissionRoleSv.save(currentPermissionRole.get());
		return new ResponseEntity<>(currentPermissionRole.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PermissionRoleModel> deletePermissionRole(@PathVariable("id") Integer id) {
		Optional<PermissionRoleModel> PermissionRole = PermissionRoleSv.findPermissionRoleById(id);
		if (!PermissionRole.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		PermissionRoleSv.remove(PermissionRole.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

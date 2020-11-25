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

import c1808g1.Models.QuanLiHoSo.PermissionRoleDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyHoSo.PermissionRoleModel;
import c1808g1.aem_api.service.QuanLyHoSo.PermissionRoleService;

@RestController
@RequestMapping("/api/quanlyhoso/permission_role_api")
public class PermissionRoleController {
	private PermissionRoleService prSv;
    @Autowired
	public PermissionRoleController(PermissionRoleService prSv) {
		this.prSv = prSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<PermissionRoleDTO>> findAllpr() {
		List<PermissionRoleModel> listpr = prSv.findAllPermissionRole();
		// List<PermissionRoleDTO> lspr = listpr.stream().map(pr -> ModelMapperConfig.modelMapper.map(pr, PermissionRoleDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<PermissionRoleDTO> lspr = ModelMapperConfig.mapList(listpr, PermissionRoleDTO.class);
		if (lspr.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lspr, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPermissionRoleById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionRoleDTO> getprById(@PathVariable("id") Integer id) {
		var data = prSv.findPermissionRoleById(id);
		//mapper từ entity -> DTO
		PermissionRoleDTO pr = ModelMapperConfig.modelMapper.map(data, PermissionRoleDTO.class);

		if (pr == null) {
			return new ResponseEntity<>(pr, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionRoleDTO> createpr(@RequestBody PermissionRoleDTO pr, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		PermissionRoleModel prModel = ModelMapperConfig.modelMapper.map(pr, PermissionRoleModel.class);
		prSv.save(prModel);
		pr.setId(prModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/pr/{id}").buildAndExpand(pr.getId()).toUri());
		return new ResponseEntity<>(pr, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PermissionRoleDTO> updatepr(@PathVariable("id") Integer id, @RequestBody PermissionRoleDTO pr) {
		PermissionRoleModel currentPermissionRole = prSv.findPermissionRoleById(id);
		
		if (currentPermissionRole == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentPermissionRole.setId(pr.getId());
		currentPermissionRole.setRole_id(pr.getRole_id());
		currentPermissionRole.setController_id(pr.getController_id());
		currentPermissionRole.setList_action(pr.getList_action());

		prSv.save(currentPermissionRole);
		return new ResponseEntity<>(pr, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PermissionRoleModel> deletepr(@PathVariable("id") Integer id) {
		PermissionRoleModel pr = prSv.findPermissionRoleById(id);
		if (pr == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		prSv.remove(pr);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

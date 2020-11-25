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

import c1808g1.Models.HeThong.RoleDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.HeThong.Role;
import c1808g1.aem_api.service.HeThong.RoleService;



@RestController
@RequestMapping("/api/hethong/Roleapi")
public class QuyenController {
	private RoleService rSv;

	@Autowired
	public QuyenController(RoleService rSv) {
		this.rSv = rSv;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<RoleDTO>> findAllRole() {
		List<Role> listr = rSv.findAllRole();

		//mapper từ list entity -> list DTO
		List<RoleDTO> listrd = ModelMapperConfig.mapList(listr, RoleDTO.class);
		if (listrd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listrd, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getRoleById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Integer id) {
		var data = rSv.findRoleById(id);
		//mapper từ entity -> DTO
		RoleDTO rd = ModelMapperConfig.modelMapper.map(data, RoleDTO.class);

		if (rd == null) {
			return new ResponseEntity<>(rd, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rd, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO rd, UriComponentsBuilder builder) {
		Role r = ModelMapperConfig.modelMapper.map(rd, Role.class);
		rSv.save(r);
		rd.setId(r.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/rd/{id}").buildAndExpand(rd.getId()).toUri());
		return new ResponseEntity<>(rd, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RoleDTO> updateRole(@PathVariable("id") Integer id, @RequestBody RoleDTO rd) {
		Role r = rSv.findRoleById(id);
		
		if (r == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		r.setId(rd.getId());
		r.setNamerole(rd.getNamerole());
		r.setAllowedit(rd.isAllowedit());
		r.setAllowdelete(rd.isAllowdelete());

		rSv.save(r);
		return new ResponseEntity<>(rd, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Role> deleteRole(@PathVariable("id") Integer id) {
		Role tfc = rSv.findRoleById(id);
		if (tfc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		rSv.remove(tfc);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}

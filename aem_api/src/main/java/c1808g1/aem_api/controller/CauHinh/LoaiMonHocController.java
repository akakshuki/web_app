package c1808g1.aem_api.controller.CauHinh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import c1808g1.Models.CauHinh.Type_SubjectDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.Type_Subject;
import c1808g1.aem_api.service.CauHinh.Type_SubjectServices;

import java.util.List;

@RestController
@RequestMapping("/api/cauhinh/type_subjectapi")
public class LoaiMonHocController {
	private Type_SubjectServices type_subjectSv;
    @Autowired
	public LoaiMonHocController(Type_SubjectServices type_subjectSv) {
		this.type_subjectSv = type_subjectSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Type_SubjectDTO>> findAlltype_subject() {
		List<Type_Subject> listtype_subject = type_subjectSv.findAllType_Subject();
		// List<Type_SubjectDTO> lstype_subject = listtype_subject.stream().map(type_subject -> ModelMapperConfig.modelMapper.map(type_subject, Type_SubjectDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<Type_SubjectDTO> lstype_subject = ModelMapperConfig.mapList(listtype_subject, Type_SubjectDTO.class);
		if (lstype_subject.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lstype_subject, HttpStatus.OK);
	}

	@RequestMapping(value = "/getType_SubjectById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Type_SubjectDTO> gettype_subjectById(@PathVariable("id") Integer id) {
		var data = type_subjectSv.findType_SubjectById(id);
		//mapper từ entity -> DTO
		Type_SubjectDTO type_subject = ModelMapperConfig.modelMapper.map(data, Type_SubjectDTO.class);

		if (type_subject == null) {
			return new ResponseEntity<>(type_subject, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(type_subject, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Type_SubjectDTO> createtype_subject(@RequestBody Type_SubjectDTO type_subject, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		Type_Subject Type_Subject = ModelMapperConfig.modelMapper.map(type_subject, Type_Subject.class);
		type_subjectSv.save(Type_Subject);
		type_subject.setId(Type_Subject.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/type_subject/{id}").buildAndExpand(type_subject.getId()).toUri());
		return new ResponseEntity<>(type_subject, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Type_SubjectDTO> updatetype_subject(@PathVariable("id") Integer id, @RequestBody Type_SubjectDTO type_subject) {
		Type_Subject currentType = type_subjectSv.findType_SubjectById(id);
		
		if (currentType == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

        currentType.setId(type_subject.getId());
        currentType.setName_type(type_subject.getName_type());
        currentType.setActive_type(type_subject.getActive_type());


		type_subjectSv.save(currentType);
		return new ResponseEntity<>(type_subject, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Type_Subject> deletetype_subject(@PathVariable("id") Integer id) {
		Type_Subject type_subject = type_subjectSv.findType_SubjectById(id);
		if (type_subject == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		type_subjectSv.remove(type_subject);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

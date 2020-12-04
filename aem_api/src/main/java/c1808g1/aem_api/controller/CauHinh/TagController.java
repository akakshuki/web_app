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

import c1808g1.Models.CauHinh.TagDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.TagModel;
import c1808g1.aem_api.models.CauHinh.TagModel;
import c1808g1.aem_api.service.CauHinh.TagService;
import c1808g1.aem_api.service.CauHinh.TagService;

@RestController
@RequestMapping("/api/cauhinh/tagapi")
public class TagController {
	private TagService tagSv;
    @Autowired
	public TagController(TagService tagSv) {
		this.tagSv = tagSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<TagDTO>> findAlltag() {
		List<TagModel> listtag = tagSv.findAllTag();
		// List<TagDTO> lstag = listtag.stream().map(tag -> ModelMapperConfig.modelMapper.map(tag, TagDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<TagDTO> lstag = ModelMapperConfig.mapList(listtag, TagDTO.class);
		if (lstag.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lstag, HttpStatus.OK);
	}

	@RequestMapping(value = "/getTagById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagDTO> gettagById(@PathVariable("id") String id) {
		var data = tagSv.findTagById(id);
		//mapper từ entity -> DTO
		TagDTO tag = ModelMapperConfig.modelMapper.map(data, TagDTO.class);

		if (tag == null) {
			return new ResponseEntity<>(tag, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagDTO> createtag(@RequestBody TagDTO tag, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		TagModel tagModel = ModelMapperConfig.modelMapper.map(tag, TagModel.class);
		tagSv.save(tagModel);
		tag.setId_tag(tagModel.getId_tag());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/tag/{id}").buildAndExpand(tag.getId_tag()).toUri());
		return new ResponseEntity<>(tag, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TagDTO> updatetag(@PathVariable("id") String id, @RequestBody TagDTO tag) {
		TagModel currentTag = tagSv.findTagById(id);
		
		if (currentTag == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentTag.setId_tag(tag.getId_tag());
		currentTag.setName_tag(tag.getName_tag());


		tagSv.save(currentTag);
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TagModel> deletetag(@PathVariable("id") String id) {
		TagModel tag = tagSv.findTagById(id);
		if (tag == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tagSv.remove(tag);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

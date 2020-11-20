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

import c1808g1.aem_api.models.CauHinh.TagModel;
import c1808g1.aem_api.service.CauHinh.TagService;

@RestController
@RequestMapping("/cauhinh/tagapi")
public class Tag {
	private TagService tagSv;

	@Autowired
	public Tag(TagService tagSv) {
		this.tagSv = tagSv;
	}

	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public ResponseEntity<List<TagModel>> findAlltag() {
		List<TagModel> tag = tagSv.findAllTag();
		if (tag.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	@RequestMapping(value = "/tag/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagModel> gettagById(@PathVariable("id") String id) {
		Optional<TagModel> tag = tagSv.findTagById(id);

		if (!tag.isPresent()) {
			return new ResponseEntity<>(tag.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tag.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/tag", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagModel> createtag(@RequestBody TagModel tag, UriComponentsBuilder builder) {
		tagSv.save(tag);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/tag/{id}").buildAndExpand(tag.getId_tag()).toUri());
		return new ResponseEntity<>(tag, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/tag/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TagModel> updatetag(@PathVariable("id") String id, @RequestBody TagModel tag) {
		Optional<TagModel> currenttag = tagSv.findTagById(id);

		if (!currenttag.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currenttag.get().setId_tag(tag.getId_tag());
		currenttag.get().setName_tag(tag.getName_tag());


		tagSv.save(currenttag.get());
		return new ResponseEntity<>(currenttag.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TagModel> deletetag(@PathVariable("id") String id) {
		Optional<TagModel> tag = tagSv.findTagById(id);
		if (!tag.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tagSv.remove(tag.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

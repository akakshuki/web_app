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

import c1808g1.Models.CauHinh.SkuDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.SkuModel;
import c1808g1.aem_api.models.CauHinh.SkuModel;
import c1808g1.aem_api.service.CauHinh.SkuService;
import c1808g1.aem_api.service.CauHinh.SkuService;

@RestController
@RequestMapping("/api/cauhinh/skuapi")
public class SkuController {
	private SkuService skuSv;
    @Autowired
	public SkuController(SkuService skuSv) {
		this.skuSv = skuSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<SkuDTO>> findAllsku() {
		List<SkuModel> listsku = skuSv.findAllSku();
		// List<SkuDTO> lssku = listsku.stream().map(sku -> ModelMapperConfig.modelMapper.map(sku, SkuDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<SkuDTO> lssku = ModelMapperConfig.mapList(listsku, SkuDTO.class);
		if (lssku.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lssku, HttpStatus.OK);
	}

	@RequestMapping(value = "/getSkuById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkuDTO> getskuById(@PathVariable("id") Integer id) {
		var data = skuSv.findSkuById(id);
		//mapper từ entity -> DTO
		SkuDTO sku = ModelMapperConfig.modelMapper.map(data, SkuDTO.class);

		if (sku == null) {
			return new ResponseEntity<>(sku, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sku, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkuDTO> createsku(@RequestBody SkuDTO sku, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		SkuModel skuModel = ModelMapperConfig.modelMapper.map(sku, SkuModel.class);
		skuSv.save(skuModel);
		sku.setId(skuModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/sku/{id}").buildAndExpand(sku.getId()).toUri());
		return new ResponseEntity<>(sku, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SkuDTO> updatesku(@PathVariable("id") Integer id, @RequestBody SkuDTO sku) {
		SkuModel currentSku = skuSv.findSkuById(id);
		
		if (currentSku == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentSku.setId(sku.getId());
		currentSku.setUnit1(sku.getUnit1());
		currentSku.setUnit2(sku.getUnit2());
		currentSku.setUnit1_value(sku.getUnit1_value());
		currentSku.setUnit2_value(sku.getUnit2_value());
		currentSku.setNote(sku.getNote());

		skuSv.save(currentSku);
		return new ResponseEntity<>(sku, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SkuModel> deletesku(@PathVariable("id") Integer id) {
		SkuModel sku = skuSv.findSkuById(id);
		if (sku == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		skuSv.remove(sku);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

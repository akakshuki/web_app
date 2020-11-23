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

import c1808g1.aem_api.models.CauHinh.SkuModel;
import c1808g1.aem_api.service.CauHinh.SkuService;

@RestController
@RequestMapping("/cauhinh/skuapi")
public class SkuController {
	private SkuService skuSv;

	@Autowired
	public SkuController(SkuService skuSv) {
		this.skuSv = skuSv;
	}

	@RequestMapping(value = "/sku", method = RequestMethod.GET)
	public ResponseEntity<List<SkuModel>> findAllSku() {
		List<SkuModel> sku = skuSv.findAllSku();
		if (sku.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sku, HttpStatus.OK);
	}

	@RequestMapping(value = "/sku/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkuModel> getSkuById(@PathVariable("id") Integer id) {
		Optional<SkuModel> sku = skuSv.findSkuById(id);

		if (!sku.isPresent()) {
			return new ResponseEntity<>(sku.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sku.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/sku", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkuModel> createSku(@RequestBody SkuModel sku, UriComponentsBuilder builder) {
		skuSv.save(sku);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/sku/{id}").buildAndExpand(sku.getId()).toUri());
		return new ResponseEntity<>(sku, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/sku/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SkuModel> updateSku(@PathVariable("id") Integer id, @RequestBody SkuModel sku) {
		Optional<SkuModel> currentSku = skuSv.findSkuById(id);

		if (!currentSku.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentSku.get().setId(sku.getId());
		currentSku.get().setUnit1(sku.getUnit1());
		currentSku.get().setUnit2(sku.getUnit2());
		currentSku.get().setUnit1_value(sku.getUnit1_value());
		currentSku.get().setUnit2_value(sku.getUnit2_value());
		currentSku.get().setNote(sku.getNote());

		skuSv.save(currentSku.get());
		return new ResponseEntity<>(currentSku.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/sku/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SkuModel> deleteSku(@PathVariable("id") Integer id) {
		Optional<SkuModel> sku = skuSv.findSkuById(id);
		if (!sku.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		skuSv.remove(sku.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

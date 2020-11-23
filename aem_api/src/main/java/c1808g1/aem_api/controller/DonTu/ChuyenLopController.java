package c1808g1.aem_api.controller.DonTu;

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

import c1808g1.aem_api.models.DonTu.TransferClass;
import c1808g1.aem_api.service.DonTu.TransferClassService;

@RestController
@RequestMapping("/api/dontu/transferclassapi")
public class ChuyenLopController {
	private TransferClassService tfcSv;

	@Autowired
	public ChuyenLopController(TransferClassService tfcSv) {
		this.tfcSv = tfcSv;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<TransferClass>> findAllTransferClass() {
		List<TransferClass> TransferClasss =tfcSv.findAllTransferClass();
		if (TransferClasss.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(TransferClasss, HttpStatus.OK);
	}

	@RequestMapping(value = "/getTransferClassById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransferClass> getTransferClassById(@PathVariable("id") Integer id) {
		Optional<TransferClass> TransferClass = tfcSv.findById(id);

		if (!TransferClass.isPresent()) {
			return new ResponseEntity<>(TransferClass.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(TransferClass.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TransferClass> createTransferClass(@RequestBody TransferClass TransferClass, UriComponentsBuilder builder) {
		tfcSv.save(TransferClass);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/TransferClasss/{id}").buildAndExpand(TransferClass.getId()).toUri());
		return new ResponseEntity<>(TransferClass, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TransferClass> updateTransferClass(@PathVariable("id") Integer id, @RequestBody TransferClass TransferClass) {
		Optional<TransferClass> currentTransferClass = tfcSv.findById(id);

		if (!currentTransferClass.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentTransferClass.get().setStudentid(TransferClass.getStudentid());
		currentTransferClass.get().setClasstransfer(TransferClass.getClasstransfer());
		currentTransferClass.get().setSubjectid(TransferClass.getSubjectid());
		currentTransferClass.get().setNumbertransfer(TransferClass.getNumbertransfer());
//		currentTransferClass.get().setPathfile(TransferClass.getPathfile());
		currentTransferClass.get().setCreator(TransferClass.getCreator());
		currentTransferClass.get().setDatecreate(TransferClass.getDatecreate());
		currentTransferClass.get().setConfirmed(TransferClass.getConfirmed());
		currentTransferClass.get().setDateconfirm(TransferClass.getDateconfirm());
		currentTransferClass.get().setCreatorconfirm(TransferClass.getCreatorconfirm());

		tfcSv.save(currentTransferClass.get());
		return new ResponseEntity<>(currentTransferClass.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TransferClass> deleteTransferClass(@PathVariable("id") Integer id) {
		Optional<TransferClass> TransferClass = tfcSv.findById(id);
		if (!TransferClass.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tfcSv.remove(TransferClass.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
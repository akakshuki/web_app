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

import c1808g1.Models.CauHinh.HolidayDTO;
import c1808g1.Models.DonTu.TransferClassDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.HolidayModel;
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
	public ResponseEntity<List<TransferClassDTO>> findAllTransferClass() {
		List<TransferClass> listtf = tfcSv.findAllTransferClass();

		//mapper từ list entity -> list DTO
		List<TransferClassDTO> listtfd = ModelMapperConfig.mapList(listtf, TransferClassDTO.class);
		if (listtfd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listtfd, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getTransferClassById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransferClassDTO> getTransferClassById(@PathVariable("id") Integer id) {
		var data = tfcSv.findTransferClassById(id);
		//mapper từ entity -> DTO
		TransferClassDTO tfc = ModelMapperConfig.modelMapper.map(data, TransferClassDTO.class);

		if (tfc == null) {
			return new ResponseEntity<>(tfc, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tfc, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TransferClassDTO> createTransferClass(@RequestBody TransferClassDTO tf, UriComponentsBuilder builder) {
		TransferClass tfc = ModelMapperConfig.modelMapper.map(tf, TransferClass.class);
		tfcSv.save(tfc);
		tf.setId(tfc.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/tf/{id}").buildAndExpand(tf.getId()).toUri());
		return new ResponseEntity<>(tf, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TransferClassDTO> updateTransferClass(@PathVariable("id") Integer id, @RequestBody TransferClassDTO tf) {
		TransferClass tfc = tfcSv.findTransferClassById(id);
		
		if (tfc == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		tfc.setStudentid(tf.getStudentid());
		tfc.setClasstransfer(tf.getClasstransfer());
		tfc.setSubjectid(tf.getSubjectid());
		tfc.setNumbertransfer(tf.getNumbertransfer());
//		currentTransferClass.get().setPathfile(TransferClass.getPathfile());
		tfc.setCreator(tf.getCreator());
		tfc.setDatecreate(tf.getDatecreate());
		tfc.setConfirmed(tf.getConfirmed());
		tfc.setDateconfirm(tf.getDateconfirm());
		tfc.setCreatorconfirm(tf.getCreatorconfirm());

		tfcSv.save(tfc);
		return new ResponseEntity<>(tf, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TransferClass> deleteTransferClass(@PathVariable("id") Integer id) {
		TransferClass tfc = tfcSv.findTransferClassById(id);
		if (tfc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		//holiSv.remove(holi.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
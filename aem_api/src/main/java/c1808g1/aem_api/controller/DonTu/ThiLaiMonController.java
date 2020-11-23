package c1808g1.aem_api.controller.DonTu;

<<<<<<< HEAD:aem_api/src/main/java/c1808g1/aem_api/controller/DonTu/ThiLaiMon.java
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

import c1808g1.aem_api.models.DonTu.RegisExamModel;
import c1808g1.aem_api.services.DonTu.RegisExamService;

@RestController
@RequestMapping("api/dontu/thilaimonapi")
public class ThiLaiMon {
	private RegisExamService RESv;

	@Autowired
	public ThiLaiMon(RegisExamService RESv) {
		this.RESv = RESv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegisExamModel>> ListAllRegisExam(){
		List<RegisExamModel> lre = RESv.ListAllRegisExam();
		if (lre.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lre,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRegisExamById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisExamModel> ListRegisExamById(@PathVariable("id") Integer id){
		Optional<RegisExamModel> ore = RESv.ListRegisExamById(id);
		if(!ore.isPresent()) {
			return new ResponseEntity<>(ore.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ore.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisExamModel> CreateRE(@RequestBody RegisExamModel rem, UriComponentsBuilder builder){
		RESv.save(rem);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(rem.getId()).toUri());
		return new ResponseEntity<>(rem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<RegisExamModel> updateRE(@PathVariable("id") Integer id,@RequestBody RegisExamModel urem) {
        Optional<RegisExamModel> currentRE = RESv.ListRegisExamById(id);

        if (!currentRE.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentRE.get().setId(urem.getId());
        currentRE.get().setClass_id(urem.getClass_id());
        currentRE.get().setSubject_id(urem.getSubject_id());
        currentRE.get().setDate_exam(urem.getDate_exam());
        currentRE.get().setBrand_id(urem.getBrand_id());
        currentRE.get().setShift_id(urem.getShift_id());
        currentRE.get().setNote_status(urem.getNote_status());
        currentRE.get().setForm_pay_id_refer(urem.getForm_pay_id_refer());

        RESv.save(currentRE.get());
        return new ResponseEntity<>(currentRE.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<RegisExamModel> deleteRE(@PathVariable("id") Integer id) {
		Optional<RegisExamModel> dre = RESv.ListRegisExamById(id);
		if (!dre.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		RESv.delete(dre.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
=======
public class ThiLaiMonController {
    
>>>>>>> 4de3a8ab80257f04521cd78a978bd8c7a58c0d5e:aem_api/src/main/java/c1808g1/aem_api/controller/DonTu/ThiLaiMonController.java
}

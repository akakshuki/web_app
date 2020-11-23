package c1808g1.aem_api.controller.DonTu;

<<<<<<< HEAD:aem_api/src/main/java/c1808g1/aem_api/controller/DonTu/HocLaiMon.java
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

import c1808g1.aem_api.models.DonTu.FormPayModel;
import c1808g1.aem_api.services.DonTu.FormPayService;

@RestController
@RequestMapping("api/dontu/hoclaimonapi")
public class HocLaiMon {
	private FormPayService FPSv;

	@Autowired
	public HocLaiMon(FormPayService FPSv) {
		this.FPSv = FPSv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FormPayModel>> ListAllFormPay(){
		List<FormPayModel> lfp = FPSv.ListAllFormPay();
		if (lfp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lfp,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFormPayById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormPayModel> ListFormPayById(@PathVariable("id") Integer id){
		Optional<FormPayModel> ofp = FPSv.ListFormPayById(id);
		if(!ofp.isPresent()) {
			return new ResponseEntity<>(ofp.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ofp.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormPayModel> CreateFP(@RequestBody FormPayModel fpm, UriComponentsBuilder builder){
		FPSv.save(fpm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(fpm.getId()).toUri());
		return new ResponseEntity<>(fpm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<FormPayModel> updateFP(@PathVariable("id") Integer id,@RequestBody FormPayModel ufpm) {
        Optional<FormPayModel> currentFP = FPSv.ListFormPayById(id);

        if (!currentFP.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentFP.get().setId(ufpm.getId());
        currentFP.get().setClass_id(ufpm.getClass_id());
        currentFP.get().setSubject_id(ufpm.getSubject_id());
        currentFP.get().setStudent_id(ufpm.getStudent_id());
        currentFP.get().setMoney(ufpm.getMoney());
        currentFP.get().setMoney_sku(ufpm.getMoney_sku());
        currentFP.get().setType_payment(ufpm.getType_payment());
        currentFP.get().setType_form(ufpm.getType_form());
        currentFP.get().setCreator(ufpm.getCreator());
        currentFP.get().setDate_create(ufpm.getDate_create());
        currentFP.get().setNote(ufpm.getNote());
        currentFP.get().setPath_file(ufpm.getPath_file());
        currentFP.get().setConfirmed(ufpm.getConfirmed());
        currentFP.get().setCreator_confirm(ufpm.getCreator_confirm());
        currentFP.get().setDate_confirm(ufpm.getDate_confirm());

        FPSv.save(currentFP.get());
        return new ResponseEntity<>(currentFP.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<FormPayModel> deleteFP(@PathVariable("id") Integer id) {
		Optional<FormPayModel> dfp = FPSv.ListFormPayById(id);
		if (!dfp.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		FPSv.delete(dfp.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
=======
public class HocLaiMonController {
    
>>>>>>> 4de3a8ab80257f04521cd78a978bd8c7a58c0d5e:aem_api/src/main/java/c1808g1/aem_api/controller/DonTu/HocLaiMonController.java
}

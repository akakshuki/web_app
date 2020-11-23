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

import c1808g1.Models.DonTu.FormPayDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.DonTu.FormPayModel;
import c1808g1.aem_api.service.DonTu.FormPayService;

@RestController
@RequestMapping("/api/dontu/hoclaimonapi")
public class HocLaiMonController {
	private FormPayService FPSv;

	@Autowired
	public HocLaiMonController (FormPayService FPSv) {
		this.FPSv = FPSv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FormPayDTO>> ListAllFormPay(){
		List<FormPayModel> fpm = FPSv.ListAllFormPay();
		List<FormPayDTO> fpdto = ModelMapperConfig.mapList(fpm, FormPayDTO.class);
		if (fpdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(fpdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFormPayById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormPayDTO> ListFormPayById(@PathVariable("id") Integer id){
		var data = FPSv.ListFormPayById(id);
		FormPayDTO fpdto = ModelMapperConfig.modelMapper.map(data, FormPayDTO.class);
		if(fpdto == null){
			return new ResponseEntity<>(fpdto,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(fpdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormPayDTO> CreateFP(@RequestBody FormPayDTO fpdto, UriComponentsBuilder builder){
		FormPayModel fpm = ModelMapperConfig.modelMapper.map(fpdto, FormPayModel.class);
		FPSv.save(fpm);
		fpdto.setId(fpm.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(fpdto.getId()).toUri());
		return new ResponseEntity<>(fpdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<FormPayDTO> updateFP(@PathVariable("id") Integer id,@RequestBody FormPayDTO fpdto) {
        FormPayModel currentFP = FPSv.ListFormPayById(id);

        if (currentFP == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentFP.setId(fpdto.getId());
        currentFP.setClass_id(fpdto.getClass_id());
        currentFP.setSubject_id(fpdto.getSubject_id());
        currentFP.setStudent_id(fpdto.getStudent_id());
        currentFP.setMoney(fpdto.getMoney());
        currentFP.setMoney_sku(fpdto.getMoney_sku());
        currentFP.setType_payment(fpdto.getType_payment());
        currentFP.setType_form(fpdto.getType_form());
        currentFP.setCreator(fpdto.getCreator());
        currentFP.setDate_create(fpdto.getDate_create());
        currentFP.setNote(fpdto.getNote());
        currentFP.setPath_file(fpdto.getPath_file());
        currentFP.setConfirmed(fpdto.getConfirmed());
        currentFP.setCreator_confirm(fpdto.getCreator_confirm());
        currentFP.setDate_confirm(fpdto.getDate_confirm());

        FPSv.save(currentFP);
        return new ResponseEntity<>(fpdto, HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<FormPayModel> deleteFP(@PathVariable("id") Integer id) {
		FormPayModel fpm = FPSv.ListFormPayById(id);
		if (fpm == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
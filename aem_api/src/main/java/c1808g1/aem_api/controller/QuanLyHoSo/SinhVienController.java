package c1808g1.aem_api.controller.QuanLyHoSo;

<<<<<<< HEAD:aem_api/src/main/java/c1808g1/aem_api/controller/QuanLyHoSo/GiangVien.java
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

import c1808g1.aem_api.models.QuanLyHoSo.FCModel;
import c1808g1.aem_api.models.QuanLyHoSo.ScoreFCModel;
import c1808g1.aem_api.services.QuanLyHoSo.FCService;
import c1808g1.aem_api.services.QuanLyHoSo.ScoreFCService;

@RestController
@RequestMapping("api/quanlyhoso/giangvienapi")
public class GiangVien {
	private ScoreFCService SFCSv;
	private FCService FCSv;

	@Autowired
	public GiangVien (ScoreFCService SFCSv) {
		this.SFCSv = SFCSv;
	}
	
	@Autowired
	public GiangVien(FCService FCSv) {
		this.FCSv = FCSv;
	}
	
	// ScoreFC
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScoreFCModel>> ListAllScoreFC(){
		List<ScoreFCModel> lsfc = SFCSv.ListAllScoreFC();
		if (lsfc.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsfc,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getScoreFcById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreFCModel> ListScoreFCById(@PathVariable("id") Integer id){
		Optional<ScoreFCModel> osfc = SFCSv.ListScoreFCById(id);
		if(!osfc.isPresent()) {
			return new ResponseEntity<>(osfc.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(osfc.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreFCModel> CreateScoreFC(@RequestBody ScoreFCModel sfcm, UriComponentsBuilder builder){
		SFCSv.save(sfcm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(sfcm.getId()).toUri());
		return new ResponseEntity<>(sfcm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ScoreFCModel> updateScoreFC(@PathVariable("id") Integer id,@RequestBody ScoreFCModel usfc) {
        Optional<ScoreFCModel> currentScoreFC = SFCSv.ListScoreFCById(id);

        if (!currentScoreFC.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentScoreFC.get().setId(usfc.getId());
        currentScoreFC.get().setSubject_id(usfc.getSubject_id());
        currentScoreFC.get().setFc_id(usfc.getFc_id());
        currentScoreFC.get().setScore_percent(usfc.getScore_percent());
        currentScoreFC.get().setScore_number(usfc.getScore_number());
        currentScoreFC.get().setDate_create(usfc.getDate_create());
        
        SFCSv.save(currentScoreFC.get());
        return new ResponseEntity<>(currentScoreFC.get(), HttpStatus.OK);
    }

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ScoreFCModel> deleteScoreFC(@PathVariable("id") Integer id) {
		Optional<ScoreFCModel> dsfc = SFCSv.ListScoreFCById(id);
		if (!dsfc.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		SFCSv.delete(dsfc.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// FC
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FCModel>> FindAllFC(){
		List<FCModel> lfc = FCSv.ListAllFC();
		if (lfc.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lfc,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFCById/{id_fc}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FCModel> FindFCById(@PathVariable("id_fc") String id_fc){
		Optional<FCModel> ofc = FCSv.ListFCById(id_fc);
		if(!ofc.isPresent()) {
			return new ResponseEntity<>(ofc.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ofc.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FCModel> CreateFC(@RequestBody FCModel fcm, UriComponentsBuilder builder){
		FCSv.save(fcm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id_fc}").buildAndExpand(fcm.getId_fc()).toUri());
		return new ResponseEntity<>(fcm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id_fc}",method = RequestMethod.PUT)
    public ResponseEntity<FCModel> updateFC(@PathVariable("id_fc") String id_fc,@RequestBody FCModel ufcm) {
        Optional<FCModel> currentFC = FCSv.ListFCById(id_fc);

        if (!currentFC.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentFC.get().setId_fc(ufcm.getId_fc());
        currentFC.get().setName_fc(ufcm.getName_fc());
        currentFC.get().setEmail_fc(ufcm.getEmail_fc());
        currentFC.get().setEmail_school(ufcm.getEmail_school());
        currentFC.get().setPassword(ufcm.getPassword());
        currentFC.get().setPhone_fc(ufcm.getPhone_fc());
        currentFC.get().setColor_css(ufcm.getColor_css());
        currentFC.get().setActive_account(ufcm.getActive_account());
        currentFC.get().setList_role(ufcm.getList_role());
        currentFC.get().setStatus_id(ufcm.getStatus_id());
        currentFC.get().setStart_date(ufcm.getStart_date());
        currentFC.get().setEnd_date(ufcm.getEnd_date());
        currentFC.get().setNote_status(ufcm.getNote_status());

        FCSv.save(currentFC.get());
        return new ResponseEntity<>(currentFC.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id_fc}",method = RequestMethod.DELETE)
	public ResponseEntity<FCModel> deleteFC(@PathVariable("id_fc") String id_fc) {
		Optional<FCModel> dfc = FCSv.ListFCById(id_fc);
		if (!dfc.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		FCSv.delete(dfc.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
=======
public class SinhVienController {
    
}
>>>>>>> 4de3a8ab80257f04521cd78a978bd8c7a58c0d5e:aem_api/src/main/java/c1808g1/aem_api/controller/QuanLyHoSo/SinhVienController.java

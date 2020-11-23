package c1808g1.aem_api.controller.QuanLyHoSo;

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

import c1808g1.Models.QuanLiHoSo.FCDTO;
import c1808g1.Models.QuanLiHoSo.ScoreFCDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyHoSo.FCModel;
import c1808g1.aem_api.models.QuanLyHoSo.ScoreFCModel;
import c1808g1.aem_api.service.QuanLyHoSo.FCService;
import c1808g1.aem_api.service.QuanLyHoSo.ScoreFCService;

@RestController
@RequestMapping("/api/quanlyhoso/giangvienapi")
public class GiangVienController {
	private ScoreFCService SFCSv;
	private FCService FCSv;

	@Autowired
	public GiangVienController (ScoreFCService SFCSv) {
		this.SFCSv = SFCSv;
	}
	
	@Autowired
	public GiangVienController (FCService FCSv) {
		this.FCSv = FCSv;
	}
	
	// ScoreFC
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScoreFCDTO>> ListAllScoreFC(){
		List<ScoreFCModel> sfcm = SFCSv.ListAllScoreFC();
		List<ScoreFCDTO> sfcdto = ModelMapperConfig.mapList(sfcm, ScoreFCDTO.class);
		if (sfcdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sfcdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getScoreFcById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreFCDTO> ListScoreFCById(@PathVariable("id") Integer id){
		var data = SFCSv.ListScoreFCById(id);
		ScoreFCDTO sfcdto = ModelMapperConfig.modelMapper.map(data, ScoreFCDTO.class);
		if(sfcdto == null) {
			return new ResponseEntity<>(sfcdto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sfcdto , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreFCDTO> CreateScoreFC(@RequestBody ScoreFCDTO sfcdto, UriComponentsBuilder builder){
		ScoreFCModel sfcm = ModelMapperConfig.modelMapper.map(sfcdto,ScoreFCModel.class);  
		SFCSv.save(sfcm);
		sfcdto.setId(sfcm.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(sfcdto.getId()).toUri());
		return new ResponseEntity<>(sfcdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ScoreFCDTO> updateScoreFC(@PathVariable("id") Integer id,@RequestBody ScoreFCDTO sfcdto) {
        ScoreFCModel currentScoreFC = SFCSv.ListScoreFCById(id);

        if (currentScoreFC == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentScoreFC.setId(sfcdto.getId());
        currentScoreFC.setSubject_id(sfcdto.getSubject_id());
        currentScoreFC.setFc_id(sfcdto.getFc_id());
        currentScoreFC.setScore_percent(sfcdto.getScore_percent());
        currentScoreFC.setScore_number(sfcdto.getScore_number());
        currentScoreFC.setDate_create(sfcdto.getDate_create());
        
        SFCSv.save(currentScoreFC);
        return new ResponseEntity<>(sfcdto, HttpStatus.OK);
    }

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ScoreFCModel> deleteScoreFC(@PathVariable("id") Integer id) {
		ScoreFCModel sfcm = SFCSv.ListScoreFCById(id);
		if (sfcm == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// FC
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FCDTO>> FindAllFC(){
		List<FCModel> fcm = FCSv.ListAllFC();
		List<FCDTO> fcdto = ModelMapperConfig.mapList(fcm, FCDTO.class);
		if (fcdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(fcdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFCById/{id_fc}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FCDTO> FindFCById(@PathVariable("id_fc") String id_fc){
		var data = FCSv.ListFCById(id_fc);
		FCDTO fcdto = ModelMapperConfig.modelMapper.map(data, FCDTO.class);
		if(fcdto == null){
			return new ResponseEntity<>(fcdto,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(fcdto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FCDTO> CreateFC(@RequestBody FCDTO fcdto, UriComponentsBuilder builder){
		FCModel fcm = ModelMapperConfig.modelMapper.map(fcdto, FCModel.class);
		FCSv.save(fcm);
		fcdto.setId_fc(fcm.getId_fc());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id_fc}").buildAndExpand(fcdto.getId_fc()).toUri());
		return new ResponseEntity<>(fcdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id_fc}",method = RequestMethod.PUT)
    public ResponseEntity<FCDTO> updateFC(@PathVariable("id_fc") String id_fc,@RequestBody FCDTO fcdto) {
        FCModel currentFC = FCSv.ListFCById(id_fc);

        if (currentFC == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentFC.setId_fc(fcdto.getId_fc());
        currentFC.setName_fc(fcdto.getName_fc());
        currentFC.setEmail_fc(fcdto.getEmail_fc());
        currentFC.setEmail_school(fcdto.getEmail_school());
        currentFC.setPassword(fcdto.getPassword());
        currentFC.setPhone_fc(fcdto.getPhone_fc());
        currentFC.setColor_css(fcdto.getColor_css());
        currentFC.setActive_account(fcdto.getActive_account());
        currentFC.setList_role(fcdto.getList_role());
        currentFC.setStatus_id(fcdto.getStatus_id());
        currentFC.setStart_date(fcdto.getStart_date());
        currentFC.setEnd_date(fcdto.getEnd_date());
        currentFC.setNote_status(fcdto.getNote_status());

        FCSv.save(currentFC);
        return new ResponseEntity<>(fcdto,HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id_fc}",method = RequestMethod.DELETE)
	public ResponseEntity<FCModel> deleteFC(@PathVariable("id_fc") String id_fc) {
		FCModel fcm = FCSv.ListFCById(id_fc);
		if (fcm == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

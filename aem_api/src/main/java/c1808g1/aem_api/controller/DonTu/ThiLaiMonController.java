package c1808g1.aem_api.controller.DonTu;

import java.util.List;

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

import c1808g1.Models.DonTu.RegisExamDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.DonTu.RegisExamModel;
import c1808g1.aem_api.service.DonTu.RegisExamService;

@RestController
@RequestMapping("/api/dontu/thilaimonapi")
public class ThiLaiMonController {
	private RegisExamService RESv;

	@Autowired
	public ThiLaiMonController (RegisExamService RESv) {
		this.RESv = RESv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegisExamDTO>> ListAllRegisExam(){
		List<RegisExamModel> rem = RESv.ListAllRegisExam();
		List<RegisExamDTO> redto = ModelMapperConfig.mapList(rem, RegisExamDTO.class);
		if (redto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(redto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRegisExamById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisExamDTO> ListRegisExamById(@PathVariable("id") Integer id){
		var data = RESv.ListRegisExamById(id);
		RegisExamDTO redto = ModelMapperConfig.modelMapper.map(data, RegisExamDTO.class);
		if(redto == null) {
			return new ResponseEntity<>(redto, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(redto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisExamDTO> CreateRE(@RequestBody RegisExamDTO redto, UriComponentsBuilder builder){
		RegisExamModel rem = ModelMapperConfig.modelMapper.map(redto, RegisExamModel.class);
		RESv.save(rem);
		redto.setId(rem.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(redto.getId()).toUri());
		return new ResponseEntity<>(redto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<RegisExamDTO> updateRE(@PathVariable("id") Integer id,@RequestBody RegisExamDTO redto) {
        RegisExamModel currentRE = RESv.ListRegisExamById(id);

        if (currentRE == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentRE.setId(redto.getId());
        currentRE.setClass_id(redto.getClass_id());
        currentRE.setSubject_id(redto.getSubject_id());
        currentRE.setDate_exam(redto.getDate_exam());
        currentRE.setBrand_id(redto.getBrand_id());
        currentRE.setShift_id(redto.getShift_id());
        currentRE.setNote_status(redto.getNote_status());
        currentRE.setForm_pay_id_refer(redto.getForm_pay_id_refer());

        RESv.save(currentRE);
        return new ResponseEntity<>(redto, HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<RegisExamModel> deleteRE(@PathVariable("id") Integer id) {
		RegisExamModel rem = RESv.ListRegisExamById(id);
		if (rem == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		RESv.delete(rem);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
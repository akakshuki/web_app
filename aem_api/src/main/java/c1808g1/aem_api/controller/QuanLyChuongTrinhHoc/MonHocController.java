package c1808g1.aem_api.controller.QuanLyChuongTrinhHoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import c1808g1.Models.QuanLyChuongTrinhHoc.ClassDTO;
import c1808g1.Models.QuanLyChuongTrinhHoc.SubjectDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Class;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Subject;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.SubjectServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quanlychuongtrinhhoc/subjectapi")
public class MonHocController {
	private SubjectServices subSv;
	
	@Autowired
	public MonHocController(SubjectServices subSv) {
		this.subSv = subSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<SubjectDTO>> findAllSubject(){
		List<Subject> listsub = subSv.findAllSubject();
		List<SubjectDTO> lssub = ModelMapperConfig.mapList(listsub, SubjectDTO.class);
		if (lssub.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lssub, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSubjectById/{id_subject}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable("id_subject") String id_subject){
		var data = subSv.findById(id_subject);
		SubjectDTO sub = ModelMapperConfig.modelMapper.map(data, SubjectDTO.class);
		
		if(sub == null) {
			return new ResponseEntity<>(sub, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sub, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO sub, UriComponentsBuilder builder){
		Subject SubjectModel = ModelMapperConfig.modelMapper.map(sub, Subject.class);
		subSv.save(SubjectModel);
		sub.setId_subject(SubjectModel.getId_subject());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subject/{id_subject}").buildAndExpand(sub.getId_subject()).toUri());
		return new ResponseEntity<>(sub, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_subject}",method = RequestMethod.PUT)
    public ResponseEntity<SubjectDTO> updateSubject(
            @PathVariable("id_subject") String id_subject,
            @RequestBody SubjectDTO sub) {
        Subject currentSubject = subSv.findById(id_subject);

        if (currentSubject == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSubject.setId_subject(sub.getId_subject());
        currentSubject.setName_subject(sub.getName_subject());
        currentSubject.setSort_name(sub.getSort_name());
        currentSubject.setHour_study(sub.getHour_study());
        currentSubject.setSeme_id(sub.getSeme_id());
        currentSubject.setNumber_session(sub.getNumber_session());
        currentSubject.setMoney_subject(sub.getMoney_subject());
        currentSubject.setSku_id(sub.getSku_id());
        currentSubject.setType_subjcet_id(sub.getType_subject_id());
        currentSubject.setNote(sub.getNote());
        currentSubject.setFactor(sub.getFactor());
        currentSubject.setPoint(sub.getPoint());

        subSv.save(currentSubject);
        return new ResponseEntity<>(sub, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id_subject}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Subject> deleteSubject(
            @PathVariable("id_subject") String id_subject) {
        Subject sub = subSv.findById(id_subject);
        if (sub == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subSv.remove(sub);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

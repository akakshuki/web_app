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

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Subject;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.SubjectServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quanlychuongtrinhhoc/subjectapi")
public class MonHocController {
	private SubjectServices subSv;
	
	@Autowired
	public MonHocController(SubjectServices subSv) {
		this.subSv = subSv;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Subject>> findAllSubject(){
		List<Subject> sub = subSv.findAllSubject();
		if (sub.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sub, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{id_subject}", method = RequestMethod.GET, produces = "appliection/json")
	public ResponseEntity<Subject> getSubjectById(@PathVariable("id_subject") Integer id_subject){
		Optional<Subject> sub = subSv.findById(id_subject);
		
		if(!sub.isPresent()) {
			return new ResponseEntity<>(sub.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sub.get() ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Subject> createSubject(@RequestBody Subject sub, UriComponentsBuilder builder){
		subSv.save(sub);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subject/{id_subject}").buildAndExpand(sub.getId_subject()).toUri());
		return new ResponseEntity<>(sub, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_subject}",method = RequestMethod.PUT)
    public ResponseEntity<Subject> updateSubject(
            @PathVariable("id_subject") Integer id_subject,
            @RequestBody Subject sub) {
        Optional<Subject> currentSubject = subSv.findById(id_subject);

        if (!currentSubject.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSubject.get().setId_subject(sub.getId_subject());
        currentSubject.get().setName_subject(sub.getName_subject());
        currentSubject.get().setSort_name(sub.getSort_name());
        currentSubject.get().setHour_study(sub.getHour_study());
        currentSubject.get().setSeme_id(sub.getSeme_id());
        currentSubject.get().setNumber_session(sub.getNumber_session());
        currentSubject.get().setMoney_subject(sub.getMoney_subject());
        currentSubject.get().setSku_id(sub.getSku_id());
        currentSubject.get().setType_subjcet_id(sub.getType_subjcet_id());
        currentSubject.get().setNote(sub.getNote());
        currentSubject.get().setFactor(sub.getFactor());
        currentSubject.get().setPoint(sub.getPoint());

        subSv.save(currentSubject.get());
        return new ResponseEntity<>(currentSubject.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id_subject}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Subject> deleteSubject(
            @PathVariable("id_subject") Integer id_subject) {
        Optional<Subject> sub = subSv.findById(id_subject);
        if (!sub.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subSv.remove(sub.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

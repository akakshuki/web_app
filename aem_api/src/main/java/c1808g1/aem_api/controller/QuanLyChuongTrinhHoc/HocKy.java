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

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Semester;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.SemesterServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quanlychuongtrinhhoc/semesterapi")
public class HocKy {
	private SemesterServices smtSv;
	
	@Autowired
	public HocKy(SemesterServices smtSv) {
		this.smtSv = smtSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Semester>> findAllSemester(){
		List<Semester> smt = smtSv.findAllSemester();
		if (smt.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(smt, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSemesterById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Semester> getSemesterById(@PathVariable("id") Integer id){
		Optional<Semester> smt = smtSv.findById(id);
		
		if(!smt.isPresent()) {
			return new ResponseEntity<>(smt.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(smt.get() ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Semester> createSemester(@RequestBody Semester smt, UriComponentsBuilder builder){
		smtSv.save(smt);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/semester/{id}").buildAndExpand(smt.getId()).toUri());
		return new ResponseEntity<>(smt, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Semester> updateSemester(
            @PathVariable("id") Integer id,
            @RequestBody Semester semester) {
        Optional<Semester> currentSemester = smtSv.findById(id);

        if (!currentSemester.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSemester.get().setName_seme(semester.getName_seme());
        currentSemester.get().setId(semester.getId());
        currentSemester.get().setNote(semester.getNote());
        currentSemester.get().setCourse_id(semester.getCourse_id());

        smtSv.save(currentSemester.get());
        return new ResponseEntity<>(currentSemester.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Semester> deleteSemester(
            @PathVariable("id") Integer id) {
        Optional<Semester> semster = smtSv.findById(id);
        if (!semster.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smtSv.remove(semster.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

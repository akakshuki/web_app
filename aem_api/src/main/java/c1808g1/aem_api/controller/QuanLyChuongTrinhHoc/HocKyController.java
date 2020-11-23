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

import c1808g1.Models.CauHinh.HolidayDTO;
import c1808g1.Models.QuanLyChuongTrinhHoc.SemesterDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.HolidayModel;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Semester;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.SemesterServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quanlychuongtrinhhoc/semesterapi")
public class HocKyController {
	private SemesterServices smtSv;
	
	@Autowired
	public HocKyController(SemesterServices smtSv) {
		this.smtSv = smtSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<SemesterDTO>> findAllSemester(){
		List<Semester> listsmt = smtSv.findAllSemester();
		List<SemesterDTO> lssmt = ModelMapperConfig.mapList(listsmt, SemesterDTO.class);
		if (lssmt.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lssmt, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSemesterById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<SemesterDTO> getSemesterById(@PathVariable("id") Integer id){
		var data = smtSv.findById(id);
		SemesterDTO smt = ModelMapperConfig.modelMapper.map(data, SemesterDTO.class);
		
		if(smt == null) {
			return new ResponseEntity<>(smt, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(smt ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SemesterDTO> createSemester(@RequestBody SemesterDTO smt, UriComponentsBuilder builder){
		Semester smtModel = ModelMapperConfig.modelMapper.map(smt, Semester.class);
		smtSv.save(smtModel);
		smt.setId(smtModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/semester/{id}").buildAndExpand(smt.getId()).toUri());
		return new ResponseEntity<>(smt, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<SemesterDTO> updateSemester(
            @PathVariable("id") Integer id,
            @RequestBody SemesterDTO semester) {
        Semester currentSemester = smtSv.findById(id);

        if (currentSemester == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentSemester.setName_seme(semester.getName_seme());
        currentSemester.setId(semester.getId());
        currentSemester.setNote(semester.getNote());
        currentSemester.setCourse_id(semester.getCourse_id());

        smtSv.save(currentSemester);
        return new ResponseEntity<>(semester, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Semester> deleteSemester(
            @PathVariable("id") Integer id) {
        Semester semster = smtSv.findById(id);
        if (semster == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smtSv.remove(semster);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

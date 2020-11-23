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

import c1808g1.aem_api.models.QuanLyHoSo.ScoreStudentModel;
import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;
import c1808g1.aem_api.services.QuanLyHoSo.ScoreStudentService;
import c1808g1.aem_api.services.QuanLyHoSo.StudentService;

@RestController
@RequestMapping("/api/quanlyhoso/sinhvienapi")
public class SinhVienController {
	private ScoreStudentService SSSv;
	private StudentService StuSv;

	@Autowired
	public SinhVienController (ScoreStudentService SSSv) {
		this.SSSv = SSSv;
	}
	
	@Autowired
	public SinhVienController (StudentService StuSv) {
		this.StuSv = StuSv;
	}
	
	// ScoreStudent
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScoreStudentModel>> ListAllScoreStudent(){
		List<ScoreStudentModel> lss = SSSv.ListAllScoreStudent();
		if (lss.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lss,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getScoreStudentById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreStudentModel> ListScoreStudentById(@PathVariable("id") Integer id){
		Optional<ScoreStudentModel> oss = SSSv.ListScoreStudentById(id);
		if(!oss.isPresent()) {
			return new ResponseEntity<>(oss.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(oss.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreStudentModel> CreateScoreStudent(@RequestBody ScoreStudentModel sdm, UriComponentsBuilder builder){
		SSSv.save(sdm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(sdm.getId()).toUri());
		return new ResponseEntity<>(sdm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ScoreStudentModel> updateScoreStudent(@PathVariable("id") Integer id,@RequestBody ScoreStudentModel ussm) {
        Optional<ScoreStudentModel> currentScoreStudent = SSSv.ListScoreStudentById(id);

        if (!currentScoreStudent.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentScoreStudent.get().setId(ussm.getId());
        currentScoreStudent.get().setRegis_exam_id(ussm.getRegis_exam_id());
        currentScoreStudent.get().setStudent_id(ussm.getStudent_id());
        currentScoreStudent.get().setPass_exam(ussm.getPass_exam());
        currentScoreStudent.get().setStatus_id(ussm.getStatus_id());
        currentScoreStudent.get().setScore_percent(ussm.getScore_percent());
        currentScoreStudent.get().setScore_number(ussm.getScore_number());
        currentScoreStudent.get().setType_exam(ussm.getType_exam());
        currentScoreStudent.get().setPath_file(ussm.getPath_file());
        currentScoreStudent.get().setCreator(ussm.getCreator());
        currentScoreStudent.get().setDate_create(ussm.getDate_create());
        currentScoreStudent.get().setNote(ussm.getNote());
        
        SSSv.save(currentScoreStudent.get());
        return new ResponseEntity<>(currentScoreStudent.get(), HttpStatus.OK);
    }

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ScoreStudentModel> deleteScoreStudent(@PathVariable("id") Integer id) {
		Optional<ScoreStudentModel> dss = SSSv.ListScoreStudentById(id);
		if (!dss.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		SSSv.delete(dss.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// Student
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentModel>> ListAllStudent(){
		List<StudentModel> lstu = StuSv.ListAllStudent();
		if (lstu.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lstu,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStudentById/{id_student}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel> ListStudentById(@PathVariable("id_student") String id_student){
		Optional<StudentModel> ostu = StuSv.ListStudentById(id_student);
		if(!ostu.isPresent()) {
			return new ResponseEntity<>(ostu.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ostu.get(), HttpStatus.OK);
	}
	
		@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel> CreateStudent(@RequestBody StudentModel astu , UriComponentsBuilder builder){
		StuSv.save(astu);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id_student}").buildAndExpand(astu.getId_student()).toUri());
		return new ResponseEntity<>(astu,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_student}",method = RequestMethod.PUT)
    public ResponseEntity<StudentModel> updateStudent(@PathVariable("id_student") String id_student,@RequestBody StudentModel ustu) {
        Optional<StudentModel> currentStudent = StuSv.ListStudentById(id_student);

        if (!currentStudent.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentStudent.get().setId_student(ustu.getId_student());
        currentStudent.get().setFirst_name(ustu.getFirst_name());
        currentStudent.get().setLast_name(ustu.getLast_name());
        currentStudent.get().setFull_name(ustu.getFull_name());
        currentStudent.get().setFirst_class(ustu.getFirst_class());
        currentStudent.get().setCurrent_class(ustu.getCurrent_class());
        currentStudent.get().setActive_account(ustu.getActive_account());
        currentStudent.get().setDate_of_doing(ustu.getDate_of_doing());
        currentStudent.get().setSex(ustu.getSex());
        currentStudent.get().setDob(ustu.getDob());
        currentStudent.get().setMobile_phone(ustu.getMobile_phone());
        currentStudent.get().setHome_phone(ustu.getHome_phone());
        currentStudent.get().setContact_phone(ustu.getContact_phone());
        currentStudent.get().setEmail_student(ustu.getEmail_student());
        currentStudent.get().setEmail_school(ustu.getEmail_school());
        currentStudent.get().setPassword(ustu.getPassword());
        currentStudent.get().setAddress(ustu.getAddress());
        currentStudent.get().setContact_address(ustu.getContact_address());
        currentStudent.get().setApplication_date(ustu.getApplication_date());
        currentStudent.get().setDistrict(ustu.getDistrict());
        currentStudent.get().setCity(ustu.getCity());
        currentStudent.get().setHo_so(ustu.getHo_so());
        currentStudent.get().setCs(ustu.getCs());
        currentStudent.get().setCourse_id(ustu.getCourse_id());
        currentStudent.get().setCourse_family(ustu.getCourse_family());
        currentStudent.get().setHigh_school(ustu.getHigh_school());
        currentStudent.get().setUniversity(ustu.getUniversity());
        currentStudent.get().setTemp_id(ustu.getTemp_id());
        currentStudent.get().setImage_student(ustu.getImage_student());
        currentStudent.get().setCentre_name(ustu.getCentre_name());
        currentStudent.get().setMobile_mac(ustu.getMobile_mac());
        currentStudent.get().setRole_id(ustu.getRole_id());

        StuSv.save(currentStudent.get());
        return new ResponseEntity<>(currentStudent.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id_student}",method = RequestMethod.DELETE)
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable("id_student") String id_student) {
		Optional<StudentModel> dstu = StuSv.ListStudentById(id_student);
		if (!dstu.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StuSv.delete(dstu.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
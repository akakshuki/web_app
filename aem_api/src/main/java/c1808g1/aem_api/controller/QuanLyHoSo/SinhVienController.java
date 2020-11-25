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

import c1808g1.Models.QuanLiHoSo.ScoreStudentDTO;
import c1808g1.Models.QuanLiHoSo.StudentDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyHoSo.ScoreStudentModel;
import c1808g1.aem_api.models.QuanLyHoSo.StudentModel;
import c1808g1.aem_api.service.QuanLyHoSo.ScoreStudentService;
import c1808g1.aem_api.service.QuanLyHoSo.StudentService;

@RestController
@RequestMapping("/api/quanlyhoso/sinhvienapi")
public class SinhVienController {
	private ScoreStudentService SSSv;
	private StudentService StuSv;

	@Autowired
	public SinhVienController (ScoreStudentService SSSv,StudentService StuSv) {
		this.SSSv = SSSv;
		this.StuSv = StuSv;
	}
	
//	@Autowired
//	public SinhVienController () {
//		
//	}
	
	// ScoreStudent
	
	@RequestMapping(value = "/getAllScoreStudent" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScoreStudentDTO>> ListAllScoreStudent(){
		List<ScoreStudentModel> ssm = SSSv.ListAllScoreStudent();
		List<ScoreStudentDTO> ssdto = ModelMapperConfig.mapList(ssm, ScoreStudentDTO.class);
		if (ssdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ssdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getScoreStudentById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreStudentDTO> ListScoreStudentById(@PathVariable("id") Integer id){
		var data = SSSv.ListScoreStudentById(id);
		ScoreStudentDTO ssdto = ModelMapperConfig.modelMapper.map(data, ScoreStudentDTO.class);
		if(ssdto == null){
			return new ResponseEntity<>(ssdto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ssdto ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createScoreStudent" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreStudentDTO> CreateScoreStudent(@RequestBody ScoreStudentDTO ssdto, UriComponentsBuilder builder){
		ScoreStudentModel ssm = ModelMapperConfig.modelMapper.map(ssdto , ScoreStudentModel.class);
		SSSv.save(ssm);
		ssdto.setId(ssm.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(ssdto.getId()).toUri());
		return new ResponseEntity<>(ssdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateScoreStudent/{id}",method = RequestMethod.PUT)
    public ResponseEntity<ScoreStudentDTO> updateScoreStudent(@PathVariable("id") Integer id,@RequestBody ScoreStudentDTO ssdto) {
        ScoreStudentModel currentScoreStudent = SSSv.ListScoreStudentById(id);

        if (currentScoreStudent == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentScoreStudent.setId(ssdto.getId());
        currentScoreStudent.setRegis_exam_id(ssdto.getRegis_exam_id());
        currentScoreStudent.setStudent_id(ssdto.getStudent_id());
        currentScoreStudent.setPass_exam(ssdto.getPass_exam());
        currentScoreStudent.setStatus_id(ssdto.getStatus_id());
        currentScoreStudent.setScore_percent(ssdto.getScore_percent());
        currentScoreStudent.setScore_number(ssdto.getScore_number());
        currentScoreStudent.setType_exam(ssdto.getType_exam());
        currentScoreStudent.setPath_file(ssdto.getPath_file());
        currentScoreStudent.setCreator(ssdto.getCreator());
        currentScoreStudent.setDate_create(ssdto.getDate_create());
        currentScoreStudent.setNote(ssdto.getNote());
        
        SSSv.save(currentScoreStudent);
        return new ResponseEntity<>(ssdto,HttpStatus.OK);
    }

	@RequestMapping(value = "/deleteScoreStudent/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ScoreStudentModel> deleteScoreStudent(@PathVariable("id") Integer id) {
		ScoreStudentModel ssm = SSSv.ListScoreStudentById(id);
		if (ssm == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		SSSv.delete(ssm);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// Student
	
	@RequestMapping(value = "/getAllStudent" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentDTO>> ListAllStudent(){
		List<StudentModel> sm = StuSv.ListAllStudent();
		List<StudentDTO> sdto = ModelMapperConfig.mapList(sm, StudentDTO.class);
		if (sdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStudentById/{id_student}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDTO> ListStudentById(@PathVariable("id_student") String id_student){
		var data = StuSv.ListStudentById(id_student);
		StudentDTO sdto = ModelMapperConfig.modelMapper.map(data , StudentDTO.class);
		if(sdto == null){
			return new ResponseEntity<>(sdto, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sdto ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createStudent" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDTO> CreateStudent(@RequestBody StudentDTO sdto, UriComponentsBuilder builder){
		StudentModel sm = ModelMapperConfig.modelMapper.map(sdto, StudentModel.class);
		StuSv.save(sm);
		sdto.setId_student(sm.getId_student());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id_student}").buildAndExpand(sdto.getId_student()).toUri());
		return new ResponseEntity<>(sdto,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/updateStudent/{id_student}",method = RequestMethod.PUT)
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id_student") String id_student,@RequestBody StudentDTO sdto) {
        StudentModel currentStudent = StuSv.ListStudentById(id_student);

        if (currentStudent == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentStudent.setId_student(sdto.getId_student());
        currentStudent.setFirst_name(sdto.getFirst_name());
        currentStudent.setLast_name(sdto.getLast_name());
        currentStudent.setFull_name(sdto.getFull_name());
        currentStudent.setFirst_class(sdto.getFirst_class());
        currentStudent.setCurrent_class(sdto.getCurrent_class());
        currentStudent.setActive_account(sdto.getActive_account());
        currentStudent.setDate_of_doing(sdto.getDate_of_doing());
        currentStudent.setSex(sdto.getSex());
        currentStudent.setDob(sdto.getDob());
        currentStudent.setMobile_phone(sdto.getMobile_phone());
        currentStudent.setHome_phone(sdto.getHome_phone());
        currentStudent.setContact_phone(sdto.getContact_phone());
        currentStudent.setEmail_student(sdto.getEmail_student());
        currentStudent.setEmail_school(sdto.getEmail_school());
        //currentStudent.setPassword(sdto.getPassword());
        currentStudent.setAddress(sdto.getAddress());
        currentStudent.setContact_address(sdto.getContact_address());
        currentStudent.setApplication_date(sdto.getApplication_date());
        currentStudent.setDistrict(sdto.getDistrict());
        currentStudent.setCity(sdto.getCity());
        currentStudent.setHo_so(sdto.getHo_so());
        currentStudent.setCs(sdto.getCs());
        currentStudent.setCourse_id(sdto.getCourse_id());
        currentStudent.setCourse_family(sdto.getCourse_family());
        currentStudent.setHigh_school(sdto.getHigh_school());
        currentStudent.setUniversity(sdto.getUniversity());
        currentStudent.setTemp_id(sdto.getTemp_id());
        currentStudent.setImage_student(sdto.getImage_student());
        currentStudent.setCentre_name(sdto.getCentre_name());
        currentStudent.setMobile_mac(sdto.getMobile_mac());
        currentStudent.setRole_id(sdto.getRole_id());

        StuSv.save(currentStudent);
        return new ResponseEntity<>(sdto, HttpStatus.OK);
    }


	@RequestMapping(value = "/deleteStudent/{id_student}",method = RequestMethod.DELETE)
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable("id_student") String id_student) {
		StudentModel sm = StuSv.ListStudentById(id_student);
		if (sm == null ){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StuSv.delete(sm);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
package c1808g1.aem_api.controller.QuanLyLichHoc;

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

import c1808g1.Models.QuanLiLichHoc.AttendanceDTO;
import c1808g1.Models.QuanLiLichHoc.AttendanceFCDTO;
import c1808g1.Models.QuanLiLichHoc.AttendanceStudentDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceFCModel;
import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceModel;
import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceFCService;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceService;
import c1808g1.aem_api.service.QuanLyLichHoc.AttendanceStudentService;

@RestController
@RequestMapping("/api/dontu/diemdanhapi")
public class DiemDanhController {
	private AttendanceFCService AFCSv;
	private AttendanceService ASv;
	private AttendanceStudentService ASSv;

	@Autowired
	public DiemDanhController(AttendanceFCService AFCSv,AttendanceService ASv,AttendanceStudentService ASSv) {
		this.AFCSv = AFCSv;
		this.ASv = ASv;
		this.ASSv = ASSv;
	}
//	@Autowired
//	public DiemDanhController() {
//		
//	}
//	@Autowired
//	public DiemDanhController() {
//		
//	}
	
	//Attendance
	
	@RequestMapping(value = "/getAllAttendance" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceDTO>> ListAllAttendance(){
		List<AttendanceModel> am = ASv.ListAllAttendance();
		List<AttendanceDTO> adto =  ModelMapperConfig.mapList(am, AttendanceDTO.class);
		if (adto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(adto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAttendanceById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceDTO> ListAttendanceById(@PathVariable("id") Integer id){
		var data = ASv.ListAttendanceById(id);
		AttendanceDTO adto = ModelMapperConfig.modelMapper.map(data , AttendanceDTO.class);
		if(adto == null){
			return new ResponseEntity<>(adto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(adto ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createAttendance" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceDTO> CreateAttendance(@RequestBody AttendanceDTO adto, UriComponentsBuilder builder){
		AttendanceModel am = ModelMapperConfig.modelMapper.map(adto, AttendanceModel.class);
		ASv.save(am);
		adto.setId(am.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(adto.getId()).toUri());
		return new ResponseEntity<>(adto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateAttendance/{id}",method = RequestMethod.PUT)
    public ResponseEntity<AttendanceDTO> updateAttendance(@PathVariable("id") Integer id,@RequestBody AttendanceDTO adto) {
        AttendanceModel currentAttendance = ASv.ListAttendanceById(id);

        if (currentAttendance == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAttendance.setId(adto.getId());
        currentAttendance.setSchedule_id(adto.getSchedule_id());
        currentAttendance.setShift_id(adto.getShift_id());
        currentAttendance.setBrand_id(adto.getBrand_id());
        currentAttendance.setDate_attendance(adto.getDate_attendance());
        currentAttendance.setStatus_id(adto.getStatus_id());
        currentAttendance.setDisable(adto.getDisable());
        currentAttendance.setNote(adto.getNote());

        ASv.save(currentAttendance);
        return new ResponseEntity<>(adto,HttpStatus.OK);
    }


	@RequestMapping(value = "/deleteAttendance/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<AttendanceModel> deleteAttendance(@PathVariable("id") Integer id) {
		AttendanceModel am = ASv.ListAttendanceById(id);
		if (am == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//AttendanceFC
	
	@RequestMapping(value = "/getAllAttendanceFC" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceFCDTO>> ListAllAttendanceFC(){
		List<AttendanceFCModel> afcm = AFCSv.ListAllAttendanceFC();
		List<AttendanceFCDTO> afcdto = ModelMapperConfig.mapList(afcm, AttendanceFCDTO.class);
		if (afcdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(afcdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAttendanceFCById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceFCDTO> ListAttendanceFCById(@PathVariable("id") Integer id){
		var data = AFCSv.ListAttendanceFCById(id);
		AttendanceFCDTO afcdto = ModelMapperConfig.modelMapper.map(data, AttendanceFCDTO.class);
		if(afcdto == null) {
			return new ResponseEntity<>(afcdto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(afcdto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createAttendanceFC" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceFCDTO> CreateAttendanceFC(@RequestBody AttendanceFCDTO afcdto, UriComponentsBuilder builder){
		AttendanceFCModel afcm = ModelMapperConfig.modelMapper.map(afcdto, AttendanceFCModel.class);
		AFCSv.save(afcm);
		afcdto.setId(afcm.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(afcdto.getId()).toUri());
		return new ResponseEntity<>(afcdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateAttendanceFC/{id}",method = RequestMethod.PUT)
    public ResponseEntity<AttendanceFCDTO> updateAFC(@PathVariable("id") Integer id,@RequestBody AttendanceFCDTO afcdto) {
        AttendanceFCModel currentAFC = AFCSv.ListAttendanceFCById(id);

        if (currentAFC == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAFC.setId(afcdto.getId());
        currentAFC.setAttendance_id(afcdto.getAttendance_id());
        currentAFC.setFc_id(afcdto.getFc_id());
        currentAFC.setStatus_id(afcdto.getStatus_id());
        currentAFC.setNote(afcdto.getNote());

        AFCSv.save(currentAFC);
        return new ResponseEntity<>(afcdto, HttpStatus.OK);
    }


	@RequestMapping(value = "/deleteAttendanceFC/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<AttendanceFCModel> deleteAFC(@PathVariable("id") Integer id) {
		AttendanceFCModel afcm = AFCSv.ListAttendanceFCById(id);
		if (afcm == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//AttendanceStudent
	
	@RequestMapping(value = "/getAllAttendanceStudent" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceStudentDTO>> ListAllAttendanceStudent(){
		List<AttendanceStudentModel> asm = ASSv.ListAllAttendanceStudent();
		List<AttendanceStudentDTO> asdto = ModelMapperConfig.mapList(asm, AttendanceStudentDTO.class);
		if (asdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(asdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAttendanceStudentById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceStudentDTO> ListAttendanceStudentById(@PathVariable("id") Integer id){
		var data = ASSv.ListAttendanceStudentById(id);
		AttendanceStudentDTO asdto = ModelMapperConfig.modelMapper.map(data , AttendanceStudentDTO.class);
		if(asdto == null){
			return new ResponseEntity<>(asdto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(asdto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createAttendanceStudent" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceStudentDTO> CreateAttendanceStudent(@RequestBody AttendanceStudentDTO asdto, UriComponentsBuilder builder){
		AttendanceStudentModel asm = ModelMapperConfig.modelMapper.map(asdto, AttendanceStudentModel.class);
		ASSv.save(asm);
		asdto.setId(asm.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(asdto.getId()).toUri());
		return new ResponseEntity<>(asdto,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateAttendanceStudent/{id}",method = RequestMethod.PUT)
    public ResponseEntity<AttendanceStudentDTO> updateAS(@PathVariable("id") Integer id,@RequestBody AttendanceStudentDTO asdto) {
        AttendanceStudentModel currentAS = ASSv.ListAttendanceStudentById(id);

        if (currentAS == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAS.setAttendance_id(asdto.getAttendance_id());
        currentAS.setStudent_id(asdto.getStudent_id());
        currentAS.setCheck_in(asdto.getCheck_in());
        currentAS.setCheck_out(asdto.getCheck_out());
        currentAS.setMinute_late(asdto.getMinute_late());
        currentAS.setMinute_leave_early(asdto.getMinute_leave_early());
        currentAS.setStatus_id(asdto.getStatus_id());
        currentAS.setNote(asdto.getNote());

        ASSv.save(currentAS);
        return new ResponseEntity<>(asdto, HttpStatus.OK);
    }


	@RequestMapping(value = "/deleteAttendanceStudent/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<AttendanceStudentModel> deleteAS(@PathVariable("id") Integer id) {
		AttendanceStudentModel asm = ASSv.ListAttendanceStudentById(id);
		if (asm == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
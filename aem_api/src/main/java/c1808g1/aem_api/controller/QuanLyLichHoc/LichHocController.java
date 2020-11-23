package c1808g1.aem_api.controller.QuanLyLichHoc;

<<<<<<< HEAD:aem_api/src/main/java/c1808g1/aem_api/controller/QuanLyLichHoc/DiemDanh.java
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

import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceFCModel;
import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceModel;
import c1808g1.aem_api.models.QuanLyLichHoc.AttendanceStudentModel;
import c1808g1.aem_api.services.QuanLyLichHoc.AttendanceFCService;
import c1808g1.aem_api.services.QuanLyLichHoc.AttendanceService;
import c1808g1.aem_api.services.QuanLyLichHoc.AttendanceStudentService;

@RestController
@RequestMapping("api/dontu/diemdanhapi")
public class DiemDanh {
	private AttendanceFCService AFCSv;
	private AttendanceService ASv;
	private AttendanceStudentService ASSv;

	@Autowired
	public DiemDanh(AttendanceFCService AFCSv) {
		this.AFCSv = AFCSv;
	}
	@Autowired
	public DiemDanh(AttendanceService ASv) {
		this.ASv = ASv;
	}
	@Autowired
	public DiemDanh(AttendanceStudentService ASSv) {
		this.ASSv = ASSv;
	}
	
	//Attendance
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceModel>> ListAllAttendance(){
		List<AttendanceModel> la = ASv.ListAllAttendance();
		if (la.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(la,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAttendanceById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceModel> ListAttendanceById(@PathVariable("id") Integer id){
		Optional<AttendanceModel> oa = ASv.ListAttendanceById(id);
		if(!oa.isPresent()) {
			return new ResponseEntity<>(oa.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(oa.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceModel> CreateAttendance(@RequestBody AttendanceModel am, UriComponentsBuilder builder){
		ASv.save(am);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(am.getId()).toUri());
		return new ResponseEntity<>(am,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<AttendanceModel> updateAttendance(@PathVariable("id") Integer id,@RequestBody AttendanceModel uam) {
        Optional<AttendanceModel> currentAttendance = ASv.ListAttendanceById(id);

        if (!currentAttendance.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAttendance.get().setId(uam.getId());
        currentAttendance.get().setSchedule_id(uam.getSchedule_id());
        currentAttendance.get().setShift_id(uam.getShift_id());
        currentAttendance.get().setBrand_id(uam.getBrand_id());
        currentAttendance.get().setDate_attendance(uam.getDate_attendance());
        currentAttendance.get().setStatus_id(uam.getStatus_id());
        currentAttendance.get().setDisable(uam.getDisable());
        currentAttendance.get().setNote(uam.getNote());

        ASv.save(currentAttendance.get());
        return new ResponseEntity<>(currentAttendance.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<AttendanceModel> deleteAttendance(@PathVariable("id") Integer id) {
		Optional<AttendanceModel> da = ASv.ListAttendanceById(id);
		if (!da.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ASv.delete(da.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//AttendanceFC
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceFCModel>> ListAllAttendanceFC(){
		List<AttendanceFCModel> lafc = AFCSv.ListAllAttendanceFC();
		if (lafc.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lafc,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAttendanceFCById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceFCModel> ListAttendanceFCById(@PathVariable("id") Integer id){
		Optional<AttendanceFCModel> oafc = AFCSv.ListAttendanceFCById(id);
		if(!oafc.isPresent()) {
			return new ResponseEntity<>(oafc.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(oafc.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceFCModel> CreateAttendanceFC(@RequestBody AttendanceFCModel afcm, UriComponentsBuilder builder){
		AFCSv.save(afcm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(afcm.getId()).toUri());
		return new ResponseEntity<>(afcm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<AttendanceFCModel> updateAFC(@PathVariable("id") Integer id,@RequestBody AttendanceFCModel uafcm) {
        Optional<AttendanceFCModel> currentAFC = AFCSv.ListAttendanceFCById(id);

        if (!currentAFC.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAFC.get().setId(uafcm.getId());
        currentAFC.get().setAttendance_id(uafcm.getAttendance_id());
        currentAFC.get().setFc_id(uafcm.getFc_id());
        currentAFC.get().setStatus_id(uafcm.getStatus_id());
        currentAFC.get().setNote(uafcm.getNote());

        AFCSv.save(currentAFC.get());
        return new ResponseEntity<>(currentAFC.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<AttendanceFCModel> deleteAFC(@PathVariable("id") Integer id) {
		Optional<AttendanceFCModel> dafc = AFCSv.ListAttendanceFCById(id);
		if (!dafc.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		AFCSv.delete(dafc.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//AttendanceStudent
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceStudentModel>> ListAllAttendanceStudent(){
		List<AttendanceStudentModel> las = ASSv.ListAllAttendanceStudent();
		if (las.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(las,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAttendanceStudentById/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceStudentModel> ListAttendanceStudentById(@PathVariable("id") Integer id){
		Optional<AttendanceStudentModel> oas = ASSv.ListAttendanceStudentById(id);
		if(!oas.isPresent()) {
			return new ResponseEntity<>(oas.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(oas.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceStudentModel> CreateAttendanceStudent(@RequestBody AttendanceStudentModel asm, UriComponentsBuilder builder){
		ASSv.save(asm);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(asm.getId()).toUri());
		return new ResponseEntity<>(asm,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<AttendanceStudentModel> updateAS(@PathVariable("id") Integer id,@RequestBody AttendanceStudentModel uasm) {
        Optional<AttendanceStudentModel> currentAS = ASSv.ListAttendanceStudentById(id);

        if (!currentAS .isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAS.get().setId(uasm.getId());
        currentAS.get().setAttendance_id(uasm.getAttendance_id());
        currentAS.get().setStudent_id(uasm.getStudent_id());
        currentAS.get().setCheck_in(uasm.getCheck_in());
        currentAS.get().setCheck_out(uasm.getCheck_out());
        currentAS.get().setMinute_late(uasm.getMinute_late());
        currentAS.get().setMinute_leave_early(uasm.getMinute_leave_early());
        currentAS.get().setStatus_id(uasm.getStatus_id());
        currentAS.get().setNote(uasm.getNote());

        ASSv.save(currentAS.get());
        return new ResponseEntity<>(currentAS.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<AttendanceStudentModel> deleteAS(@PathVariable("id") Integer id) {
		Optional<AttendanceStudentModel> das = ASSv.ListAttendanceStudentById(id);
		if (!das.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ASSv.delete(das.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
=======
public class LichHocController {
    
>>>>>>> 4de3a8ab80257f04521cd78a978bd8c7a58c0d5e:aem_api/src/main/java/c1808g1/aem_api/controller/QuanLyLichHoc/LichHocController.java
}

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

import c1808g1.Models.QuanLiHoSo.EmployeeDTO;
import c1808g1.Models.QuanLiHoSo.ScoreFCDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;
import c1808g1.aem_api.service.QuanLyHoSo.EmployeeService;

@RestController
@RequestMapping("/api/quanlyhoso/nhanvienapi")
public class NhanVienController {
private EmployeeService EmpSv;
	
	@Autowired
	public NhanVienController(EmployeeService EmpSv) {
		this.EmpSv = EmpSv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDTO>> ListAllEmployee(){
		List<EmployeeModel> em = EmpSv.ListAllEmployee();
		List<EmployeeDTO> edto = ModelMapperConfig.mapList(em, EmployeeDTO.class);
		if (edto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(edto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getEmployeeById/{id_emp}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> ListEmployeeById(@PathVariable("id_emp") String id_emp){
		var data = EmpSv.ListEmployeeById(id_emp);
		EmployeeDTO edto = ModelMapperConfig.modelMapper.map(data, EmployeeDTO.class);
		if(edto == null){
			return new ResponseEntity<>(edto ,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(edto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> CreateEmployee(@RequestBody EmployeeDTO edto, UriComponentsBuilder builder){
		EmployeeModel em = ModelMapperConfig.modelMapper.map(edto, EmployeeModel.class);
		EmpSv.save(em);
		edto.setId_emp(em.getId_emp());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id_emp}").buildAndExpand(edto.getId_emp()).toUri());
		return new ResponseEntity<>(edto,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/update/{id_emp}",method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id_emp") String id_emp,@RequestBody EmployeeDTO edto) {
        EmployeeModel currentEmployee = EmpSv.ListEmployeeById(id_emp);

        if (currentEmployee == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentEmployee.setId_emp(edto.getId_emp());
        currentEmployee.setName_emp(edto.getName_emp());
        currentEmployee.setEmail_emp(edto.getEmail_emp());
        currentEmployee.setPhone_emp(edto.getPhone_emp());
        currentEmployee.setPassword(edto.getPassword());
        currentEmployee.setActive_account(edto.getActive_account());
        currentEmployee.setList_role(edto.getList_role());
        currentEmployee.setStatus(edto.getStatus());

        EmpSv.save(currentEmployee);
        return new ResponseEntity<>(edto, HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id_emp}",method = RequestMethod.DELETE)
	public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable("id_emp") String id_emp) {
		EmployeeModel em = EmpSv.ListEmployeeById(id_emp);
		if (em == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
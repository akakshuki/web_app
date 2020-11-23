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

import c1808g1.aem_api.models.QuanLyHoSo.EmployeeModel;
import c1808g1.aem_api.services.QuanLyHoSo.EmployeeService;

@RestController
@RequestMapping("/api/quanlyhoso/nhanvienapi")
public class NhanVienController {
private EmployeeService EmpSv;
	
	@Autowired
	public NhanVienController(EmployeeService EmpSv) {
		this.EmpSv = EmpSv;
	}
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeModel>> ListAllEmployee(){
		List<EmployeeModel> lemp = EmpSv.ListAllEmployee();
		if (lemp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lemp,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getEmployeeById/{id_emp}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeModel> ListEmployeeById(@PathVariable("id_emp") String id_emp){
		Optional<EmployeeModel> oemp = EmpSv.ListEmployeeById(id_emp);
		if(!oemp.isPresent()) {
			return new ResponseEntity<>(oemp.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(oemp.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeModel> CreateEmployee(@RequestBody EmployeeModel emp, UriComponentsBuilder builder){
		EmpSv.save(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id_emp}").buildAndExpand(emp.getId_emp()).toUri());
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/update/{id_emp}",method = RequestMethod.PUT)
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("id_emp") String id_emp,@RequestBody EmployeeModel uemp) {
        Optional<EmployeeModel> currentEmployee = EmpSv.ListEmployeeById(id_emp);

        if (!currentEmployee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentEmployee.get().setId_emp(uemp.getId_emp());
        currentEmployee.get().setName_emp(uemp.getName_emp());
        currentEmployee.get().setEmail_emp(uemp.getEmail_emp());
        currentEmployee.get().setPhone_emp(uemp.getPhone_emp());
        currentEmployee.get().setPassword(uemp.getPassword());
        currentEmployee.get().setActive_account(uemp.getActive_account());
        currentEmployee.get().setList_role(uemp.getList_role());
        currentEmployee.get().setStatus(uemp.getStatus());

        EmpSv.save(currentEmployee.get());
        return new ResponseEntity<>(currentEmployee.get(), HttpStatus.OK);
    }


	@RequestMapping(value = "/delete/{id_emp}",method = RequestMethod.DELETE)
	public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable("id_emp") String id_emp) {
		Optional<EmployeeModel> demp = EmpSv.ListEmployeeById(id_emp);
		if (!demp.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		EmpSv.delete(demp.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
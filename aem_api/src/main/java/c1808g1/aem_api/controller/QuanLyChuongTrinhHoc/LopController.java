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

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Class;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.ClassServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quanlychuongtrinhhoc/classapi")
public class LopController {
	private ClassServices classSv;
	
	@Autowired
	public LopController(ClassServices classSv) {
		this.classSv = classSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Class>> findAllClass(){
		List<Class> classV = classSv.findAllClass();
		if (classV.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(classV, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getClassById/{id_class}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Class> getClassById(@PathVariable("id_class") String id_class){
		Optional<Class> classV = classSv.findById(id_class);
		
		if(!classV.isPresent()) {
			return new ResponseEntity<>(classV.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(classV.get() ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Class> createClass(@RequestBody Class classV, UriComponentsBuilder builder){
		classSv.save(classV);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/class/{id_class}").buildAndExpand(classV.getId_class()).toUri());
		return new ResponseEntity<>(classV, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_class}",method = RequestMethod.PUT)
    public ResponseEntity<Class> updateClass(
            @PathVariable("id_class") String id_class,
            @RequestBody Class classV) {
        Optional<Class> currentClass = classSv.findById(id_class);

        if (!currentClass.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentClass.get().setId_class(classV.getId_class());
        currentClass.get().setName_class(classV.getName_class());
        currentClass.get().setSlot_total(classV.getSlot_total());
        currentClass.get().setSlot_regis(classV.getSlot_regis());

        classSv.save(currentClass.get());
        return new ResponseEntity<>(currentClass.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id_class}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Class> deleteClass(
            @PathVariable("id_class") String id_class) {
        Optional<Class> classV = classSv.findById(id_class);
        if (!classV.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classSv.remove(classV.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

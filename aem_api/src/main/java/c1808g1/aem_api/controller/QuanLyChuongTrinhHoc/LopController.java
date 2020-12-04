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

import c1808g1.Models.QuanLyChuongTrinhHoc.ClassDTO;
import c1808g1.Models.QuanLyChuongTrinhHoc.CourseDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Class;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Course;
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
	public ResponseEntity<List<ClassDTO>> findAllClass(){
		List<Class> listclassV = classSv.findAllClass();
		List<ClassDTO> lsclassV = ModelMapperConfig.mapList(listclassV, ClassDTO.class);
		if (lsclassV.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsclassV, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getClassById/{id_class}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ClassDTO> getClassById(@PathVariable("id_class") String id_class){
		var data = classSv.findById(id_class);
		ClassDTO classV = ModelMapperConfig.modelMapper.map(data, ClassDTO.class);
		
		if(classV == null) {
			return new ResponseEntity<>(classV, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(classV, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ClassDTO> createClass(@RequestBody ClassDTO classV, UriComponentsBuilder builder){
		Class classModel = ModelMapperConfig.modelMapper.map(classV, Class.class);
		classSv.save(classModel);
		classV.setId_class(classModel.getId_class());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/class/{id_class}").buildAndExpand(classV.getId_class()).toUri());
		return new ResponseEntity<>(classV, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_class}",method = RequestMethod.PUT)
    public ResponseEntity<ClassDTO> updateClass(
            @PathVariable("id_class") String id_class,
            @RequestBody ClassDTO classV) {
        Class currentClass = classSv.findById(id_class);

        if (currentClass == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentClass.setId_class(classV.getId_class());
        currentClass.setName_class(classV.getName_class());
        currentClass.setSlot_total(classV.getSlot_total());
        currentClass.setSlot_regis(classV.getSlot_regis());

        classSv.save(currentClass);
        return new ResponseEntity<>(classV, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id_class}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Class> deleteClass(
            @PathVariable("id_class") String id_class) {
        Class classV = classSv.findById(id_class);
        if (classV == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classSv.remove(classV);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

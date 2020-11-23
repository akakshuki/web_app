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

import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Course;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.CourseServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quanlychuongtrinhhoc/courseapi")
public class KhoaHocController {
	private CourseServices cosSv;
	
	@Autowired
	public KhoaHocController(CourseServices cosSv) {
		this.cosSv = cosSv;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Course>> findAllCourse(){
		List<Course> cos = cosSv.findAllCourse();
		if (cos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{id_course}", method = RequestMethod.GET, produces = "appliection/json")
	public ResponseEntity<Course> getCourseById(@PathVariable("id_course") Integer id_course){
		Optional<Course> cos = cosSv.findById(id_course);
		
		if(!cos.isPresent()) {
			return new ResponseEntity<>(cos.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cos.get() ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Course> createCourse(@RequestBody Course cos, UriComponentsBuilder builder){
		cosSv.save(cos);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/semester/{id_course}").buildAndExpand(cos.getId_course()).toUri());
		return new ResponseEntity<>(cos, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_course}",method = RequestMethod.PUT)
    public ResponseEntity<Course> updateCourse(
            @PathVariable("id_course") Integer id_course,
            @RequestBody Course course) {
        Optional<Course> currentCourse = cosSv.findById(id_course);

        if (!currentCourse.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentCourse.get().setId_course(course.getId_course());
        currentCourse.get().setName_course(course.getName_course());
        currentCourse.get().setSort_name(course.getSort_name());
        currentCourse.get().setPrice_course(course.getPrice_course());
        currentCourse.get().setCourse_root(course.getCourse_root());

        cosSv.save(currentCourse.get());
        return new ResponseEntity<>(currentCourse.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id_course}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse(
            @PathVariable("id_course") Integer id_course) {
        Optional<Course> course = cosSv.findById(id_course);
        if (!course.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cosSv.remove(course.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

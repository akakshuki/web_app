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

import c1808g1.Models.QuanLyChuongTrinhHoc.CourseDTO;
import c1808g1.Models.QuanLyChuongTrinhHoc.SemesterDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Course;
import c1808g1.aem_api.models.QuanLyChuongTrinhHoc.Semester;
import c1808g1.aem_api.service.QuanLyChuongTrinhHoc.CourseServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quanlychuongtrinhhoc/courseapi")
public class KhoaHocController {
	private CourseServices cosSv;
	
	@Autowired
	public KhoaHocController(CourseServices cosSv) {
		this.cosSv = cosSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CourseDTO>> findAllCourse(){
		List<Course> listcos = cosSv.findAllCourse();
		List<CourseDTO> lscos = ModelMapperConfig.mapList(listcos, CourseDTO.class);
		if (lscos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lscos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCourseById/{id_course}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id_course") String id_course){
		var data = cosSv.findById(id_course);
		CourseDTO cos = ModelMapperConfig.modelMapper.map(data, CourseDTO.class);
		
		if(cos == null) {
			return new ResponseEntity<>(cos, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO cos, UriComponentsBuilder builder){
		Course cosModel = ModelMapperConfig.modelMapper.map(cos, Course.class);
		cosSv.save(cosModel);
		cos.setId_course(cosModel.getId_course());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/course/{id_course}").buildAndExpand(cos.getId_course()).toUri());
		return new ResponseEntity<>(cos, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id_course}",method = RequestMethod.PUT)
    public ResponseEntity<CourseDTO> updateCourse(
            @PathVariable("id_course") String id_course,
            @RequestBody CourseDTO course) {
        Course currentCourse = cosSv.findById(id_course);

        if (currentCourse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentCourse.setId_course(course.getId_course());
        currentCourse.setName_course(course.getName_course());
        currentCourse.setSort_name(course.getSort_name());
        currentCourse.setPrice_course(course.getPrice_course());
        currentCourse.setCourse_root(course.getCourse_root());

        cosSv.save(currentCourse);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id_course}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse(
            @PathVariable("id_course") String id_course) {
        Course course = cosSv.findById(id_course);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cosSv.remove(course);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

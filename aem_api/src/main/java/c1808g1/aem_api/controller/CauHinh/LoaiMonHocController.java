package c1808g1.aem_api.controller.CauHinh;

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

import c1808g1.aem_api.models.CauHinh.Type_Subject;
import c1808g1.aem_api.service.CauHinh.Type_SubjectServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cauhinh/type_subjectapi")
public class LoaiMonHocController {
	private Type_SubjectServices tysubSv;
	
	@Autowired
	public LoaiMonHocController(Type_SubjectServices tysubSv) {
		this.tysubSv = tysubSv;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Type_Subject>> findAllTypeSubject(){
		List<Type_Subject> tysub = tysubSv.findAllType_Subject();
		if (tysub.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tysub, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getTypeSubjectById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Type_Subject> getTypeSubjectById(@PathVariable("id") Integer id){
		Optional<Type_Subject> sub = tysubSv.findById(id);
		
		if(!sub.isPresent()) {
			return new ResponseEntity<>(sub.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(sub.get() ,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Type_Subject> createTypeSubject(@RequestBody Type_Subject tysub, UriComponentsBuilder builder){
		tysubSv.save(tysub);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/type_subject/{id}").buildAndExpand(tysub.getId()).toUri());
		return new ResponseEntity<>(tysub, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Type_Subject> updateTypeSubject(
            @PathVariable("id") Integer id,
            @RequestBody Type_Subject tysub) {
        Optional<Type_Subject> currentType_Subject = tysubSv.findById(id);

        if (!currentType_Subject.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentType_Subject.get().setId(tysub.getId());
        currentType_Subject.get().setName_type(tysub.getName_type());
        currentType_Subject.get().setActive_type(tysub.getActive_type());

        tysubSv.save(currentType_Subject.get());
        return new ResponseEntity<>(currentType_Subject.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Type_Subject> deleteTypeSubject(
            @PathVariable("id") Integer id) {
        Optional<Type_Subject> tysub = tysubSv.findById(id);
        if (!tysub.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tysubSv.remove(tysub.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

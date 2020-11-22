package c1808g1.aem_api.controller.CauHinh;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
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

import c1808g1.Models.CauHinh.HolidayDTO;
import c1808g1.aem_api.config.ModelMapperConfig;
import c1808g1.aem_api.models.CauHinh.HolidayModel;
import c1808g1.aem_api.service.CauHinh.HolidayService;

@RestController
@RequestMapping("/cauhinh/holidayapi")
public class NgayNghi {
	private HolidayService holiSv;

	public NgayNghi() {
		super();

	}

	@Autowired
	public NgayNghi(HolidayService holiSv) {
		this.holiSv = holiSv;
	}

	@RequestMapping(value = "/holi", method = RequestMethod.GET)
	public ResponseEntity<List<HolidayDTO>> findAllholi() {
		List<HolidayModel> listHoli = holiSv.findAllHoliday();
		// List<HolidayDTO> lsHoli = listHoli.stream().map(holi -> ModelMapperConfig.modelMapper.map(holi, HolidayDTO.class))
		// 		.collect(Collectors.toList());

		//mapper từ list entity -> list DTO
		List<HolidayDTO> lsHoli = ModelMapperConfig.mapList(listHoli, HolidayDTO.class);
		if (lsHoli.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lsHoli, HttpStatus.OK);
	}

	@RequestMapping(value = "/holi/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HolidayDTO> getholiById(@PathVariable("id") Integer id) {
		var data = holiSv.findHolidayById(id).get();
		//mapper từ entity -> DTO
		HolidayDTO holi = ModelMapperConfig.modelMapper.map(data, HolidayDTO.class);

		if (holi == null) {
			return new ResponseEntity<>(holi, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(holi, HttpStatus.OK);
	}
	@RequestMapping(value = "/holi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HolidayDTO> createholi(@RequestBody HolidayDTO holi, UriComponentsBuilder builder) {
		//mapper từ DTO -> entity
		HolidayModel holiModel = ModelMapperConfig.modelMapper.map(holi, HolidayModel.class);
		holiSv.save(holiModel);
		holi.setId(holiModel.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/holi/{id}").buildAndExpand(holi.getId()).toUri());
		return new ResponseEntity<>(holi, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/holi/{id}", method = RequestMethod.PUT)
	public ResponseEntity<HolidayModel> updateholi(@PathVariable("id") Integer id, @RequestBody HolidayModel holi) {
		Optional<HolidayModel> currentholi = holiSv.findHolidayById(id);

		if (!currentholi.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentholi.get().setId(holi.getId());
		currentholi.get().setName_holiday(holi.getName_holiday());
		currentholi.get().setDate_off(holi.getDate_off());

		holiSv.save(currentholi.get());
		return new ResponseEntity<>(currentholi.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/holi/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HolidayModel> deleteholi(@PathVariable("id") Integer id) {
		Optional<HolidayModel> holi = holiSv.findHolidayById(id);
		if (!holi.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		holiSv.remove(holi.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
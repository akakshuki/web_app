package c1808g1.aem_api.service.CauHinh;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.CauHinh.ShiftStudyModel;

public interface ShiftStudyService {
	List<ShiftStudyModel> findAllShift();
	Optional<ShiftStudyModel> findShiftById(Integer id);
	void save(ShiftStudyModel shiftStudyModel);
	void remove(ShiftStudyModel shiftStudyModel);
}

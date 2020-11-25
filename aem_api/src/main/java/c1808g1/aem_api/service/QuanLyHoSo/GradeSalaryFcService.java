package c1808g1.aem_api.service.QuanLyHoSo;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.QuanLyHoSo.GradeSalaryFcModel;

public interface GradeSalaryFcService {
	List<GradeSalaryFcModel> findAllGradeSalaryFc();
	GradeSalaryFcModel findGradeSalaryFcById(Integer id);
	void save(GradeSalaryFcModel salary);
	void remove(GradeSalaryFcModel salary);
}

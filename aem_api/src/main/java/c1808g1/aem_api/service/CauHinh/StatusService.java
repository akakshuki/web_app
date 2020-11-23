package c1808g1.aem_api.service.CauHinh;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.CauHinh.StatusModel;

public interface StatusService {
	List<StatusModel> findAllStatus();
	StatusModel findStatusByGroupType(int group_type);
	StatusModel findStatusById(Integer id);
	void save(StatusModel stat);
	void remove(StatusModel stat);
}

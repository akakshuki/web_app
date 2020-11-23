package c1808g1.aem_api.service.HeThong;

import java.util.List;
import java.util.Optional;

import c1808g1.aem_api.models.HeThong.NotifyModel;

public interface NotifyService {
	List<NotifyModel> findAllNotify();
	Optional<NotifyModel> findNotifyById(Integer id);
	void save(NotifyModel notify);
	void remove(NotifyModel notify);
}

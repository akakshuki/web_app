package c1808g1.aem_api.service.implement.HeThong;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c1808g1.aem_api.models.HeThong.Role;
import c1808g1.aem_api.repository.HeThong.RoleRepository;
import c1808g1.aem_api.service.HeThong.RoleService;

	@Service
	public class RoleServiceImplement implements RoleService {
		private RoleRepository rrepo;

		@Autowired
		public RoleServiceImplement(RoleRepository rrepo) {
			this.rrepo = rrepo;
		}
		@Override
		public List<Role> findAllRole() {
			// TODO Auto-generated method stub
			return (List<Role>) rrepo.findAll();
		}

		@Override
		public Optional<Role> findById(Integer id) {
			// TODO Auto-generated method stub
			return rrepo.findById(id);
		}

		@Override
		public void save(Role r) {
			// TODO Auto-generated method stub
			rrepo.save(r);
		}

		@Override
		public void remove(Role r) {
			// TODO Auto-generated method stub
			rrepo.delete(r);
		}

}

package c1808g1.aem_api.models.HeThong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="controller")
public class Controller {
	private String idcontroller;
	private String namecontroller;
	private Boolean active;
	private String menuroot;
	
	@Id
	@Column(name="id_controller",nullable=false)
	public String getIdcontroller() {
		return idcontroller;
	}
	public void setIdcontroller(String idcontroller) {
		this.idcontroller = idcontroller;
	}
	@Column(name="name_controller",nullable=false)
	public String getNamecontroller() {
		return namecontroller;
	}
	public void setNamecontroller(String namecontroller) {
		this.namecontroller = namecontroller;
	}
	@Column(name="active",nullable=false)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getMenuroot() {
		return menuroot;
	}
	@Column(name="menu_root",nullable=false)
	public void setMenuroot(String menuroot) {
		this.menuroot = menuroot;
	}
	public Controller(String idcontroller, String namecontroller, Boolean active, String menuroot) {
		super();
		this.idcontroller = idcontroller;
		this.namecontroller = namecontroller;
		this.active = active;
		this.menuroot = menuroot;
	}
	public Controller() {
	}

}

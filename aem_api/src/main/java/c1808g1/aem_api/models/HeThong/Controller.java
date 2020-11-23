package c1808g1.aem_api.models.HeThong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import c1808g1.aem_api.models.CauHinh.TagModel;
import lombok.Data;
@Data
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
	@Column(name="active",nullable=true)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Column(name="menuroot",nullable=true)
	public String getMenuroot() {
		return menuroot;
	}	
	public void setMenuroot(String menuroot) {
		this.menuroot = menuroot;
	}
	
	public Controller() {
	}

}

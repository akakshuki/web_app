package c1808g1.aem_api.models.CauHinh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class StatusModel {
	private int id;
	private String name_status;
	private int group_type;
	private Boolean active;
	
	public StatusModel() {
		
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name_status",nullable=false)
	public String getName_status() {
		return name_status;
	}
	public void setName_status(String name_status) {
		this.name_status = name_status;
	}
	@Column(name="group_type",nullable=true)
	public int getGroup_type() {
		return group_type;
	}
	public void setGroup_type(int group_type) {
		this.group_type = group_type;
	}
	@Column(name="active",nullable=true)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

}

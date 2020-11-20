package c1808g1.aem_api.models.QuanLyHoSo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "permission_role")
public class PermissionRoleModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
	private int id;
	@Column(name="role_id",nullable=false)
	private int role_id;
	@Column(name="controller_id",nullable=false)
	private String controller_id;
	@Column(name="list_action",nullable=true)
	private String list_action;
}

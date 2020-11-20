package c1808g1.aem_api.models.HeThong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="role")
public class Role {
	private int id;
	private String namerole;
	private boolean allowedit;
	private boolean allowdelete;
	
	public Role() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name_role",nullable=false)
	public String getNamerole() {
		return namerole;
	}
	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}
	@Column(name="allow_edit",nullable=true)
	public boolean isAllowedit() {
		return allowedit;
	}
	public void setAllowedit(boolean allowedit) {
		this.allowedit = allowedit;
	}
	@Column(name="allow_delete",nullable=true)
	public boolean isAllowdelete() {
		return allowdelete;
	}
	public void setAllowdelete(boolean allowdelete) {
		this.allowdelete = allowdelete;
	}
	public Role(int id, String namerole, boolean allowedit, boolean allowdelete) {
		super();
		this.id = id;
		this.namerole = namerole;
		this.allowedit = allowedit;
		this.allowdelete = allowdelete;
	}
	
}

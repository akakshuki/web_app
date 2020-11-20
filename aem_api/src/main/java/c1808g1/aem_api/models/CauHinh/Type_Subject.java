package c1808g1.aem_api.models.CauHinh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_subject")
public class Type_Subject {
private static final long serialVersionUID = 1L;
	
	private int id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	private String name_type;
	private Boolean active_type;

	public Type_Subject() {

	}

	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name_type", nullable = false)
	public String getName_type() {
		return name_type;
	}
	
	
	
	public void setName_type(String name_type) {
		this.name_type = name_type;
	}

	@Column(name = "active_type", nullable = true)
	public Boolean getActive_type() {
		return active_type;
	}

	
	public void setActive_type(Boolean active_type) {
		this.active_type = active_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

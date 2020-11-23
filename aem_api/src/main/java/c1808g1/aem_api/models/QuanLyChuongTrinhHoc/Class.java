package c1808g1.aem_api.models.QuanLyChuongTrinhHoc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {
	private static final long serialVersionUID = 1L;
	
	private String id_class;
	private String name_class;
	private int slot_total;
	private int slot_regis;

	public Class() {

	}

	@Id
	@Column(name = "id_class", nullable = false)
	public String getId_class() {
		return id_class;
	}

	public void setId_class(String id_class) {
		this.id_class = id_class;
	}

	
	@Column(name = "name_class", nullable = false)
	public String getName_class() {
		return name_class;
	}

	public void setName_class(String name_class) {
		this.name_class = name_class;
	}

	
	@Column(name = "slot_total", nullable = true)
	public int getSlot_total() {
		return slot_total;
	}

	public void setSlot_total(int slot_total) {
		this.slot_total = slot_total;
	}

	
	@Column(name = "slot_regis", nullable = true)
	public int getSlot_regis() {
		return slot_regis;
	}

	public void setSlot_regis(int slot_regis) {
		this.slot_regis = slot_regis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}

package c1808g1.aem_api.models.CauHinh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sku")
public class SkuModel {
	private int id;
	private String unit1;
    private String unit2;
    private String unit1_value;
    private String unit2_value;
    private String note;
    
    public SkuModel() {
	
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
	@Column(name="unit1",nullable=false)
	public String getUnit1() {
		return unit1;
	}
	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}
	@Column(name="unit2",nullable=false)
	public String getUnit2() {
		return unit2;
	}
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
	@Column(name="unit1_value",nullable=true)
	public String getUnit1_value() {
		return unit1_value;
	}
	public void setUnit1_value(String unit1_value) {
		this.unit1_value = unit1_value;
	}
	@Column(name="unit2_value",nullable=true)
	public String getUnit2_value() {
		return unit2_value;
	}
	public void setUnit2_value(String unit2_value) {
		this.unit2_value = unit2_value;
	}
	@Column(name="note",nullable=true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}

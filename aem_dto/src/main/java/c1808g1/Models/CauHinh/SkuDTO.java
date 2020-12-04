package c1808g1.Models.CauHinh;

import lombok.Data;

@Data
public class SkuDTO {
	private int id;
	private String unit1;
    private String unit2;
    private String unit1_value;
    private String unit2_value;
    private String note;
	public SkuDTO(int id, String unit1, String unit2, String unit1_value, String unit2_value, String note) {
		super();
		this.id = id;
		this.unit1 = unit1;
		this.unit2 = unit2;
		this.unit1_value = unit1_value;
		this.unit2_value = unit2_value;
		this.note = note;
	}
	public SkuDTO() {
		super();
	}
    
    
}

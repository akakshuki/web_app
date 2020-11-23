package c1808g1.Models.QuanLyChuongTrinhHoc;

import lombok.Data;

@Data
public class ClassDTO {
	private String id_class;
	private String name_class;
	private int slot_total;
	private int slot_regis;
	public ClassDTO(String id_class, String name_class, int slot_total, int slot_regis) {
		super();
		this.id_class = id_class;
		this.name_class = name_class;
		this.slot_total = slot_total;
		this.slot_regis = slot_regis;
	}
    public ClassDTO() {
        super();
    }
}

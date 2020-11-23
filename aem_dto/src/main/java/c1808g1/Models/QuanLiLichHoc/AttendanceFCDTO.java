package c1808g1.Models.QuanLiLichHoc;

import lombok.Data;

@Data
public class AttendanceFCDTO {
	private Integer id;	
	private Integer attendance_id;
	private String fc_id;
	private Integer status_id;
	private String note;
	public AttendanceFCDTO(Integer id, Integer attendance_id, String fc_id, Integer status_id, String note) {
		super();
		this.id = id;
		this.attendance_id = attendance_id;
		this.fc_id = fc_id;
		this.status_id = status_id;
		this.note = note;
	}
	public AttendanceFCDTO() {
		super();
	}
}
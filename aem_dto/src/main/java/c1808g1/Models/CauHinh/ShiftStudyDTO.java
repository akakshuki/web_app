package c1808g1.Models.CauHinh;

import java.sql.Time;

import lombok.Data;

@Data
public class ShiftStudyDTO {

	private int id;
	private String name_shift;
	private Time start_time;
	private Time end_time;
	private int allow_late;
	private int allow_leave_early;
	private Boolean even_or_odd;
	private String note;
	
	public ShiftStudyDTO(int id, String name_shift, Time start_time, Time end_time, int allow_late,
			int allow_leave_early, Boolean even_or_odd, String note) {
		super();
		this.id = id;
		this.name_shift = name_shift;
		this.start_time = start_time;
		this.end_time = end_time;
		this.allow_late = allow_late;
		this.allow_leave_early = allow_leave_early;
		this.even_or_odd = even_or_odd;
		this.note = note;
	}

	public ShiftStudyDTO() {
		super();
	}
	
	
}

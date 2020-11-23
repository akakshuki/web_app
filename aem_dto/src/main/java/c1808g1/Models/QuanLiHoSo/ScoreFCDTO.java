package c1808g1.Models.QuanLiHoSo;

import java.sql.Date;

import lombok.Data;

@Data
public class ScoreFCDTO {
	private Integer id;
	private String subject_id;
	private String fc_id;
	private Integer score_percent;
	private Integer score_number;
	private Date date_create;
	
	public ScoreFCDTO(Integer id, String subject_id, String fc_id, Integer score_percent, Integer score_number,
			Date date_create) {
		super();
		this.id = id;
		this.subject_id = subject_id;
		this.fc_id = fc_id;
		this.score_percent = score_percent;
		this.score_number = score_number;
		this.date_create = date_create;
	}		
		public ScoreFCDTO() {
			super();
	}
}

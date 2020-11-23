package c1808g1.Models.HeThong;

import lombok.Data;

@Data
public class NotifyDTO {
	public NotifyDTO(int id, String url, String receiver_id, String title, Boolean seen, String note) {
		super();
		this.id = id;
		this.url = url;
		this.receiver_id = receiver_id;
		this.title = title;
		this.seen = seen;
		this.note = note;
	}
	public NotifyDTO() {
		super();
	}
	private int id;
	private String url;
	private String receiver_id;
	private String title;
	private Boolean seen;
	private String note;
}

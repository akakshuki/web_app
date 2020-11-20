package c1808g1.aem_api.models.CauHinh;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift_study")
public class ShiftStudyModel {
	private int id;
	private String name_shift;
	private Time start_time;
	private Time end_time;
	private int allow_late;
	private int allow_leave_early;
	private Boolean even_or_odd;
	private String note;
	
	public ShiftStudyModel() {
		// TODO Auto-generated constructor stub
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
	@Column(name="name_shift",nullable=false)
	public String getName_shift() {
		return name_shift;
	}
	public void setName_shift(String name_shift) {
		this.name_shift = name_shift;
	}
	@Column(name="start_time",nullable=true)
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	@Column(name="end_time",nullable=true)
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	@Column(name="allow_late",nullable=true)
	public int getAllow_late() {
		return allow_late;
	}
	public void setAllow_late(int allow_late) {
		this.allow_late = allow_late;
	}
	@Column(name="allow_leave_early",nullable=true)
	public int getAllow_leave_early() {
		return allow_leave_early;
	}
	public void setAllow_leave_early(int allow_leave_early) {
		this.allow_leave_early = allow_leave_early;
	}
	@Column(name="even_or_odd",nullable=true)
	public Boolean getEven_or_odd() {
		return even_or_odd;
	}
	public void setEven_or_odd(Boolean even_or_odd) {
		this.even_or_odd = even_or_odd;
	}
	@Column(name="note",nullable=true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}

package c1808g1.aem_api.models.QuanLyHoSo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "status_student")
public class StatusStudentModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
	private int id;
	@Column(name="student_id",nullable=false)
	private String student_id;
	@Column(name="status_id",nullable=false)
	private int status_id;
	@Column(name="start_date",nullable=true)
	private Date start_date;
	@Column(name="end_date",nullable=true)
	private Date end_date;
	@Column(name="note",nullable=true)
	private String note;
	@Column(name="creator",nullable=true)
	private String creator;
	@Column(name="date_create",nullable=true)
	private Date date_create;
}

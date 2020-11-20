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
@Table(name = "grade_salary_fc")
public class GradeSalaryFcModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
	private int id;
	@Column(name="fc_id",nullable=false)
	private String fc_id;
	@Column(name="hour_salary",nullable=false)
	private Double hour_salary;
	@Column(name="start_date",nullable=false)
	private Date start_date;
	@Column(name="date_create",nullable=true)
	private Date date_create;
}

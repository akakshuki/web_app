package c1808g1.aem_api.models.CauHinh;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Data thay thế cho getset
@Data
@Entity
@Table(name = "holiday")
public class HolidayModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
	private int id;
	@Column(name="name_holiday",nullable=false)
	private String name_holiday;
	@Column(name="date_off",nullable=false)
	private Date date_off;


	
}


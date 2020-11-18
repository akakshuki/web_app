package c1808g1.aem_api.models.HeThong;

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
@Table(name = "notify")
public class NotifyModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
	private int id;
	@Column(name="url",nullable=false)
	private String url;
	@Column(name="receiver_id",nullable=false)
	private String receiver_id;
	@Column(name="title",nullable=true)
	private String title;
	@Column(name="seen",nullable=true)
	private Boolean seen;
	@Column(name="note",nullable=true)
	private String note;
}

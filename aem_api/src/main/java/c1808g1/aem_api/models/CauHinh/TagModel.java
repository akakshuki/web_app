package c1808g1.aem_api.models.CauHinh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tag_content")
public class TagModel {
	@Id
	@Column(name="id_tag",nullable=true)
	private String id_tag;
	@Column(name="name_tag",nullable=true)
	private String name_tag;
	
	

}

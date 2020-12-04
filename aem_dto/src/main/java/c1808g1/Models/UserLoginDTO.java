package c1808g1.Models;

import lombok.Data;

@Data
public class UserLoginDTO {
	private String id_user;
	private String name_user;
	private String email;
	private int id_role;
	private String list_role;
	private String creator; // id_user+last word of name_user
	private String image_student;

	public UserLoginDTO(String id_user, String image_student, String name_user, String email, int id_role,
			String list_role, String creator) {
		super();
		this.id_user = id_user;
		this.name_user = name_user;
		this.email = email;
		this.id_role = id_role;
		this.list_role = list_role;
		this.creator = creator;
		this.image_student = image_student;
	}

	public UserLoginDTO() {
		super();
	}

}

package aem_trickcode.Model.Dto;

import java.util.List;

import lombok.Data;

@Data
public class FamilyCourse {
	private int id;
	private String Name;
	private List<Term> terms;
}

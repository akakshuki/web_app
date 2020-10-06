package aem_trickcode.Model.Dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class FamilyCourse {
	private int id;
	private String Name;
	private ArrayList<Term> terms;
}

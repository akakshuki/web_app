package aem_trickcode.Model.Dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Term {
	private int id;
	private String name;
	private ArrayList<Module> modules;
}

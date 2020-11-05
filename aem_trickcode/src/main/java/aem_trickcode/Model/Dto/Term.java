package aem_trickcode.Model.Dto;


import java.util.List;

import lombok.Data;

@Data
public class Term {
	private int id;
	private String name;
	private List<Module> modules;
}

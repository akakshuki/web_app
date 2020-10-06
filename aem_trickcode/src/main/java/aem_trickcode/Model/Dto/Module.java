package aem_trickcode.Model.Dto;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Module {
	private int id;
	private String name;
	private ArrayList<Session> sessions;
}

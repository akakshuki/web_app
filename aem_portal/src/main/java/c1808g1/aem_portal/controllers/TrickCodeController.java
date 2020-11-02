package c1808g1.aem_portal.controllers;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import aem_trickcode.TrickCode;
import aem_trickcode.Model.ResponseDataAcademic;
import aem_trickcode.Model.Dto.FamilyCourse;
import aem_trickcode.Model.Dto.Session;
import aem_trickcode.Model.Dto.Term;
import aem_trickcode.Model.Dto.Module;
@Controller
@RequestMapping("trickcode")
public class TrickCodeController {
	private TrickCode trickCode;

	public TrickCodeController() {
		super();
		this.trickCode = new TrickCode();
	}

	@RequestMapping(value = "getCapcha", method = RequestMethod.GET)
	public String name(Model model) {

		String capchaCode = trickCode.getCapChaWeb();

		model.addAttribute("getCapcha", capchaCode);
		return "trickcode/getCapcha";
	}
		
	@RequestMapping(value = "getCapcha", method = RequestMethod.POST)
	public String name(@RequestBody() String capchacode, Model model) throws IOException, JSONException {
		boolean capchaCode = trickCode.getLogin(capchacode);
		if (capchaCode) {
			System.out.println("thanh cong ");
			List<FamilyCourse> familyCourses = new ArrayList<FamilyCourse>();
			var dataFamilyCourses = this.trickCode.getFamilyCourse();
			// Thread thread = new Thread();
			// thread.start();
			for (ResponseDataAcademic dataFamilyCourse : dataFamilyCourses) {
				FamilyCourse familyCourse = new FamilyCourse();
				familyCourse.setId(Integer.parseInt(dataFamilyCourse.getValue()));
				familyCourse.setName(dataFamilyCourse.getName());
				List<Term> terms = new ArrayList<Term>();
				var dataTerms = this.trickCode.getTermForCouse(dataFamilyCourse.getValue());
				for (ResponseDataAcademic dataTerm : dataTerms) {
					var term = new Term();
					term.setId(Integer.parseInt(dataTerm.getValue()));
					term.setName(dataTerm.getName());
					var modules = new ArrayList<Module>();
					var dataModules = this.trickCode.getModulesForTerm(dataFamilyCourse.getValue(),
							dataTerm.getValue());
					for (var dataModule : dataModules) {
						Module module = new Module();
						module.setId(Integer.parseInt(dataModule.getValue()));
						module.setName(dataModule.getName());
						var sessions = new ArrayList<Session>();
						var dataSessions = this.trickCode.getSessionsForModule(dataFamilyCourse.getValue(),
								dataTerm.getValue(), dataModule.getValue());
						for (var dataSession : dataSessions) {
							Session session = new Session();
							session.setId(Integer.parseInt(dataSession.getValue()));
							session.setName(dataSession.getName());
							sessions.add(session);
						}
						module.setSessions(sessions);
						modules.add(module);
					}
					term.setModules(modules);

					terms.add(term);

				}

				familyCourse.setTerms(terms);
				familyCourses.add(familyCourse);
			}
			var dataString = new ObjectMapper().writeValueAsString(familyCourses);
			System.out.println(dataString);
		} else
			System.out.println("khong thanh cong");

		return "trickcode/getCapcha";
	}
	
}

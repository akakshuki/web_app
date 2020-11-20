package aem_trickcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import aem_trickcode.Enums.Academics_category;
import aem_trickcode.Enums.Account_Login;
import aem_trickcode.Enums.Selected_Menu;
import aem_trickcode.Model.FormTrickCode;
import aem_trickcode.Model.ResponseDataAcademic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrickCode {

	private Document _mainPage;
	public Map<String, String> cookies;

	public String getCapChaWeb() {

		try {
			var response = Jsoup.connect("https://aptrack.asia/Login.aspx").method(Method.GET).execute();
			_mainPage = response.parse();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return _mainPage.html();
	}

	public boolean getLogin(String capchaResponseCode) throws IOException {
		System.out.println(capchaResponseCode);
		String g_capcha_response = capchaResponseCode.split("capchacode=")[1];
		String viewState = _mainPage.getElementById("__VIEWSTATE").val();
		String viewStateGenerator = _mainPage.getElementById("__VIEWSTATEGENERATOR").val();
		String txtLoginID = Account_Login.USN;
		String txtPassword = Account_Login.PSS;

		HashMap<String, String> mapData = new HashMap<>();

		// main data
		mapData.put("g-recaptcha-response", g_capcha_response);
		mapData.put("__VIEWSTATEGENERATOR", viewStateGenerator);
		mapData.put("txtLoginID", txtLoginID);
		mapData.put("txtPassword", txtPassword);
		mapData.put("__VIEWSTATE", viewState);
		// another data
		mapData.put("__EVENTTARGET", "");
		mapData.put("__EVENTARGUMENT", "");
		mapData.put("__SCROLLPOSITIONX", "0");
		mapData.put("__SCROLLPOSITIONY", "204.8000030517578");
		mapData.put("hfcaptcha1", "441");
		mapData.put("hfcaptcha1", "441");
		mapData.put("hdnbkimg", "");
		mapData.put("hdnbkimg1", "https://api.aptrack.asia/AptrackImages/login-top.gif");
		mapData.put("hdnbkimg2", "");
		mapData.put("btnLogin.x", "26");
		mapData.put("btnLogin.y", "16");

		var res = Jsoup.connect("https://aptrack.asia/Login.aspx").data(mapData).userAgent("Mozilla")
				.method(Method.POST).execute();
		System.out.println(res.cookies());
		if (res.hasCookie("ASP.NET_SessionId")) {
			this.cookies = res.cookies();
			

			
			return true;
		}
		this._mainPage = null;
		this.cookies = null;
		return false;
	}

	// Get classes and timeline
	public List<ResponseDataAcademic> getTimeslots() throws IOException, JSONException {
		this.cookies.put("SelectedMenu", "ACADEMICS");

		var requestBody = new ObjectMapper()
				.writeValueAsString(new FormTrickCode(Academics_category.TIMESLOT, "", "521"));

		var response = Jsoup.connect("https://aptrack.asia/Academics/CascadingDropdown.asmx/GetTimeSlot")
				.header("Content-Type", "application/json").header("Accept", "application/json").followRedirects(true)
				.ignoreHttpErrors(true).ignoreContentType(true)
				.userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML," + " like Gecko) Chrome/45.0.2454.4 Safari/537.36")
				.method(Method.POST).requestBody(requestBody).maxBodySize(1_000_000 * 30) // 30 mb ~
				.cookies(this.cookies).timeout(0) // infinite timeout
				.execute();
		var data = response.body();
		System.out.println(data);
		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

	// getAllCourse
	public List<ResponseDataAcademic> getFamilyCourse() throws IOException, JSONException {
		this.cookies.put("SelectedMenu", "ACADEMICS");

		var requestBody = new ObjectMapper()
				.writeValueAsString(new FormTrickCode(Academics_category.COURSE, null, "55:521"));

		var response = Jsoup.connect("https://aptrack.asia/Academics/CascadingDropdown.asmx/GetCourseView")
				.header("Content-Type", "application/json").header("Accept", "application/json").followRedirects(true)
				.ignoreHttpErrors(true).ignoreContentType(true)
				.userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML," + " like Gecko) Chrome/45.0.2454.4 Safari/537.36")
				.method(Method.POST).requestBody(requestBody).maxBodySize(1_000_000 * 30) // 30 mb ~
				.cookies(this.cookies).timeout(0) // infinite timeout
				.execute();

		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});

		return null;
	}

	// getAll term by course id
	public List<ResponseDataAcademic> getTermForCouse(String courseId) throws IOException, JSONException {
		this.cookies.put("SelectedMenu", "ACADEMICS");

		var requestBody = new ObjectMapper().writeValueAsString(
				new FormTrickCode(Academics_category.TERM, Academics_category.COURSE + ":" + courseId + ";", "521"));

		var response = Jsoup.connect("https://aptrack.asia/Academics/CascadingDropdown.asmx/GetTermsForCourse")
				.header("Content-Type", "application/json").header("Accept", "application/json").followRedirects(true)
				.ignoreHttpErrors(true).ignoreContentType(true)
				.userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML," + " like Gecko) Chrome/45.0.2454.4 Safari/537.36")
				.method(Method.POST).requestBody(requestBody).maxBodySize(1_000_000 * 30) // 30 mb ~
				.cookies(this.cookies).timeout(0) // infinite timeout
				.execute();

		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

	// get all module by term id
	public List<ResponseDataAcademic> getModulesForTerm(String courseId, String termId)
			throws IOException, JSONException {
		this.cookies.put("SelectedMenu", Selected_Menu.ACADEMICS);

		var requestBody = new ObjectMapper().writeValueAsString(new FormTrickCode(Academics_category.MODULE,
				Academics_category.COURSE + ":" + courseId + ";" + Academics_category.TERM + ":" + termId + ";",
				"521"));

		var response = Jsoup.connect("https://aptrack.asia/Academics/CascadingDropdown.asmx/GetModulesForTerm")
				.header("Content-Type", "application/json").header("Accept", "application/json").followRedirects(true)
				.ignoreHttpErrors(true).ignoreContentType(true)
				.userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML," + " like Gecko) Chrome/45.0.2454.4 Safari/537.36")
				.method(Method.POST).requestBody(requestBody).maxBodySize(1_000_000 * 30) // 30 mb ~
				.cookies(this.cookies).timeout(0) // infinite timeout
				.execute();

		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

	// get all session by modules
	public List<ResponseDataAcademic> getSessionsForModule(String courseId, String termId, String ModuleId)
			throws IOException, JSONException {
		this.cookies.put("SelectedMenu", "ACADEMICS");
		// request body
		var requestBody = new ObjectMapper().writeValueAsString(new FormTrickCode(Academics_category.SESSION,
				Academics_category.COURSE + ":" + courseId + ";" + Academics_category.TERM + ":" + termId + ";"
						+ Academics_category.MODULE + ":" + ModuleId + ";",
				"521"));

		var response = Jsoup.connect("https://aptrack.asia/Academics/CascadingDropdown.asmx/GetSessionsForModule")
				.header("Content-Type", "application/json").header("Accept", "application/json").followRedirects(true)
				.ignoreHttpErrors(true).ignoreContentType(true)
				.userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML," + " like Gecko) Chrome/45.0.2454.4 Safari/537.36")
				.method(Method.POST).requestBody(requestBody).maxBodySize(1_000_000 * 30) // 30 mb ~
				.cookies(this.cookies).timeout(0) // infinite timeout
				.execute();

		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

	// student
	public void getStudentByAllCause() throws IOException {
		this.cookies.put("SelectedMenu", "ACADEMICS");

		

		//form data 	
		String courseFamily = "1146:::OV-ACCP-6715-ACE:::";
		String semester = "3785:::ACCP-Semester 3:::";
		String module = "11355:::Analysis, Design, and Implementation:::";
		String session = "101259:::ANADIMPL-NCC_Session03:::";
		String timeSlot = "39149:::C1808G1 -Sang 246 -7h-9h30:::";

		//form data 	
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("ctl00$cphContentPanel$ScriptManager1", "ctl00$cphContentPanel$UpdatePanel1|ctl00$cphContentPanel$btnFetch");
		formData.put("cphContentPanel_ScriptManager1_HiddenField", ";;AjaxControlToolkit, Version=3.5.40412.0, Culture=neutral, PublicKeyToken=28f01b0e84b6d53e:en-US:1547e793-5b7e-48fe-8490-03a375b13a33:de1feab2:f9cec9bc:ca57ef3c;");
		formData.put("ctl00$cphContentPanel$CascadingDropDown1_ClientState", courseFamily);
		formData.put("ctl00$cphContentPanel$CascadingDropDown2_ClientState", semester);
		formData.put("ctl00$cphContentPanel$CascadingDropDown3_ClientState", module);
		formData.put("ctl00$cphContentPanel$CascadingDropDown4_ClientState", session);
		formData.put("ctl00$cphContentPanel$CascadingDropDown5_ClientState", timeSlot);
		
		//data off business manager 
		formData.put("ctl00$cphContentPanel$ucUserAssignment$drpHierarchy_45_2", "679");
		formData.put("ctl00$cphContentPanel$ucUserAssignment$drpHierarchy_46_3", "1813");
		formData.put("ctl00$cphContentPanel$ucUserAssignment$drpHierarchy_47_4", "810");
		formData.put("ctl00$cphContentPanel$ucUserAssignment$drpHierarchy_48_4", "894");
		formData.put("ctl00$cphContentPanel$txtAttendanceDate", "10/25/2020");
		
		//data filter form data
		formData.put("ctl00$cphContentPanel$ddlTimeSlot", "39149");
		formData.put("ctl00$cphContentPanel$ddlCourseFamily", "1146");
		formData.put("ctl00$cphContentPanel$ddlTerm", "3785");
		formData.put("ctl00$cphContentPanel$ddlModule", "11355");
		formData.put("ctl00$cphContentPanel$ddlSession", "101259");

		// dunno this field data 
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl02$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl03$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl04$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl05$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl06$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl07$hdnKYCFlag", "0");
	
	
		//
		formData.put("ctl00$cphContentPanel$hdnCenterID", "5212");

		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl07$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl07$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl07$hdnKYCFlag", "0");
		formData.put("ctl00$cphContentPanel$gvwFetchStudentDetails$ctl07$hdnKYCFlag", "0");
		

		//response form post request link
		var response = Jsoup.connect("https://aptrack.asia/Academics/CascadingDropdown.asmx/GetSessionsForModule")
				.header("Content-Type", "application/json")
				.header("Accept", "application/json")
				.followRedirects(true)
				.ignoreHttpErrors(true).ignoreContentType(true)
				.userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML," + " like Gecko) Chrome/45.0.2454.4 Safari/537.36")
				.method(Method.POST).requestBody("").maxBodySize(1_000_000 * 30) // 30 mb ~
				.cookies(this.cookies).timeout(0) // infinite timeout
				.execute();



	}
}

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
		System.out.println(response.body());
		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

	public List<ResponseDataAcademic> getModulesForTerm(String courseId, String termId)
			throws IOException, JSONException {
		this.cookies.put("SelectedMenu", "ACADEMICS");

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
		System.out.println(response.body());
		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

	public List<ResponseDataAcademic> getSessionsForModule(String courseId, String termId, String ModuleId)
			throws IOException, JSONException {
		this.cookies.put("SelectedMenu", "ACADEMICS");
//request body
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
		System.out.println(response.body());
		if (response.body() != null)
			return new ObjectMapper().readValue(new JSONObject(response.body()).get("d").toString(),
					new TypeReference<List<ResponseDataAcademic>>() {
					});
		return null;
	}

}

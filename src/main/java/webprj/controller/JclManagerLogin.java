package webprj.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JclManagerLogin {
	
	@Autowired
	private DataSource dataSource;
	private String loginId;
	private String loginPwd;
	private String loginName;
	
	@RequestMapping("/jclLogin")
	public String user() {
		
		return "jclLogin";
	}
	
	@RequestMapping("/jclLoginCheck")
	public String login(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String sql = "SELECT LOGIN_ID ID, LOGIN_PWD PW, LOGIN_NAME NAME FROM LOGIN WHERE LOGIN_ID='"+id+"'";
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			loginId = rs.getString("ID");
			loginPwd = rs.getString("PW");
			loginName = rs.getString("NAME");
		}
		
		if(id.equals(loginId) && !pw.equals(loginPwd)) {
			
			return "jclLogin";
			
		} else if(id.equals(loginId) && pw.equals(loginPwd) && id.equals("admin")) {
			
			return "redirect:jclAdminMain";
			
		} else if(id.equals(loginId) && pw.equals(loginPwd)) {
			
			loginName = URLEncoder.encode(loginName, "UTF-8");
			String url="redirect:jclmain?userName="+loginName;
			
			return url;
			
		} else {
			
			return "jclLogin";
		}
	}
	
	@RequestMapping("/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping("/joinproc")
	public @ResponseBody String joinproc() {
		
		return "회원가입이 완료됨!";
	}
	
}

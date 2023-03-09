package webprj.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webprj.entity.Jclerror;

@Controller
public class JclController {
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/jclmain")
	public String Jclmain(@RequestParam("userName") String userName, HttpServletRequest request, Model model) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		String sql = "SELECT JCL_NUM NUM, JCL_REGDATE REGDATE, JCL_REGDATE REGTIME, JCL_ID ID, JCL_WORK WORK, JCL_NAME NAME, JCL_CHARGER CHARGER, "
				+ "JCL_ERROR_REASON REASON, JCL_ERROR_ACTION ACTION, JCL_ACTION_TIME ACTIONTIME, JCL_HIT HIT "
				+ "FROM JCLERROR WHERE JCL_DEL_YN='N' AND JCL_CHARGER='"+userName+"' ORDER BY JCL_REGDATE DESC";
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Jclerror> list = new ArrayList<>();
		
		while(rs.next()){

        	int num =rs.getInt("NUM");
        	Date regdate =rs.getDate("REGDATE");
        	Date regtime =rs.getDate("REGTIME");
        	String id =rs.getString("ID");
        	String work =rs.getString("WORK");
        	String name =rs.getString("NAME");
        	String charger =rs.getString("CHARGER");
        	String reason =rs.getString("REASON");
        	String action =rs.getString("ACTION");
        	Date actiontime = rs.getDate("ACTIONTIME");
        	int hit =rs.getInt("HIT");
        	
        	Jclerror jclerror = new Jclerror(
        			num,
        			regdate,
        			regtime,
        			id,
        			work,
        			name,
        			charger,
        			reason,
        			action,
        			actiontime,
        			hit
        			);
        	
        	
        	list.add(jclerror);
		}
		
		rs.close();
		st.close();
		con.close();
		
		model.addAttribute("charger", userName);
		model.addAttribute("list", list);
		int totalcount = list.size();
		model.addAttribute("totalcount", totalcount);
		LocalDate now = LocalDate.now();
		request.setAttribute("dateType", now);

		return "jclmain";
	}
	
	@RequestMapping("/searchjclerr")
	public String Searchjclerr(HttpServletRequest request, HttpServletResponse response, Model model) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		String datevalue = request.getParameter("jclDateParam");
		
		datevalue = datevalue.replace("-", "/");
		
		datevalue = datevalue.substring(2);
		
		String sql = "SELECT JCL_NUM NUM, JCL_REGDATE REGDATE, JCL_REGDATE REGTIME, JCL_ID ID, JCL_WORK WORK, JCL_NAME NAME, "
				+ "JCL_CHARGER CHARGER, JCL_ERROR_REASON REASON, JCL_ERROR_ACTION ACTION, JCL_ACTION_TIME ACTIONTIME, JCL_HIT HIT "
				+ "FROM JCLERROR WHERE JCL_REGDATE LIKE '%"+datevalue+"%' AND JCL_DEL_YN='N' ORDER BY JCL_REGDATE DESC";
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Jclerror> list = new ArrayList<>();
		
		while(rs.next()){

        	int num =rs.getInt("NUM");
        	Date regdate =rs.getDate("REGDATE");
        	Date regtime =rs.getDate("REGTIME");
        	String id =rs.getString("ID");
        	String work =rs.getString("WORK");
        	String name =rs.getString("NAME");
        	String charger =rs.getString("CHARGER");
        	String reason =rs.getString("REASON");
        	String action =rs.getString("ACTION");
        	Date actiontime = rs.getDate("ACTIONTIME");
        	int hit =rs.getInt("HIT");
        	
        	Jclerror jclerror = new Jclerror(
        			num,
        			regdate,
        			regtime,
        			id,
        			work,
        			name,
        			charger,
        			reason,
        			action,
        			actiontime,
        			hit
        			);
        	
        	list.add(jclerror);
		}
		
		rs.close();
		st.close();
		con.close();
		
		model.addAttribute("list", list);
		int totalcount = list.size();
		model.addAttribute("totalcount", totalcount);
		datevalue = datevalue.replace("/", "-");
		request.setAttribute("dateType", datevalue);
		
		return "searchjclerr";
	}
	
	@RequestMapping("/jcldetail")
	public String Jcldetail(@RequestParam("jcl_num") int jcl_num, Model model) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT JCL_NUM NUM, JCL_REGDATE REGDATE, JCL_REGDATE REGTIME, JCL_ID ID, JCL_WORK WORK, JCL_NAME NAME, "
				+ "JCL_CHARGER CHARGER, JCL_CLASS JOBCLASS, JCL_ERROR_FACTORS FACTORS, JCL_ERROR_REASON REASON, JCL_ERROR_ACTION ACTION, "
				+ "JCL_ACTION_TIME ACTIONTIME, JCL_HIT HIT FROM JCLERROR WHERE JCL_NUM="+jcl_num;
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Jclerror> list = new ArrayList<>();
		
		while(rs.next()){
			
			int num = rs.getInt("NUM");
	    	Date regdate =rs.getDate("REGDATE");
	    	Date regtime =rs.getDate("REGTIME");
	    	String id =rs.getString("ID");
	    	String work =rs.getString("WORK");
	    	String name =rs.getString("NAME");
	    	String charger =rs.getString("CHARGER");
	    	String reason =rs.getString("REASON");
	    	String jobclass =rs.getString("JOBCLASS");
	    	String factors =rs.getString("FACTORS");
	    	String action =rs.getString("ACTION");
	    	Date actiontime =rs.getDate("ACTIONTIME");
	    	int hit = rs.getInt("HIT");
	    	
	    	Jclerror jclerror = new Jclerror(num, regdate, regtime, id, work, name, charger, jobclass, factors, reason, action, actiontime, hit);
	    	
	    	list.add(jclerror);
		}
    	
    	rs.close();
		st.close();
		con.close();
		
		model.addAttribute("list", list);
		
		return "jcldetail";
	}
	
}

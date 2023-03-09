package webprj.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webprj.entity.Jclerror;

@Controller
public class JclAdminController {
	
	@Autowired
	private DataSource dataSource;
	

	@RequestMapping("/jclAdminMain")
	public String admin(HttpServletRequest request, Model model) throws UnsupportedEncodingException, SQLException {
		
		request.setCharacterEncoding("utf-8");
		
		String sql = "SELECT JCL_NUM NUM, JCL_REGDATE REGDATE, JCL_REGDATE REGTIME, JCL_ID ID, JCL_WORK WORK, JCL_NAME NAME, JCL_CHARGER CHARGER, "
				+ "JCL_ERROR_REASON REASON, JCL_ERROR_ACTION ACTION, JCL_ACTION_TIME ACTIONTIME, JCL_HIT HIT "
				+ "FROM JCLERROR WHERE JCL_DEL_YN='N' ORDER BY JCL_REGDATE DESC";
		
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
		LocalDate now = LocalDate.now();
		request.setAttribute("dateType", now);

		
		return "jclAdminMain";
	}
	
	@RequestMapping("/jclAdminPage")
	public String jclAdminPage(Model model) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		
		String sql = "SELECT JCL_NUM NUM, JCL_REGDATE REGDATE, JCL_ID ID, JCL_WORK WORK, JCL_NAME NAME, JCL_CHARGER CHARGER, "
				+ "JCL_CLASS JOBCLASS, JCL_ERROR_FACTORS FACTORS, JCL_HIT HIT "
				+ "FROM JCLERROR WHERE JCL_DEL_YN='N' AND JCL_ERROR_FACTORS IS NULL ORDER BY JCL_REGDATE DESC";
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Jclerror> list = new ArrayList<>();
		
		while(rs.next()) {
			
			int num =rs.getInt("NUM");
	    	Date regdate =rs.getDate("REGDATE");
	    	String id =rs.getString("ID");
	    	String work =rs.getString("WORK");
	    	String name =rs.getString("NAME");
	    	String charger =rs.getString("CHARGER");
	    	String jobclass =rs.getString("JOBCLASS");
	    	String factors =rs.getString("FACTORS");
	    	int hit = rs.getInt("HIT");
	    	
	    	Jclerror jclerror = new Jclerror(num, regdate, id, work, name, charger, jobclass, factors, hit);
	    	
	    	list.add(jclerror);
		}
		
		rs.close();
		st.close();
		con.close();
		
		model.addAttribute("list", list);
		
		return "jclAdminPage";
	}
	
	@RequestMapping("/jclAdminReg")
	public String JclAdminReg(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, SQLException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("jobId");
		String name = request.getParameter("jobName");
		String work = request.getParameter("jobWork");
		String charger = request.getParameter("jobCharger");
		
		String sql = "INSERT INTO JCLERROR (JCL_NUM, JCL_DEL_YN, JCL_ID, JCL_NAME, JCL_WORK, JCL_CHARGER) "
				+ "VALUES (JCLERROR_SEQ.NEXTVAL,'N', ?, ?, ?, ?)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, name);
		st.setString(3, work);
		st.setString(4, charger);
		
		st.executeUpdate();
		
		st.close();
		con.close();
		
		return "redirect:jclAdminPage";
	}
	
	@RequestMapping("/jclAdminDetail")
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
		
		return "jclAdminDetail";
	}
	

	@RequestMapping("/modifyJclError")
	public String Updatejclerr(@RequestParam("jcl_num") int jcl_num, HttpServletRequest request, 
			HttpServletResponse response, Model model,
			String jobid, String jclwork, String jobname, String jobcharger, String reason, String action, String jobclass, String factors) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
	
		String Jobid= new String(jobid.getBytes("8859_1"), "UTF-8");
		String Jclwork = new String(jclwork.getBytes("8859_1"), "UTF-8");
		String Jobname = new String(jobname.getBytes("8859_1"), "UTF-8");
		String Jobcharger = new String(jobcharger.getBytes("8859_1"), "UTF-8");
		String Reason = new String(reason.getBytes("8859_1"), "UTF-8");
		String Action = new String(action.getBytes("8859_1"), "UTF-8");
		String Jobclass = new String(jobclass.getBytes("8859_1"), "UTF-8");
		String Factors = new String(factors.getBytes("8859_1"), "UTF-8");
		
		String sql = "UPDATE JCLERROR SET JCL_ID=?, JCL_WORK=?, JCL_NAME=?, JCL_CHARGER=?, JCL_ERROR_REASON=?, JCL_ERROR_ACTION=?, JCL_CLASS=?, JCL_ERROR_FACTORS=? WHERE JCL_NUM="+jcl_num;
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, Jobid);
		st.setString(2, Jclwork);
		st.setString(3, Jobname);
		st.setString(4, Jobcharger);
		st.setString(5, Reason);
		st.setString(6, Action);
		st.setString(7, Jobclass);
		st.setString(8, Factors);
		
		st.executeUpdate();
		
		st.close();
		con.close();
		
		return "redirect:jclmain";
	}
	
	@RequestMapping("/deleteJclError")
	public String Deletejcl (@RequestParam("jcl_num") int jcl_num) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE JCLERROR SET JCL_DEL_YN='Y' WHERE JCL_NUM="+jcl_num;
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		st.executeQuery(sql);
		
		st.close();
		con.close();
	
	return "redirect:jclmain";
	
	}

}

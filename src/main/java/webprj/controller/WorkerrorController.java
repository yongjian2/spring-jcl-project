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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webprj.entity.Workerr;


@Controller
public class WorkerrorController {
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/workerrormain")
	public String Index(HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT IDX_NUM AS NUM, SYSDATETIME REGDATE, SYSDATETIME REGTIME, "
				+ "WNAME, ERNAME, SID, IDENTI, CHARGER, ERRMS, SUBSTR(SYSDATETIME, 1, 17) AS SYSDATETIME "
				+ "FROM WORKERROR WHERE WORK_DEL_YN='N' ORDER BY SYSDATETIME DESC";
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Workerr> list = new ArrayList<>();
		
		while(rs.next()){

        	int num =rs.getInt("NUM");
        	Date regdate =rs.getDate("REGDATE");
        	Date regtime =rs.getDate("REGTIME");
        	String wname =rs.getString("WNAME");
        	String ername =rs.getString("ERNAME");
        	String sid =rs.getString("SID");
        	String identi =rs.getString("IDENTI");
        	String charger =rs.getString("CHARGER");
        	String errms =rs.getString("ERRMS");
        	String sysdatetime = rs.getString("SYSDATETIME");
        	
        	Workerr workerr = new Workerr(
        			num,
        			regdate,
        			regtime,
        			wname,
        			ername,
        			sid,
        			identi,
        			charger,
        			errms,
        			sysdatetime
        			);
        	
        	list.add(workerr);
		}
		
		rs.close();
		st.close();
		con.close();
		
		model.addAttribute("list", list);
		int totalcount = list.size();
		model.addAttribute("totalcount", totalcount);
		LocalDate now = LocalDate.now();
		request.setAttribute("dateType", now);
		
		return "workerrormain";
	}
	
	@RequestMapping("/searchworkerr")
	public String SearchWorkerr(HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		String datevalue = request.getParameter("workDateParam");
		
		datevalue = datevalue.replace("-", "/");
		
		datevalue = datevalue.substring(2);
		System.out.println(datevalue);
		
		
		String sql = "SELECT IDX_NUM NUM, SYSDATETIME AS REGDATE, SYSDATETIME AS REGTIME, "
				+ "WNAME, ERNAME, SID, IDENTI, CHARGER, ERRMS, SUBSTR(SYSDATETIME, 1, 17) AS SYSDATETIME "
				+ "FROM WORKERROR WHERE SYSDATETIME LIKE '%"+datevalue+"%' AND WORK_DEL_YN='N' ORDER BY SYSDATETIME DESC";
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Workerr> list = new ArrayList<>();
		
		while(rs.next()){

        	int num =rs.getInt("NUM");
        	Date regdate =rs.getDate("REGDATE");
        	Date regtime =rs.getDate("REGTIME");
        	String wname =rs.getString("WNAME");
        	String ername =rs.getString("ERNAME");
        	String sid =rs.getString("SID");
        	String identi =rs.getString("IDENTI");
        	String charger =rs.getString("CHARGER");
        	String errms =rs.getString("ERRMS");
        	String sysdatetime = rs.getString("SYSDATETIME");
        	
        	Workerr workerr = new Workerr(
        			num,
        			regdate,
        			regtime,
        			wname,
        			ername,
        			sid,
        			identi,
        			charger,
        			errms,
        			sysdatetime
        			);
        	
        	list.add(workerr);
		}
		
		rs.close();
		st.close();
		con.close();
		
		model.addAttribute("list", list);
		int totalcount = list.size();
		model.addAttribute("totalcount", totalcount);
		//request.setAttribute("dateType", "2023-01-01");
		
		return "searchworkerr";
		
	}
	
	
	@PostMapping("/reg")
	public String Reg(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, SQLException {
		
		request.setCharacterEncoding("utf-8");
		
		String wname = request.getParameter("wname");
		String ername = request.getParameter("ername");
		String sid = request.getParameter("sid");
		String identi = request.getParameter("identi");
		String charger = request.getParameter("charger");
		String errms = request.getParameter("errms");
		
		
		String sql = "INSERT INTO WORKERROR (IDX_NUM, WORK_DEL_YN, wname, ername, sid, identi, charger, errms) "
				+ "VALUES (WORKERROR_SEQ.NEXTVAL,'N', ?, ?, ?, ?, ?, ?)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, wname);
		st.setString(2, ername);
		st.setString(3, sid);
		st.setString(4, identi);
		st.setString(5, charger);
		st.setString(6, errms);
		
		st.executeUpdate();
		
		st.close();
		con.close();
		
		return "redirect:workerrormain" ;
		
	}
	
	@RequestMapping("/workdetail")
	public String Detail(@RequestParam("work_num") int work_num, Model model) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT IDX_NUM NUM, SYSDATETIME REGDATE, SYSDATETIME REGTIME, WNAME, ERNAME, SID, IDENTI, CHARGER, "
				+ "ERRMS, WORK_ERROR_REASON REASON, WORK_ERROR_ACTION ACTION FROM WORKERROR WHERE IDX_NUM="+work_num;
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Workerr> list = new ArrayList<>();
		
		while(rs.next()){

        	int num =rs.getInt("NUM");
        	Date regdate =rs.getDate("REGDATE");
        	Date regtime =rs.getDate("REGTIME");
        	String wname =rs.getString("WNAME");
        	String ername =rs.getString("ERNAME");
        	String sid =rs.getString("SID");
        	String identi =rs.getString("IDENTI");
        	String charger =rs.getString("CHARGER");
        	String errms =rs.getString("ERRMS");
        	String reason =rs.getString("REASON");
        	String action =rs.getString("ACTION");
        	
        	Workerr workerr = new Workerr(
        			num,
        			regdate,
        			regtime,
        			wname,
        			ername,
        			sid,
        			identi,
        			charger,
        			errms,
        			reason,
        			action
        			);
        	
        	list.add(workerr);
		}
    	
    	rs.close();
		st.close();
		con.close();
		
		model.addAttribute("list", list);
		
		return "workdetail";
	}
	
	@RequestMapping("/updateworkerr")
	public String Updatejclerr(@RequestParam("work_num") int work_num, HttpServletRequest request, HttpServletResponse response, Model model,
			String wname, String ername, String sid, String errms, String charger, String identi, String reason, String action) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
	
		String Wname= new String(wname.getBytes("8859_1"), "UTF-8");
		String Ername = new String(ername.getBytes("8859_1"), "UTF-8");
		String Sid = new String(sid.getBytes("8859_1"), "UTF-8");
		String Errms = new String(errms.getBytes("8859_1"), "UTF-8");
		String Charger = new String(charger.getBytes("8859_1"), "UTF-8");
		String Identi = new String(identi.getBytes("8859_1"), "UTF-8");
		String Reason = new String(reason.getBytes("8859_1"), "UTF-8");
		String Action = new String(action.getBytes("8859_1"), "UTF-8");
		
		String sql = "UPDATE WORKERROR SET WNAME=?, ERNAME=?, SID=?, ERRMS=?, CHARGER=?, IDENTI=?, WORK_ERROR_REASON=?, WORK_ERROR_ACTION=? WHERE IDX_NUM="+work_num;
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, Wname);
		st.setString(2, Ername);
		st.setString(3, Sid);
		st.setString(4, Errms);
		st.setString(5, Charger);
		st.setString(6, Identi);
		st.setString(7, Reason);
		st.setString(8, Action);
		
		st.executeUpdate();
		
		st.close();
		con.close();
		
		return "redirect:workerrormain";
	}
	
	@RequestMapping("/deleteworkerr")
	public String Deletejcl (@RequestParam("work_num") int work_num) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE WORKERROR SET WORK_DEL_YN='Y' WHERE IDX_NUM="+work_num;
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		st.executeQuery(sql);
		
		st.close();
		con.close();
	
	return "redirect:workerrormain";
	
	}
	
}

package webprj.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JclUpdateController {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/jclUpdateMerge")
	public String UpdateMerge(@RequestParam("jcl_id") String jcl_id, @RequestParam("jcl_num") int jcl_num, @RequestParam("jcl_charger") String jcl_charger, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		
		request.setCharacterEncoding("utf-8");
		
		String reason = request.getParameter("reason");
		String action = request.getParameter("action");
		String Reason = new String(reason.getBytes("8859_1"), "UTF-8");
		String Action = new String(action.getBytes("8859_1"), "UTF-8");
		
		String sql = "UPDATE JCLERROR SET JCL_ERROR_REASON='"+Reason+"', JCL_ERROR_ACTION='"+Action+"' WHERE JCL_NUM="+jcl_num;
		
		Connection con = dataSource.getConnection();
		
		Statement st1 = con.createStatement();
		st1.executeQuery(sql);
		
		st1.close();
		
		/*----------------------------------------------------   누적횟수 쿼리    ----------------------------------------------------------*/
		Statement st = con.createStatement();
		
		String jcl_hit = "UPDATE JCLERROR SET JCL_HIT=(SELECT COUNT(JCL_ID) COUNT FROM JCLERROR WHERE JCL_ID='"+jcl_id+"') WHERE JCL_ID='"+jcl_id+"'";
		st.executeQuery(jcl_hit);
		
		/*----------------------------------------------------   업무분류 쿼리    ----------------------------------------------------------*/
		
		
		String jcl_online = "UPDATE JCLERROR SET JCL_CLASS='온라인공통' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='한태종' OR JCL_CHARGER='고민경' OR JCL_CHARGER='이민선' OR JCL_CHARGER='차범희' "
				+ "OR JCL_CHARGER='김장원' OR JCL_CHARGER='나성원' OR JCL_CHARGER='배이철' OR JCL_CHARGER='김준호' OR JCL_CHARGER='박나원' OR JCL_CHARGER='장진호' "
				+ "OR JCL_CHARGER='고유리' OR JCL_CHARGER='김수진' OR JCL_CHARGER='김규연' OR JCL_CHARGER='이현' OR JCL_CHARGER='이수빈' OR JCL_CHARGER='김영신' "
				+ "OR JCL_CHARGER='김욱현' OR JCL_CHARGER='최문석' OR JCL_CHARGER='고재선' OR JCL_CHARGER='강성훈')";
		st.executeQuery(jcl_online);
		
		String jcl_totalinfo = "UPDATE JCLERROR SET JCL_CLASS='종합정보' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='이준범' OR JCL_CHARGER='윤현정' OR JCL_CHARGER='이은희' OR JCL_CHARGER='박영진' "
				+ "OR JCL_CHARGER='김국진' OR JCL_CHARGER='심정보' OR JCL_CHARGER='이정석' OR JCL_CHARGER='오정규' OR JCL_CHARGER='김승환' OR JCL_CHARGER='이채리' "
				+ "OR JCL_CHARGER='오성욱' OR JCL_CHARGER='박동현' OR JCL_CHARGER='이가영' OR JCL_CHARGER='박소현' OR JCL_CHARGER='김영곤' OR JCL_CHARGER='안문석' "
				+ "OR JCL_CHARGER='엄대승' OR JCL_CHARGER='김진범' OR JCL_CHARGER='서혜원' OR JCL_CHARGER='이한진' OR JCL_CHARGER='송제철')";
		st.executeQuery(jcl_totalinfo);
		
		String jcl_card = "UPDATE JCLERROR SET JCL_CLASS='카드' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='최봉석' OR JCL_CHARGER='임한구' OR JCL_CHARGER='정용태' OR JCL_CHARGER='박신영' "
				+ "OR JCL_CHARGER='박영호' OR JCL_CHARGER='신정민' OR JCL_CHARGER='유승진' OR JCL_CHARGER='배재성' OR JCL_CHARGER='최학선')";
		st.executeQuery(jcl_card);
		
		String jcl_loan = "UPDATE JCLERROR SET JCL_CLASS='여신' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='김규동' OR JCL_CHARGER='신주형' OR JCL_CHARGER='박진주' OR JCL_CHARGER='이다민' "
				+ "OR JCL_CHARGER='김건수' OR JCL_CHARGER='임채준' OR JCL_CHARGER='김민철' OR JCL_CHARGER='이상욱' OR JCL_CHARGER='박무성' OR JCL_CHARGER='김종철' OR JCL_CHARGER='신윤재')";
		st.executeQuery(jcl_loan);
		
		String jcl_bank = "UPDATE JCLERROR SET JCL_CLASS='수신' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='임사기' OR JCL_CHARGER='김난영' OR JCL_CHARGER='이슬지' OR JCL_CHARGER='안기효' "
				+ "OR JCL_CHARGER='김주연' OR JCL_CHARGER='배진문' OR JCL_CHARGER='송태우' OR JCL_CHARGER='임채훈' OR JCL_CHARGER='박성배' OR JCL_CHARGER='최정란' "
				+ "OR JCL_CHARGER='박수용' OR JCL_CHARGER='박상헌' OR JCL_CHARGER='양경수')";
		st.executeQuery(jcl_bank);
		
		String jcl_daeheang = "UPDATE JCLERROR SET JCL_CLASS='대행/단위' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='안태광' OR JCL_CHARGER='김세영' OR JCL_CHARGER='홍유진' OR JCL_CHARGER='민기원' "
				+ "OR JCL_CHARGER='정수연' OR JCL_CHARGER='박미라' OR JCL_CHARGER='문상철' OR JCL_CHARGER='조기영' OR JCL_CHARGER='조제영' OR JCL_CHARGER='이태주' "
				+ "OR JCL_CHARGER='이주성' OR JCL_CHARGER='이도화')";
		st.executeQuery(jcl_daeheang);
		
		String jcl_channel = "UPDATE JCLERROR SET JCL_CLASS='채널' WHERE JCL_NUM="+jcl_num+" AND (JCL_CHARGER='조동옥' OR JCL_CHARGER='이현지' OR JCL_CHARGER='최정현' OR JCL_CHARGER='남효식' "
				+ "OR JCL_CHARGER='김연숙' OR JCL_CHARGER='김세진' OR JCL_CHARGER='장세미' OR JCL_CHARGER='안석남' OR JCL_CHARGER='박훈')";
		st.executeQuery(jcl_channel);
		
		
		/*----------------------------------------------------   업무오류 쿼리    ----------------------------------------------------------*/
		
		String jcl_ex = "UPDATE JCLERROR SET JCL_ERROR_FACTORS='외부기관' WHERE JCL_NUM="+jcl_num+" AND (JCL_ERROR_REASON LIKE '%외부기관%' OR JCL_ERROR_REASON LIKE '%파일%' OR JCL_ERROR_REASON LIKE '%한페이%' "
				+ "OR JCL_ERROR_REASON LIKE '%금융결제원%' OR JCL_ERROR_REASON LIKE '%증권%' OR JCL_ERROR_REASON LIKE '%타행%' OR JCL_ERROR_REASON LIKE '%자동이체%' "
				+ "OR JCL_ERROR_REASON LIKE '%금고%' OR JCL_ERROR_REASON LIKE '%잔고%' OR JCL_ERROR_REASON LIKE '%수수료%' OR JCL_ERROR_REASON LIKE '%파일%' OR JCL_ERROR_ACTION LIKE '%외부기관%' "
				+ "OR JCL_ERROR_ACTION LIKE '%파일%' OR JCL_ERROR_ACTION LIKE '%한페이%' OR JCL_ERROR_ACTION LIKE '%금융결제원%' OR JCL_ERROR_ACTION LIKE '%증권%' OR JCL_ERROR_ACTION LIKE '%타행%' "
				+ "OR JCL_ERROR_ACTION LIKE '%자동이체%' OR JCL_ERROR_ACTION LIKE '%금고%' OR JCL_ERROR_ACTION LIKE '%잔고%' OR JCL_ERROR_ACTION LIKE '%수수료%' OR JCL_ERROR_ACTION LIKE '%파일%')";
		st.executeQuery(jcl_ex);
		
		String jcl_prog = "UPDATE JCLERROR SET JCL_ERROR_FACTORS='프로그램' WHERE JCL_NUM="+jcl_num+" AND (JCL_ERROR_REASON LIKE '%배치%' OR JCL_ERROR_REASON LIKE '%선행%' OR JCL_ERROR_REASON LIKE '%다중%' "
				+ "OR JCL_ERROR_REASON LIKE '%동시%' OR JCL_ERROR_REASON LIKE '%예외%' OR JCL_ERROR_REASON LIKE '%중복%' OR JCL_ERROR_REASON LIKE '%타임아웃%' "
				+ "OR JCL_ERROR_REASON LIKE '%누락%' OR JCL_ERROR_REASON LIKE '%비정상%' OR JCL_ERROR_REASON LIKE '%JCL%' OR JCL_ERROR_REASON LIKE '%DB%' "
				+ "OR JCL_ERROR_REASON LIKE '%데이터%' OR JCL_ERROR_REASON LIKE '%프로그램%' OR JCL_ERROR_REASON LIKE '%코드%' OR JCL_ERROR_ACTION LIKE '%배치%' OR JCL_ERROR_ACTION LIKE '%선행%' OR JCL_ERROR_ACTION LIKE '%다중%' "
				+ "OR JCL_ERROR_ACTION LIKE '%동시%' OR JCL_ERROR_ACTION LIKE '%예외%' OR JCL_ERROR_ACTION LIKE '%중복%' OR JCL_ERROR_ACTION LIKE '%타임아웃%' "
				+ "OR JCL_ERROR_ACTION LIKE '%누락%' OR JCL_ERROR_ACTION LIKE '%비정상%' OR JCL_ERROR_ACTION LIKE '%JCL%' OR JCL_ERROR_ACTION LIKE '%DB%' "
				+ "OR JCL_ERROR_ACTION LIKE '%데이터%' OR JCL_ERROR_ACTION LIKE '%프로그램%' OR JCL_ERROR_ACTION LIKE '%코드%')";
		st.executeQuery(jcl_prog);
		
		String jcl_sys = "UPDATE JCLERROR SET JCL_ERROR_FACTORS='시스템' WHERE JCL_NUM="+jcl_num+" AND (JCL_ERROR_REASON LIKE '%형상%' OR JCL_ERROR_REASON LIKE '%PM%' OR JCL_ERROR_REASON LIKE '%통신%' "
				+ "OR JCL_ERROR_REASON LIKE '%계획변경%' OR JCL_ERROR_REASON LIKE '%파기작업%' OR JCL_ERROR_ACTION LIKE '%형상%' OR JCL_ERROR_ACTION LIKE '%PM%' OR JCL_ERROR_ACTION LIKE '%통신%' "
				+ "OR JCL_ERROR_ACTION LIKE '%계획변경%' OR JCL_ERROR_ACTION LIKE '%파기작업%')";
		st.executeQuery(jcl_sys);
		
		String jcl_in = "UPDATE JCLERROR SET JCL_ERROR_FACTORS='본부/영업점' WHERE JCL_NUM="+jcl_num+" AND (JCL_ERROR_REASON LIKE '%영업점%' OR JCL_ERROR_REASON LIKE '%본부%' OR JCL_ERROR_REASON LIKE '%현업%' "
				+ "OR JCL_ERROR_REASON LIKE '%업무부서%' OR JCL_ERROR_REASON LIKE '%수기%' OR JCL_ERROR_ACTION LIKE '%영업점%' OR JCL_ERROR_ACTION LIKE '%본부%' OR JCL_ERROR_ACTION LIKE '%현업%' "
				+ "OR JCL_ERROR_ACTION LIKE '%업무부서%' OR JCL_ERROR_ACTION LIKE '%수기%')";
		st.executeQuery(jcl_in);
		
		st.close();
		con.close();
		
		String userName = URLEncoder.encode(jcl_charger, "UTF-8");
		String url = "redirect:jclmain?userName="+userName;
		
		return url;
	}
}

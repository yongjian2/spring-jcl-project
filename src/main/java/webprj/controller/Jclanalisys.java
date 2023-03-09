package webprj.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jclanalisys {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/jclanalisys")
	public String jclanalisys(Model model) throws SQLException, ClassNotFoundException {
		
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		
		/*----------------------------------------------    분석 1번째 표 쿼리문    -------------------------------------------------------  */
		
		String t1_cbs_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='계정계' AND JCL_DEL_YN='N'";
		ResultSet t1_11 = st.executeQuery(t1_cbs_cnt);

		while(t1_11.next()) {
			int cnt = t1_11.getInt(1);
			model.addAttribute("t1_cbs_cnt", cnt);
		}
		
		String t1_d_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='정보계' AND JCL_DEL_YN='N'";
		ResultSet t1_12 = st.executeQuery(t1_d_cnt);

		while(t1_12.next()) {
			int cnt = t1_12.getInt(1);
			model.addAttribute("t1_d_cnt", cnt);
		}
		
		String t1_bk_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='방카' AND JCL_DEL_YN='N'";
		ResultSet t1_13 = st.executeQuery(t1_bk_cnt);

		while(t1_13.next()) {
			int cnt = t1_13.getInt(1);
			model.addAttribute("t1_bk_cnt", cnt);
		}
		
		String t1_bcv_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='BCV' AND JCL_DEL_YN='N'";
		ResultSet t1_14 = st.executeQuery(t1_bcv_cnt);

		while(t1_14.next()) {
			int cnt = t1_14.getInt(1);
			model.addAttribute("t1_bcv_cnt", cnt);
		}
		
		String t1_lisk_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='리스크' AND JCL_DEL_YN='N'";
		ResultSet t1_15 = st.executeQuery(t1_lisk_cnt);

		while(t1_15.next()) {
			int cnt = t1_15.getInt(1);
			model.addAttribute("t1_lisk_cnt", cnt);
		}
		
		String t1_myd_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='마이데이터' AND JCL_DEL_YN='N'";
		ResultSet t1_16 = st.executeQuery(t1_myd_cnt);

		while(t1_16.next()) {
			int cnt = t1_16.getInt(1);
			model.addAttribute("t1_myd_cnt", cnt);
		}
		
		String t1_bs_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_WORK='분석지원' AND JCL_DEL_YN='N'";
		ResultSet t1_17 = st.executeQuery(t1_bs_cnt);

		while(t1_17.next()) {
			int cnt = t1_17.getInt(1);
			model.addAttribute("t1_bs_cnt", cnt);
		}
		
		String t1_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_DEL_YN='N' AND (JCL_WORK='계정계' OR JCL_WORK='정보계' OR JCL_WORK='방카' OR "
				+ "JCL_WORK='BCV' OR JCL_WORK='리스크' OR JCL_WORK='마이데이터' OR JCL_WORK='분석지원')";
		ResultSet t1_18 = st.executeQuery(t1_total_cnt);

		while(t1_18.next()) {
			int cnt = t1_18.getInt(1);
			model.addAttribute("t1_total_cnt", cnt);
		}
		
		
		/*----------------------------------------------    분석 2번째 표 1월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_1m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_11 = st.executeQuery(t2_1m_online_cnt);

		while(t2_11.next()) {
			int cnt = t2_11.getInt(1);
			model.addAttribute("t2_1m_online_cnt", cnt);
		}
		
		String t2_1m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_12 = st.executeQuery(t2_1m_totalinfo_cnt);

		while(t2_12.next()) {
			int cnt = t2_12.getInt(1);
			model.addAttribute("t2_1m_totalinfo_cnt", cnt);
		}
		
		String t2_1m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_13 = st.executeQuery(t2_1m_card_cnt);

		while(t2_13.next()) {
			int cnt = t2_13.getInt(1);
			model.addAttribute("t2_1m_card_cnt", cnt);
		}
		
		String t2_1m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_14 = st.executeQuery(t2_1m_loan_cnt);

		while(t2_14.next()) {
			int cnt = t2_14.getInt(1);
			model.addAttribute("t2_1m_loan_cnt", cnt);
		}
		
		String t2_1m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_15 = st.executeQuery(t2_1m_bank_cnt);

		while(t2_15.next()) {
			int cnt = t2_15.getInt(1);
			model.addAttribute("t2_1m_bank_cnt", cnt);
		}
		
		String t2_1m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_16 = st.executeQuery(t2_1m_daeheang_cnt);

		while(t2_16.next()) {
			int cnt = t2_16.getInt(1);
			model.addAttribute("t2_1m_daeheang_cnt", cnt);
		}
		
		String t2_1m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_17 = st.executeQuery(t2_1m_smart_cnt);

		while(t2_17.next()) {
			int cnt = t2_17.getInt(1);
			model.addAttribute("t2_1m_smart_cnt", cnt);
		}
		
		String t2_1m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_18 = st.executeQuery(t2_1m_web_cnt);

		while(t2_18.next()) {
			int cnt = t2_18.getInt(1);
			model.addAttribute("t2_1m_web_cnt", cnt);
		}
		
		String t2_1m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_19 = st.executeQuery(t2_1m_channel_cnt);

		while(t2_19.next()) {
			int cnt = t2_19.getInt(1);
			model.addAttribute("t2_1m_channel_cnt", cnt);
		}
		
		String t2_1m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_110 = st.executeQuery(t2_1m_total_cnt);

		while(t2_110.next()) {
			int cnt = t2_110.getInt(1);
			model.addAttribute("t2_1m_total_cnt", cnt);
		}
		

		/*----------------------------------------------    분석 2번째 표 2월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_2m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_21 = st.executeQuery(t2_2m_online_cnt);

		while(t2_21.next()) {
			int cnt = t2_21.getInt(1);
			model.addAttribute("t2_2m_online_cnt", cnt);
		}
		
		String t2_2m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_22 = st.executeQuery(t2_2m_totalinfo_cnt);

		while(t2_22.next()) {
			int cnt = t2_22.getInt(1);
			model.addAttribute("t2_2m_totalinfo_cnt", cnt);
		}
		
		String t2_2m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_23 = st.executeQuery(t2_2m_card_cnt);

		while(t2_23.next()) {
			int cnt = t2_23.getInt(1);
			model.addAttribute("t2_2m_card_cnt", cnt);
		}
		
		String t2_2m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_24 = st.executeQuery(t2_2m_loan_cnt);

		while(t2_24.next()) {
			int cnt = t2_24.getInt(1);
			model.addAttribute("t2_2m_loan_cnt", cnt);
		}
		
		String t2_2m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_25 = st.executeQuery(t2_2m_bank_cnt);

		while(t2_25.next()) {
			int cnt = t2_25.getInt(1);
			model.addAttribute("t2_2m_bank_cnt", cnt);
		}
		
		String t2_2m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_26 = st.executeQuery(t2_2m_daeheang_cnt);

		while(t2_26.next()) {
			int cnt = t2_26.getInt(1);
			model.addAttribute("t2_2m_daeheang_cnt", cnt);
		}
		
		String t2_2m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_27 = st.executeQuery(t2_2m_smart_cnt);

		while(t2_27.next()) {
			int cnt = t2_27.getInt(1);
			model.addAttribute("t2_2m_smart_cnt", cnt);
		}
		
		String t2_2m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_28 = st.executeQuery(t2_2m_web_cnt);

		while(t2_28.next()) {
			int cnt = t2_28.getInt(1);
			model.addAttribute("t2_2m_web_cnt", cnt);
		}
		
		String t2_2m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_29 = st.executeQuery(t2_2m_channel_cnt);

		while(t2_29.next()) {
			int cnt = t2_29.getInt(1);
			model.addAttribute("t2_2m_channel_cnt", cnt);
		}
		
		String t2_2m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_210 = st.executeQuery(t2_2m_total_cnt);

		while(t2_210.next()) {
			int cnt = t2_210.getInt(1);
			model.addAttribute("t2_2m_total_cnt", cnt);
		}
		
		
/*----------------------------------------------    분석 2번째 표 3월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_3m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_31 = st.executeQuery(t2_3m_online_cnt);

		while(t2_31.next()) {
			int cnt = t2_31.getInt(1);
			model.addAttribute("t2_3m_online_cnt", cnt);
		}
		
		String t2_3m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_32 = st.executeQuery(t2_3m_totalinfo_cnt);

		while(t2_32.next()) {
			int cnt = t2_32.getInt(1);
			model.addAttribute("t2_3m_totalinfo_cnt", cnt);
		}
		
		String t2_3m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_33 = st.executeQuery(t2_3m_card_cnt);

		while(t2_33.next()) {
			int cnt = t2_33.getInt(1);
			model.addAttribute("t2_3m_card_cnt", cnt);
		}
		
		String t2_3m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_34 = st.executeQuery(t2_3m_loan_cnt);

		while(t2_34.next()) {
			int cnt = t2_34.getInt(1);
			model.addAttribute("t2_3m_loan_cnt", cnt);
		}
		
		String t2_3m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_35 = st.executeQuery(t2_3m_bank_cnt);

		while(t2_35.next()) {
			int cnt = t2_35.getInt(1);
			model.addAttribute("t2_3m_bank_cnt", cnt);
		}
		
		String t2_3m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_36 = st.executeQuery(t2_3m_daeheang_cnt);

		while(t2_36.next()) {
			int cnt = t2_36.getInt(1);
			model.addAttribute("t2_3m_daeheang_cnt", cnt);
		}
		
		String t2_3m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_37 = st.executeQuery(t2_3m_smart_cnt);

		while(t2_37.next()) {
			int cnt = t2_37.getInt(1);
			model.addAttribute("t2_3m_smart_cnt", cnt);
		}
		
		String t2_3m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_38 = st.executeQuery(t2_3m_web_cnt);

		while(t2_38.next()) {
			int cnt = t2_38.getInt(1);
			model.addAttribute("t2_3m_web_cnt", cnt);
		}
		
		String t2_3m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_39 = st.executeQuery(t2_3m_channel_cnt);

		while(t2_39.next()) {
			int cnt = t2_39.getInt(1);
			model.addAttribute("t2_3m_channel_cnt", cnt);
		}
		
		String t2_3m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_310 = st.executeQuery(t2_3m_total_cnt);

		while(t2_310.next()) {
			int cnt = t2_310.getInt(1);
			model.addAttribute("t2_3m_total_cnt", cnt);
		}
		
		
/*----------------------------------------------    분석 2번째 표 4월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_4m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_41 = st.executeQuery(t2_4m_online_cnt);

		while(t2_41.next()) {
			int cnt = t2_41.getInt(1);
			model.addAttribute("t2_4m_online_cnt", cnt);
		}
		
		String t2_4m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_42 = st.executeQuery(t2_4m_totalinfo_cnt);

		while(t2_42.next()) {
			int cnt = t2_42.getInt(1);
			model.addAttribute("t2_4m_totalinfo_cnt", cnt);
		}
		
		String t2_4m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_43 = st.executeQuery(t2_4m_card_cnt);

		while(t2_43.next()) {
			int cnt = t2_43.getInt(1);
			model.addAttribute("t2_4m_card_cnt", cnt);
		}
		
		String t2_4m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_44 = st.executeQuery(t2_4m_loan_cnt);

		while(t2_44.next()) {
			int cnt = t2_44.getInt(1);
			model.addAttribute("t2_4m_loan_cnt", cnt);
		}
		
		String t2_4m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_45 = st.executeQuery(t2_4m_bank_cnt);

		while(t2_45.next()) {
			int cnt = t2_45.getInt(1);
			model.addAttribute("t2_4m_bank_cnt", cnt);
		}
		
		String t2_4m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_46 = st.executeQuery(t2_4m_daeheang_cnt);

		while(t2_46.next()) {
			int cnt = t2_46.getInt(1);
			model.addAttribute("t2_4m_daeheang_cnt", cnt);
		}
		
		String t2_4m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_47 = st.executeQuery(t2_4m_smart_cnt);

		while(t2_47.next()) {
			int cnt = t2_47.getInt(1);
			model.addAttribute("t2_4m_smart_cnt", cnt);
		}
		
		String t2_4m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_48 = st.executeQuery(t2_4m_web_cnt);

		while(t2_48.next()) {
			int cnt = t2_48.getInt(1);
			model.addAttribute("t2_4m_web_cnt", cnt);
		}
		
		String t2_4m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_49 = st.executeQuery(t2_4m_channel_cnt);

		while(t2_49.next()) {
			int cnt = t2_49.getInt(1);
			model.addAttribute("t2_4m_channel_cnt", cnt);
		}
		
		String t2_4m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_410 = st.executeQuery(t2_4m_total_cnt);

		while(t2_410.next()) {
			int cnt = t2_410.getInt(1);
			model.addAttribute("t2_4m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 5월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_5m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_51 = st.executeQuery(t2_5m_online_cnt);

		while(t2_51.next()) {
			int cnt = t2_51.getInt(1);
			model.addAttribute("t2_5m_online_cnt", cnt);
		}
		
		String t2_5m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_52 = st.executeQuery(t2_5m_totalinfo_cnt);

		while(t2_52.next()) {
			int cnt = t2_52.getInt(1);
			model.addAttribute("t2_5m_totalinfo_cnt", cnt);
		}
		
		String t2_5m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_53 = st.executeQuery(t2_5m_card_cnt);

		while(t2_53.next()) {
			int cnt = t2_53.getInt(1);
			model.addAttribute("t2_5m_card_cnt", cnt);
		}
		
		String t2_5m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_54 = st.executeQuery(t2_5m_loan_cnt);

		while(t2_54.next()) {
			int cnt = t2_54.getInt(1);
			model.addAttribute("t2_5m_loan_cnt", cnt);
		}
		
		String t2_5m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_55 = st.executeQuery(t2_5m_bank_cnt);

		while(t2_55.next()) {
			int cnt = t2_55.getInt(1);
			model.addAttribute("t2_5m_bank_cnt", cnt);
		}
		
		String t2_5m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_56 = st.executeQuery(t2_5m_daeheang_cnt);

		while(t2_56.next()) {
			int cnt = t2_56.getInt(1);
			model.addAttribute("t2_5m_daeheang_cnt", cnt);
		}
		
		String t2_5m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_57 = st.executeQuery(t2_5m_smart_cnt);

		while(t2_57.next()) {
			int cnt = t2_57.getInt(1);
			model.addAttribute("t2_5m_smart_cnt", cnt);
		}
		
		String t2_5m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_58 = st.executeQuery(t2_5m_web_cnt);

		while(t2_58.next()) {
			int cnt = t2_58.getInt(1);
			model.addAttribute("t2_5m_web_cnt", cnt);
		}
		
		String t2_5m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_59 = st.executeQuery(t2_5m_channel_cnt);

		while(t2_59.next()) {
			int cnt = t2_59.getInt(1);
			model.addAttribute("t2_5m_channel_cnt", cnt);
		}
		
		String t2_5m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_510 = st.executeQuery(t2_5m_total_cnt);

		while(t2_510.next()) {
			int cnt = t2_510.getInt(1);
			model.addAttribute("t2_5m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 6월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_6m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_61 = st.executeQuery(t2_6m_online_cnt);

		while(t2_61.next()) {
			int cnt = t2_61.getInt(1);
			model.addAttribute("t2_6m_online_cnt", cnt);
		}
		
		String t2_6m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_62 = st.executeQuery(t2_6m_totalinfo_cnt);

		while(t2_62.next()) {
			int cnt = t2_62.getInt(1);
			model.addAttribute("t2_6m_totalinfo_cnt", cnt);
		}
		
		String t2_6m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_63 = st.executeQuery(t2_6m_card_cnt);

		while(t2_63.next()) {
			int cnt = t2_63.getInt(1);
			model.addAttribute("t2_6m_card_cnt", cnt);
		}
		
		String t2_6m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_64 = st.executeQuery(t2_6m_loan_cnt);

		while(t2_64.next()) {
			int cnt = t2_64.getInt(1);
			model.addAttribute("t2_6m_loan_cnt", cnt);
		}
		
		String t2_6m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_65 = st.executeQuery(t2_6m_bank_cnt);

		while(t2_65.next()) {
			int cnt = t2_65.getInt(1);
			model.addAttribute("t2_6m_bank_cnt", cnt);
		}
		
		String t2_6m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_66 = st.executeQuery(t2_6m_daeheang_cnt);

		while(t2_66.next()) {
			int cnt = t2_66.getInt(1);
			model.addAttribute("t2_6m_daeheang_cnt", cnt);
		}
		
		String t2_6m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_67 = st.executeQuery(t2_6m_smart_cnt);

		while(t2_67.next()) {
			int cnt = t2_67.getInt(1);
			model.addAttribute("t2_6m_smart_cnt", cnt);
		}
		
		String t2_6m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_68 = st.executeQuery(t2_6m_web_cnt);

		while(t2_68.next()) {
			int cnt = t2_68.getInt(1);
			model.addAttribute("t2_6m_web_cnt", cnt);
		}
		
		String t2_6m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_69 = st.executeQuery(t2_6m_channel_cnt);

		while(t2_69.next()) {
			int cnt = t2_69.getInt(1);
			model.addAttribute("t2_6m_channel_cnt", cnt);
		}
		
		String t2_6m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_610 = st.executeQuery(t2_6m_total_cnt);

		while(t2_610.next()) {
			int cnt = t2_610.getInt(1);
			model.addAttribute("t2_6m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 7월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_7m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_71 = st.executeQuery(t2_7m_online_cnt);

		while(t2_71.next()) {
			int cnt = t2_71.getInt(1);
			model.addAttribute("t2_7m_online_cnt", cnt);
		}
		
		String t2_7m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_72 = st.executeQuery(t2_7m_totalinfo_cnt);

		while(t2_72.next()) {
			int cnt = t2_72.getInt(1);
			model.addAttribute("t2_7m_totalinfo_cnt", cnt);
		}
		
		String t2_7m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_73 = st.executeQuery(t2_7m_card_cnt);

		while(t2_73.next()) {
			int cnt = t2_73.getInt(1);
			model.addAttribute("t2_7m_card_cnt", cnt);
		}
		
		String t2_7m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_74 = st.executeQuery(t2_7m_loan_cnt);

		while(t2_74.next()) {
			int cnt = t2_74.getInt(1);
			model.addAttribute("t2_7m_loan_cnt", cnt);
		}
		
		String t2_7m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_75 = st.executeQuery(t2_7m_bank_cnt);

		while(t2_75.next()) {
			int cnt = t2_75.getInt(1);
			model.addAttribute("t2_7m_bank_cnt", cnt);
		}
		
		String t2_7m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_76 = st.executeQuery(t2_7m_daeheang_cnt);

		while(t2_76.next()) {
			int cnt = t2_76.getInt(1);
			model.addAttribute("t2_7m_daeheang_cnt", cnt);
		}
		
		String t2_7m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_77 = st.executeQuery(t2_7m_smart_cnt);

		while(t2_77.next()) {
			int cnt = t2_77.getInt(1);
			model.addAttribute("t2_7m_smart_cnt", cnt);
		}
		
		String t2_7m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_78 = st.executeQuery(t2_7m_web_cnt);

		while(t2_78.next()) {
			int cnt = t2_78.getInt(1);
			model.addAttribute("t2_7m_web_cnt", cnt);
		}
		
		String t2_7m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_79 = st.executeQuery(t2_7m_channel_cnt);

		while(t2_79.next()) {
			int cnt = t2_79.getInt(1);
			model.addAttribute("t2_7m_channel_cnt", cnt);
		}
		
		String t2_7m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_710 = st.executeQuery(t2_7m_total_cnt);

		while(t2_710.next()) {
			int cnt = t2_710.getInt(1);
			model.addAttribute("t2_7m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 8월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_8m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_81 = st.executeQuery(t2_8m_online_cnt);

		while(t2_81.next()) {
			int cnt = t2_81.getInt(1);
			model.addAttribute("t2_8m_online_cnt", cnt);
		}
		
		String t2_8m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_82 = st.executeQuery(t2_8m_totalinfo_cnt);

		while(t2_82.next()) {
			int cnt = t2_82.getInt(1);
			model.addAttribute("t2_8m_totalinfo_cnt", cnt);
		}
		
		String t2_8m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_83 = st.executeQuery(t2_8m_card_cnt);

		while(t2_83.next()) {
			int cnt = t2_83.getInt(1);
			model.addAttribute("t2_8m_card_cnt", cnt);
		}
		
		String t2_8m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_84 = st.executeQuery(t2_8m_loan_cnt);

		while(t2_84.next()) {
			int cnt = t2_84.getInt(1);
			model.addAttribute("t2_8m_loan_cnt", cnt);
		}
		
		String t2_8m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_85 = st.executeQuery(t2_8m_bank_cnt);

		while(t2_85.next()) {
			int cnt = t2_85.getInt(1);
			model.addAttribute("t2_8m_bank_cnt", cnt);
		}
		
		String t2_8m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_86 = st.executeQuery(t2_8m_daeheang_cnt);

		while(t2_86.next()) {
			int cnt = t2_86.getInt(1);
			model.addAttribute("t2_8m_daeheang_cnt", cnt);
		}
		
		String t2_8m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_87 = st.executeQuery(t2_8m_smart_cnt);

		while(t2_87.next()) {
			int cnt = t2_87.getInt(1);
			model.addAttribute("t2_8m_smart_cnt", cnt);
		}
		
		String t2_8m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_88 = st.executeQuery(t2_8m_web_cnt);

		while(t2_88.next()) {
			int cnt = t2_88.getInt(1);
			model.addAttribute("t2_8m_web_cnt", cnt);
		}
		
		String t2_8m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_89 = st.executeQuery(t2_8m_channel_cnt);

		while(t2_89.next()) {
			int cnt = t2_89.getInt(1);
			model.addAttribute("t2_8m_channel_cnt", cnt);
		}
		
		String t2_8m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_810 = st.executeQuery(t2_8m_total_cnt);

		while(t2_810.next()) {
			int cnt = t2_810.getInt(1);
			model.addAttribute("t2_8m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 9월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_9m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_91 = st.executeQuery(t2_9m_online_cnt);

		while(t2_91.next()) {
			int cnt = t2_91.getInt(1);
			model.addAttribute("t2_9m_online_cnt", cnt);
		}
		
		String t2_9m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_92 = st.executeQuery(t2_9m_totalinfo_cnt);

		while(t2_92.next()) {
			int cnt = t2_92.getInt(1);
			model.addAttribute("t2_9m_totalinfo_cnt", cnt);
		}
		
		String t2_9m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_93 = st.executeQuery(t2_9m_card_cnt);

		while(t2_93.next()) {
			int cnt = t2_93.getInt(1);
			model.addAttribute("t2_9m_card_cnt", cnt);
		}
		
		String t2_9m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_94 = st.executeQuery(t2_9m_loan_cnt);

		while(t2_94.next()) {
			int cnt = t2_94.getInt(1);
			model.addAttribute("t2_9m_loan_cnt", cnt);
		}
		
		String t2_9m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_95 = st.executeQuery(t2_9m_bank_cnt);

		while(t2_95.next()) {
			int cnt = t2_95.getInt(1);
			model.addAttribute("t2_9m_bank_cnt", cnt);
		}
		
		String t2_9m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_96 = st.executeQuery(t2_9m_daeheang_cnt);

		while(t2_96.next()) {
			int cnt = t2_96.getInt(1);
			model.addAttribute("t2_9m_daeheang_cnt", cnt);
		}
		
		String t2_9m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_97 = st.executeQuery(t2_9m_smart_cnt);

		while(t2_97.next()) {
			int cnt = t2_97.getInt(1);
			model.addAttribute("t2_9m_smart_cnt", cnt);
		}
		
		String t2_9m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_98 = st.executeQuery(t2_9m_web_cnt);

		while(t2_98.next()) {
			int cnt = t2_98.getInt(1);
			model.addAttribute("t2_9m_web_cnt", cnt);
		}
		
		String t2_9m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_99 = st.executeQuery(t2_9m_channel_cnt);

		while(t2_99.next()) {
			int cnt = t2_99.getInt(1);
			model.addAttribute("t2_9m_channel_cnt", cnt);
		}
		
		String t2_9m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_910 = st.executeQuery(t2_9m_total_cnt);

		while(t2_910.next()) {
			int cnt = t2_910.getInt(1);
			model.addAttribute("t2_9m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 10월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_10m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_101 = st.executeQuery(t2_10m_online_cnt);

		while(t2_101.next()) {
			int cnt = t2_101.getInt(1);
			model.addAttribute("t2_10m_online_cnt", cnt);
		}
		
		String t2_10m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_102 = st.executeQuery(t2_10m_totalinfo_cnt);

		while(t2_102.next()) {
			int cnt = t2_102.getInt(1);
			model.addAttribute("t2_10m_totalinfo_cnt", cnt);
		}
		
		String t2_10m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_103 = st.executeQuery(t2_10m_card_cnt);

		while(t2_103.next()) {
			int cnt = t2_103.getInt(1);
			model.addAttribute("t2_10m_card_cnt", cnt);
		}
		
		String t2_10m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_104 = st.executeQuery(t2_10m_loan_cnt);

		while(t2_104.next()) {
			int cnt = t2_104.getInt(1);
			model.addAttribute("t2_10m_loan_cnt", cnt);
		}
		
		String t2_10m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_105 = st.executeQuery(t2_10m_bank_cnt);

		while(t2_105.next()) {
			int cnt = t2_105.getInt(1);
			model.addAttribute("t2_10m_bank_cnt", cnt);
		}
		
		String t2_10m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_106 = st.executeQuery(t2_10m_daeheang_cnt);

		while(t2_106.next()) {
			int cnt = t2_106.getInt(1);
			model.addAttribute("t2_10m_daeheang_cnt", cnt);
		}
		
		String t2_10m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_107 = st.executeQuery(t2_10m_smart_cnt);

		while(t2_107.next()) {
			int cnt = t2_107.getInt(1);
			model.addAttribute("t2_10m_smart_cnt", cnt);
		}
		
		String t2_10m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_108 = st.executeQuery(t2_10m_web_cnt);

		while(t2_108.next()) {
			int cnt = t2_108.getInt(1);
			model.addAttribute("t2_10m_web_cnt", cnt);
		}
		
		String t2_10m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_109 = st.executeQuery(t2_10m_channel_cnt);

		while(t2_109.next()) {
			int cnt = t2_109.getInt(1);
			model.addAttribute("t2_10m_channel_cnt", cnt);
		}
		
		String t2_10m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_1010 = st.executeQuery(t2_10m_total_cnt);

		while(t2_1010.next()) {
			int cnt = t2_1010.getInt(1);
			model.addAttribute("t2_10m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 11월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_11m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_111 = st.executeQuery(t2_11m_online_cnt);

		while(t2_111.next()) {
			int cnt = t2_111.getInt(1);
			model.addAttribute("t2_11m_online_cnt", cnt);
		}
		
		String t2_11m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_112 = st.executeQuery(t2_11m_totalinfo_cnt);

		while(t2_112.next()) {
			int cnt = t2_112.getInt(1);
			model.addAttribute("t2_11m_totalinfo_cnt", cnt);
		}
		
		String t2_11m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_113 = st.executeQuery(t2_11m_card_cnt);

		while(t2_113.next()) {
			int cnt = t2_113.getInt(1);
			model.addAttribute("t2_11m_card_cnt", cnt);
		}
		
		String t2_11m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_114 = st.executeQuery(t2_11m_loan_cnt);

		while(t2_114.next()) {
			int cnt = t2_114.getInt(1);
			model.addAttribute("t2_11m_loan_cnt", cnt);
		}
		
		String t2_11m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_115 = st.executeQuery(t2_11m_bank_cnt);

		while(t2_115.next()) {
			int cnt = t2_115.getInt(1);
			model.addAttribute("t2_11m_bank_cnt", cnt);
		}
		
		String t2_11m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_116 = st.executeQuery(t2_11m_daeheang_cnt);

		while(t2_116.next()) {
			int cnt = t2_116.getInt(1);
			model.addAttribute("t2_11m_daeheang_cnt", cnt);
		}
		
		String t2_11m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_117 = st.executeQuery(t2_11m_smart_cnt);

		while(t2_117.next()) {
			int cnt = t2_117.getInt(1);
			model.addAttribute("t2_11m_smart_cnt", cnt);
		}
		
		String t2_11m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_118 = st.executeQuery(t2_11m_web_cnt);

		while(t2_118.next()) {
			int cnt = t2_118.getInt(1);
			model.addAttribute("t2_11m_web_cnt", cnt);
		}
		
		String t2_11m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_119 = st.executeQuery(t2_11m_channel_cnt);

		while(t2_119.next()) {
			int cnt = t2_119.getInt(1);
			model.addAttribute("t2_11m_channel_cnt", cnt);
		}
		
		String t2_11m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_1110 = st.executeQuery(t2_11m_total_cnt);

		while(t2_1110.next()) {
			int cnt = t2_1110.getInt(1);
			model.addAttribute("t2_11m_total_cnt", cnt);
		}
		

/*----------------------------------------------    분석 2번째 표 12월 쿼리문    -------------------------------------------------------  */
		
		
		String t2_12m_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_121 = st.executeQuery(t2_12m_online_cnt);

		while(t2_121.next()) {
			int cnt = t2_121.getInt(1);
			model.addAttribute("t2_12m_online_cnt", cnt);
		}
		
		String t2_12m_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_122 = st.executeQuery(t2_12m_totalinfo_cnt);

		while(t2_122.next()) {
			int cnt = t2_122.getInt(1);
			model.addAttribute("t2_12m_totalinfo_cnt", cnt);
		}
		
		String t2_12m_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_123 = st.executeQuery(t2_12m_card_cnt);

		while(t2_123.next()) {
			int cnt = t2_123.getInt(1);
			model.addAttribute("t2_12m_card_cnt", cnt);
		}
		
		String t2_12m_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_124 = st.executeQuery(t2_12m_loan_cnt);

		while(t2_124.next()) {
			int cnt = t2_124.getInt(1);
			model.addAttribute("t2_12m_loan_cnt", cnt);
		}
		
		String t2_12m_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_125 = st.executeQuery(t2_12m_bank_cnt);

		while(t2_125.next()) {
			int cnt = t2_125.getInt(1);
			model.addAttribute("t2_12m_bank_cnt", cnt);
		}
		
		String t2_12m_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_126 = st.executeQuery(t2_12m_daeheang_cnt);

		while(t2_126.next()) {
			int cnt = t2_126.getInt(1);
			model.addAttribute("t2_12m_daeheang_cnt", cnt);
		}
		
		String t2_12m_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_127 = st.executeQuery(t2_12m_smart_cnt);

		while(t2_127.next()) {
			int cnt = t2_127.getInt(1);
			model.addAttribute("t2_12m_smart_cnt", cnt);
		}
		
		String t2_12m_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_128 = st.executeQuery(t2_12m_web_cnt);

		while(t2_128.next()) {
			int cnt = t2_128.getInt(1);
			model.addAttribute("t2_12m_web_cnt", cnt);
		}
		
		String t2_12m_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_129 = st.executeQuery(t2_12m_channel_cnt);

		while(t2_129.next()) {
			int cnt = t2_129.getInt(1);
			model.addAttribute("t2_12m_channel_cnt", cnt);
		}
		
		String t2_12m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_1210 = st.executeQuery(t2_12m_total_cnt);

		while(t2_1210.next()) {
			int cnt = t2_1210.getInt(1);
			model.addAttribute("t2_12m_total_cnt", cnt);
		}
		
		

/*----------------------------------------------    분석 2번째 표 총 합계 쿼리문    -------------------------------------------------------  */
		
		
		String t2_total_online_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='온라인공통' AND JCL_DEL_YN='N'";
		ResultSet t2_131 = st.executeQuery(t2_total_online_cnt);

		while(t2_131.next()) {
			int cnt = t2_131.getInt(1);
			model.addAttribute("t2_total_online_cnt", cnt);
		}
		
		String t2_total_totalinfo_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='종합정보' AND JCL_DEL_YN='N'";
		ResultSet t2_132 = st.executeQuery(t2_total_totalinfo_cnt);

		while(t2_132.next()) {
			int cnt = t2_132.getInt(1);
			model.addAttribute("t2_total_totalinfo_cnt", cnt);
		}
		
		String t2_total_card_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='카드' AND JCL_DEL_YN='N'";
		ResultSet t2_133 = st.executeQuery(t2_total_card_cnt);

		while(t2_133.next()) {
			int cnt = t2_133.getInt(1);
			model.addAttribute("t2_total_card_cnt", cnt);
		}
		
		String t2_total_loan_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='여신' AND JCL_DEL_YN='N'";
		ResultSet t2_134 = st.executeQuery(t2_total_loan_cnt);

		while(t2_134.next()) {
			int cnt = t2_134.getInt(1);
			model.addAttribute("t2_total_loan_cnt", cnt);
		}
		
		String t2_total_bank_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='수신' AND JCL_DEL_YN='N'";
		ResultSet t2_135 = st.executeQuery(t2_total_bank_cnt);

		while(t2_135.next()) {
			int cnt = t2_135.getInt(1);
			model.addAttribute("t2_total_bank_cnt", cnt);
		}
		
		String t2_total_daeheang_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='대행/단위' AND JCL_DEL_YN='N'";
		ResultSet t2_136 = st.executeQuery(t2_total_daeheang_cnt);

		while(t2_136.next()) {
			int cnt = t2_136.getInt(1);
			model.addAttribute("t2_total_daeheang_cnt", cnt);
		}
		
		String t2_total_smart_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='스마트뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_137 = st.executeQuery(t2_total_smart_cnt);

		while(t2_137.next()) {
			int cnt = t2_137.getInt(1);
			model.addAttribute("t2_total_smart_cnt", cnt);
		}
		
		String t2_total_web_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='웹뱅킹' AND JCL_DEL_YN='N'";
		ResultSet t2_138 = st.executeQuery(t2_total_web_cnt);

		while(t2_138.next()) {
			int cnt = t2_138.getInt(1);
			model.addAttribute("t2_total_web_cnt", cnt);
		}
		
		String t2_total_channel_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_CLASS='채널' AND JCL_DEL_YN='N'";
		ResultSet t2_139 = st.executeQuery(t2_total_channel_cnt);

		while(t2_139.next()) {
			int cnt = t2_139.getInt(1);
			model.addAttribute("t2_total_channel_cnt", cnt);
		}
		
		String t2_total_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_DEL_YN='N' "
				+ "AND (JCL_CLASS='온라인공통' OR JCL_CLASS='종합정보' OR JCL_CLASS='카드' OR JCL_CLASS='여신' OR JCL_CLASS='수신' "
				+ "OR JCL_CLASS='대행/단위' OR JCL_CLASS='스마트뱅킹' OR JCL_CLASS='웹뱅킹' OR JCL_CLASS='채널')";
		ResultSet t2_1310 = st.executeQuery(t2_total_total_cnt);

		while(t2_1310.next()) {
			int cnt = t2_1310.getInt(1);
			model.addAttribute("t2_total_total_cnt", cnt);
		}
		
		
		
		/*----------------------------------------------    분석 3번째 표 1월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_1m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_11 = st.executeQuery(t3_1m_external_cnt);

		while(t3_11.next()) {
			int cnt = t3_11.getInt(1);
			model.addAttribute("t3_1m_external_cnt", cnt);
		}
		
		
		String t3_1m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_12 = st.executeQuery(t3_1m_program_cnt);

		while(t3_12.next()) {
			int cnt = t3_12.getInt(1);
			model.addAttribute("t3_1m_program_cnt", cnt);
		}
		
		
		String t3_1m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_13 = st.executeQuery(t3_1m_system_cnt);

		while(t3_13.next()) {
			int cnt = t3_13.getInt(1);
			model.addAttribute("t3_1m_system_cnt", cnt);
		}
		
		
		String t3_1m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_14 = st.executeQuery(t3_1m_office_cnt);

		while(t3_14.next()) {
			int cnt = t3_14.getInt(1);
			model.addAttribute("t3_1m_office_cnt", cnt);
		}
		
		
		String t3_1m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/01%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_15 = st.executeQuery(t3_1m_total_cnt);

		while(t3_15.next()) {
			int cnt = t3_15.getInt(1);
			model.addAttribute("t3_1m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 2월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_2m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_21 = st.executeQuery(t3_2m_external_cnt);

		while(t3_21.next()) {
			int cnt = t3_21.getInt(1);
			model.addAttribute("t3_2m_external_cnt", cnt);
		}
		
		
		String t3_2m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_22 = st.executeQuery(t3_2m_program_cnt);

		while(t3_22.next()) {
			int cnt = t3_22.getInt(1);
			model.addAttribute("t3_2m_program_cnt", cnt);
		}
		
		
		String t3_2m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_23 = st.executeQuery(t3_2m_system_cnt);

		while(t3_23.next()) {
			int cnt = t3_23.getInt(1);
			model.addAttribute("t3_2m_system_cnt", cnt);
		}
		
		
		String t3_2m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_24 = st.executeQuery(t3_2m_office_cnt);

		while(t3_24.next()) {
			int cnt = t3_24.getInt(1);
			model.addAttribute("t3_2m_office_cnt", cnt);
		}
		
		
		String t3_2m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/02%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_25 = st.executeQuery(t3_2m_total_cnt);

		while(t3_25.next()) {
			int cnt = t3_25.getInt(1);
			model.addAttribute("t3_2m_total_cnt", cnt);
		}
		
		

		/*----------------------------------------------    분석 3번째 표 3월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_3m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_31 = st.executeQuery(t3_3m_external_cnt);

		while(t3_31.next()) {
			int cnt = t3_31.getInt(1);
			model.addAttribute("t3_3m_external_cnt", cnt);
		}
		
		
		String t3_3m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_32 = st.executeQuery(t3_3m_program_cnt);

		while(t3_32.next()) {
			int cnt = t3_32.getInt(1);
			model.addAttribute("t3_3m_program_cnt", cnt);
		}
		
		
		String t3_3m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_33 = st.executeQuery(t3_3m_system_cnt);

		while(t3_33.next()) {
			int cnt = t3_33.getInt(1);
			model.addAttribute("t3_3m_system_cnt", cnt);
		}
		
		
		String t3_3m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_34 = st.executeQuery(t3_3m_office_cnt);

		while(t3_34.next()) {
			int cnt = t3_34.getInt(1);
			model.addAttribute("t3_3m_office_cnt", cnt);
		}
		
		
		String t3_3m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/03%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_35 = st.executeQuery(t3_3m_total_cnt);

		while(t3_35.next()) {
			int cnt = t3_35.getInt(1);
			model.addAttribute("t3_3m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 4월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_4m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_41 = st.executeQuery(t3_4m_external_cnt);

		while(t3_41.next()) {
			int cnt = t3_41.getInt(1);
			model.addAttribute("t3_4m_external_cnt", cnt);
		}
		
		
		String t3_4m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_42 = st.executeQuery(t3_4m_program_cnt);

		while(t3_42.next()) {
			int cnt = t3_42.getInt(1);
			model.addAttribute("t3_4m_program_cnt", cnt);
		}
		
		
		String t3_4m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_43 = st.executeQuery(t3_4m_system_cnt);

		while(t3_43.next()) {
			int cnt = t3_43.getInt(1);
			model.addAttribute("t3_4m_system_cnt", cnt);
		}
		
		
		String t3_4m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_44 = st.executeQuery(t3_4m_office_cnt);

		while(t3_44.next()) {
			int cnt = t3_44.getInt(1);
			model.addAttribute("t3_4m_office_cnt", cnt);
		}
		
		
		String t3_4m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/04%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_45 = st.executeQuery(t3_4m_total_cnt);

		while(t3_45.next()) {
			int cnt = t3_45.getInt(1);
			model.addAttribute("t3_4m_total_cnt", cnt);
		}
		
		

		/*----------------------------------------------    분석 3번째 표 5월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_5m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_51 = st.executeQuery(t3_5m_external_cnt);

		while(t3_51.next()) {
			int cnt = t3_51.getInt(1);
			model.addAttribute("t3_5m_external_cnt", cnt);
		}
		
		
		String t3_5m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_52 = st.executeQuery(t3_5m_program_cnt);

		while(t3_52.next()) {
			int cnt = t3_52.getInt(1);
			model.addAttribute("t3_5m_program_cnt", cnt);
		}
		
		
		String t3_5m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_53 = st.executeQuery(t3_5m_system_cnt);

		while(t3_53.next()) {
			int cnt = t3_53.getInt(1);
			model.addAttribute("t3_5m_system_cnt", cnt);
		}
		
		
		String t3_5m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_54 = st.executeQuery(t3_5m_office_cnt);

		while(t3_54.next()) {
			int cnt = t3_54.getInt(1);
			model.addAttribute("t3_5m_office_cnt", cnt);
		}
		
		
		String t3_5m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/05%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_55 = st.executeQuery(t3_5m_total_cnt);

		while(t3_55.next()) {
			int cnt = t3_55.getInt(1);
			model.addAttribute("t3_5m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 6월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_6m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_61 = st.executeQuery(t3_6m_external_cnt);

		while(t3_61.next()) {
			int cnt = t3_61.getInt(1);
			model.addAttribute("t3_6m_external_cnt", cnt);
		}
		
		
		String t3_6m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_62 = st.executeQuery(t3_6m_program_cnt);

		while(t3_62.next()) {
			int cnt = t3_62.getInt(1);
			model.addAttribute("t3_6m_program_cnt", cnt);
		}
		
		
		String t3_6m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_63 = st.executeQuery(t3_6m_system_cnt);

		while(t3_63.next()) {
			int cnt = t3_63.getInt(1);
			model.addAttribute("t3_6m_system_cnt", cnt);
		}
		
		
		String t3_6m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_64 = st.executeQuery(t3_6m_office_cnt);

		while(t3_64.next()) {
			int cnt = t3_64.getInt(1);
			model.addAttribute("t3_6m_office_cnt", cnt);
		}
		
		
		String t3_6m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/06%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_65 = st.executeQuery(t3_6m_total_cnt);

		while(t3_65.next()) {
			int cnt = t3_65.getInt(1);
			model.addAttribute("t3_6m_total_cnt", cnt);
		}
		
		

		/*----------------------------------------------    분석 3번째 표 7월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_7m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_71 = st.executeQuery(t3_7m_external_cnt);

		while(t3_71.next()) {
			int cnt = t3_71.getInt(1);
			model.addAttribute("t3_7m_external_cnt", cnt);
		}
		
		
		String t3_7m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_72 = st.executeQuery(t3_7m_program_cnt);

		while(t3_72.next()) {
			int cnt = t3_72.getInt(1);
			model.addAttribute("t3_7m_program_cnt", cnt);
		}
		
		
		String t3_7m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_73 = st.executeQuery(t3_7m_system_cnt);

		while(t3_73.next()) {
			int cnt = t3_73.getInt(1);
			model.addAttribute("t3_7m_system_cnt", cnt);
		}
		
		
		String t3_7m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_74 = st.executeQuery(t3_7m_office_cnt);

		while(t3_74.next()) {
			int cnt = t3_74.getInt(1);
			model.addAttribute("t3_7m_office_cnt", cnt);
		}
		
		
		String t3_7m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/07%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_75 = st.executeQuery(t3_7m_total_cnt);

		while(t3_75.next()) {
			int cnt = t3_75.getInt(1);
			model.addAttribute("t3_7m_total_cnt", cnt);
		}
		
		
		
		

		/*----------------------------------------------    분석 3번째 표 8월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_8m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_81 = st.executeQuery(t3_8m_external_cnt);

		while(t3_81.next()) {
			int cnt = t3_81.getInt(1);
			model.addAttribute("t3_8m_external_cnt", cnt);
		}
		
		
		String t3_8m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_82 = st.executeQuery(t3_8m_program_cnt);

		while(t3_82.next()) {
			int cnt = t3_82.getInt(1);
			model.addAttribute("t3_8m_program_cnt", cnt);
		}
		
		
		String t3_8m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_83 = st.executeQuery(t3_8m_system_cnt);

		while(t3_83.next()) {
			int cnt = t3_83.getInt(1);
			model.addAttribute("t3_8m_system_cnt", cnt);
		}
		
		
		String t3_8m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_84 = st.executeQuery(t3_8m_office_cnt);

		while(t3_84.next()) {
			int cnt = t3_84.getInt(1);
			model.addAttribute("t3_8m_office_cnt", cnt);
		}
		
		
		String t3_8m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/08%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_85 = st.executeQuery(t3_8m_total_cnt);

		while(t3_85.next()) {
			int cnt = t3_85.getInt(1);
			model.addAttribute("t3_8m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 9월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_9m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_91 = st.executeQuery(t3_9m_external_cnt);

		while(t3_91.next()) {
			int cnt = t3_91.getInt(1);
			model.addAttribute("t3_9m_external_cnt", cnt);
		}
		
		
		String t3_9m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_92 = st.executeQuery(t3_9m_program_cnt);

		while(t3_92.next()) {
			int cnt = t3_92.getInt(1);
			model.addAttribute("t3_9m_program_cnt", cnt);
		}
		
		
		String t3_9m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_93 = st.executeQuery(t3_9m_system_cnt);

		while(t3_93.next()) {
			int cnt = t3_93.getInt(1);
			model.addAttribute("t3_9m_system_cnt", cnt);
		}
		
		
		String t3_9m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_94 = st.executeQuery(t3_9m_office_cnt);

		while(t3_94.next()) {
			int cnt = t3_94.getInt(1);
			model.addAttribute("t3_9m_office_cnt", cnt);
		}
		
		
		String t3_9m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/09%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_95 = st.executeQuery(t3_9m_total_cnt);

		while(t3_95.next()) {
			int cnt = t3_95.getInt(1);
			model.addAttribute("t3_9m_total_cnt", cnt);
		}
		
		

		/*----------------------------------------------    분석 3번째 표 10월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_10m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_101 = st.executeQuery(t3_10m_external_cnt);

		while(t3_101.next()) {
			int cnt = t3_101.getInt(1);
			model.addAttribute("t3_10m_external_cnt", cnt);
		}
		
		
		String t3_10m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_102 = st.executeQuery(t3_10m_program_cnt);

		while(t3_102.next()) {
			int cnt = t3_102.getInt(1);
			model.addAttribute("t3_10m_program_cnt", cnt);
		}
		
		
		String t3_10m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_103 = st.executeQuery(t3_10m_system_cnt);

		while(t3_103.next()) {
			int cnt = t3_103.getInt(1);
			model.addAttribute("t3_10m_system_cnt", cnt);
		}
		
		
		String t3_10m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_104 = st.executeQuery(t3_10m_office_cnt);

		while(t3_104.next()) {
			int cnt = t3_104.getInt(1);
			model.addAttribute("t3_10m_office_cnt", cnt);
		}
		
		
		String t3_10m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/10%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_105 = st.executeQuery(t3_10m_total_cnt);

		while(t3_105.next()) {
			int cnt = t3_105.getInt(1);
			model.addAttribute("t3_10m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 11월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_11m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_111 = st.executeQuery(t3_11m_external_cnt);

		while(t3_111.next()) {
			int cnt = t3_111.getInt(1);
			model.addAttribute("t3_11m_external_cnt", cnt);
		}
		
		
		String t3_11m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_112 = st.executeQuery(t3_11m_program_cnt);

		while(t3_112.next()) {
			int cnt = t3_112.getInt(1);
			model.addAttribute("t3_11m_program_cnt", cnt);
		}
		
		
		String t3_11m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_113 = st.executeQuery(t3_11m_system_cnt);

		while(t3_113.next()) {
			int cnt = t3_113.getInt(1);
			model.addAttribute("t3_11m_system_cnt", cnt);
		}
		
		
		String t3_11m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_114 = st.executeQuery(t3_11m_office_cnt);

		while(t3_114.next()) {
			int cnt = t3_114.getInt(1);
			model.addAttribute("t3_11m_office_cnt", cnt);
		}
		
		
		String t3_11m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/11%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_115 = st.executeQuery(t3_11m_total_cnt);

		while(t3_115.next()) {
			int cnt = t3_115.getInt(1);
			model.addAttribute("t3_11m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 12월 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_12m_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_121 = st.executeQuery(t3_12m_external_cnt);

		while(t3_121.next()) {
			int cnt = t3_121.getInt(1);
			model.addAttribute("t3_12m_external_cnt", cnt);
		}
		
		
		String t3_12m_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_122 = st.executeQuery(t3_12m_program_cnt);

		while(t3_122.next()) {
			int cnt = t3_122.getInt(1);
			model.addAttribute("t3_12m_program_cnt", cnt);
		}
		
		
		String t3_12m_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_123 = st.executeQuery(t3_12m_system_cnt);

		while(t3_123.next()) {
			int cnt = t3_123.getInt(1);
			model.addAttribute("t3_12m_system_cnt", cnt);
		}
		
		
		String t3_12m_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_124 = st.executeQuery(t3_12m_office_cnt);

		while(t3_124.next()) {
			int cnt = t3_124.getInt(1);
			model.addAttribute("t3_12m_office_cnt", cnt);
		}
		
		
		String t3_12m_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_REGDATE LIKE '%23/12%' AND JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_125 = st.executeQuery(t3_12m_total_cnt);

		while(t3_125.next()) {
			int cnt = t3_125.getInt(1);
			model.addAttribute("t3_12m_total_cnt", cnt);
		}
		
		
		

		/*----------------------------------------------    분석 3번째 표 총 합계 오류 요인별 쿼리문    -------------------------------------------------------  */
		
		
		String t3_total_external_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_ERROR_FACTORS='외부기관' AND JCL_DEL_YN='N'";
		ResultSet t3_131 = st.executeQuery(t3_total_external_cnt);

		while(t3_131.next()) {
			int cnt = t3_131.getInt(1);
			model.addAttribute("t3_total_external_cnt", cnt);
		}
		
		
		String t3_total_program_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_ERROR_FACTORS='프로그램' AND JCL_DEL_YN='N'";
		ResultSet t3_132 = st.executeQuery(t3_total_program_cnt);

		while(t3_132.next()) {
			int cnt = t3_132.getInt(1);
			model.addAttribute("t3_total_program_cnt", cnt);
		}
		
		
		String t3_total_system_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_ERROR_FACTORS='시스템' AND JCL_DEL_YN='N'";
		ResultSet t3_133 = st.executeQuery(t3_total_system_cnt);

		while(t3_133.next()) {
			int cnt = t3_133.getInt(1);
			model.addAttribute("t3_total_system_cnt", cnt);
		}
		
		
		String t3_total_office_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_ERROR_FACTORS='본부/영업점' AND JCL_DEL_YN='N'";
		ResultSet t3_134 = st.executeQuery(t3_total_office_cnt);

		while(t3_134.next()) {
			int cnt = t3_134.getInt(1);
			model.addAttribute("t3_total_office_cnt", cnt);
		}
		
		
		String t3_total_total_cnt = "SELECT COUNT(JCL_ID) CNT FROM JCLERROR WHERE JCL_DEL_YN='N' AND (JCL_ERROR_FACTORS='외부기관' "
				+ "OR JCL_ERROR_FACTORS='프로그램' OR JCL_ERROR_FACTORS='시스템' OR JCL_ERROR_FACTORS='본부/영업점')";
		ResultSet t3_135 = st.executeQuery(t3_total_total_cnt);

		while(t3_135.next()) {
			int cnt = t3_135.getInt(1);
			model.addAttribute("t3_total_total_cnt", cnt);
		}
		
		
		/*----------------------------------------------    close 함수    -------------------------------------------------------  */
		
		
		t1_11.close(); t1_12.close(); t1_13.close(); t1_14.close(); t1_15.close(); t1_16.close(); t1_17.close(); t1_18.close();
		
		t2_11.close(); t2_12.close(); t2_13.close(); t2_14.close(); t2_15.close(); t2_16.close(); t2_17.close(); t2_18.close(); t2_19.close(); t2_110.close();
		t2_21.close(); t2_22.close(); t2_23.close(); t2_24.close(); t2_25.close(); t2_26.close(); t2_27.close(); t2_28.close(); t2_29.close(); t2_210.close();
		t2_31.close(); t2_32.close(); t2_33.close(); t2_34.close(); t2_35.close(); t2_36.close(); t2_37.close(); t2_38.close(); t2_39.close(); t2_310.close();
		t2_41.close(); t2_42.close(); t2_43.close(); t2_44.close(); t2_45.close(); t2_46.close(); t2_47.close(); t2_48.close(); t2_49.close(); t2_410.close();
		t2_51.close(); t2_52.close(); t2_53.close(); t2_54.close(); t2_55.close(); t2_56.close(); t2_57.close(); t2_58.close(); t2_59.close(); t2_510.close();
		t2_61.close(); t2_62.close(); t2_63.close(); t2_64.close(); t2_65.close(); t2_66.close(); t2_67.close(); t2_68.close(); t2_69.close(); t2_610.close();
		t2_71.close(); t2_72.close(); t2_73.close(); t2_74.close(); t2_75.close(); t2_76.close(); t2_77.close(); t2_78.close(); t2_79.close(); t2_710.close();
		t2_81.close(); t2_82.close(); t2_83.close(); t2_84.close(); t2_85.close(); t2_86.close(); t2_87.close(); t2_88.close(); t2_89.close(); t2_810.close();
		t2_91.close(); t2_92.close(); t2_93.close(); t2_94.close(); t2_95.close(); t2_96.close(); t2_97.close(); t2_98.close(); t2_99.close(); t2_910.close();
		t2_101.close(); t2_102.close(); t2_103.close(); t2_104.close(); t2_105.close(); t2_106.close(); t2_107.close(); t2_108.close(); t2_109.close(); t2_1010.close();
		t2_111.close(); t2_112.close(); t2_113.close(); t2_114.close(); t2_115.close(); t2_116.close(); t2_117.close(); t2_118.close(); t2_119.close(); t2_1110.close();
		t2_121.close(); t2_122.close(); t2_123.close(); t2_124.close(); t2_125.close(); t2_126.close(); t2_127.close(); t2_128.close(); t2_129.close(); t2_1210.close();
		t2_131.close(); t2_132.close(); t2_133.close(); t2_134.close(); t2_135.close(); t2_136.close(); t2_137.close(); t2_138.close(); t2_139.close(); t2_1310.close();
		
		t3_11.close(); t3_12.close(); t3_13.close(); t3_14.close(); t3_15.close();
		t3_21.close(); t3_22.close(); t3_23.close(); t3_24.close(); t3_25.close();
		t3_31.close(); t3_32.close(); t3_33.close(); t3_34.close(); t3_35.close();
		t3_41.close(); t3_42.close(); t3_43.close(); t3_44.close(); t3_45.close();
		t3_51.close(); t3_52.close(); t3_53.close(); t3_54.close(); t3_55.close();
		t3_61.close(); t3_62.close(); t3_63.close(); t3_64.close(); t3_65.close();
		t3_71.close(); t3_72.close(); t3_73.close(); t3_74.close(); t3_75.close();
		t3_81.close(); t3_82.close(); t3_83.close(); t3_84.close(); t3_85.close();
		t3_91.close(); t3_92.close(); t3_93.close(); t3_94.close(); t3_95.close();
		t3_101.close(); t3_102.close(); t3_103.close(); t3_104.close(); t3_105.close();
		t3_111.close(); t3_112.close(); t3_113.close(); t3_114.close(); t3_115.close();
		t3_121.close(); t3_122.close(); t3_123.close(); t3_124.close(); t3_125.close();
		t3_131.close(); t3_132.close(); t3_133.close(); t3_134.close(); t3_135.close();
		
		st.close();
		con.close();
		
		return "jclanalisys";
	}

}

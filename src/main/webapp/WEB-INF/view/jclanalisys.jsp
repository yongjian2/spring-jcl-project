<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/css/jclanalisys.css" rel="stylesheet" type="text/css">
    <title>JCL 오류 분석</title>

</head>

<header>
	<div id="main-header">
        <div class="header-block">
            <ul>
        	    <li><a href="jclAdminMain"> JCL 오류현황 </a></li>
                <li><a href="jclanalisys">JCL 오류분석 </a></li>
                <li><a href="workerrormain">업무별 오류현황</a></li>
                <li><a href="jclAdminPage">관리자 페이지</a></li>
            </ul>
        </div>
	</div>
</header>

<body>

    <div id="table1-total-block">

        <div id="table1-block">

            <h3 style="font-size:18px">◎ 업무별 JCL 오류 현황</h3>

            <table id="table1" border="1">
                
                <colgroup>
                    <col style="width: 7%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                    <col style="width: 11%">
                </colgroup>

                <thead id="table1-thead">
                    <tr>
                        <td class="table1-thead-td"></td>
                        <td class="table1-thead-td">계정계</td>
                        <td class="table1-thead-td">정보계</td>
                        <td class="table1-thead-td">방카</td>
                        <td class="table1-thead-td">BCV</td>
                        <td class="table1-thead-td">리스크</td>
                        <td class="table1-thead-td">마이데이터</td>
                        <td class="table1-thead-td">분석지원</td>
                        <td class="table1-thead-td">합계</td>
                    </tr>
                </thead>

                <tbody id="table1-tbody">
                    <tr>
                        <td class="table1-tbody-td">건수</td>
                        <td class="table1-tbody-td">${ t1_cbs_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_d_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_bk_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_bcv_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_lisk_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_myd_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_bs_cnt }건</td>
                        <td class="table1-tbody-td">${ t1_total_cnt }건</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div id="table2-total-block">

        <div id="table2-block">

            <h3 style="font-size:18px">◎ 부서/파트별 JCL 오류 현황</h3>

            <table id="table2" border="1">

                <col style="width: 6%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 8%">
                <col style="width: 6%">

                <thead id="table2-thead">
                    <tr>
                        <td class="table2-thead-td" rowspan="2">기간</td>
                        <td class="table2-thead-td" colspan="2">IT기획부</td>
                        <td class="table2-thead-td" colspan="7">IT개발부</td>
                        <td class="table2-thead-td" rowspan="2">합계</td>
                    </tr>
                    <tr>
                        <td class="table2-thead-td">온라인공통</td>
                        <td class="table2-thead-td">종합정보</td>
                        <td class="table2-thead-td">카드</td>
                        <td class="table2-thead-td">여신</td>
                        <td class="table2-thead-td">수신</td>
                        <td class="table2-thead-td">대행/단위</td>
                        <td class="table2-thead-td">스마트뱅킹</td>
                        <td class="table2-thead-td">웹뱅킹</td>
                        <td class="table2-thead-td">채널</td>
                    </tr>
                </thead>

                <tbody id="table2-tbody">
                    <tr>
                        <td class="table2-tbody-td">1월</td>
                        <td class="table2-tbody-td">${ t2_1m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_1m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">2월</td>
                        <td class="table2-tbody-td">${ t2_2m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_2m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">3월</td>
                        <td class="table2-tbody-td">${ t2_3m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_3m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">4월</td>
                        <td class="table2-tbody-td">${ t2_4m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_4m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">5월</td>
                        <td class="table2-tbody-td">${ t2_5m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_5m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">6월</td>
                        <td class="table2-tbody-td">${ t2_6m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_6m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">7월</td>
                        <td class="table2-tbody-td">${ t2_7m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_7m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">8월</td>
                        <td class="table2-tbody-td">${ t2_8m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_8m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">9월</td>
                        <td class="table2-tbody-td">${ t2_9m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_9m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">10월</td>
                        <td class="table2-tbody-td">${ t2_10m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_10m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">11월</td>
                        <td class="table2-tbody-td">${ t2_11m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_11m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">12월</td>
                        <td class="table2-tbody-td">${ t2_12m_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_12m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table2-tbody-td">합계</td>
                        <td class="table2-tbody-td">${ t2_total_online_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_totalinfo_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_card_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_loan_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_bank_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_daeheang_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_smart_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_web_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_channel_cnt }건</td>
                        <td class="table2-tbody-td">${ t2_total_total_cnt }건</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div id="table3-total-block">

        <div id="table3-block">

            <h3 style="font-size:18px">◎ JCL 오류 요인별 현황</h3>

            <table id="table3" border="1">

                <col style="width: 8%">
                <col style="width: 14%">
                <col style="width: 14%">
                <col style="width: 14%">
                <col style="width: 14%">
                <col style="width: 8%">

                <thead id="table3-thead">
                    <tr>
                        <td class="table3-thead-td" rowspan="2">기간</td>
                        <td class="table3-thead-td" rowspan="2">외부기관</td>
                        <td class="table3-thead-td" colspan="3">내부요인</td>
                        <td class="table3-thead-td" rowspan="2">합계</td>
                    </tr>
                    <tr>
                        <td class="table3-thead-td">프로그램</td>
                        <td class="table3-thead-td">시스템</td>
                        <td class="table3-thead-td">본부/영업점</td>
                    </tr>
                </thead>
                <tbody id="table3-tbody">
                    <tr>
                        <td class="table3-tbody-td">1월</td>
                        <td class="table3-tbody-td">${ t3_1m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_1m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_1m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_1m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_1m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">2월</td>
                        <td class="table3-tbody-td">${ t3_2m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_2m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_2m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_2m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_2m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">3월</td>
                        <td class="table3-tbody-td">${ t3_3m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_3m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_3m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_3m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_3m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">4월</td>
                        <td class="table3-tbody-td">${ t3_4m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_4m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_4m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_4m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_4m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">5월</td>
                        <td class="table3-tbody-td">${ t3_5m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_5m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_5m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_5m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_5m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">6월</td>
                        <td class="table3-tbody-td">${ t3_6m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_6m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_6m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_6m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_6m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">7월</td>
                        <td class="table3-tbody-td">${ t3_7m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_7m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_7m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_7m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_7m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">8월</td>
                        <td class="table3-tbody-td">${ t3_8m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_8m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_8m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_8m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_8m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">9월</td>
                        <td class="table3-tbody-td">${ t3_9m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_9m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_9m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_9m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_9m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">10월</td>
                        <td class="table3-tbody-td">${ t3_10m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_10m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_10m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_10m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_10m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">11월</td>
                        <td class="table3-tbody-td">${ t3_11m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_11m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_11m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_11m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_11m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">12월</td>
                        <td class="table3-tbody-td">${ t3_12m_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_12m_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_12m_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_12m_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_12m_total_cnt }건</td>
                    </tr>
                    <tr>
                        <td class="table3-tbody-td">합계</td>
                        <td class="table3-tbody-td">${ t3_total_external_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_total_program_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_total_system_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_total_office_cnt }건</td>
                        <td class="table3-tbody-td">${ t3_total_total_cnt }건</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    
</body>
</html>
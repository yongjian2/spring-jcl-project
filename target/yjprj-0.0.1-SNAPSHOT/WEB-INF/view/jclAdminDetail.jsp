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
    <link href="/css/jclAdminDetail.css" rel="stylesheet" type="text/css">
    <title>JCL 오류 상세페이지</title>
</head>

<body>
    <div id="container">
    <c:forEach var="n" items="${list}">
        <form action="modifyJclError?jcl_num=${n.num}" method="post" >
            <input type="hidden" value="${n.num}">
            <div id="container-block">
                <table id="container-table" border="1">
               		
	                    <tr>
	                        <td class="container-theader">일자 :</td>
	                        <td class="container-theader">오류시간 :</td>
							<td class="container-theader">조치시간 :</td>
							<td class="container-theader">누적횟수 :</td>
	                    </tr>
	                    <tr>
	                        <td class="container-input">
	                        	<c:set var="dateVar" value="${n.regdate}" />
			        			<fmt:formatDate value="${ dateVar }" pattern="yy-MM-dd" />
	                        </td>
	                        <td class="container-input">
	                        	<c:set var="dateVar" value="${n.regtime}" />
			        			<fmt:formatDate value="${ dateVar }" pattern="HH:mm:ss" />
	                        </td>
							<td class="container-input">
								<input readonly class="input-text2" name="actiontime" type="text" value="${n.actiontime}" />	                        
	                        </td>
							<td class="container-input">
								<input readonly class="input-text2" name="hit" type="text" value="${n.hit}" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-theader">JOB ID :</td>
	                        <td colspan="2" class="container-theader">시스템분류 :</td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-input">
	                            <input class="input-text" name="jobid" type="text" autocomplete="off" value="${n.id}" />
	                        </td>
	                        <td colspan="2" class="container-input">
	                            <input class="input-text" name="jclwork" type="text" autocomplete="off" value="${n.work}" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-theader">작업명 :</td>
	                        <td colspan="2" class="container-theader">담당자 :</td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-input">
	                            <input class="input-text" name="jobname" type="text" autocomplete="off" value="${n.name}" />
	                        </td>
	                        <td colspan="2" class="container-input">
	                            <input class="input-text" name="jobcharger" type="text" autocomplete="off" value="${n.charger}" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" height="40px">
	                        <div id="container-comment-block">
		                        <div class="container-theader2">업무분류 :</div>
		                        <div class="container-theader-comment">(온라인공통,종합정보,카드,여신,수신,대행/단위,스마트뱅킹,웹뱅킹,채널)</div>
	                        </div>
	                        </td>
	                        <td colspan="2" height="40px">
	                        <div id="container-comment-block">
		                        <div class="container-theader2">오류요인 :</div>
		                        <div class="container-theader-comment">(외부기관,프로그램,시스템,본부/영업점)</div>
	                        </div>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-input">
								<%-- <select class="input-text" name="${n.jobclass}" >
									<option value="전체">전체</option>
									<option value="온라인공통">온라인공통</option>
									<option value="종합정보">종합정보</option>
									<option value="카드">카드</option>
									<option value="여신">여신</option>
									<option value="수신">수신</option>
									<option value="대행/단위">대행/단위</option>
									<option value="스마트뱅킹">스마트뱅킹</option>
									<option value="웹뱅킹">웹뱅킹</option>
									<option value="채널">채널</option>
								</select> --%>
	                            <input id="inputJobclass" class="input-text" name="jobclass" type="text" autocomplete="off" value="${n.jobclass}" />
	                        </td>
	                        <td colspan="2" class="container-input">
								<%-- <select class="input-text" name="${n.factors}" >
									<option value="전체">전체</option>
									<option value="온라인공통">외부기관</option>
									<option value="종합정보">프로그램</option>
									<option value="카드">시스템</option>
									<option value="여신">본부/영업점</option>
								</select> --%>
	                            <input id="inputFactors" class="input-text" name="factors" type="text" autocomplete="off" value="${n.factors}" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-theader">오류사유 :</td>
	                        <td colspan="2" class="container-theader">조치내용 :</td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="container-text">
	                            <input class="input-text" name="reason" type="text" autocomplete="off" value="${n.reason}" />
	                        </td>
	                        <td colspan="2" class="container-text">
	                            <input class="input-text" name="action" type="text" autocomplete="off" value="${n.action}" />
	                        </td>
	                    </tr>
                </table>
            </div>		
            <div id="btn-block">
                <input class="btn1" type="submit" value="수정" onclick="return confirm('수정하시겠습니까?');">
                <a href="deleteJclError?jcl_num=${n.num}" onclick="return confirm('삭제하시겠습니까?');" ><input class="btn2" type="button" value="삭제" ></a> 
                <a href="javascript:history.go(-1)"><input class="btn3" type="button" value="목록" ></a>
            </div>
            
        </form>
    </c:forEach>
    </div>
    
</body>
</html>

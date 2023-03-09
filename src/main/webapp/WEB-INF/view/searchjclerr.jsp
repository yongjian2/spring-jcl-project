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
    <link href="/css/jclstyle.css" rel="stylesheet" type="text/css">

    <title>JCL 오류현황</title>
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

    <div id="totalheader-block">

		<form action="searchjclerr" method="post" name="searchjclerr_form">
			<input id="cal" type="date" value="${dateType}" min="2023-01-01" max="2023-12-31" name=jclDateParam >
			<button class="b1" type="submit" onclick="return search_check()">조회</button>
			<script type="text/javascript">
				function search_check() {
					if (document.searchjclerr_form.jclDateParam.value == "") {
						alert("날짜를 선택해주세요.");
						return false;
					} else { return true; }
				}
			</script>
		</form>

        <div id="totalcount-block">
            <div class="totalcount">
                <h3>총 : ${totalcount}건</h3>
            </div>
        </div>

    </div>
    
    <form>
        <table id="maintable" border="1">
            <colgroup>
                <col style="width: 3%">
                <col style="width: 6%">
                <col style="width: 6%">
                <col style="width: 8%">
                <col style="width: 7%">
                <col style="width: 20%">
                <col style="width: 7%">
                <col style="width: auto">
                <col style="width: auto">
                <%-- <col style="width: 7%"> --%>
                <col style="width: 5%">
            </colgroup>
            <thead id="maintable-head">
                <tr height="30px">
                    <td class="thead-td">No.</td>
                    <td class="thead-td">일자</td>
                    <td class="thead-td">오류시간</td>
                    <td class="thead-td">JOB ID</td>
                    <td class="thead-td">업무분류</td>
                    <td class="thead-td">작업명</td>
                    <td class="thead-td">담당자</td>
                    <td class="thead-td">오류사유</td>
                    <td class="thead-td">조치내역</td>
                    <!-- <td class="thead-td">조치시간</td> -->
                    <td class="thead-td">누적횟수</td>
                </tr>
            </thead>
            
            <tbody>
            
          		<c:forEach var="n" items="${list}">
	                <tr>
	                    <td height="25px" class="tbody-td">${n.num}</td>
	                    <td height="25px" class="tbody-td">
			        		<c:set var="dateVar" value="${n.regdate}" />
			        		<fmt:formatDate value="${ dateVar }" pattern="yy-MM-dd" />
	                    </td>
	                    <td height="25px" class="tbody-td">
			        		<c:set var="dateVar" value="${n.regtime}" />
			        		<fmt:formatDate value="${ dateVar }" pattern="HH:mm:ss" />
	                    </td>                   <!-- target="_blank"  새탭열기 코드  -->
	                    <td height="25px" class="tbody-td"><a href="/jcldetail?jcl_num=${n.num}" >${n.id}</a></td>
	                    <td height="25px" class="tbody-td">${n.work}</td>
	                    <td height="25px" class="tbody-td">${n.name}</td>
	                    <td height="25px" class="tbody-td">${n.charger}</td>
	                    <td height="25px" class="tbody-td">${n.reason}</td>
	                    <td height="25px" class="tbody-td">${n.action}</td>
	                   <%--  <td height="25px" class="tbody-td">${n.actiontime}</td> --%>
	                    <td height="25px" class="tbody-td">${n.hit}</td>
	                </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/css/jclAdminPage.css" rel="stylesheet" type="text/css">
    <title>관리자 페이지</title>
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
	<div id="content1-block">
	
		<div id="content1-h3">
            <h3 style="font-size:18px">◎ JCL JOB 등록</h3>
        </div>

        <div id="content1-table1-block">

		    <form action="jclAdminReg" method="post">
                <div>
		    	<table id="table1" border="1">
			    	<colgroup>
		                <col style="width: 20%">
		                <col style="width: 40%">
		                <col style="width: 20%">
		                <col style="width: 20%">
		            </colgroup>
		            
		            <thead class="table1-thead">
			            <tr>
			                <td class="table1-thead-td" >JOB ID</td>
			                <td class="table1-thead-td" >작업명</td>
			                <td class="table1-thead-td" >시스템분류</td>
			                <td class="table1-thead-td" >담당자</td>
			             </tr>
			         </thead>
		             </tbody>
			             <tr>
			                <td class="table1-tbody-td" >
			           		   	<input class="table1-input1" type="text" name=jobId autocomplete="off" required>
			                </td>
			                <td class="table1-tbody-td" >
			                    <input class="table1-input2" type="text" name=jobName autocomplete="off" required>
			                </td>
			                <td class="table1-tbody-td" >
			              		<input class="table1-input1" type="text" name=jobWork autocomplete="off" required>
			                </td>
			                <td class="table1-tbody-td" >
			                    <input class="table1-input1" type="text" name=jobCharger autocomplete="off" required>
			                </td>
			            </tr>
		            </tbody>
		       	</table>
                </div>
                
                <button class="table1-btn1" type="submit" onclick="return confirm('입력하시겠습니까?');">입력</button>
                
	       	</form>

       	</div>
    </div>

    <div id="content2-total-block">

        <div id="content2-block">

            <div>
                <h3 style="font-size:18px">◎ 업데이트 현황</h3>
            </div>
            <div>
                <!-- <a href="jclAdminMerge"><input id="content1-btn" type="button" value="전체 업데이트" onclick="return confirm('업데이트하시겠습니까?');"></a> -->
            </div>

            <table id="table2" border="1">
                
                <colgroup>
                    <col style="width: 5%">
                    <col style="width: 4%">
                    <col style="width: 5%">
                    <col style="width: 17%">
                    <col style="width: 5%">
                    <col style="width: 6%">
                    <col style="width: 6%">
                    <col style="width: 3%">
                </colgroup>

                <thead id="table2-thead">
                    <tr>
                        <td class="table2-thead-td">일자</td>
                        <td class="table2-thead-td">JOB ID</td>
                        <td class="table2-thead-td">시스템분류</td>
                        <td class="table2-thead-td">작업명</td>
                        <td class="table2-thead-td">담당자</td>
                        <td class="table2-thead-td">업무분류</td>
                        <td class="table2-thead-td">오류요인</td>
                        <td class="table2-thead-td">누적횟수</td>
                    </tr>
                </thead>

                
                <tbody id="table2-tbody">
                    <c:forEach var="n" items="${list}">
                    <input type="hidden" value="${n.num}">
                        <tr>
                            <td class="table2-tbody-td">${n.regdate}</td>
                            <td class="table2-tbody-td"><a href="/jclAdminDetail?jcl_num=${n.num}" >${n.id}</a></td>
                            <td class="table2-tbody-td">${n.work}</td>
                            <td class="table2-tbody-td">${n.name}</td>
                            <td class="table2-tbody-td">${n.charger}</td>
                            <td class="table2-tbody-td">${n.jobclass}</td>
                            <td class="table2-tbody-td">${n.factors}</td>
                            <td class="table2-tbody-td">${n.hit}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
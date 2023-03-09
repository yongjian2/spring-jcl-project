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
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <script src="/lib/jquery.js"></script>
	<title>업무별 오류현황</title>

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
    <div id="table-blank">
    <input type="hidden" value="${n.num}">
        <table id="table1" border="1">
            <tr>
                <td id="table-bl" class="t1">
                    담당업무
                </td>
                <td id="table-bl" class="t2">
              
                       <select id="getWname" name=wname>	                   
                           <option value="전체">전체</option>
                           <option value="아키텍처">아키텍처</option>
                           <option value="응용개발그룹">응용개발그룹</option>
                           <option value="자동이체">자동이체</option>
                           <option value="공통">공통</option>
                           <option value="카드">카드</option>
                           <option value="수신">수신</option>
                           <option value="전자금융">전자금융</option>
                           <option value="단위업무 외">단위업무 외</option>
                           <option value="대외접속">대외접속</option>
                           <option value="외환">외환</option>
                           <option value="예산자산관리">예산자산관리</option>
                           <option value="인사관리">인사관리</option>
                           <option value="여신">여신</option>
                           <option value="종합정보지원">종합정보지원</option>
                           <option value="계리">계리</option>
                           <option value="대행/부대">대행/부대</option>
                       </select>
                 
                </td>
                <td id="table-bl" class="t1">
                    오류유형
                </td>
                <td id="table-bl" class="t2">
              
                       <select id="getErname" name=ername>
                           <option value="전체">전체</option>
                           <option value="비즈니스 메시지">비즈니스 메시지</option>
                           <option value="조작자 메시지">조작자 메시지</option>
                           <option value="데이터베이스 메시지">데이터베이스 메시지</option>
                           <option value="시스템 메시지">시스템 메시지</option>
                           <option value="프로그램 메시지">프로그램 메시지</option>
                       </select>
                 
                </td>
                <td id="table-bl" class="t1">
                    서비스ID
                </td>
                <td id="table-bl" class="t3">
                    <input id="getSid" class="f2" type="text" name=sid autocomplete="off" required>
                </td>
            </tr>
            <tr>
                <td id="table-bl" class="t1">                
                    확인자
                </td>
                <td id="table-bl" class="t2">
                    <input id="getIdenti" class="f1" type="text" name=identi autocomplete="off" required>
                </td>
                <td id="table-bl" class="t1">                
                    담당자
                </td>
                <td id="table-bl" class="t2">
                    <input id="getCharger" class="f1" type="text" name=charger autocomplete="off" required>
                </td>
                <td id="table-bl" class="t1">                
                    오류메시지
                </td>
                <td id="table-bl" class="t3">
                    <input id="getErrms" class="f2" type="text" name=errms autocomplete="off" required>
                </td>
            </tr>
       	</table>

           <button id="btn_script" class="b2" onclick="work_submit_confirm()" >등록</button>
           
           <script type="text/javascript">
           	function work_submit_confirm() { 
           		
           		var result = confirm("등록하시겠습니까?");
           		if(result == true) {
           			alert("등록되었습니다.");
           			
           			var getWname = document.getElementById("getWname").value;
           			var getErname = document.getElementById("getErname").value;
           			var getSid = document.getElementById("getSid").value;
           			var getIdenti = document.getElementById("getIdenti").value;
           			var getCharger = document.getElementById("getCharger").value;
           			var getErrms = document.getElementById("getErrms").value; 
           			console.log(getWname);
           			console.log(getErname);
           			console.log(getSid);
           			console.log(getIdenti);
           			console.log(getCharger);
           			console.log(getErrms);
           			
           			var newForm = document.createElement('form');
           			
           			newForm.name = 'newForm';
           			newForm.method = 'post';
           			newForm.action = 'reg';
           			
           			var input1 = document.createElement('input');
           			var input2 = document.createElement('input');
           			var input3 = document.createElement('input');
           			var input4 = document.createElement('input');
           			var input5 = document.createElement('input');
           			var input6 = document.createElement('input');
           			
           			input1.setAttribute("type", "hidden");
           			input1.setAttribute("name", 'wname');
           			input1.setAttribute("value", getWname);
           			input2.setAttribute("type", "hidden");
           			input2.setAttribute("name", 'ername');
           			input2.setAttribute("value", getErname);
           			input3.setAttribute("type", "hidden");
           			input3.setAttribute("name", 'sid');
           			input3.setAttribute("value", getSid);
           			input4.setAttribute("type", "hidden");
           			input4.setAttribute("name", 'identi');
           			input4.setAttribute("value", getIdenti);
           			input5.setAttribute("type", "hidden");
           			input5.setAttribute("name", 'charger');
           			input5.setAttribute("value", getCharger);
           			input6.setAttribute("type", "hidden");
           			input6.setAttribute("name", 'errms');
           			input6.setAttribute("value", getErrms);
           			
           			newForm.appendChild(input1);
           			newForm.appendChild(input2);
           			newForm.appendChild(input3);
           			newForm.appendChild(input4);
           			newForm.appendChild(input5);
           			newForm.appendChild(input6);
           			
           			document.body.appendChild(newForm);
           			
           			newForm.submit();
               		
           		} else if(result == false){
           		}
           	}
           </script>
            
		<form action="searchworkerr" method="post" name="searchjclerr_form">
			<input id="cal" type="date" value="${dateType}" min="2023-01-01" max="2023-12-31" name=workDateParam >
			<button class="b1" type=submit onclick="return search_check()">조회</button>
			<script type="text/javascript">
				function search_check() {
					if (document.searchjclerr_form.workDateParam.value == "") {
						alert("날짜를 선택해주세요.");
						return false;
					} else { return true; }
				}
			</script>
		</form>
		
	</div>
	
	<div id="totalcount-block">
		<div class="totalcount">
			<h3>총 :  ${totalcount}건</h3>
		</div>
	</div>
	
    <table id="table2" border="1">
        <thead>		
        	<tr class="table2-head">
	            <td class="thead-td">일자</td>
	            <td class="thead-td">시간</td>
	            <td class="thead-td">담당업무</td>
	            <td class="thead-td">오류유형</td>
	            <td class="thead-td">서비스ID</td>
	            <td class="thead-td">확인자</td>
	            <td class="thead-td">담당자</td>
	            <td class="thead-td">오류메시지</td>
	        </tr>
        </thead>

        <tbody>
        
        	<c:forEach var="n" items="${list}">
		        <tr>
		        	<td class="tbody-td" width="70px" class="t4">
		        		<c:set var="dateVar" value="${n.regdate}" />
		        		<fmt:formatDate value="${ dateVar }" pattern="yy-MM-dd" />
		        	</td>
		        	<td class="tbody-td" width="50px" class="t4">
			        		<c:set var="dateVar" value="${n.regtime}" />
			        		<fmt:formatDate value="${ dateVar }" pattern="HH:mm:ss" />
	                    </td> 
		        	<td class="tbody-td" width="150px" class="t4">${n.wname}</td>
		        	<td class="tbody-td" width="200px" class="t4"><a href="/workdetail?work_num=${n.num}">${n.ername}</a></td>
		        	<td class="tbody-td" width="200px" class="t4">${n.sid}</td>
		        	<td class="tbody-td" width="50px" class="t4">${n.identi}</td>
		        	<td class="tbody-td" width="50px" class="t4">${n.charger}</td>
		        	<td class="tbody-td" width="200px" class="t4">${n.errms}</td>
		        </tr>
	        </c:forEach>
        </tbody>

    </table>

</body>

</html>
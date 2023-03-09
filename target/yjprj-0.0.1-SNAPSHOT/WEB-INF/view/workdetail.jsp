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
    <link href="/css/workdetail.css" rel="stylesheet" type="text/css">
    <title>업무별 오류 상세페이지</title>
</head>

<body>
    <div id="container">
    <c:forEach var="n" items="${list}">
    <input type="hidden" value="${n.num}">
        <form action="updateworkerr?work_num=${n.num}" method="post">
            <div id="container-block">
                <table id="container-table" border="1">
                    <tr>
                        <td class="container-theader">일자 :</td>
                        <td class="container-theader">시간 :</td>
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
                    </tr>
                    <tr>
                        <td class="container-theader">담당업무 :</td>
                        <td class="container-theader">오류유형 :</td>
                    </tr>
                    <tr>
                        <td class="container-input">
                            <input class="input-text" name="wname" type="text" autocomplete="off" value="${n.wname}" />
                        </td>
                        <td class="container-input">
                            <input class="input-text" name="ername" type="text" autocomplete="off" value="${n.ername}" />
                        </td>
                    </tr>
                    <tr>
                        <td class="container-theader">서비스ID :</td>
                        <td class="container-theader">오류메시지 :</td>
                    </tr>
                    <tr>
                        <td class="container-input">
                            <input class="input-text" name="sid" type="text" autocomplete="off" value="${n.sid}" />
                        </td>
                        <td class="container-input">
                            <input class="input-text" name="errms" type="text" autocomplete="off" value="${n.errms}" />
                        </td>
                    </tr>
                    <tr>
                        <td class="container-theader">담당자 :</td>
                        <td class="container-theader">확인자 :</td>
                    </tr>
                    <tr>
                        <td class="container-input">
                            <input class="input-text" name="charger" type="text" autocomplete="off" value="${n.charger}" />
                        </td>
                        <td class="container-input">
                            <input class="input-text" name="identi" type="text" autocomplete="off" value="${n.identi}" />
                        </td>
                    </tr>
                    <tr>
                        <td class="container-theader">오류사유 :</td>
                        <td class="container-theader">조치내용 :</td>
                    </tr>
                    <tr>
                        <td class="container-input">
                            <input class="input-text" name="reason" type="text" autocomplete="off" value="${n.reason}" />
                        </td>
                        <td class="container-input">
                            <input class="input-text" name="action" type="text" autocomplete="off" value="${n.action}" />
                        </td>
                    </tr>
                </table>
            </div>
            <div id="btn-block">
                <input class="btn1" type="submit" value="수정" onclick="return confirm('수정하시겠습니까?');" >
                <a href="deleteworkerr?work_num=${n.num}" onclick="return confirm('삭제하시겠습니까?');" ><input class="btn2" type="button" value="삭제" ></a> 
                <a href="workerrormain"><input class="btn3" type="button" value="목록" ></a>
			
            </div>
        </form>
    </c:forEach>
    </div>
    
</body>
</html>
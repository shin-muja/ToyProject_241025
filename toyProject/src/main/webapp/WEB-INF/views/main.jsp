<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 목록</title>

	<link rel="stylesheet" href="/resources/css/main.css">
</head>

<body>
    <div class="container">
        <h1 class="main-title">학생 목록</h1>
        <div class="header">
            <div></div> <!-- 왼쪽 여백을 위한 빈 div -->
            <div class="total-count">
                총 학생 수 : ${totalStudent}명
            </div>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>학점</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${stdList}" var="std" varStatus="vs">
                    <tr>
                        <td class="student-number">${std.stdNo}</td>
                        <td>
                            <a href="/student/detail?stdNo=${std.stdNo }" class="student-name">
                                ${std.stdName}
                            </a>
                        </td>
                        <td>${std.stdScore}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="button-container">
            <button id="add-button">
                학생 추가
            </button>
        </div>
    </div>
    
    <c:if test="${not empty sessionScope.message}">
	  	<script>
	  		alert("${message}");
	  	</script>
	  	
	  	<%-- message를 한 번만 출력하고 제거 --%>
	  	<c:remove var="message" scope="session" />
	</c:if>
	<script src="/resources/js/main.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
<link rel="stylesheet" href="/resources/css/update.css">
</head>
<body>
<div class="container">
    <h2>학생 정보 수정</h2>
    
    <form action="/student/update" method="POST">
        <input type="hidden" name="stdNo" value="${std.stdNo}">
        
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" id="name" name="stdName" value="${std.stdName}" required>
        </div>
        
        <div class="form-group">
            <label for="age">나이:</label>
            <input type="number" id="age" name="stdAge" value="${std.stdAge}" min="1" max="100" required>
        </div>
        
        <div class="form-group">
            <label for="grade">성적:</label>
            <div class="select-wrapper">
                <select id="grade" name="stdScore" required>
                    <option value="" disabled selected>학점을 선택하세요</option>
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="F">F</option>
                </select>
            </div>
        </div>
        
        <div class="btn-group">
            <button type="submit" class="btn">수정하기</button>
            <button type="button" class="btn btn-cancel" onclick="location.href='/'">취소</button>
        </div>
    </form>
    
    <c:if test="${not empty sessionScope.message}">
    	<script>
    		alert("${messege}");
    	</script>
    	
    	<c:remove var="message" scope="session" />
    </c:if>
</div>
</body>
</html>
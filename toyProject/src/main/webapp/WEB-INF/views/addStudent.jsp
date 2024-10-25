<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 추가</title>
    
	<link rel="stylesheet" href="/resources/css/addStd.css">
</head>
<body>
    <h2>학생 정보 입력</h2>
    
    <form action="/student/addStudent" method="post">
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="stdName" required placeholder="이름을 입력하세요">
        </div>

        <div class="form-group">
            <label for="age">나이</label>
            <input type="number" id="age" name="stdAge" min="1" max="100" required placeholder="나이를 입력하세요">
        </div>

        <div class="form-group">
            <label>성별</label>
            <div class="radio-group">
                <label for="male">
                    <input type="radio" id="male" name="stdGender" value="M" required>
                    남자
                </label>
                <label for="female">
                    <input type="radio" id="female" name="stdGender" value="F">
                    여자
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="grade">학점</label>
            <select id="grade" name="stdScore" required>
                <option value="">학점을 선택하세요</option>
                <c:forEach var="grade" items="A,B,C,D,F">
                    <option value="${grade}">${grade}</option>
                </c:forEach>
            </select>
        </div>

        <div class="button-group">
            <button type="submit">저장하기</button>
            <button type="reset">초기화</button>
            <button type="button" class="btn-list" onclick="location.href='/'">목록으로</button>
        </div>
    </form>
</body>
</html>
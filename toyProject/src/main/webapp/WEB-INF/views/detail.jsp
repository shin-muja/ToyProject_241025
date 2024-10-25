<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 상세 정보</title>
    
    <link rel="stylesheet" href="/resources/css/detail.css">
    <script>
        function confirmDelete() {
            if(confirm('정말 삭제하시겠습니까?')) {
                document.getElementById('deleteForm').submit();
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>학생 상세 정보</h2>
        
        <div class="info-row">
            <span class="label">이름:</span>
            <span>${std.stdName}</span>
        </div>
        
        <div class="info-row">
            <span class="label">나이:</span>
            <span>${std.stdAge}</span>
        </div>
        
        <div class="info-row">
            <span class="label">성별:</span>
            <span>${std.stdGender}</span>
        </div>
        
        <div class="info-row">
            <span class="label">성적:</span>
            <span>${std.stdScore}</span>
        </div>
        
        <div class="button-group">
            <button class="button" id="main">목록으로</button>
            <button class="button" id="update">수정</button>
            <button class="button" id="delete">삭제</button>
        </div>
        
        <!-- 삭제 결과 메시지 출력 -->
        <c:if test="${not empty sessionScope.message}">
		  	<script>
		  		alert("${message}");
		  	</script>
		  	
		  	<%-- message를 한 번만 출력하고 제거 --%>
		  	<c:remove var="message" scope="session" />
		</c:if>
    </div>
    
    <script src="/resources/js/detail.js"></script>
</body>
</html>
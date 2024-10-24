<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 목록</title>
    <style>
        .container {
            width: 66.67%;
            margin: 0 auto;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        .main-title {
            width: 100%;
            text-align: center;
            font-size: 2em;
            margin: 20px 0;
        }
        .total-count {
            font-size: 0.9em;
            color: #666;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
        }
        .student-name {
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
        .student-number {
            font-weight: bold;
        }
        .button-container {
            display: flex;
            justify-content: flex-end;
            margin-top: 20px;
        }
        .add-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .add-button:hover {
            background-color: #45a049;
        }
    </style>
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
                    <th>성적</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${stdList}" var="std" varStatus="vs">
                    <tr>
                        <td class="student-number">${std.stdNo}</td>
                        <td>
                            <a href="studentDetail?id=${student.id}" class="student-name">
                                ${std.stdName}
                            </a>
                        </td>
                        <td>${std.stdScore}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="button-container">
            <button onclick="location.href='addStudent'" class="add-button">
                학생 추가
            </button>
        </div>
    </div>
</body>
</html>
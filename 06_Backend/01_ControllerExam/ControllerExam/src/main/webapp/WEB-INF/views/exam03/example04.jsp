<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--TODO: jstl 표현식 사용을 위한 import --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%-- bootstrap css cdn   --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <%-- TODO: 연습 4) --%>
    <h2>연습 4)</h2>
    <p>${title}</p>
    <p>${color}</p>
    <p>${kind}</p>

    <%-- TODO: if 조건문으로 출력하기 : jstl 표현식, else 없음 --%>
    <%--    사용법 : <c:if test="${조건식}">실행문</c:if> --%>
    <c:if test="${title == '아반떼'}">
        <p>아반떼가 맞습니다.</p>
    </c:if>

    <%-- TODO: choose 조건문으로 출력하기, else 있음 --%>
    <%--    사용법 <c:choose> --%>
    <%--    (if, else if): <c:when test="조건문">실행문</c:when> --%>
    <%--    (else): <c:otherwise>실행문</c:otherwise> --%>
    <%--    </c:choose> --%>
        <c:choose>
        <c:when test="${color == 'grey'}">
            회색입니다.
        </c:when>
        <c:otherwise>
            다른색입니다.
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>

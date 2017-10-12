<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Hi, Welcome to our super-puper secret page!</h1>
<p>Next, you can see the full list of <a href="/showFemales">girls</a> or <a href="/showMales">boys</a></p>
<form:form method="POST" action="/select">
    <p>
    <select name="gender">
        <c:forEach items="${listOfGender}" var="gend">
            <option value="${gend}"> ${gend} </option>
        </c:forEach>
    </select>
    </p>

    <p>
    <select name="age">
        <c:forEach items="${listOfAges}" var="cAge">
            <option value="${cAge}"> ${cAge} </option>
        </c:forEach>
    </select>
    </p>
    <button type="submit">Login</button>
</form:form>
</body>
</html>
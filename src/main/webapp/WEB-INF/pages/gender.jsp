<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Here are all our ${gender}:</h2>
<c:forEach items="${list}" var="user">
    <p>Name: ${user.userName} | Password: ${user.password}</p>
</c:forEach>
<h2>Here are all our ${age}:</h2>
<label>Age</label>
<p>
    <select>
        <c:forEach items="${listByAges}" var="user">
            <option> ${user.userName}|${user.age}</option>
        </c:forEach>
    </select>
</p>
</body>
</html>

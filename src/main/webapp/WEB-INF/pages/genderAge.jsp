<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Here are all our ${gender}-${age}: </h2>
<c:forEach items="${list}" var="user">
    <p>Name: ${user.userName} | Password: ${user.password} | Age: ${user.age} | Gender: ${user.gender}</p>
</c:forEach>

</body>
</html>

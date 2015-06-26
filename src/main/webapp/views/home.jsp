<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
    <a href=<c:url value="/j_spring_security_logout"/>>Logout</a><br/>

    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <h1>Only admin can see this</h1><br/>
        <a href="admin"> Admin Home </a>
    </sec:authorize>

    <sec:authorize ifAnyGranted="ROLE_USER">
        <h1>Only user can see this</h1><br/>
        <%--<a href=<c:url value="/j_spring_security_logout"/>>Logout</a><br/>--%>


        <p>
            <h1> FIO: ${fio} </h1>
        </p>

    </sec:authorize>

    <h1>Welcome, ${username}</h1>
    <p>To string: ${toString}</p>



</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <%--URLs--%>
    <spring:url value="/resources/js/viewFio.js" var="viewFio"/>
    <spring:url value="localhost:8080/QPSec/api/userData/getFio/${username}" var="getUser"/>
    <%--js scripts--%>
    <%--<script src="${viewFio}"></script>--%>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <a href="<c:url value="/j_spring_security_logout"/>"> Logout </a><br/>

    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <h1>Only admin can see this</h1><br/>
        <a href="admin"> Admin Home </a>
    </sec:authorize>

    <sec:authorize ifAnyGranted="ROLE_USER,ROLE_MET">
        <h1>Only user can see this</h1><br/>
        <%--<a href=<c:url value="/j_spring_security_logout"/>>Logout</a><br/>--%>
        <%--<script type="application/javascript" language="JavaScript" >--%>
            <%--getFioFromUserLoginToElementId('${getUser}','getUser');--%>
        <%--</script>--%>

        <input type="button" value="Показать ФИО" class="button"/>

        <p id="getFioUser">
            <%--<div id="getUser"><script>getFioFromUserLoginToString(${getUser});</script></div>--%>
        </p>

    </sec:authorize>

    <h1>Welcome, ${username}</h1>
    <p>To string: ${toString}</p>

<script>
    $(document).ready(function(){
        $('.button').click(function(){
        $.ajax({
            url:${getUser},
            dataType:"text",
            success: function (data){
                var jsonData = $.parseJSON(data);
                $('#getFioUser').html('ФИО пользователя: '+jsonData.fio);
            }
        });
        });
    });
</script>

</body>
</html>
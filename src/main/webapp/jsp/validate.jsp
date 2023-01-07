<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
</head>
<body>

    <form:form action="valid" method="post" modelAttribute="shoppingCart">
        <spring:hasBindErrors name="shoppingCart">
            <c:forEach var="error" items="${errors.allErrors}">
                <b><spring:message message="${error}" /></b>
                <br />
            </c:forEach>
        </spring:hasBindErrors>

        <form:label path="userName">User name: </form:label>
        <form:input type="text" path="userName"/>
        <form:errors path="userName" cssClass="error" />
        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Kostya
  Date: 14.08.2014
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Tester</title>
</head>
<body>
<form:form method="POST" action="${context}/login" commandName="loginForm" >
    <table>
        <tr>
            <td colspan="2" class="errors"><form:errors path="*"/></td>
        </tr>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password"/> </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

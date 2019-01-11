<%@page pageEncoding="UTF-8" isELIgnored="false" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.List" %>
<%@ page import="org.slim3.controller.validator.Errors" %>
<%
Errors errors = (Errors)request.getAttribute("errors");
%>
{
	<%if(errors != null && !errors.isEmpty()) { %>
	"status" : "error"
	,"errorMessage" : "<%=errors.get(0) %>"
	<%}else { %>
	"status" : "success"
	<%} %>
}

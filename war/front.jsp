<%@page pageEncoding="UTF-8" isELIgnored="false" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.List" %>
<%@ page import="com.plucial.mulcms.App" %>
<%@ page import="com.plucial.mulcms.model.res.*" %>
<%
String html =(String) request.getAttribute("pageHtml");
List<Res> textResList = (List<Res>) request.getAttribute("textResList");
%>
<%=html %>
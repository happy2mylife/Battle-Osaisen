<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checked out!</title>
</head>
<body>
<h1>This is Checkedout.jsp.</h1>
<p>client taken generated at server: <s:property value="clientToken" /></p>
<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--
  Version 1.0  2015/06/12  T.Hayashi  Created. Former index.jsp is transfered to purchase.jsp
 --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BattleHack GetStarted teset</title>
</head>
<body>
<h1>Welcome To FREMA</h1>
<center>
<img border="0" src="pic/redPencil.png" width="128" height="128" alt="red pencil" title="red pencil">
<s:form action="purchase">
	<s:submit value="Purchase" />
</s:form>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:rust">
<u><i>Share Price Edit</i></u>
</h1>
<br/>
<form:form method="post" action="company-edit" modelAttribute="companyRecord">
<h2>
Course Id:<form:input type="text" path="companyId" readonly="readonly"/>
<br/><br/>
Company Name:<form:input type="text" path="companyName" readonly="readonly"/>
<br/><br/>
Enter New Share Price:<form:input type="text" path="sharePrice"/>
<br/><br/>
<button type="submit">Submit</button>
<br/><br/>
</h2>
</form:form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">

<h3>
<a href="company-entry">Company Entry</a>
<hr size="5" color="mauve"/>
<h1 style="color:coral">
<u><i>Company Share List</i></u>
</h1>
<br/>
<table border="2">
  <tr>
    <th>Company Id</th>
    <th>Company Name</th>
    <th>Share Price</th>
    <th>Action</th>
    </tr>
    <c:forEach  items="${companyShareList}" var="companyShare">
      <tr>
      <td>${companyShare.companyId}</td>
      <td>${companyShare.companyName}</td>
      <td>${companyShare.sharePrice}</td>
      <td>
      <a href="edit-companyShare/${companyShare.companyId }">Edit Share Price</a> 
      &nbsp;&nbsp;<a href="delete-companyShare/${companyShare.companyId}">Delete Company</a>
      </td>
      </tr>
     </c:forEach>
  </table>
  </h3>

</div>
</body>
</html>
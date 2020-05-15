<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>List of customer</title>
</head>

<body>
 <div id="wrapper">
	 <div id="header">
	 	<h2>CRM-Customer relationship manager</h2>
	 </div>
 </div>
 <div id="container">
 	<div id="content">
 	<table>
 		<tr>
 			<th>FirstName</th>
 			<th>LastName</th>
 			<th>Email</th>
 		</tr>
 		<c:forEach var="tempCustomer" items="${customers}">
 			<tr>
 				<td>${tempCustomer.firstName}</td>
 				<td>${tempCustomer.lastName}</td>
 				<td>${tempCustomer.email}</td>
 			</tr>
 			
 		</c:forEach>
 	
 	</table>
 	
 	</div>
 </div>
</body>
</html>
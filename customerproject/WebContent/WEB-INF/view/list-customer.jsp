<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>List of customer</title>


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>

<body>
 <div id="wrapper">
	 <div id="header">
	 	<h2>CRM-Customer relationship manager</h2>
	 </div>
 </div>
 <div id="container">
 
 	
 	<div id="content">
 	<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false"/>
 	<br><br>
 	<table>
 		<tr>
 			<th>FirstName</th>
 			<th>LastName</th>
 			<th>Email</th>
 			<th>Action</th>
 		</tr>
 		<c:forEach var="tempCustomer" items="${customers}">
 		
 		
 		<!-- Construction an "update" link with customer id-->
 		
 		<c:url var="updatelink" value="/customer/showFormForUpdate">
 			<c:param name="customerId" value="${tempCustomer.id}" />
 		</c:url>
 		
 		<c:url var="deletelink" value="/customer/delete">
 			<c:param name="customerId" value="${tempCustomer.id}" />
 		</c:url>
 			<tr>
 				<td>${tempCustomer.firstName}</td>
 				<td>${tempCustomer.lastName}</td>
 				<td>${tempCustomer.email}</td>
 				<td>
 					<a href="${updatelink}">Update</a> | 
 					<a href="${deletelink}"
 					onclick="if(!(confirm('Are you sure want ot delete this customer?'))) return false">Delete</a>
 				</td>
 			</tr>
 			
 		</c:forEach>
 	
 	</table>
 	
 	</div>
 </div>
</body>
</html>
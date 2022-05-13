<%@page import="com.Notification" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/notifications.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container"><div class="row"><div class="col-6"> 
	<h1>Items Management V10.1</h1>
	
	<form id="formItem" name="formItem" method="post" action="notifications.jsp">
	
	 Notification code: 
	 <input id="notificationCode" name="notificationCode" type="text" 
	 class="form-control form-control-sm">
	 <br> Message: 
	 <input id="message" name="message" type="text" 
	 class="form-control form-control-sm">
	 <br> date: 
	 <input id="date" name="date" type="text" 
	 class="form-control form-control-sm">
	 <br> TimePeriod: 
	 <input id="timePeriod" name="timePeriod" type="text" 
	 class="form-control form-control-sm">
	 <br> Area: 
	 <input id="area" name="area" type="text" 
	 class="form-control form-control-sm">
	 <br> Established By: 
	 <input id="establishedBy" name="establishedBy" type="text" 
	 class="form-control form-control-sm">
	 
	 <input id="btnSave" name="btnSave" type="button" value="Save" 
	 class="btn btn-primary">
	 <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divItemsGrid">
	 <%
	 Notification itemObj = new Notification(); 
	 out.print(itemObj.readNotifications()); 
	 %>
	</div>
	</div> </div> </div> 

</body>
</html>
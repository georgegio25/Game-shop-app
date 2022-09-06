<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="/css/card.css"/>	
	<title>Add Game!</title>
</head>
<body>
<div class="background">

<div class="header">
<div class="header-container">Add game:</div>
</div>

<div class="main"> <!-- =================MAIN========================= -->

<div class="form-container">
<form:form  class="game-forms-container" action="/games/create" method="post"
	modelAttribute="game">
		
	<form:input path="name" placeholder="NAME >>>" />
	
	<form:input path="genre" placeholder="GENRE >>>"/>
	
	<form:textarea path="description" placeholder="DESCRIPTION >>>"/>
	
	
	<div class="button" style="grid-column:1; justify-self: center;"> 
	<input id="input-button" type = "submit" value = "save"/>
	</div>
		
	<div class="errors-container"> 
	<form:errors path = "name" />
	<br>
	<form:errors path = "genre" />
	<br>
	<form:errors path = "description" />
	</div>
	

</form:form>
</div>
</div><!-- ================= END MAIN========================= -->

<div class="footer">
<div class="footer-container">
<a id="btn-dashboard" class="button" href="/home">can cel</a>
</div>
</div>

	


</div> <!-- ================ END BACKGROUND============ -->

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$('.background').mousemove(function(e){
		var moveX = (e.pageX * -1 / 20);
		var moveY = (e.pageY * -1 / 20);
		$(this).css('background-position', moveX+'px '+moveY+'px')
	})
</script>

</body>
</html>
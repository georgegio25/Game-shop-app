<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="/css/card.css"/>	
	<title>Edit Game!</title>
</head>
<body>

<div class="background">
<c:if test="${ game.creator.id != user.id }">
<div class="header">
<div class="header-container">Sorry, only creator can edit the game.
<h5><a href="/home">>>> Go to the main page</a></h5></div>
</div>
</c:if>

<c:if test="${ game.creator.id == user.id }">

<div class="header">
<div class="header-container">Edit Game:</div>
</div>

<div class="main"> <!-- =================MAIN========================= -->



<div class="form-container">
<form:form  class="game-forms-container" action="/games/${ game.id }/update" method="post"
	modelAttribute="game">
	<input type="hidden" name="_method" value="put"> 
	
	<form:input path="name" value="${ game.name }" />
	
	<form:input path="genre" value="${ game.genre }"/>
	
	<form:textarea path="description" value="${ game.description }"/>
	
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

</c:if>	


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
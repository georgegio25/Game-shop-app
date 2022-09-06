<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/card.css"/>
	<meta charset="ISO-8859-1">
 	<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- #1 of 3 BOOTSTRAP  -->
	<title>Dashboard</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> <!-- #2 of 3 3BOOTSTRAP  -->
</head>
<body>
<div class="background"> <!-- MAin screen size container with background picture! -->

<div class="header" >
<div class="header-container">
<h3>Welcome to the Game Shop, 
<c:if test="${ user.userName == null }">
dear Guest!

<div class="intro">
<p>You're visiting my demo web-application for game lovers developed using programming language "Java", technologies "Spring Boot", "JavaScript", "jQuery" and "SQL".
I also created and added completely unique CSS styling for better user's experience.</p><p>
Please, register on this web site to experience its whole functionality and be able to add and edit your own games.
 </p><p>Please, take a minute to complete a feedback form, I'll be happy to hear any feedback from you. 
Thank you!</p> 
<p>George Grigolaya, Full-stack Software Developer.
</p>

<button id="btn-feedback" onclick="openForm()">feedback form</button>

<div class="hidden" id="feedbackForm">
  <form action="mailto:geo51015@gmail.com" method="post" enctype="text/plain">
<br>Your Name:<br>
<input type="text" name="name"><br>
Your E-mail:<br>
<input type="text" name="mail"><br>
Comment:<br>
<textarea rows="4" cols="50" name="comment"></textarea> 


<br><br>
<input type="submit" value="Send">
</form>
</div>
</div>
</c:if>

<c:if test="${ user.userName != null }">
<c:out value="${ user.userName }" />!
</c:if>
</h3>



<h1>Available games:</h1>
</div>
</div> <!-- ======================= END header ================================ -->

<div class="main">
<div class="table-main">

<c:forEach var="game" items="${ games }" >
<a class="table-cell" href="/games/${game.id}">
<h2><c:out value="${game.name}"/></h2>
<h5 id="game-genre">"<c:out value="${game.genre}"/>"</h5>
</a>
</c:forEach>

</div> <!-- TABLE ENDS -->

</div><!-- ======================= END main ================================ -->
<div class="footer" style="position:fixed; bottom: 0; justify-self: center; margin-bottom: 20px;">
<div class="footer-container">

<!-- 


-->

<c:if test="${ user.userName == null }">
<a id="btn-addnew" class="button" href="/register">re gist er</a>
</c:if>


<c:if test="${ user.userName != null }">
<a id="btn-addnew" class="button" href="/games/new">add new</a>
<a id="btn-logout" class="button" href="/logout">log out</a>
</c:if>




</div>
</div>

</div> <!-- <<<<<<<< END BACKGROUND -->


<!-- <<<<<<<< FEEDBACK FORM SCRIPT -->
<!-- Don't forget to add link to jQuery in order to make it work!!! -->
<script src="https://code.jquery.com/jquery-3.5.0.js"></script> <!-- jQuery to make my animation work! -->
<script type="text/javascript">
$('#btn-feedback').click(function() {
	//$('.three, .four').addClass('disappear');
	$('#feedbackForm').toggleClass('hidden');
});
</script>

<!-- <<<<<<<< END FEEDBACK FORM SCRIPT-->

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
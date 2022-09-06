<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="/css/main.css"/>	
	<title>Welcome!</title>
</head>
<div class="background">


<div  id="register" class="wrappercont ">
<div class="title">Welcome to Game Shop!</div>

<div class="form-container">
<form:form  class="wrapper" action = "/register/go" method = "post" modelAttribute = "newUser" >
	<div class="one">
		<h1>Register:</h1>
	</div>
	<div class="two">		
		<form:input type = "text" path = "userName" class="form-control" id="floatingInput" placeholder="USERNAME >>>"/>
	</div>
	<div class="three">
		<form:input type = "text" path = "email" id="floatingInput" class="form-control" placeholder="EMAIL >>>"/>
	</div>
	<div class="four">
		<form:input type = "password" path = "password" class="form-control" placeholder="PASSWORD >>>"/>
	</div>
	<div class="five">
		<form:input type = "password" path = "confirmPassword" class="form-control" placeholder="CONFIRM PASSWORD >>>"/>
	</div>	
	<div class="six">
	<input id="go-button" type = "submit" value = "GO"/>	
	</div>
	
	<h2 class="eight"><a href="/signin/" style="text-decoration: none !important; color:#99004D !important;">or Sign-in</a></h2>

	<div class="errors-container"> <!-- xyz -->
	<form:errors class="errors" path = "userName" />
	<br>
	<form:errors class="errors" path = "email" />
	<br>
	<form:errors class="errors" path = "password" />
	<br>
	<form:errors class="errors" path = "confirmPassword" />
	</div>
</form:form>
</div>
</div>
</div>

<!-- CONSOLE EFFECT ============================================ -->

<!-- END CONSOLE EFFECT ============================================ -->

  

<!-- Don't forget to add link to jQuery in order to make it work!!! -->
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
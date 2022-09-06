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
<body>
<div class="background">


<div id="sign-in" class="wrappercont">
<div class="title">Welcome to Game Shop!</div>

<div  class="form-container">
<form:form  class="wrapper" action = "/login" method = "post" modelAttribute = "newLogin" >
	<div class="one">
		<h1>Sign-in:</h1>
	</div>
	<div class="two"></div>
	<div class="three" >
		<form:input type = "text" path = "email" id="floatingInput" class="form-control" placeholder="EMAIL >>>"/>
	</div>
	<div class="four">
		<form:input type = "password" path = "password" class="form-control" placeholder="PASSWORD >>>"/>
	</div>
	<div class="five"></div>		
	<div class="six">
	<input id="go-button" type = "submit" value = "GO"/>	
	</div>
<h2 class="eight" ><a href="/register/" style="text-decoration: none !important; color:#99004D !important;">or Register</a></h2>
	
	
	<div class="errors-container"> 
	<form:errors class="errors" path = "email" />
	<br>
	<form:errors class="errors" path = "password" />
	</div>
	

</form:form>
</div>

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
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
<link rel="stylesheet" href="/css/card.css"/>	

<title><c:out value="${ game.name }" /></title>
</head>
<body>
<div class="background"> 

<div class="header">
<div class="header-container"><c:out value="${ game.name }" /></div>
</div>



<div class="main">
<div class="card">


<table>
  <tr>
    <th>NAME:</th>
    <td><c:out value="${ game.name }" /></td>
  </tr>
  <tr>
    <th>ADDED BY:</th>
    <td><c:out value="${ game.creator.userName }" /></td>
  </tr>
  <tr>
    <th>DESCRIPTION:</th>
    <td><c:out value="${ game.description }" /></td>
  </tr>
</table>


</div> <!-- END card -->
</div> <!-- END main -->

<div class="footer">
<div class="footer-container">
<a id="btn-dashboard" class="button" href="/home">dshbrd</a>

<c:if test="${ game.creator.id == user.id }">
<a id="btn-edit" class="button" href="/games/${ game.id }/edit">edit</a>

<form class="button" action="/games/${game.id}" method="post"> <!-- By some reasons delete input doesn't take "button" CSS and gets smaller than all other buttons, so we have to give class ".button" to the parent form and write its own CSS purposely for delete input -->
    <input type="hidden" name="_method" value="delete" />
    <input id="input-button" type="submit" value="DEL"/>    
   
</form>
</c:if>

</div> <!-- END footer-container -->
</div> <!-- END footer -->

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
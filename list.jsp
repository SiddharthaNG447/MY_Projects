 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
            <h1> List of Registrations</h1>
           </div>
           <script>
           function Edit()
           {
        	   rn = window.prompt("Input the Row number(0,1,2)", "0");
        	   cn = window.prompt("Input the Column number(0,1)","0");
        	   content = window.prompt("Input the Cell content");  
        	   var x=document.getElementById('myTable').rows[parseInt(rn,10)].cells;
        	   x[parseInt(cn,10)].innerHTML=content;
        	   }
           }
           
           
           
           </script>
           
           
           
    </body>
    <a href="/des/listhome"  method="get"><button>Home(Click Here to go to home page)</button></a><br/><br/>
   
    
    
    
     <c:if test="${not empty lists}">
	<table id="myTable" border="2">
	<th>Name</th>
	        	<th>Gender</th>
	        <c:forEach items="${lists}" var="user">
			    <tr>
			      <td><c:out value="${user.nm}" /></td>
			      <td><c:out value="${user.gender}" /></td>
			      <td><a href="/des/checkout?selectedrecord=${user.nm}" method="get"/>Delete</a ></td>
			      <td><input type="button" onclick="Edit()" value="Edit"></td>
            </tr>
            </tr>
			    </tr>
			  </c:forEach>
	</table>
	</c:if>
</html>      








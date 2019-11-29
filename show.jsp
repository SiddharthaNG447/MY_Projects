<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
  <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url ="jdbc:mysql://localhost/springs"
    user="root" password="root"/>
    
    <sql:query dataSource="${snapshot}" var="result">
    SELECT * from firstsp;
   </sql:query>
    <table>
    
    <tr>
    
    <th>Name</th>
    <th>Gender</th>
    
    </tr>
    
    <c : forEach var="row" items="${result.rows}" >
    
    <tr>
    <td><c:out value="${row.name}" /></td>
    <td><c:out value="${row.gender}" /></td>
    
    </tr>
    </c :forEach>
    </table>
 
</body>
</html>
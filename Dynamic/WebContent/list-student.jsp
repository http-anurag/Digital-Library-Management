<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>Student Tracker</title>

<link type="text/css" rel="stylesheet" href="css/style.css"></link>
</head>

<body>
<div id="wrapper">
   <div id="header">
   <h2>SCHOOL OF COMPUTER IPS ACADEMY INDORE</h2>
   </div>
</div>
<div id="container">
    <div id="content">
    
    <input type="button" value="Add Student" onclick="window.location.href='add-student-form.jsp';return false;"
       class="add-student-button"/>   
    <table>
    <thead>
    <tr>
    <th>Student Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="temp" items="${STUDENT_LIST}">
        <c:url var="tempLink" value="StudentControllerServlet">
        <c:param name="command" value="LOAD"/>
        <c:param name="studentId" value="${temp.id}"/>        
        </c:url>
        <c:url var="delLink" value="StudentControllerServlet">
        <c:param name="command" value="DELETE"/>
        <c:param name="studentId" value="${temp.id}"/>        
        </c:url>
        <c:url var="get" value="StudentControllerServlet">
        <c:param name="command" value="Page"/>
        <c:param name="studentId" value="${temp.id}"/>        
        </c:url>
    	<tr>
    	<td>${temp.id}</td>
    	<td>${temp.firstName}</td>
        <td>${temp.lastName}</td>
        <td>${temp.email}</td>
        <td><a href="${tempLink}">Update</a>|<a href="${delLink}" onclick="if(!(confirm'(Are yiu Sure you want to delete this Student?')))return false">Delete</a>|<a href="${get}">Get</a></td>
    	</tr>
   </c:forEach>
   </tbody>
    </table>
    </div>
</div>
 <div style="clear : both;">
  <p> <a href="login-page.jsp">Back to Home</a></p>
</div>
</body>

</html>
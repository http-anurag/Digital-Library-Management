<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Student</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
<link  type="text/css" rel="stylesheet" href="css/add-student-style.css">

</head>
<body>
<div id="wraper">

<div id="header">
<h2> School Of Computer <br>I P S Academy Indore </h2>
</div>
</div>
<div id="container">
  <h3> Student Profile</h3>
  <form action="StudentControllerServlet" method="GET" value="PAGE">
 
    <c:forEach var="temp" items="${STUDENT_LIST}">
    	Student Id:MCA2024IPSSOC00${temp.id}
        First Name:${temp.firstName}
        Last Name:${temp.lastName}
        Email:${temp.email}
        Total Allocated Book: ${temp.a_book}    	
        <hr>
   </c:forEach>
  </form>
  <div style="clear : both;"></div>
  <p> <a href="StudentControllerServlet">Back to List</a></p>
</div>

</body>
</html>
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
  <h3>Update Student</h3>
  <form action="StudentControllerServlet" method="GET">
  <input type="hidden" name="command" value="UPDATE"/>
  <input type="hidden" name="studentId" value="${THE_STUDENT.id}"/>
  <table>
     <tbody>
     <tr>
     <td><label>First name:</label></td>
     <td><input type="text" name="firstName"  value="${THE_STUDENT.firstName}" required /></td>
     </tr>
     <tr>
     <td><label>Last name:</label></td>
     <td><input type="text" name="lastName" value="${THE_STUDENT.lastName}" required /></td>
     </tr>
     <tr>
     <td><label>Email:</label></td>
     <td><input type="text" name="email" value="${THE_STUDENT.email}" required/></td>
     </tr>
     <tr>
     <td><label></label></td>
     <td><input type="submit" name="save" value="Save"/></td>
     </tr>
     </tbody>
  </table>
  </form>
  <div style="clear : both;"></div>
  <p> <a href="StudentControllerServlet">Back to List</a></p>
</div>

</body>
</html>
<html>
<head>
<title>Add Student</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
<link  type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
<div id="wraper">

<div id="header">
<h2>School Of Computer I P S Academy Indore</h2>
</div>
</div>
<div id="container">
  <h3>Add Student</h3>
  <form action="StudentControllerServlet" method="GET">
  <input type="hidden" name="command" value="ADD"/>
  <table>
     <tbody>
     <tr>
     <td><label>First name:</label></td>
     <td><input type="text" name="firstName" required /></td>
     </tr>
     <tr>
     <td><label>Last name:</label></td>
     <td><input type="text" name="lastName" required /></td>
     </tr>
     <tr>
     <td><label>Email:</label></td>
     <td><input type="text" name="email" required/></td>
     </tr>
     <tr>
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
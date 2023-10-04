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
    <input type="button" name="{param.username}"value="Request Book" onclick="window.location.href='request-book.jsp';return false;"
       class="add-student-button"/>        
    <table>
    <thead>
    <tr>
    <th>Student Id: MCA2024IPSSOC00${param.username}</th>
    <th>          Your Email:${Student.getEmail()}  </th>
    </tr>
    <tr>
    <th>Name: ${param.password} ${Student.getLastName()}</th>
    <th>Alloted Book: ${Student.getA_book()}</th>
    <th></th>
    
    </tr>
    </thead>
      </table>
    </div>
</div>
 <div style="clear : both;">
  <p> <a href="login-page.jsp">Back to Home</a></p>
</div>
</body>

</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="styles.css">
    <style>
    body {
    font-family: Arial, sans-serif;

}
.login{
display:flex;}
.login-container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 5px;
}

input[type="text"],
input[type="password"] {
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
    </style>
</head>
<body>
<div class="login">
    <div class="login-container">
        <h1>Admin Login</h1>
        <form id="login-form" action="AdminLogin" method="Post">
            <label for="username1">Username:</label>
            <input type="text" id="username1" name="username" required>
            <label for="password1">Password:</label>
            <input type="password" id="password1" name="password" required>
            <button type="submit">Login</button>
        </form>
    </div>
   
    <div class="login-container">
        <h1>Student Login</h1>
        <form id="login-form" action="LoginServlet" method="Post">
            <label for="usernames">Username:</label>
            <input type="text" id="usernames" name="username" required>
            <label for="passwords">Password:</label>
            <input type="password" id="passwords" name="password" required>
            <button type="submit">Login</button>
        </form>
    </div>
 </div>
    <script src="script.js"></script>
</body>
</html>

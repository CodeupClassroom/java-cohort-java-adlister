<%--
  Created by IntelliJ IDEA.
  User: kennethhowell
  Date: 1/3/23
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tell Me About A Cookie</h1>
<form action="/cookies/submit" method="post">
    <label for="name">What cookie do you like?</label>
    <input name="name" id="name" type="text">

    <br />
    <input type="submit">
</form>
</body>
</html>

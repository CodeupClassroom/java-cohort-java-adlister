<%--
  Created by IntelliJ IDEA.
  User: kennethhowell
  Date: 1/3/23
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>You Told Me About A Cookie</title>
</head>
<body>
<h1>Here's the cookie you told me about that is in the session:</h1>
<h5>${viewCookie} is what is stored in the session as your cookie :)</h5>
</body>
</html>

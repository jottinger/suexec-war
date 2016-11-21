<%@ page import="com.autumncode.suexec.ejb.MyEJB" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! @EJB MyEJB injectedEJB; %>
<%
    Context ctx=new InitialContext();
    MyEJB jndiEJB= (MyEJB) ctx.lookup("java:module/MyEJB");
%>
<html>
<head>
    <title>This is a test</title>
</head>
<body>
This is a test JSP file.

<p>The injected EJB ref: <%= injectedEJB %></p>

<p>The looked up EJB ref: <%= jndiEJB %></p>

<p>Calling the looked up ref:<span id="greeting"><%= jndiEJB.greet() %></span></p>

<p>The time is: <%= new Date() %></p>
</body>
</html>

<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wilder
  Date: 25/04/18
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class=="container">
    <h2>Githubers Table</h2>
<table class="table table-bordered table-striped">
    <thead>
         <tr>
             <th>ID</th>
             <th>Name</th>
             <th>Email</th>
             <th>Login</th>
             <th>Avatar</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGithuber}" var="githuber">
        <tr>
            <td><c:out value="${githuber.id}" /></td>
            <td><c:out value="${githuber.name}" /></td>
            <td><c:out value="${githuber.email}" /></td>
            <td><c:out value="${githuber.login}" /></td>
            <td><img src="<c:out value="${githuber.avatar_url}"/>" alt="icone" /></td>
            <td><form action="/GithubTracker2/untrack" method="post">
                <input type="hidden" name="loginGit" value="${githuber.login}">
                <button type="submit" name="delete" id="delete" >Delete</button><br>
            </form></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>
</body>
</html>

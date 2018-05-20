<%--
  Created by IntelliJ IDEA.
  User: wilder
  Date: 30/04/18
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

<form action="/GithubTracker2/track" method="post">
    <fieldset>
        <legend>Login information :</legend>
        <label for="login">Login :</label><br>
        <input type="text" name="login" id="login" placeholder="login..."/><br>

        <input type="submit" value="Submit"/>
    </fieldset>
</form>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-12">

  <jsp:include page="/WEB-INF/global/errors.jsp" />
  <div class="col-4">&nbsp;</div>
  <div class="col-4">
    <form method="POST">
      <fieldset>
        <legend>Login Form</legend>
        <label for="username">Username</label>
        <input type="text" name="username" id="username">
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
        <button type="submit">Sign in</button>
      </fieldset>
    </form>
  </div>
</div>

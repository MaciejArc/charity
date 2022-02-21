<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header-mini.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>
   <form method="post">
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>
            <p>${error}</p>

        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Edytuj</button>
        </div>
    </form>
</section>

<%@ include file="footer.jsp" %>
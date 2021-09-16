<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header-mini.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user">
        <div class="form-group">
            <form:input path="firstName" placeholder="Imie"/>
            <form:errors path="firstName"/>
        </div>
        <div class="form-group">
            <form:input path="lastName" placeholder="Nazwisko"/>
            <form:errors path="lastName"/>
        </div>
        <div class="form-group">
            <form:input path="email" placeholder="Email"/>
            <form:errors path="email"/>
            <p>${error}</p>
        </div>
        <div class="form-group">
            <form:password path="password" name="password" placeholder="Hasło"/>
            <form:errors path="password"/>

        </div>
        <%--        <div class="form-group">--%>
        <%--          <input type="password" name="password2" placeholder="Powtórz hasło" />--%>
        <%--        </div>--%>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>

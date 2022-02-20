<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">

    <div class="card shadow mb-4">
        <!-- Card Header - Dropdown -->
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
        </div>
        <!-- Card Body -->
        <div class="card-body">
            <form:form modelAttribute="user">
                <label>
                    Imię<br>
                    <form:input path="firstName"/><form:errors path="firstName"/>
                </label>
                <br>

                <label>
                    Nazwisko<br>
                    <form:input path="lastName"/><form:errors path="lastName"/>
                </label>
                <br>
                <label>
                    Email<br>
                    <form:input path="email"/><form:errors path="email"/>
                </label>
                <br>
                <label>
                    Hasło<br>
                    <form:password path="password"/><form:errors path="password"/>
                </label>
                <br>
                <button type="submit">Wyślij</button>

            </form:form>
        </div>
    </div>

</div>
</div>
<%@ include file="footer.jsp" %>
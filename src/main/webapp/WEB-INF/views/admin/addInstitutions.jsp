<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">

    <div class="card shadow mb-4">
        <!-- Card Header - Dropdown -->
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">Dodaj instytucje</h6>
        </div>
        <!-- Card Body -->
        <div class="card-body">
            <form:form modelAttribute="institution">
                <label>
                    Nazwa instytucji<br>
                    <form:input path="name"/><form:errors path="name"/>
                </label>
                <br>

                <label>
                    Opis instytucji<br>
                    <form:input path="description"/><form:errors path="description"/>
                </label>
                <br>
                <button type="submit">Wyślij</button>

            </form:form>
        </div>
    </div>

</div>
</div>
<%@ include file="footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Lista instytucji</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Instytucje:</h6>
            <p><a href="footer.jsp">Dodaj nową instytucje</a> </p>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nazwa</th>
                        <th>Opis</th>
                        <th>Akcja</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${institutionList}" var="institution">
                        <tr>
                            <td>${institution.id}</td>
                            <td>${institution.name}</td>
                            <td>${institution.description}</td>
                            <td><a href="http://localhost:8080/admin/deleteInstitution?id=${institution.id}">Usuń</a>
                                <a href="http://localhost:8080/admin/addInstitution?id=${institution.id}">Edytuj</a>
                            </td>
                        </tr>


                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</div>


<%@ include file="footer.jsp" %>
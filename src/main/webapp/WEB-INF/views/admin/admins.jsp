<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Lista administratorów</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Administratorzy:</h6>
            <p><a href="http://localhost:8080/admin/addAdmin">Dodaj nowego administratora</a> </p>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>Email</th>
                        <th>Akcja</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${adminsList}" var="admin">
                        <tr>
                            <td>${admin.id}</td>
                            <td>${admin.firstName}</td>
                            <td>${admin.lastName}</td>
                            <td>${admin.email}</td>
                            <td><a href="http://localhost:8080/admin/deleteUser?id=${admin.id}">Usuń</a>
                                <a href="http://localhost:8080/admin/editUser?id=${admin.id}">Edytuj</a>
                                <a href="http://localhost:8080/admin/lockUser?id=${admin.id}">Zablokuj</a>
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
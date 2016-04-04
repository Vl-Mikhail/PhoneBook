<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Home Page</title>
  <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body>
<div class="container">
  <h1 style="text-align: center">Телефонный справочник</h1>
  <table border="1" class="table table-striped">
    <tr>
      <td>Номер</td>
      <td>Имя</td>
      <td>Фамилия</td>
      <td>Отчество</td>
      <td>Город</td>
      <td>Улица</td>
      <td>Дата рождения</td>
      <td>Номер телефона</td>
      <td>Действия</td>
    </tr>
    <c:forEach items="${clients}" var="client">
      <tr>
        <td>${client.uid}</td>
        <td>${client.firstname}</td>
        <td>${client.lastname}</td>
        <td>${client.middlename}</td>
        <td>${client.city.city}</td>
        <td>${client.street.street}</td>
        <td>${client.bithday}</td>
        <td>${client.phonenum}</td>
        <td>
          <a href="<c:url value="/delete?id=${client.uid}"/>">
            <input type="submit" value="Удалить" >
          </a>
          <a href='<c:url value="/edit?id=${client.uid}"/>'>
            <input type="submit" value="Редактировать">
          </a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <form class="form-horizontal" action="/add" method="get">
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success">Добавить Клиента</button>
      </div>
    </div>
  </form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="../js/bootstrap.min.js"></script>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit Client</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.min.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/js/jquery-ui.css"/>">
    <script src="<c:url value="/js/jquery-ui.js"/>"></script>
    <script type="text/javascript">
        $(function() {
            $("#bithday").datepicker();
        });

        function loadStreets() {
            $.ajax('<c:url value="streets"/>?id=' + $("#city option:selected").val(), {
                method : 'get',
                success: function(values) {
                    var data = jQuery.parseJSON(values);i
                    var options = "";
                    var size = data.length;
                    $('#streets').html("");
                    for (var i=0;i!=size;++i) {
                        if ('${client.street.uid}' == data[i].uid) {
                            options += "<option selected value='" + data[i].uid + "'>" + data[i].street + "</option>";
                        } else {
                            options += "<option value='" + data[i].uid + "'>"+data[i].street+"</option>"
                        }
                    }
                    $('#streets').html(options);
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <h1 style="margin-bottom: 40px">Редактирование данных клиента</h1>
    <form class="form-horizontal" action="<c:url value="/edit"/>" method="post">
        <input type="hidden" name="uid" class="form-control" id="id" value="${client.uid}">
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">Имя</label>
            <div class="col-sm-2">
                <input type="text" name="firstname" class="form-control" id="firstname" value="${client.firstname}">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">Фамилия</label>
            <div class="col-sm-2">
                <input type="text" name="lastname" class="form-control" id="lastname" value="${client.lastname}">
            </div>
        </div>
        <div class="form-group">
            <label for="middlename" class="col-sm-2 control-label">Отчество</label>
            <div class="col-sm-2">
                <input type="text" name="middlename" class="form-control" id="middlename" value="${client.middlename}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Город</label>
            <div class="col-sm-2">
                <select name="cityId" id="city" class="form-control">
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.uid}" ${client.city.uid == city.uid ? 'selected' : ''}>${city.city}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Улица</label>
            <div class="col-sm-2">
                <select name="streetId" id="streets" class="form-control">
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="bithday" class="col-sm-2 control-label">Дата Рождения</label>
            <div class="col-sm-2">
                <input type="text" name="bithday" id="bithday" class="form-control" value="${client.bithdayValue}">
            </div>
        </div>
        <div class="form-group">
            <label for="tel" class="col-sm-2 control-label">Телефон</label>
            <div class="col-sm-2">
                <input type="tel" name="phonenum" class="form-control" id="tel" value="${client.phonenum}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Изменить</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-success" onclick="history.back()">Назад</button>
            </div>
        </div>
    </form>
</div>
<script>
    loadStreets();
</script>

</body>
</html>


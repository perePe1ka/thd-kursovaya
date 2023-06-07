
<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Специальности</title>
    <link rel="stylesheet" href="../static/tables.css">
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
</head>
<body>
<div id="container">
    <div class="burger-menu">
        <input id="menu-toggle" type="checkbox" onclick="document.getElementById('uploadForm').style.display='block'" />
        <label class="menu-btn" for="menu-toggle">
            <span></span>
        </label>
        <ul class="menubox">
            <li><a class="menubox_ref" href="/">На главную</a></li>
            <li><a class="menubox_ref" href="/teachers">Преподаватели</a></li>
            <li><a class="menubox_ref" href="/speciality">Специальности</a></li>
            <li><a class="menubox_ref" href="/planOfWork">Планируемая работа</a></li>
            <li><a class="menubox_ref" href="/literature">Методическая литература</a></li>
            <li><a class="menubox_ref" href="/discipline">Дисциплины</a></li>
            <li><a class="menubox_ref" href="/departaments">Кафедры</a></li>
        </ul>
    </div>
    <div id="content">
        <div class="header_text">
            <h1>Специальности</h1>
        </div>
        <div class="header">
            <h2>Специальности</h2>
            <button class="add-button" onclick="openForm()">Добавить специльность</button>
        </div>


        <#if listSpeciality ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Дисциплина</th>
                <th>Удалить</th>
                </thead>
                <tbody>
                <#list listSpeciality as speciality>
                    <tr>
                        <td>${speciality.id}</td>
                        <td>${speciality.name}</td>
                        <td>
                            <#list speciality.discipline as discipline> <!-- Итерация по множеству кафедр -->
                                ${discipline.name}<br> <!-- Получение имени каждой кафедры -->
                            </#list>
                        </td>
                        <td><a href="paper/delete/${speciality.id}">Удалить</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </#if>


    </div>
</div>
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeForm()">&times;</span>
        <h2>Добавить специальность</h2>
        <form th:action="@{/artist/create}" method="POST">
            <table>
                <tr>
                    <td>Название  спецальности:</td>
                    <td><input type="text" name="fullName"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Сохранить</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script>
    function openForm() {
        document.getElementById("myModal").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myModal").style.display = "none";
    }
</script>
</body>
</html>
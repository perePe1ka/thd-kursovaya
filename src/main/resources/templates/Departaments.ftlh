
<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Преподаватели</title>
    <link rel="stylesheet" href="../static/tables.css">
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
</head>
<body>
<div id="container">
    <div class="burger-menu">
        <input id="menu-toggle" type="checkbox" onclick="" />
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
            <h1>Кафедры</h1>
        </div>
        <div class="header">
            <h2>Преводаватели</h2>
            <button class="add-button" onclick="openForm()">Добавить преподавателя</button>
        </div>



        <#if listDepartaments ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Преподаватели</th>
                <th>Литература</th>
                <th>Удалить</th>
                </thead>
                <tbody>
                <#list listDepartaments as departament>
                    <tr>
                        <td>${departament.id}</td>
                        <td>${departament.name}</td>
                        <td>
                        <#list departament.teachers as teachers> <!-- Итерация по множеству кафедр -->
                            ${teachers.fullName}<br> <!-- Получение имени каждой кафедры -->
                        </#list>
                        </td>
                            <td>
                                <#list departament.literature as literature> <!-- Итерация по множеству кафедр -->
                                    ${literature.name}<br> <!-- Получение имени каждой кафедры -->
                                </#list>
                            </td>
                        <td><a href="paper/delete/${departament.id}">Удалить</a></td>
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
        <h2>Добавить преподавателя</h2>
        <form th:action="@{/artist/create}" method="POST">
            <table>
                <tr>
                    <td>Имя преподавателя:</td>
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

<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Дисциплины</title>
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
            <h1>Дисциплины</h1>
        </div>
        <div class="header">

            <button class="add-button" onclick="openForm()">Добавить дисциплину</button>
        </div>




        <#if listDiscipline ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Вид занятий</th>
                <th>Специальность</th>
                <th>Преподаватель</th>
                <th>Удалить</th>
                <th>Изменить</th>
                </thead>
                <tbody>
                <#list listDiscipline as discipline>
                    <tr>
                        <td>${discipline.id}</td>
                        <td>${discipline.name}</td>
                        <td>${discipline.class_type}</td>
                        <td>
                            <#list discipline.speciality as speciality> <!-- Итерация по множеству кафедр -->
                                ${speciality.name}<br> <!-- Получение имени каждой кафедры -->
                            </#list>
                        </td>
                        <td>
                            <#list discipline.teachers as teacher> <!-- Итерация по множеству кафедр -->
                                ${teacher.fullName}<br> <!-- Получение имени каждой кафедры -->
                            </#list>
                        </td>
                        <td>
                            <form action="/discipline/delete/${discipline.id}" method="post">
                                <input type="submit" value="Удалить"/>
                            </form>
                        </td>
                        <td>
                            <div>
                                <button class="add-button" onclick="openEditForm()">Изменить</button>
                            </div>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </#if>





    </div>
</div>
<div id="myEditModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeEditForm()">&times;</span>
        <h2>Изменить</h2>

        <form action="/createDepartaments" method="post">

            <table>
                <tr>
                    <td>Название дисциплины:</td>
                    <td>
                        <input type="text" name="name"/>
                        <input type="text" name="teacher"/>
                        <input type="text" name="literatures"/>
                    </td>
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
    function openEditForm() {
        document.getElementById("myEditModal").style.display = "block";
    }

    function closeEditForm() {
        document.getElementById("myEditModal").style.display = "none";
    }
</script>
</body>
</html>
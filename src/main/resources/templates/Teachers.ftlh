<!DOCTYPE html>
<html lang="" xmlns:th="<http://www.thymeleaf.org>">
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
            <h1>Преподаватели</h1>
        </div>
        <div class="header">
            <button class="add-button" onclick="openForm()">Добавить преподавателя</button>
        </div>


        <#if listTeachers ??>
            <table>
                <thead>
                <th>ID</th>
                <th>ФИО</th>
                <th>Кафедра</th>
                <th>Дисциплина</th>
                <th>Планируемая работа</th>
                <th>Удалить</th>
                </thead>
                <tbody>
                <#list listTeachers as teacher>
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.fullName}</td>
                        <td>
                            <#list teacher.departaments as department> <!-- Итерация по множеству кафедр -->
                                ${department.name}<br> <!-- Получение имени каждой кафедры -->
                            </#list>
                        </td>
                        <td>
                            <#list teacher.discipline as discipline> <!-- Итерация по множеству кафедр -->
                                ${discipline.name}<br> <!-- Получение имени каждой кафедры -->
                            </#list>
                        </td>
                        <td>
                        <#if teacher.planOfWork??>

                                ${teacher.planOfWork.deadline},
                                ${teacher.planOfWork.name},
                                ${teacher.planOfWork.workload}.

                        <#else>
                            <!-- Handle the case when teacher.planOfWork is null or missing -->
                            No plan of work available
                        </#if>
                        </td>

                        <td><form action="/teacher/delete/${teacher.id}" method="post">
                                <input type="submit" value="Удалить"/>
                            </form>
                        </td>
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
        <form action="/createTeachers" method="post">

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
</div>
</body>
</html>

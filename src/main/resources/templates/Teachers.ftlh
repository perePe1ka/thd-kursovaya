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
            <h1>Преподаватели</h1>
        </div>
        <div class="header">
            <input type="text" id="searchInput" placeholder="Поиск по ФИО" onkeyup="searchTable()" />
            <button class="add-button" onclick="openForm()">Добавить преподавателя</button>
        </div>

        <#if listTeachers ??>
            <table>
                <thead>
                <th>ID</th>
                <th>ФИО</th>
                <th>Принадлежит кафедре</th>
                <th>Ведет дисциплину</th>
                <th>Имеет работу</th>
                <th>Удалить</th>
                <th>Изменить</th>
                </thead>
                <tbody>
                <#list listTeachers as teacher>
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.fullName}</td>
                        <td>
                            <#list teacher.departaments as department>
                                ${department.name}<br>
                            </#list>
                        </td>
                        <td>
                            <#list teacher.discipline as discipline>
                                ${discipline.name}<br>
                            </#list>
                        </td>
                        <td>
                            <#if teacher.planOfWork??>

                                ${teacher.planOfWork.deadline},
                                ${teacher.planOfWork.name},
                                ${teacher.planOfWork.workload}.

                            <#else>
                                No plan of work available
                            </#if>
                        </td>

                        <td>
                            <form action="/teacher/delete/${teacher.id}" method="post">
                                <input type="submit" value="Удалить"/>
                            </form>
                        </td>
                        <td>
                            <div>
                                <button class="add-button" onclick="openEditForm(${teacher.id})">Изменить</button>
                            </div>
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
                    <td>Введите данные:</td>
                    <td><input type="text" name="fullName" placeholder="ФИО"/></td>
                    <td><input type="text" name="planOfWork" placeholder="План работы(цифра)"/></td>
                    <td><input type="text" name="departaments" placeholder="Кафедра(цифра)"/></td>
                    <td><input type="text" name="discipline" placeholder="Дисциплина(цифра)"/></td>
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

<#list listTeachers as teacher>
    <div id="myEditModal-${teacher.id}" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeEditForm(${teacher.id})">&times;</span>
            <h2>Изменить преподавателя</h2>
            <form action="/teachers/edit/${teacher.id}" method="post">
                <table>
                    <tr>
                        <td>Измените данные:</td>
                        <td><input type="text" name="fullName" placeholder="ФИО"/></td>
                        <td><input type="text" name="planOfWork" placeholder="План работы(цифра)"/></td>
                        <td><input type="text" name="departaments" placeholder="Кафедра(цифра)"/></td>
                        <td><input type="text" name="discipline" placeholder="Дисциплина(цифра)"/></td>
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
</#list>

<script>
    function openForm() {
        document.getElementById("myModal").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myModal").style.display = "none";
    }

    function openEditForm(teacherId) {
        var modalId = "myEditModal-" + teacherId;
        document.getElementById(modalId).style.display = "block";
    }

    function closeEditForm(teacherId) {
        var modalId = "myEditModal-" + teacherId;
        document.getElementById(modalId).style.display = "none";
    }

    function sortTable() {
        var table = document.querySelector("table");
        var rows = Array.from(table.querySelectorAll("tbody tr"));

        rows.sort(function (a, b) {
            var idA = parseInt(a.querySelector("td").textContent);
            var idB = parseInt(b.querySelector("td").textContent);
            return idA - idB;
        });

        var tbody = table.querySelector("tbody");
        rows.forEach(function (row) {
            tbody.appendChild(row);
        });
    }
    window.addEventListener("DOMContentLoaded", sortTable);

    function searchTable() {
        var input = document.getElementById("searchInput");
        var filter = input.value.toUpperCase();
        var table = document.querySelector("table");
        var rows = table.querySelectorAll("tbody tr");

        rows.forEach(function (row) {
            var fullName = row.querySelector("td:nth-child(2)").textContent.toUpperCase();
            if (fullName.includes(filter)) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        });
    }

</script>
</body>
</html>

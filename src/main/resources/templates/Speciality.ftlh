
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
            <input type="text" id="searchInput" placeholder="Поиск по названию" onkeyup="searchTable()" />
            <button class="add-button" onclick="openForm()">Добавить специльность</button>
        </div>


        <#if listSpeciality ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Дисциплина специальности</th>
                <th>Удалить</th>
                <th>Изменить</th>
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
                        <td>
                            <form action="/speciality/delete/${speciality.id}" method="post">
                                <input type="submit" value="Удалить"/>
                            </form>
                        </td>
                        <td>
                            <div>
                                <button class="add-button" onclick="openEditForm(${speciality.id})">Изменить</button>
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
        <h2>Добавить специальность</h2>

        <form action="/createSpeciality" method="post">

            <table>
                <tr>
                    <td>Введите данные:</td>
                    <td>
                        <input type="text" name="name" placeholder="Название"/>
                        <input type="text" name="discipline" placeholder="Дисциплина(цифра)"/>
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
<#list listSpeciality as speciality>
    <div id="myEditModal-${speciality.id}" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeEditForm()">&times;</span>
        <h2>Изменить специальность</h2>

        <form action="/speciality/edit/${speciality.id}" method="post">

            <table>
                <tr>
                    <td>Измените данные:</td>
                    <td>
                        <input type="text" name="name" placeholder="Название"/>
                        <input type="text" name="discipline" placeholder="Дисциплина(цифра)"/>
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
</#list>
<script>
    function openForm() {
        document.getElementById("myModal").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myModal").style.display = "none";
    }
    function openEditForm(specialityId) {
        var modalId = "myEditModal-" + specialityId;
        document.getElementById(modalId).style.display = "block";
    }

    function closeEditForm(specialityId) {
        var modalId = "myEditModal-" + specialityId;
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
    // Вызываем функцию sortTable() после загрузки страницы, чтобы список был отсортирован изначально
    window.addEventListener("DOMContentLoaded", sortTable);

    function searchTable() {
        var input = document.getElementById("searchInput");
        var filter = input.value.toUpperCase();
        var table = document.querySelector("table");
        var rows = table.querySelectorAll("tbody tr");

        rows.forEach(function (row) {
            var name = row.querySelector("td:nth-child(2)").textContent.toUpperCase();
            if (name.includes(filter)) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        });
    }
</script>
</body>
</html>

<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>План работы</title>
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
            <h1>Планируемая работа</h1>
        </div>
        <div class="header">
            <input type="text" id="searchInput" placeholder="Поиск по названию" onkeyup="searchTable()" />
            <button class="add-button" onclick="openForm()">Добавить работу</button>
        </div>


        <#if listPlanOfWork ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Дедлайн</th>
                <th>Нагрузка</th>
                <th>В какой кафедре есть</th>
                <th>Удалить</th>
                <th>Изменить</th>
                </thead>
                <tbody>
                <#list listPlanOfWork as planOfWork>
                    <tr>
                        <td>${planOfWork.id}</td>
                        <td>${planOfWork.name}</td>
                        <td>${planOfWork.deadline}</td>
                        <td>${planOfWork.workload}</td>
                        <td>
                            <#if planOfWork.department??>
                                ${planOfWork.department.id},
                                ${planOfWork.department.name}.
                            </#if>
                        </td>
                        <td>
                            <form action="/planOfWork/delete/${planOfWork.id}" method="post">
                                <input type="submit" value="Удалить"/>
                            </form>
                        </td>
                        <td>
                            <div>
                                <button class="add-button" onclick="openEditForm(${planOfWork.id})">Изменить</button>
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
        <h2>Добавить работу</h2>


        <form action="/createPlanOfWork" method="post">

            <table>
                <tr>
                    <td>Название работы:</td>
                    <td>
                        <input type="text" name="name"/>
                        <input type="text" name="deadline"/>
                        <input type="text" name="workload"/>
                        <input type="text" name="department"/>
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

<#list listPlanOfWork as planOfWork>
    <div id="myEditModal-${planOfWork.id}" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeEditForm()">&times;</span>
        <h2>Добавить работу</h2>


        <form action="/planOfWork/edit/${planOfWork.id}" method="post">

            <table>
                <tr>
                    <td>Название работы:</td>
                    <td>
                        <input type="text" name="name"/>
                        <input type="text" name="deadline"/>
                        <input type="text" name="workload"/>
                        <input type="text" name="department"/>
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
    function openEditForm(planOfWorkId) {
        var modalId = "myEditModal-" + planOfWorkId;
        document.getElementById(modalId).style.display = "block";
    }

    function closeEditForm(planOfWorkId) {
        var modalId = "myEditModal-" + planOfWorkId;
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
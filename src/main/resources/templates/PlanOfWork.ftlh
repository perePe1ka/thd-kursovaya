
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

            <button class="add-button" onclick="openForm()">Добавить работу</button>
        </div>


        <#if listPlanOfWork ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Дедлайн</th>
                <th>Нагрузка</th>
                <th>Референс на кафедру</th>
                <th>Удалить</th>
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
                        <input type="text" name="fk_departaments_id"/>
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
</script>
</body>
</html>
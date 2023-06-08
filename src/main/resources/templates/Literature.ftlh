
<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Методическая литература</title>
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
            <h1>Методическая литература</h1>
        </div>
        <div class="header">

            <button class="add-button" onclick="openForm()">Добавить литературу</button>
        </div>




        <#if listLiterature ??>
            <table>
                <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Вид материала</th>
                <th>Референс на специальность</th>
                <th>Референс на дисциплину</th>
                <th>Референс на Преподов</th>
                <th>Референс на Кафедры</th>
                <th>Удалить</th>
                </thead>
                <tbody>
                <#list listLiterature as literature>
                    <tr>
                        <td>${literature.id}</td>
                        <td>${literature.name}</td>
                        <td>${literature.type_of_material}</td>
                        <td>
                            <#if literature.speciality??>
                                ${literature.speciality.name}
                            </#if>
                        </td>

                        <td>
                        <#if literature.discipline??>
                            ${literature.discipline.name}
                            ${literature.discipline.class_type}
                        </#if>
                        </td>
                        <td>
                            <#if literature.teachers??>
                                ${literature.teachers.fullName}
                            </#if>
                        </td>


                        <td>
                            <#list literature.departaments as departaments> <!-- Итерация по множеству кафедр -->
                                ${departaments.name}<br> <!-- Получение имени каждой кафедры -->
                            </#list>
                        </td>

                        <td><a href="paper/delete/${literature.id}">Удалить</a></td>
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
        <h2>Добавить литературу</h2>

        <form action="/createLiterature" method="post">

            <table>
                <tr>
                    <td>Название литературы:</td>
                    <td>
                        <input type="text" name="name"/>
                        <input type="text" name="type_of_material"/>
                        <input type="text" name="fk_id_speciality"/>
                        <input type="text" name="fk_id_discipline"/>
                        <input type="text" name="fk_id_teachers"/>
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
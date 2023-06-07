
<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Специальности</title>
    <link rel="stylesheet" href="../static/css/tables.css">
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
            <li><a class="menubox_ref" href="/">Преподаватели</a></li>
            <li><a class="menubox_ref" href="/artist">Специальности</a></li>
            <li><a class="menubox_ref" href="/genre">Планируемая работа</a></li>
            <li><a class="menubox_ref" href="/medium">Методическая литература</a></li>
            <li><a class="menubox_ref" href="/musicgroup">Дисциплины</a></li>
            <li><a class="menubox_ref" href="/song">Кафедры</a></li>
            <li><a class="menubox_ref" href="/enters">Преподаватель/Литература</a></li>
            <li><a class="menubox_ref" href="/containssong">Преподаватель/Дисциплина</a></li>
            <li><a class="menubox_ref" href="/containsmedium">Спецальность/Дисциплина</a></li>
            <li><a class="menubox_ref" href="/containsartist">Учитель/Кафедра</a></li>
        </ul>
    </div>
    <div id="content">
        <div class="header_text">
            <h1>Методическая литература</h1>
        </div>
        <div class="header">
            <h2>Специальности</h2>
            <button class="add-button" onclick="openForm()">Добавить специльность</button>
        </div>
        <form th:action="@{/artist}" method="GET">
            <table>
                <thead>
                <tr>
                    <th>Название специальности</th>
                    <th>Действия</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="artist : ${artists}">
                    <td th:text="${artist.fullName}"></td>
                    <td>
                        <a th:href="@{/artist/edit/{id}(id=${artist.fullName})}"><span>&#9999;</span></a>
                        <form th:action="@{/artist/delete/{id}(id=${artist.fullName})}" method="POST">
                            <button type="submit"><span>&#10060;</span></button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
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
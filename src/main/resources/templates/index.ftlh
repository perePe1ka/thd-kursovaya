
<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Методическая литература</title>
  <link rel="stylesheet" href="../static/css/tables.css">
  <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
</head>
<body>
<div id="container">
  <div id="menu">
    <ul>
      <li><a href="/">Альбомы</a></li>
      <li><a href="/artist">Исполнители</a></li>
      <li><a href="/genre">Жанры</a></li>
      <li><a href="/medium">Носители</a></li>
      <li><a href="/musicgroup">Музыкальные группы</a></li>
      <li><a href="/song">Песни</a></li>
      <li><a href="/enters">Исполнители/Музыкальные группы</a></li>
      <li><a href="/containssong">Альбомы/Песни</a></li>
      <li><a href="/containsmedium">Альбомы/Носители</a></li>
      <li><a href="/containsartist">Альбомы/Исполнители</a></li>
      <li><a href="/containsgroup">Альбомы/Музыкальные группы</a></li>
      <li><a href="/performsartist">Песни/Исполнители</a></li>
      <li><a href="/performsgroup">Песни/Музыкальные группы</a></li>
    </ul>
  </div>
  <div id="content">
    <h1>Методическая литература</h1>
    <div class="header">
      <h2>Преводаватели</h2>
      <button class="add-button" onclick="openForm()">Добавить преподавателя</button>
    </div>
    <form th:action="@{/artist}" method="GET">
      <table>
        <thead>
        <tr>
          <th>Имя преподавателя</th>
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
    <h2>Добавить исполнителя</h2>
    <form th:action="@{/artist/create}" method="POST">
      <table>
        <tr>
          <td>Имя исполнителя:</td>
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
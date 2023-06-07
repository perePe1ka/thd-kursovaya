
<!DOCTYPE html>
<html lang="" xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Методическая литература</title>
  <link rel="stylesheet" href="./static/tables.css">
  <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
</head>
<body>
<div id="container">
  <div id="menu">
    <ul>
      <li><a href="/">Главная</a></li>
      <li><a href="/teachers">Преподаватели</a></li>
      <li><a href="/departaments">Кафедры</a></li>
      <li><a href="/discipline">Дисциплины</a></li>
      <li><a href="/literature">Методическая литература</a></li>
      <li><a href="/planOfWork">Планируемая работа</a></li>
      <li><a href="/speciality">Специальности</a></li>
    </ul>
  </div>
  <div id="content">
    <h1>Методическая литература</h1>






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
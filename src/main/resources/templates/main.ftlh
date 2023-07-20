<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/style.css"/>
        <title>Главная</title>
    </head>

    <body>
       <h1>Справочник</h1>
       <h2>Транстпортные средства</h2>
       <table border="1">
            <tr>
                <th>Марка</th>
                <th>Модель</th>
                <th>Категория</th>
                <th>Государственный номер</th>
                <th>Тип ТС</th>
                <th>Год выпуска</th>
                <th>Наличие прицепа</th>
                <th>Редактировать</th>

       <#list transports as transport>
            <tr>
                <td>${transport.mark}</td>
                <td>${transport.model}</td>
                <td>${transport.category}</td>
                <td>${transport.number}</td>
                <td>${transport.type}</td>
                <td >${transport.year}</td>

                <td><#if transport.trailer>Есть<#else>Нет</#if></td>

                <td><a href="edit/${transport.id}"> Редактировать</a></td>
            </tr>
              <#else>
              <h2>Справочник пуст</h2>
       </#list>
       </table><br>

 <form action="/add" method ="get">
       <input  class="button" type="submit" value ="Добавить"/><br>
       </form><br>


       <hr>
       <h2>Поиск транспортных средств</h2>
       <form action="/" method ="get">
       <label>Марка:</label><input type="text" name="mark"/>
       <label>Модель:</label><input type="text" name="model"/>
       <label>Категория:</label><input type="text" name="category"/>
       <label>Гос. номер:</label><input type="text" name="number"/>
       <label>Год выпуска:</label><input type="text" inputmode="numeric" pattern="[0-9]*" name="year"/><br>

       <input class="button" type="submit" value ="Найти"/>
       </form>
    </body>
</html>
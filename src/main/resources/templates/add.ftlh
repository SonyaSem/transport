<!DOCTYPE html>
 <html>
     <head>
        <link rel="stylesheet" type="text/css" href="/style.css"/>
        <title>Добавление</title>
     </head>
     <body>

     <fieldset>
         <legend>Добавление транспортного средства</legend>
          <form action="/add/create" method ="post">
               <label> Марка</label><br><input type="text" name="mark"/><br>
               <label> Модель</label><br><input type="text" name="model"/><br>
               <label> Категория</label><br><input type="text" name="category"/><br>
               <label>Тип</label><br>
                    <select name="type">
                    <option name="type">Пассажирский</option>
                    <option name="type">Грузовой</option>
                    <option name ="type">Специальный</option>
                   <option name="type">Специализированный</option>
              </select><br>
               <label> Гос. номер</label><br><input type="text" name="number"/><br>
               <label> Год выпуска</label><br><input type="text" inputmode="numeric" pattern="[0-9]*" name="year"/><br>
               <label> Наличие прицепа</label><br> <input type="checkbox" name="trailer" checked="checked" /><br>
               <input class="button" type="submit" name="submit" value ="Сохранить"/>
               <input class="button" type="submit" name="cancel" value ="Закрыть"/><br>

           </form>

       </fieldset>
 <#if error??>
 <h3 style="color: red">${error}</h3>
 </#if>

    </body>
</html>
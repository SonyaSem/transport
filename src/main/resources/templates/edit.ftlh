 <!DOCTYPE html>
 <html>
     <head>
        <link rel="stylesheet" type="text/css" href="/style.css"/>
        <title>Редактирование</title>
     </head>
     <body>

       <fieldset>
             <legend>Редактирование транспортного средства</legend>

             <form action="/edit/update" method ="post">
                   <label> Марка</label><br><input type="text" value ="${transport.mark}" name="mark"/><br>
                   <label> Модель</label><br><input type="text" value ="${transport.model}" name="model"/><br>
                   <label> Категория</label><br><input type="text" value ="${transport.category}" name="category"/><br>
                   <label> Тип</label><br>
                   <select name="type">
                       <option name="type">Пассажирский</option>
                       <option  name="type" >Грузовой</option>
                       <option name ="type" >Специальный</option>
                       <option name="type">Специализированный</option>
                      </select></p>

                   <label> Гос. номер</label><br><input type="text" readonly value ="${transport.number}" name="number"/><br>
                   <label> Год выпуска</label><br><input type="text" inputmode="numeric" pattern="[0-9]*" value ="${transport.year}" name="year"/><br>
                   <label> Наличие прицепа</label><br> <input type="checkbox" name="trailer" <#if transport.trailer> checked="checked"</#if> />
                   <input type="hidden" value="${transport.id}" name ="id"><br>
                   <input class="button" type="submit" name="submit" value ="Сохранить"/>
                   <input class="button" type="submit" name="cancel" value ="Закрыть"/><br>
           </form>
       </fieldset>
    </body>
</html>

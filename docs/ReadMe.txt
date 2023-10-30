Логин/пароль MySQL root/root.
Имя базы данных distance-calculator.

Миграции к бд находятся в папке liquibase.

Приложение может рассчитывать расстояние:
1) От города до города напрямую по координатам (тип CROWFLIGHT);
2) Показывая значение, хранящееся в бд (тип DISTANCE_MATRIX);
3) Рассчёт влкючает оба способа (тип All).

В поля Id города "от" и Id города "до" необходимо ввести id городов от и до которых нужно рассчитать расстояние. Список id и соответствующие названия городов можно посмотреть во вкладке "Перейти к списку городов".

Веб-приложение принимает XML-файлы для загрузки формата:

City:
<?xml version="1.0" encoding="UTF-8" ?>
<cities>
    <city>
        <name>Paris</name>
        <longitude>2.349014</longitude>
        <latitude>48.864716</latitude>
    </city>
</cities>

Distance:
<?xml version="1.0" encoding="UTF-8" ?>
<distances>
   <distance>
       <from_city>
           <id>4</id>
           <name>Samara</name>
       </from_city>
       <to_city>
           <id>5</id>
           <name>Paris</name>
       </to_city>
       <distance>3317</distance>
    </distance>
</distances>


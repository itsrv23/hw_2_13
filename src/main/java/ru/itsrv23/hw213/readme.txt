> Привет!
На связи домашнее задание урока 2.10 Библиотеки.
Цель сегодняшней домашней работы - научиться подключать к проектам библиотеки.
**Внимание!** В данной домашней работе вам понадобятся данные из курсовой работы.
*Среднее время выполнения: 60 минут*
>

**Шаг 1**
Подключите к вашему проекту из прошлых домашних заданий библиотеку **commons-lang3** (с помощью Maven)
**Шаг 2**
Реализуйте проверку всех входящих от пользователя текстовых данных (имена сотрудников и фамилии) с помощью класса **StringUtils**.
Критерий проверки: в переданной строке нет чисел и других запрещенных символов.
Если проверка не пройдена, выбросить исключение, возвращающее статус 400 Bad Request.
**Шаг 3**
Если данные прошли проверку, убедиться, что имя и фамилия будут записаны в сотрудника с большой буквы.
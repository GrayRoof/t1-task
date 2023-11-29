# Probation task 
Тестовое задание для стажировки
## Описание
REST API, которое вычисляет частоту встречи символов по заданной строке. 
Результат отсортирован по убыванию количества вхождений символа в заданную строку.

### [Репозиторий](https://github.com/GrayRoof/t1-task/tree/dev)

Входные параметры: 
- String text - строка, в которой будет производиться расчет. Длина строки ограничена и не может быть длиннее 100 символов.
- Boolean ignoreCase - параметр, который отвечает за чувствительность к регистру: 
  - TRUE - подсчет будет произведен без учета регистра.
  - FALSE - при подсчете будет учитываться регистр. Заглавные и строчные символы будут считаться отдельно.

Выходное значение: 
- json представление List<Entry<Character, Integer>> вида: 
```
[
    {
        "h": 2
    },
    {
        "j": 2
    }
]
```

### Запустить решение (через Maven)
Чтобы запустить сервер решения, выполните код ниже:

```
mvn package spring-boot:run
```

Данная инструкция запустит сервер на порту 8080.

### Тестирование решения
После запуска сервер будет доступен по этому пути [http://localhost:8080](http://localhost:8080)
- [swagger спецификация]
- [postman]
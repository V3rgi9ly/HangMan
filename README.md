![Виселица](https://habrastorage.org/r/w1560/getpro/habr/upload_files/0f0/635/ef0/0f0635ef059d85640d8e4d9e8f72eacf.png)

# Игра "Виселица"
Добро пожаловать в классическую игру "Виселица"! Цель игры — угадать загаданное слово по буквам, делая как можно меньше ошибок.

---

## Описание игры
"Виселица" — это игра на угадывание слов, в которой первый игрок загадывает слово, второй должен угадать секретное слово, называя по одной букве за ход. Если угаданная буква присутствует в слове, она открывается на своем месте. Если игрок ошибается, рисуется очередная часть "виселицы". Игра продолжается до тех пор, пока игрок не угадает все буквы или не совершит 6 ошибок.

---

## Правила игры
В начале игры первый игрок вводит слово.
Второй игрок вводит буквы, пытаясь угадать слово.
Если буква есть в слове, она открывается в соответствующих местах.
Если буквы нет, количество ошибок увеличивается, и на экране рисуется часть "виселицы".
Второй Игрок побеждает, если угадывает слово до того, как будут совершены 6 ошибок.
Второй Игрок проигрывает, если совершает 6 ошибок.

---

## Структура проекта и связи
Проект состоит из следующих основных классов:
Main: Главный класс main и методы в которых заключена вся логика игры

---

## Пример игры
* В начале игры первый игрок вводит секретное слово
* После ввода слова, программа автоматический скрывает слово и передает возможность второму игроку отгадать.
* Введите букву и нажмите Enter. Программа сообщит, была ли буква угадана, и отобразит текущее состояние слова.
* Продолжайте угадывать буквы до победы или поражения.

### Пример вывода

```
Введи секретное слово:
виселица
 _____
|   |
|   
|   
|
-----------
Слово:********

Введи букву:
е
Вы угадали букву!
Слово:***е****
Ошибки:[]

Введи букву:
в
Вы угадали букву!
Слово:в**е****
Ошибки:[]

Введи букву:
й
Вы не угадали букву!
Слово:********
Ошибки:[й]
 _____
|   |
|   O
|   
|
-----------
Введи букву:
х
Вы не угадали букву!
Слово:********
Ошибки:[й, х]
 _____
|   |
|   O
|   |
|
-----------
Введи букву:
л
Вы угадали букву!
Слово:в**ел***
Ошибки:[й, х]

Введи букву:
и
Вы угадали букву!
Слово:ви*ел***
Ошибки:[й, х]
Вы угадали букву!
Слово:ви*ели**
Ошибки:[й, х]

Введи букву:
с
Вы угадали букву!
Слово:висели**
Ошибки:[й, х]

Введи букву:
г
Вы не угадали букву!
Слово:********
Ошибки:[й, х, г]
 _____
|   |
|   O
|  /|
|
-----------
Введи букву:
ц
Вы угадали букву!
Слово:виселиц*
Ошибки:[й, х, г]

Введи букву:
а
Вы угадали букву!
Слово:виселица
Ошибки:[й, х, г]

Вы угадали слово, поздравляем!!!
Вы хотите повторить игру?
Выйти из игры-нажмите на число 1
Повторить игру-нажмите на число 2
Введите цифру:
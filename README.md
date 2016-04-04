# PhoneBook

<h4>Телефонный Справочник на Spring MVC + Hibernate.</h4>

В данном проекте реализован телефонный справочник с возможностью заносить
фамилию, имя, отчество, город, улицу, дату рождения, номер телефона. 
У пользователя есть возможность добавлять, редактировать и удалять пользователя.

В данном проекте использовались технологии:
<ol>
    <li>Apache Maven</li>
    <li>Spring MVC</li>
    <li>Hibernate 4</li>
    <li>JQuery</li>
    <li>Bootstrap</li>
    <li>JUnit Test</li>
</ol>

Среда разработки Intellij Idea. 
Сервер Apache Tomcat.
Приложение собрано с помощью Maven.

<h4>Инструкция по базе данных:</h4>
В данном приложении использовалась база данных PostgerSQL, для подключения установите следующие настойки:
<ol>
    <li>URL: jdbc:postgresql://localhost:5432/phonebook </li>
    <li>Username: postgres</property></li>
    <li>Password: 12345</li>
    <li>Driver: postgresql</li>
    <li>Скрипт создания таблиц базы данных находится в папке src -> sql</li>
</ol>
Основные настройки для подключения к базы данных через Hibernate прописаны в 
hibernate.cfg.xml

<h4>Инструкция по запуску:</h4>
Дальше мы собираем наш проект в war файл с помощью  сборщика Maven, выполнив
команду mvn clean install.
<ol>
    <li>Во вложении в письме находить war файл</li>
    <li>Добавляем war в каталог TOMCAT_HOME\webapps</li>
    <li>Главная страница находится по адресу http://localhost:8010/имя_папки/home_</li>
</ol>
![Home Paje] (GitImage/home.PNG)


package step.learning;
import step.learning.basics.BasicsDemo;
import step.learning.basics.FilesDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
      //  new BasicsDemo().run();
        new FilesDemo().run();
    }
}

/*
* 1.JDE (Java Runtime Environment - аналог .Net - платформа виконання)
* https://www.oracle.com/java/technologies/downloads/
* 2. JDK (Java Runtime Kit - набір розробника - копілятор + бібліотеки)
*  за тим самим посіланням або через інструменти IDE
* 3. IDE (JetBrains Idea / NetBeans(Apache) / Eclipse / VS Code)
*
* Новий проєкт
* 1. Ахрхітип (система збірки/управління пакетами ~NuGet)
* Maven / Gradle / Ants / Idea
* Назва - довільна
* Архітип - quickstart
* 1.розкрити додаткові налаштування, вписати группу "step.learning"
* Вибрати JDK, за відсутності - завантажити
* 2. Кофігурація запуску - після створення проєкту маємо лише розпакований шаблон, потрібна кофігурція
* меню Run - Edit Configuration - Add new - Aplication
* Вводимо назву конфігурації (довільна, App)
* Та вибираемо головний класс(з методом main)
* 3.Пробний запуск
*
* */
/*
* Про Java
* Парадигма - ООП
* Покоління - 4
* Запуск - трансльваний, на базі платформи
* Вихідний код - Юникод, файли .java
* Виконавчий код - проміжний, файли .class
* Висока чутливість до організації:
*  -назва файлу збігаеться з назвою классу(реєстрочутливо)->
*   один файл - один клас(public)
*  -назва пакету відповідає назві директорії
* */
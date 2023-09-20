package step.learning.basics;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class FilesDemo {


    public void run(){
        //зберігання данних у файлах
        String filename = "test.txt";
        //всі види роботи з данними у файлі - через Stream
        //це некерованні ресурси, їх треба закривати окремими командами або вживати
        //блоки з автоматичним вивільненям ресурсів (using-c#, try()-Java)
        try(OutputStream writer = new FileOutputStream(filename)) {
            writer.write("Hello, world!".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileWriter writer = new FileWriter(filename, true)) {
            writer.write("\nNewLine");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();


        try(InputStream reader = new FileInputStream(filename)){
            int c;
            while((c = reader.read()) != -1){
                sb.append((char) c);
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------");
        ByteArrayOutputStream byteBuilder = new ByteArrayOutputStream(4096);
        byte[] buf = new byte[512];
        try(InputStream reader = new BufferedInputStream(new FileInputStream(filename))){
            int cnt;
            while ((cnt = reader.read(buf)) > 0 ){
                byteBuilder.write(buf, 0, cnt);

            }
            String content = new String(
                    byteBuilder.toByteArray(),
                    StandardCharsets.UTF_16
            );
            System.out.println(content);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------------------------------");
        try (InputStream reader = new FileInputStream(filename);
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) { // next - "слово" - між пробілами/кінцем рядку
                System.out.println(scanner.next());
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //Scanner kbScanner = new Scanner(System.in);
        //System.out.print("Your name: ");
        //String name=kbScanner.next();
        //System.out.printf("Hello, %s!%n",name);
        Random random = new Random();
        int minLength = 20;
        int maxLength = 127;
        int length = random.nextInt(maxLength - minLength + 1) + minLength;

        // Генерируем случайную строку с символами от 20 до 127
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(108) + 20); // 20 <= код символа <= 127
            randomString.append(randomChar);
        }

        // Записываем строку в файл
        try {
            String fileName = "random_string.txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write(randomString.toString());
            writer.close();
            System.out.println("Строка записана в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public void run2() {
        // створення файлів та папок
        File dir = new File("./uploads");
        // задача: перевірити чи є в проєкті папка, якщо немає - створити
        if(dir.exists()){
            if(dir.isDirectory()){
                System.out.printf("Directory '%s' exists%n", dir.getName());
            }else {
                System.out.printf(" '%s' alredy exists%n BUT NOT DIRECTORY", dir.getName());
            }
        }else {
            if(!dir.isDirectory()) {


            boolean res = dir.mkdir();
            if (res) {
                System.out.printf("Directory '%s' created", dir.getName());
            } else {
                System.out.printf("Directory '%s' creation error%n", dir.getName());
            }
        } else {
            System.out.printf("Directory '%s' already exists%n", dir.getName());
        }

        }

        //створити у директорії файл
        File file = new File("./uploads/whitelist.txt");
        if(file.exists()){
            if(file.isFile()){
                System.out.printf("File '%s' exists%n", file.getName());
            }else {
                System.out.printf(" '%s' alredy exists%n BUT NOT FILE", file.getName());
            }
        }else {
            try {
                if(file.createNewFile()){
                    System.out.printf("File '%s' created", file.getName());
                }
                else {
                    System.out.printf("File '%s' creation error%n", file.getName());
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }


    public void run1() {
        // Основа роботи з файлами - java.io.File
        File dir = new File("./");
        // стврення new File НЕ впливає на файлову систему, це лише
        // програмний об'єкт, який відповідає за зазначений шлях
        if (dir.exists()) {
            System.out.println("Path exists");
        } else {
            System.out.println("Path does not exist");
        }

        System.out.printf("Path is %s %n",
                dir.isDirectory() ? "directory" : "file");

        System.out.println(dir.getAbsolutePath());
        for(String filename: dir.list()){
            System.out.println(filename);
        }

    }
}
/* Робота з файлами розглядається у двох аспектах:
    - робота з файловую системою: створення файлів, пошук, переміщення, видалення, тощо
    - використання файлів для збереження/віднолвення даних

    Зберігання читання данних з файлу відбувается через Stream
    -це некеровані ресурси, потрібне закриття
    -базові засоби Stream значно обмежені роботою з одним байтом чи їх масивом
    -часто вживаются "обгортки", які спрощують роботу з даними, розбиваючи
    потоки байт на типи Java
    -FileWriter/FileReader - додає роботу з символами та строками
*/

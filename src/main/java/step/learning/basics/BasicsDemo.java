package step.learning.basics;

import java.util.*;

public class BasicsDemo {
    public void run() {
        // region Types
        System.out.println("BasicsDemo");
        System.out.printf("Interpolated %s value %n", "hello");
        byte b = 10; // 8 біт
        short s = 100;
        int i = 1000;
        long l = 10000000;
        // Цим типам наявні reference-аналоги
        Byte rb = 10; // boxing-обгортки
        Short rs = 1000;
        Integer ri = 10000;
        Long rl = 100000000L;

        float f = 1e-3f; //MeE - мантиса: число від 1.0 до 9.(9)
        double d = 2e-7; // E - експонента: ціле число = показчик 10
        //1е - з =  1 * 10^(-7) = o.001
        //2e - 7 = 2 * 1-(-7) = 0.0000002
        //3.3e3 = 3.3 * 10^3 = 3300

        boolean bool = true;
        Boolean Bool = true;
        char c = 'a';


        String str1 = "Hello";    // String pooling - збирання однакових значень
        String str2 = "Hello";    // та використання іх для різних рядків
        String str3 = new String("Hello");
        if (str1 == str2) {    // у Java == - об'єктна рівність (рівність посилань)
            System.out.println("str1 == str2"); // рівні оскільки pooling
        } else {
            System.out.println("str1 != str2");
        }
        if (str1 == str3) {
            System.out.println("str1 == str2");
        } else {
            System.out.println("str1 != str2");
        }
        //для порівняння вікорістовуется .equals()
        if (str1.equals(str3)) {
            System.out.println("str1 equals str2");
        } else {
            System.out.println("str1 !equals str2");
        }
        // endregin
        arrDemo();
    }


    private void arrDemo() {
        //масиви, колеції, цикли
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = new int[]{5, 4, 3, 2, 1};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int x : arr2) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] row : arr2d) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Collections
        // Linear: List - interface, ArrayList - implementation
        List<Integer> list1 = new LinkedList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        for (Integer x : list1) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Assoc:
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Host", "localhost");
        headers.put("Connection", "close");
        headers.put("Content-Type", "text/html");
        for (String key : headers.keySet()) {
            System.out.println(
                    String.format(
                            "%s: %s",
                            key, headers.get(key)
                    )
            );
        }
    }
}

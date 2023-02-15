package chap12;

import java.util.Scanner;

public class TestMyArrayList {

    public static void main(String[] args) {
        MyList list = new MyArrayList();
        Scanner k = new Scanner(System.in);
        list.menu();
        while(true) {
            int key = k.nextInt();
            switch(key) {
                case 0:list.menu();break;
                case 1:
                    list.add("中国");
                    list.add("日本");
                    break;
                case 2:
                    //Student s = new Student("2113042725","郑馥秉");
                    //list.add(s);
                    list.add(2,"俄罗斯");
                    break;
                case 3://list.contaims("日本");
                    System.out.println(list.contaims("法国"));break;
                case 4://list.indexOf("中国");
                    System.out.println(list.indexOf("加拿大"));break;
                case 5://list.LastIndexOf("日本");
                    System.out.println(list.LastIndexOf("日本"));break;
                case 6:list.remove("日本");break;
                case 7://list.remove(1);
                    System.out.println(list.remove(1));break;
                case 8:list.replace(0, "法国");break;
                case 9:System.out.println(list.toString());break;
                case 10:System.out.println(list.size());break;
                case 11:System.out.println(list.isEmpty());break;
                case 12:list.clear();break;
            }
        }

    }
}

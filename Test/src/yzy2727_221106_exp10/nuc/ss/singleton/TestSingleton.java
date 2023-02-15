package yzy2727_221106_exp10.nuc.ss.singleton;

public class TestSingleton {
    public static void main(String[] args) {

        System.out.println("---测试饿汉式单例类---");

        EagerSingleton instance1 = EagerSingleton.getInstance();

        EagerSingleton instance2 = EagerSingleton.getInstance();

        EagerSingleton instance3 = EagerSingleton.getInstance();

        EagerSingleton instance4 = EagerSingleton.getInstance();

        System.out.println(instance1 == instance2);

        System.out.println(instance4 == instance3);
        System.out.println("---测试饿汉式单例类---");

        LazySingleton instance5 = LazySingleton.getInstance();

        LazySingleton instance6 = LazySingleton.getInstance();

        LazySingleton instance7 = LazySingleton.getInstance();

        LazySingleton instance8 = LazySingleton.getInstance();

        System.out.println(instance5 == instance6);

        System.out.println(instance7 == instance8);
    }
}

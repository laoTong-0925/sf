package sf.顺序;


public class Father {

    private String name;

    {
        name = "father1";
        System.out.println("父类代码块1" + name);
    }

    {
        name = "father2";
        System.out.println("父类代码块2" + name);

    }

    public Father() {
        System.out.println("父类构造函数");
    }

    private static int a;

    static {
        a = 10;
        System.out.println("父类静态属性a:" + a);
    }

}

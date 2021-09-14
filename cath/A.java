package sf.cath;

public class A {

    {
        System.out.println("a 代码块");
    }

    static {
        System.out.println("a static代码块");
    }

    public A() {
        System.out.println("a 构造函数");
    }

    static class AA{
        public AA(){
            System.out.println("aa 构造函数");
        }
        {
            System.out.println("aa 代码块");
        }
    }
}

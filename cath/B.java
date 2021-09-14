package sf.cath;

public class B extends A{
    private static BB bb;
    {
        System.out.println("b 代码块");
    }

    static {
        System.out.println("b static代码块");
    }

    public B() {
        System.out.println("b 构造函数");
    }

    static class BB{
        public BB(){
            System.out.println("bb 构造函数");
        }
        {
            System.out.println("bb 代码块");
        }
    }
}

package sf;

public class Singleton {
    
    private Singleton(){
        System.out.println("Singleton: " + System.nanoTime());
    }
    
    public static Singleton getInstance(){
        return SingletonFactory.singletonInstance;
    }
    
    private static class SingletonFactory{
        private static Singleton singletonInstance = new Singleton();
        static {
            System.out.println("加载内部类");
        }
    }

    public static void main(String[] args) {
//        Singleton singleton = new Singleton();
        int i = 1;
        Singleton instance = Singleton.getInstance();
    }
}

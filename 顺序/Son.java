package sf.顺序;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Son extends Father {
    private String name;

    {
        name = "son1";
        System.out.println("子代码块1" + name);
    }

    {
        name = "son2";
        System.out.println("子代码块2" + name);

    }

    public Son() {
        System.out.println("子构造函数");
    }

    private static int a;

    static {
        a = 10;
        System.out.println("子静态属性a:" + a);
    }

//    public static void main(String[] args) {
////        Son s = new Son();
////        double d = 0.5;
////        int i = 100;
////        System.out.println(Math.round(d*i));
////        Boolean b=null;
////        if (b){
////            System.out.println(1);
////        }
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s1";
//        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s2";
//        }), () -> System.out.println("hello world"));
//        while (true) {
//        }
        Set<Father> set = new HashSet<>();
        set.add(new Son());
        set.forEach(e -> {
            System.out.println(e);
        });
    }
}

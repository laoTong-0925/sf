package sf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description :
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 分的孩子越多越好，胃口大的吃大块，胃口小的吃小块
 * @Author :
 * @Date: 2020-12-25 09:35
 */
public class 分饼干 {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, List<Integer>> map = new ConcurrentHashMap<>();
        map.put(1, Arrays.asList(1, 2, 3));
        map.put(11, Arrays.asList(1, 2, 3));
        map.put(2, Arrays.asList(1, 2, 3));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<Integer, List<Integer>> finalMap = map;
        executorService.submit(() -> {
            for (Map.Entry<Integer, List<Integer>> entry : finalMap.entrySet()) {
                Integer k = entry.getKey();
                List<Integer> v = entry.getValue();
                System.out.println(k);
                k.toString();
                System.out.println(v);
                System.out.println(System.currentTimeMillis());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        map = null;
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        executorService.submit(() -> {
//            map.forEach((k,v)->{
//                System.out.println(v.get(0));
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        });
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(System.currentTimeMillis());
//                map = null;
//            }
//        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关键在于排序，让饼干大小和胃口保持小的差值，大胃口吃大饼干，小胃口吃小饼干
     * @param g 胃口
     * @param s 饼干大小
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int j = 0; count < g.length && j < s.length; j++) {// 满足人数判断
            //如果当前饼干能满足当前孩子的胃口值，count就加1，否则就继续查找更大的饼干
            if (g[count] <= s[j])
                count++;
        }
        return count;
    }

}

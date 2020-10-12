package sf;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @ClassName : Test
 * @Description :
 * @Author :
 * @Date: 2020-09-08 16:15
 */
public class Test {

    /**
     * 召回逻辑调用封装
     */
    interface CandidateCall {
        /**
         * 调用召回服务并返回结果
         *
         * @param userId 用户ID
         * @return 召回items
         */
        Set<Integer> invoke(int userId);

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, CandidateCall> candidateCallMap = new ConcurrentHashMap<>();
        candidateCallMap.put("a", (userId) -> {
            System.out.println(Thread.currentThread().getName());
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            return set;
        });
        candidateCallMap.put("b", (userId) -> {
            System.out.println(Thread.currentThread().getName());
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            return set;
        });

        CompletableFuture<Set<Integer>> chainAsyncFuture = null;
        Set<String> strategySet = new HashSet<>();
        strategySet.add("a");
        strategySet.add("b");
        for (String strategy : strategySet) {
            CandidateCall call = candidateCallMap.get(strategy);
//            RecallParams params = config.getConfig(strategy);

            Supplier<Set<Integer>> supplier = () -> call.invoke(1);

            if (chainAsyncFuture == null) {
                chainAsyncFuture = CompletableFuture.supplyAsync(supplier);
                continue;
            }

            CompletableFuture<Set< Integer>> future = CompletableFuture.supplyAsync(supplier);
            chainAsyncFuture = chainAsyncFuture.thenCombineAsync(future, (a, b) -> {
                if (a == null || a.size() == 0) {
                    return b;
                }
                if (b == null || b.size() == 0) {
                    return a;
                }
                Set<Integer> set = new HashSet<>();
                set.addAll(a);
                set.addAll(b);
                return set;
            });
        }
        Set<Integer> multimap = chainAsyncFuture.get();
        System.out.println(multimap.toString());
    }
}

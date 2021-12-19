package sf.极客时间算法训练营_2期.four_week;

import java.util.*;

/**
 * 最小基因变化
 * <p>
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意：
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * 返回值: 2
 */
public class Clazz433 {

    /**
     * bfs 解题
     */
    public static int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, bank);

        Deque<String> deque = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>(); // 记录start字符串每个下标字符变化时的新字符串以及经过多少次变化可以得到新
        char[] gene = {'A', 'T', 'C', 'G'};
        deque.add(start);
        map.put(start, 0);
        while (!deque.isEmpty()) {
            String s = deque.poll(); //取队头元素

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    // 基因相同跳过
                    if (s.charAt(i) == gene[j]) continue;
                    char[] chars = s.toCharArray();
                    chars[i] = gene[j];
                    String ns = String.valueOf(chars);

                    // System.out.println(ns);
                    if (!set.contains(ns)) continue; // 合法基因库中不包含变化后的新字符串则进入下一次循环
                    
                    if (!map.containsKey(ns)) {
                        // 没走过
                        Integer c = map.get(s); // s基因通过几步得来的
                        map.put(ns, c + 1); // 加入新基因的步数
                        deque.add(ns);
                        if (ns.equals(end))
                            return map.get(ns);
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] strings = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int i = minMutation("AACCGGTT", "AAACGGTA", strings);
        System.out.println(i);
    }


}

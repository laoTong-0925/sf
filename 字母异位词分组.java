package sf;

import java.util.*;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-16 10:12
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] as = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(as);
        System.out.println(lists);
    }

    /**
     * char 字符排序是根据ascll码进行排序的，相同字符拼接成的字符串根据ascll码排序后得到的结果是一致的，做k
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            ans.computeIfAbsent(key, x -> new ArrayList<>());
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());

    }
}

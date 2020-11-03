package sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author :
 * @Date: 2020-10-30 13:12
 */
public class 拆分单词 {



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ll");
        list.add("code1");
        boolean b = wordBreak("code1l", list);
        System.out.println(b);

        boolean code1l = wordBreak0("code1ll", list);
        System.out.println(code1l);
    }

    public static boolean wordBreak0(String s, List<String> wordDict) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> hasCompute = new HashMap<>();
        return wordBreak(s, wordDict, 0, hasCompute);
    }

    public static boolean wordBreak(String s, List<String> wordDict, int index, Map<Integer, Boolean> hasCompute) {
        //找到所有可能性
        boolean result = false;
        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                index += word.length();
                //先判断之前是否已经计算过
                if (hasCompute.containsKey(index)) return false;//如果已经计算过，说明是失败的
                if (index == s.length()) return true;//递归结束条件
                if (wordBreak(s, wordDict, index, hasCompute)) return true;//如果找到了，直接返回
                else {
                    //记录已经计算的字符串
                    if (!hasCompute.containsKey(index)) {
                        hasCompute.put(index, false);
                    }
                    //把index还原
                    index -= word.length();
                }
            }
        }
        return result;
    }
}

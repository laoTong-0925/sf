package sf.极客时间算法训练营_2期.four_week;

import sf.cath.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Clazz17 {

    private static Map<Character, String> map = new HashMap<>();
    private static List<String> ans = new ArrayList<>();
    private static StringBuilder stringBuilder = new StringBuilder();


    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, stringBuilder, 0);
        return ans;
    }

    public static void dfs(String digits, StringBuilder str, int index) {
        if (index == digits.length()) {
            ans.add(stringBuilder.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for (char c : s.toCharArray()) {
//            dfs(digits, str + c, index + 1);// 每次产生新的String
            dfs(digits, stringBuilder.append(c), index + 1);// 每次产生新的String
            stringBuilder.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}

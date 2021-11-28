package sf.极客时间算法训练营_2期.tow_week.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author :
 * @Date: 2021-11-28 21:13
 */
public class 子域名访问技术 {

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ansList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // 存储子域名及其出现次数

        for (int i = 0; i < cpdomains.length; i++) {
            String[] ss = cpdomains[i].split(" "); // 分割 次数 域名
            int count = Integer.parseInt(ss[0]); // count为地址出现次数

            String[] splits = ss[1].split("\\."); // 每个子域名分隔开
            String s = "";
            for (int j = splits.length - 1; j >= 0; j--) {
                s = splits[j] + "." + s;
                // 出现过子域名就 ++ 次数
                if (map.containsKey(s.substring(0, s.length() - 1))) {
                    map.put(s.substring(0, s.length() - 1), map.get(s.substring(0, s.length() - 1)) + count);
                } else { // 如果map中不存在这个子域名，则将该子域名及出现次数存储至map中
                    map.put(s.substring(0, s.length() - 1), count);
                }

            }
        }
        //遍历map，并将得到的结果存入list中
        for (String str : map.keySet()) {
            ansList.add(map.get(str) + " " + str);
        }

        return ansList;
    }

}

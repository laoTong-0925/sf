package sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : 两数之和二输入有序数组
 * @Description :
 * @Author :
 * @Date: 2020-07-20 23:04
 */
public class 两数之和二输入有序数组 {
    private static  int i;
    static {
        i=1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4};// 9 5 8 1 3   8
        int[] ints = twoSum(a, 6);
        int[] ints2 = twoSum2(a, 6);
        for (Integer i : ints)
            System.out.println(i);


    }

    //map
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();// 另一个家数，当前加数的位置
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                return new int[]{index, i + 1};
            }
            int x = target - numbers[i];
            map.put(x, i + 1);
        }
        return null;
    }

    //二分
    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
    //双指针
    public int[] twoSum3(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }


    public Integer[] sum(int[] numbers, int target){
        int[] pos = new int[2];
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer i:numbers){
            integers.add(i);
        }

        for(int i=0;i<integers.size();i++){
            int res = target - integers.get(i);
            if(integers.contains(res)){
                index.add(i);
            }
        }
        Integer[] ts = index.toArray(new Integer[2]);
        return ts;
    }

}

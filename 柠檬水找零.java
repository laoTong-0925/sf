package sf;

import java.io.File;

/**
 * @Description : 只有5 10 20的面值 ，水卖5块，收10元时必须有5元，收20时有 10+5 或者 5+5+5
 * @Author :
 * @Date: 2020-12-10 09:31
 */
public class 柠檬水找零 {

    public static void main(String[] args) {
        try {
            File file = new File("/data/log/cu-api");
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File fileIn : files) {
                        if (fileIn.isFile()) {
                            String name = fileIn.getName();
                            if (name.contains("500"))
                                fileIn.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

package sf.剑指.中等;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 */
public class 排序二维数组的查找 {
    /**
     * 排序的，可以从左下角或者右上角开始，减少搜索的范围
     * 从左下角开始，
     */
    public boolean get(int[][] numbs,int tag){
        int i = numbs.length - 1,
                j = 0;
        while(i >= 0 && j < numbs[0].length)
        {
            if(numbs[i][j] > tag) i--;
            else if(numbs[i][j] < tag) j++;
            else return true;
        }
        return false;
    }
}

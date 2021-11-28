package sf.极客时间算法训练营_2期.tow_week;

public class 乘最多水的容器 {

    /**
     * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 -1−1​ 变短：
     *
     * 若向内 移动短板 ，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
     * 若向内 移动长板 ，水槽的短板 min(h[i], h[j])min(h[i],h[j])​ 不变或变小，因此下个水槽的面积 一定变小 。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            int i = r - l;
            res = height[l] < height[r] ?
                    Math.max(res, i * height[l++]) :
                    Math.max(res, i * height[r--]);
        }
        return res;
    }
}

package Java相关;

import org.junit.Test;

import java.math.BigDecimal;

public class 精度处理 {
    @Test
    public void test(){
        Double a = 0.13;
        Double b = 0.22323232;
        double c = a+b;
        System.out.println("做处理之前："+c);

        BigDecimal decimal = new BigDecimal(c);
        BigDecimal num = decimal.setScale(4,BigDecimal.ROUND_HALF_DOWN);

        System.out.println("做处理之后:"+num);
        System.out.println("做处理之后的类型:"+num.getClass().toString());

        double s = num.doubleValue();
        System.out.println("将处理后转换成double："+s);
    }
    /**
     * ROUND_CEILING
     * Rounding mode to round towards positive infinity.
     * 向正无穷方向舍入
     *
     * ROUND_DOWN
     * Rounding mode to round towards zero.
     * 向零方向舍入
     *
     * ROUND_FLOOR
     * Rounding mode to round towards negative infinity.
     * 向负无穷方向舍入
     *
     * ROUND_HALF_DOWN
     * Rounding mode to round towards "nearest neighbor" unless both neighbors are equidistant, in which case round down.
     * 向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5
     *
     * ROUND_HALF_EVEN
     * Rounding mode to round towards the "nearest neighbor" unless both neighbors are equidistant, in which case, round towards the even neighbor.
     * 向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP ，如果是偶数，使用ROUND_HALF_DOWN
     *
     *
     * ROUND_HALF_UP
     * Rounding mode to round towards "nearest neighbor" unless both neighbors are equidistant, in which case round up.
     * 向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6
     *
     *
     * ROUND_UNNECESSARY
     * Rounding mode to assert that the requested operation has an exact result, hence no rounding is necessary.
     * 计算结果是精确的，不需要舍入模式
     *
     *
     * ROUND_UP
     * Rounding mode to round away from zero.
     * 向远离0的方向舍入
     */
}

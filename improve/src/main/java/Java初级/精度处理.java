package Java初级;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class 精度处理 {

    /**
     * 运算
     */
    @Test
    public void calc(){
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
        System.out.println(Math.round(4.015 * 100) / 100.0);
        System.out.println(Math.round(401.5/100));

        BigDecimal valueFir = new BigDecimal(0.005);
        BigDecimal valueThi = new BigDecimal(-1000000);
        BigDecimal valueSec = new BigDecimal(1000000);

        //尽量用字符串的形式初始化
        BigDecimal stringFir = new BigDecimal("0.005");
        BigDecimal stringSec = new BigDecimal("1000000");
        BigDecimal stringThi = new BigDecimal("-1000000");

        //加法
        BigDecimal addVal = valueFir.add(valueSec);
        System.out.println("加法用value结果：" + addVal);
        BigDecimal addStr = stringFir.add(stringSec);
        System.out.println("加法用string结果：" + addStr);

        //减法
        BigDecimal subtractVal = valueFir.subtract(valueSec);
        System.out.println("减法value结果：" + subtractVal);
        BigDecimal subtractStr = stringFir.subtract(stringSec);
        System.out.println("减法用string结果：" + subtractStr);

        //乘法
        BigDecimal multiplyVal = valueFir.multiply(valueSec);
        System.out.println("乘法用value结果：" + multiplyVal);
        BigDecimal multiplyStr = stringFir.multiply(stringSec);
        System.out.println("乘法用string结果：" + multiplyStr);

        //绝对值
        BigDecimal absVal = valueThi.abs();
        System.out.println("绝对值用value结果：" + absVal);
        BigDecimal absStr = stringThi.abs();
        System.out.println("绝对值用string结果：" + absStr);

        //除法
        BigDecimal divideVal = valueSec.divide(valueFir, 20, BigDecimal.ROUND_HALF_UP);
        System.out.println("除法用value结果：" + divideVal);
        BigDecimal divideStr = stringSec.divide(stringFir, 20, BigDecimal.ROUND_HALF_UP);
        System.out.println("除法用string结果：" + divideStr);
        /**
         * 其中
         * 可以假设在Java中写入new BigDecimal(0.1)创建一个BigDecimal ，它完全等于0.1（非标尺值为1，比例为1），但实际上等于0.1000000000000000055511151231257827021181583404541015625。
         * 写new BigDecimal("0.1")创建BigDecimal这正好等于0.1，正如人们所期望的那样。
         * 因此在创建BigDecimal的时候选择string类型的构造函数创建较好
         */
    }

    /**
     * 操作
     */
    @Test
    public void oper(){
        Double a = 0.13;
        Double b = 0.22323232;
        double c = a+b;
        System.out.println("做处理之前："+c);

        //BigDecimal对小数的处理
        DecimalFormat df = new  DecimalFormat("0.0000");
        System.out.println("DecimalFormat对小数处理之后：" + df.format(c));

        BigDecimal decimal = new BigDecimal(c);
        BigDecimal num = decimal.setScale(1,BigDecimal.ROUND_HALF_DOWN);

        System.out.println("做处理并且之后:"+num);
        //BigDecimal转Double
        double s = num.doubleValue();
        System.out.println("将处理后转换成double："+s);
    }
}
/**
 * 舍入模式
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

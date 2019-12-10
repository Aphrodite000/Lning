import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringBuilderTest {
    @Test
    public void test1(){
        try {
            throw new RuntimeException("出错了");
        } catch (RuntimeException e) {
            e.printStackTrace();//显示在控制台  有参数就不输出到控制台
            e.getMessage();//打印自定义信息“出错了”
            StringWriter sw=new StringWriter();
            PrintWriter  pw=new PrintWriter(sw);
            e.printStackTrace(pw);//在控制台不显示，显示在流中
        }
    }
}

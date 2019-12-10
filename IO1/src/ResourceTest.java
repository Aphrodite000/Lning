import org.junit.Test;

import java.io.InputStream;

public class ResourceTest {
    @Test
    public  void test1(){
        //获取流相对路径，以根目录为相对路径
        InputStream is=ResourceTest.class.getClassLoader().getResourceAsStream("test1.txt");
        //相对class的根路径，test1.txt就在这，所以直接写，
        //通过类加载器获取资源转成流，
        InputStream is2=ResourceTest.class.getResourceAsStream("../../test1.txt");
        //跳两级，在当前class文件的上上层路径下，以当前class为当前路径
        //如果改了目录结构，同级里面建个包，把这个类放进去，就不在一个级别，该类在更深层
        //这个文件和这些类是同级别的
    }
}

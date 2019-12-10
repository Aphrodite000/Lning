import org.junit.Test;

import java.io.*;

public class FileInputStreamTest2 {

    @Test
    public void test1(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            //相对路径是针对这个项目的路径，不太写

            //读取文件流,这个流是需要关闭的，也可以读取流（流就是数据）
            FileInputStream fis = new FileInputStream(f);
            //读取从哪个长度到哪个长度，不断读取，每一次读取完就返回一个int，就是read()的返回值
            //就是当前读取到的长度，读到最后就会返回-1
            //要判断是否读到文件最后
            byte[] bytes = new byte[1024];//读取到数组
            int len = 0;//读取长度，
            while((len=fis.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            //包裹流，加工流
            //缓冲流读取 读取出现放到缓冲区
            //内核里先创建缓冲区域，读到了告诉相应程序
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=bis.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                //直接把读取的转成字符串
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s=br.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileWriter fw = new FileWriter(f);
            //缓冲字符流
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("1=123\n");
            bw.write("唐诗");
            bw.write("11123");
            bw.newLine();
            //新建一行
            bw.write("宋词");
            //先发送到缓冲区，写完了，告诉缓冲区，写入文件
            bw.flush();//刷新文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @Test
    public void test1() throws IOException {
        File file=new File("C:\\Users\\dell\\IdeaProjects\\IO -Learning\\fileTest.txt");
        //写绝对路径
        System.out.println(file.exists());
        //List<File> files=listFiles(dir);
        //File直接打印，但是没有路径
        //files.stream().forEach(System.out::println);
        File f2=new File("test1.txt");
        //f3.exist打印不存在，这个相对路径不对
        //因为编译路径（放的是编译好的class文件）与源文件路径不同，所以会出现问题
        File f3=new File("test2.txt");
        f3.createNewFile();//创建文件到相对路径，与src同级中，不推荐到这个，因为系统和其他问题
        // 创建的路径并不是我们期望的
        //这个方法直接可以生成文件

        File d=new File("d:/");//文件夹
        for(File f:d.listFiles()){
            //遍历这个文件夹
            //获取文件路径
            System.out.println(f.getPath());
        }
    }
    @Test
    public  void test2(){
        File dir=new File("C:\\Users\\dell\\Documents\\Tencent Files\\153118976\\FileRecv");
        List<File> files =listFiles(dir);
        files.stream().forEach(System.out::println);
        //利用流操作，直接通过集合类里的流操作获取每一行打印，是file直接打印，路径打印不了
        files.stream().forEach((f) -> {
            System.out.println(f.getPath());
        });
        //每个each是一个file类型数据,这个可以打印路径
    }
    public List<File> listFiles(File file){
        //文件夹遍历，文件存入list
        List<File> list=new ArrayList<>();
        //因为同一级下可能是文件可能是文件夹，所以要从两方面来考虑
        list.add(file);
        //System.out.println(file.getPath());
        //如果是文件夹就去遍历，把每一个文件都要打印出来
        if(file.isDirectory()){
            for(File f:file.listFiles()){
                //list.add(f);如果是文件夹会重复添加，所以不能写
                if(f.isDirectory()){
                    //文件夹下可能没有文件，有漏洞
                    //是文件夹就再去遍历
                    list.addAll(listFiles(f));
                    //有返回值所以要把集合添加回去,子文件的集合
                }else {
                    list.add(f);
                    System.out.println(f.getPath());
                    //如果是文件就打印，是文件夹就遍历，直到打印完每一个文件
                }
            }
        }
        return list;
    }
}

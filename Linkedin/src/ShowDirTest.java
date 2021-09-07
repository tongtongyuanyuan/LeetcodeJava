import java.io.*;
public class ShowDirTest {
    public static void showDir(String str) {
        File file = new File(str);
        File[] files = file.listFiles();/*获取该目录下得所有文件或者文件夹*/
        if (files.length == 0) {/*如果为空则直接退出*/
            return;
        }
        System.out.println(file.getAbsolutePath());/*显示当前文件路劲*/
        for (File f : files) {/*for 循环得一种便利方法*/
            if (f.isFile()) {/*判断f是否是文件*/
                System.out.println("...\\.." + f.getName());
            } else if (f.isDirectory()) {/*判断f是否是文件夹*/
                showDir(f.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "E:\\福建师范大学@学习\\大一\\Java\\java实验";
        showDir(s1);
    }
}


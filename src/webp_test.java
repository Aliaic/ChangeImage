/**
 * Created by yuchao.liang on 2017/7/24.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by yuchao.liang on 2017/7/19.
 * oripath :源文件路径
 * newpath：新文件路径
 */

public class webp_test {
    public static void main(String[] args) throws IOException {
//        test02();
        //读取图片
        String  oripath =  "D:\\test.png";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(oripath));
        //字节流转图片对象
        Image ori_img = ImageIO.read(in);
//        设置图片的长宽和格式
/*        Scanner sc = new Scanner(System.in);
        System.out.println("输入宽和长，换行结束");
        int w = sc.nextInt();
        int h = sc.nextInt();*/
        int w = 500;
        int h = 500;
        List<String> list = new LinkedList<>();
        list.add("webp");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String format = it.next();
            String newfileName = w + "x" + h + "." + format;
//        构建图片流，这一步长宽如果不设置就会保留一个原尺寸的背景
            BufferedImage new_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            new_img.getGraphics().drawImage(ori_img, 0, 0, w, h, null);
//        创建Java2D对象
            Graphics2D g2d = new_img.createGraphics();
//        使用新图片作为背景
            g2d.drawImage(new_img, 0, 0, new_img.getWidth(), new_img.getHeight(), null, null);
//        设置透明度
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(ac);
//            新建一个文件夹名称就是当前设置的尺寸
            File newpath = new File("D:/" + w + "x" + h);
//            getWebp2(oripath,newpath + "\\" + newfileName);
            getWebp2(oripath,newpath + "\\" + w + "x" + h +".webp");
            newpath.mkdir();
//            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newpath + "\\" + newfileName));
//            ImageIO.write(new_img, format, out); //这里的格式和后缀名区别是什么？
//            in.close();
//            out.close();
        }
    }



    public static void getWebp2(String oripath, String newpath) throws IOException {
        /*
        提示系统找不到该文件，处理方法1：指令之间如果有空格而不用不同的字符串隔开，就会无法识别指令
        http://blog.csdn.net/iaiti/article/details/45268991
        处理方法2：重启，因为配置了Webp的环境变量，idea应用程序尚未识别到该程序
        */
        String cwebp ="cwebp";
//      "D:\\libwebp-0.4.2-windows-x64\\cwebp.exe";
        String cmd="";
        BufferedReader br = null;
//        List<String> commands = new ArrayList<String>();
//        commands.add(cwebp);
//        commands.add("-q 80");
//        commands.add(oripath);
//        commands.add("-o");
//        commands.add(newpath);
        try {
            Runtime run = Runtime.getRuntime();
////        String cmd = "";
//        for(int i=0;i<commands.size();i++)
//        {
//            cmd +=","+commands.get(i);
//        }

            System.out.println(cmd);
            ProcessBuilder builder = new ProcessBuilder();
//            builder.start();
            Process process = builder.command("cwebp","-q","80",oripath,"-o",newpath).start();
//            process = run.exec("cmd.exe /k start" + cmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
            System.out.println("1");
            String line =null;
            while (( line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        }catch (Exception e) {
            e.printStackTrace();}


    }

        public static void test02() {
            BufferedReader br = null;
            try {
                ProcessBuilder builder = new ProcessBuilder();
                Process process = builder.command("ipconfig").start();
                Process p = Runtime.getRuntime().exec("cwebp");
                br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;
                System.out.println("2");
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (br != null) {
                    try {
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}

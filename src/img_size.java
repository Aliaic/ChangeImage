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
 * ori_img：旧的图片对象
 * new_img:新图片对象
 * newfileName：新文件名称
 */

public class img_size {
    public static void main(String[] args) throws IOException {

//        读取图片
        String oripath = "D:\\test.png";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(oripath));
//        字节流转图片对象
        Image ori_img = ImageIO.read(in);

//        设置图片的长宽和格式
        Scanner sc = new Scanner(System.in);
        System.out.println("输入宽和长，换行结束");
        int w = sc.nextInt();
        int h = sc.nextInt();
//        调用setSize()设置尺寸,返回new_img
        Image new_img = setSize(ori_img,w,h);
//         新建一个文件夹名称就是当前设置的尺寸
        File newpath = new File("D:/" + w + "x" + h);
        newpath.mkdir();
        //生成webp格式图片
        getWebp2(oripath, newpath + "\\" + w + "x" + h + ".webp");
        //生成常用格式圖片
        getFormat(new_img,newpath,w,h);
        in.close();

    }

    public static void getFormat(Image ori_img, File newpath,int w, int h) throws IOException {
        List<String> list = new LinkedList<>();
        list.add("jpg");
        list.add("jpeg");
        list.add("gif");
        list.add("png");
        list.add("bmp");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String format = it.next();
            String newfileName = w + "x" + h + "." + format;
//        构建图片流，这一步长宽如果不设置就会保留一个原尺寸的背景
            BufferedImage new_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            new_img.getGraphics().drawImage(ori_img, 0, 0, w, h, null);
//            setSize(ori_img,w,h);
            setMark(new_img, newfileName);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newpath + "\\" + newfileName));
            ImageIO.write(new_img, format, out); //这里的格式和后缀名区别是什么？
            out.close();
        }
    }

    public static void setMark(BufferedImage new_img, String newfileName) {
//          创建Java2D对象
        Graphics2D g2d = new_img.createGraphics();
//        使用新图片作为背景
        g2d.drawImage(new_img, 0, 0, new_img.getWidth(), new_img.getHeight(), null, null);
//        设置透明度
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2d.setComposite(ac);
//        设置字体样式大小,颜色
        g2d.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        g2d.setColor(Color.black);
//        设置水印文字和起始坐标
        g2d.drawString(newfileName, 0, new_img.getHeight() / 2); //1/2*w和w/2有什么区别。为什么结果不一样
        g2d.dispose();   //这一步作用没太明白，大致意思同close
    }
    public static Image setSize(Image ori_img,int w, int h)
    {
        BufferedImage new_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        new_img.getGraphics().drawImage(ori_img, 0, 0, w, h, null);
        return (new_img);
    }

    public static void getWebp2(String oripath, String newpath) throws IOException {
        /*
        生成Webp格式图片
        提示系统找不到该文件，处理方法1：指令之间如果有空格而不用不同的字符串隔开，就会无法识别指令
        http://blog.csdn.net/iaiti/article/details/45268991
        处理方法2：重启，因为配置了Webp的环境变量，idea应用程序尚未识别到该程序
       "D:\\libwebp-0.4.2-windows-x64\\cwebp.exe";
        */
        BufferedReader br = null;

        try {
            Runtime run = Runtime.getRuntime();
            ProcessBuilder builder = new ProcessBuilder();
            Process process = builder.command("cwebp", "-q", "80", oripath, "-o", newpath).start();
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

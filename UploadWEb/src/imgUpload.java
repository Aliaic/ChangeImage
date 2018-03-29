
/**
 * Created by yuchao.liang on 2017/8/25.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;  //要是找不到这个包就去tomcat安装目录下lib里面找
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.
public class imgUpload extends HttpServlet {
    public  void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        //设置文件上传路径
        String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(savepath);
    }
}

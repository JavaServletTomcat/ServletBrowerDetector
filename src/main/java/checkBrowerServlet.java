import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class checkBrowerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getHeader("User-Agent");
        String brower = "Unknown Brower";
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        writer.println(info);

        if (info.contains("Firefox")){
            brower = "Mozzila Firefox";
        }else if(info.contains("Safari")){
            if(info.contains("Chrome")){
                brower = "Chrome";
            }else {
                brower = "Safari";
            }
        }else if(info.contains("OPR")){
            brower = "Opera";
        }

        writer.println("<br>You user: "+brower);
        writer.println("</body></html>");
    }
}

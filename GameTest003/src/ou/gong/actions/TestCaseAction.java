package ou.gong.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wlgo2108 on 2017/3/8.
 */
public class TestCaseAction  extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        doGet(req,resp) ;
    }

    public void tcAction(HttpServletRequest request,HttpServletResponse response ) {

        int pro_id = Integer.parseInt((String)request.getParameter("pro_id")) ;
        int game_id = Integer.parseInt((String)request.getParameter("game_id")) ;
        int issue = Integer.parseInt((String)request.getParameter("issue")) ;
        int station_id = Integer.parseInt((String)request.getParameter("station_id")) ;
        int station_cert = Integer.parseInt((String)request.getParameter("station_cert")) ;
        int type = Integer.parseInt((String)request.getParameter("type")) ;
        int stat = Integer.parseInt((String)request.getParameter("stat")) ;


    }
}

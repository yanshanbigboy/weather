package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.Admin;
import bean.User;
import dao.AdminDao;
import dao.UserDao;

public class Login extends HttpServlet {

	
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String enrolleeType=request.getParameter("enrolleeType");
		String validateCode=request.getParameter("validationCode");
		System.out.println("this is in servlet-Login"+name+password+validateCode);
		HttpSession session = request.getSession();
		String validation_code = (String)session.getAttribute("validation_code");
		
		//�ж��û����������Ƿ�Ϊ��
		if(password!=null&&name!=null){
		    //����ǹ���Ա��¼
		    if(enrolleeType.equals("admin")){    
			    Admin admin=new Admin(name,password);
			    String adminPasswordDB=AdminDao.adminLogin(admin);
			    System.out.println("this is servlet_Login adminPasswordDb "+adminPasswordDB);
			    if(adminPasswordDB!=null){
			    	
			        if(adminPasswordDB.equals(password)){
			    	    if(validateCode.equalsIgnoreCase(validation_code)){
			  	            System.out.println("��½�ɹ�");
			  	            int type=0;
			  	            session.setAttribute("type", type);
			  	            session.setAttribute("name", name);
			  	        
				            RequestDispatcher rd=request.getRequestDispatcher("AdminIndex.jsp");
				            rd.forward(request,response);
				        }else{
				    	    System.out.println("������ȷ+��֤�����");
				    	    Object[] options = { "ȷ��", "ȡ��" };
				    	    JOptionPane.showOptionDialog(null, "  �û������������", "Warning",
						    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						    null, options, options[0]); 
				    	    request.setAttribute(name, password);
				            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				            rd.forward(request,response);
				        }
			        }else{
			    	    System.out.println("�������+��½ʧ��");
			    	    Object[] options = { "ȷ��", "ȡ��" };
			    	    JOptionPane.showOptionDialog(null, "  �û������������", "����",
			    	    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			    	    null, options, options[0]); 
			    	    request.setAttribute(name, password);
				        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				        rd.forward(request,response);	
			        }
			        }else{
		        	System.out.println("�û�������+��½ʧ��");
		    	    Object[] options = { "ȷ��", "ȡ��" };
		    	    JOptionPane.showOptionDialog(null, "  �û������������", "����",
		    	    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		    	    null, options, options[0]); 
		    	    request.setAttribute(name, password);
			        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			        rd.forward(request,response);
		        }
		    }
		        //������û���¼
		    if(enrolleeType.equals("user")){
			    User user=new User(name,password);
			    String userPasswordDB=UserDao.userLogin(user);
			    if(userPasswordDB!=null){
			        if(userPasswordDB.equals(password) ){
			    	    if(validateCode.equalsIgnoreCase(validation_code)){
			    		    System.out.println("��½�ɹ�");
			    		    int t=1;
			  	            session.setAttribute("type", t);
			    		    session.setAttribute("name", name);
			    		    session.setAttribute("onlineUserBindingListener", new OnlineUserBindingListener(name));
				            RequestDispatcher rd=request.getRequestDispatcher("UserIndex.jsp");
				            rd.forward(request,response);	
				        }else{
				    	    System.out.println("������ȷ+��֤�����");
				    	    Object[] options = { "ȷ��", "ȡ��" };
				    	    JOptionPane.showOptionDialog(null, "  �û������������", "����",
				    	    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				    	    null, options, options[0]);
				    	    request.setAttribute(name, password);
				    	    RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				            rd.forward(request,response);
				        }
			        }else{
			    	    System.out.println("�������+��½ʧ��");
			    	    Object[] options = { "ȷ��", "ȡ��" };
			    	    JOptionPane.showOptionDialog(null, "  �û������������", "����",
			    	    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			    	    null, options, options[0]);
			    	    request.setAttribute(name, password);
				        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				        rd.forward(request,response);	
			        }
		        }else{
		        	System.out.println("�û�������+��½ʧ��");
		    	    Object[] options = { "ȷ��", "ȡ��" };
		    	    JOptionPane.showOptionDialog(null, "  �û������������", "����",
		    	    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		    	    null, options, options[0]); 
		    	    request.setAttribute(name, password);
			        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			        rd.forward(request,response);
		        }
		    	
		    }
		
		}else{
			Object[] options = { "ȷ��", "ȡ��" };
	    	JOptionPane.showOptionDialog(null, "  �û������������", "����",
	    	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	    	null, options, options[0]);
			request.setAttribute(name, password);
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		    rd.forward(request,response);
		}
			
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

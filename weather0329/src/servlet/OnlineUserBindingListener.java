package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class OnlineUserBindingListener implements HttpSessionBindingListener {
	String name;

	public OnlineUserBindingListener(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		List onlineUserList = (List) application.getAttribute("onlineUserList");
		if (onlineUserList == null) {
			onlineUserList = new ArrayList();
			application.setAttribute("onlineUserList", onlineUserList);
			System.out.println("sbsbsbsbsbsbsbsb");
		}
		onlineUserList.add(this.name);
		System.out.println(this.name + "µÇÂ¼¡£");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {

	}
}

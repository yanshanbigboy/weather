package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class OnlineUserBindingListener implements HttpSessionBindingListener {
	String name;

	public OnlineUserBindingListener() {
		super();
	}

	public OnlineUserBindingListener(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		List<OnlineUserBindingListener> onlineUserList = (List) application.getAttribute("onlineUserList");
		if (onlineUserList == null) {
			onlineUserList = new ArrayList();
			application.setAttribute("onlineUserList", onlineUserList);
			System.out.println("sbsbsbsbsbsbsbsb");
		}
		OnlineUserBindingListener listener = new OnlineUserBindingListener(
				this.name);
		onlineUserList.add(listener);
		System.out.println(this.name + "µÇÂ¼¡£");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {

	}
}

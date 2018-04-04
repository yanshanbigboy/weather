<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<%@page import="java.util.List" %>
<head>
</head>
<html>
        <h3>您好：${name} [<a href="Logout.jsp">注销</a>]</h3>
                             当前在线用户：
        <table>
        <%
             List onlineUserList=(List)application.getAttribute("onlineUserList");
             for(int i=0;i<onlineUserList.size();i++){
             String onlineUsername=(String)onlineUserList.get(i);
         %>
            <tr>
                  <td><%=onlineUsername%>></td>
            </tr>
         <%
            }
          %>
        </table>

</html>
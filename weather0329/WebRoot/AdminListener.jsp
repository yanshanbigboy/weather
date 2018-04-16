<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!-- start of header -->
<jsp:include page="/pattern/Header.jsp"></jsp:include>
<!-- end of header -->

<c:if test="${user!=null||admin!=null }">
	<p4> 您好：${user.userName}${admin.adminName} [<a
		href="logout.listener">注销</a>] </p4>
</c:if>
<h3>
	当前在线用户：
	<table>
		<c:forEach var="onlineUser" items="${onlineUserList }">
			<tr>
				<td>${onlineUser.name}</td>
			</tr>
		</c:forEach>
	</table>
</h3>
<!--start of footer  -->
<jsp:include page="/pattern/Footer.jsp"></jsp:include>
<!--end of footer  -->

<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="common/head.jsp"%>
<html lang="zh-CN">
<body>
	<div class="login-content">
		<form action="/bms/user/login" method="post">
			<div class="user-login">
				<div class="user-login-title">管理员登录</div>
			    <%@ include file="common/message.jsp"%>
				<div>
					<label>帐号</label><input type="text" name="username" id="userName"
					 maxlength="12" value="${userForm.username}" placeholder="帐号">
				</div>
				<div>
					<label>密码</label><input type="password" name="password" id="password"
                        maxlength="12" value="${userForm.password}" placeholder="密码">
				</div>
				<div class="user-login-save">
					<label>&nbsp;</label><button type="submit">登录</button>
				</div>
			</div>
		</form>
	</div>
</body>
<%@ include file="common/foot.jsp"%>
</html>
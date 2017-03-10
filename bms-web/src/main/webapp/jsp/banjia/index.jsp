<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<html lang="zh-CN">
<body>
<div class="body">
      <%@ include file="../common/menu.jsp"%>
      <div class="content" style="font-size:18px;padding:33px 30xp;">
        <div>数据库管理</div>
        <div class="tables">
            <div class="table"><a href="#">user</a></div>
            <div class="table"><a href="#">card</a></div>
            <div class="table"><a href="#">introduce</a></div>
            <div class="table"><a href="#">location</a></div>
            <div class="table"><a href="#">type</a></div>
            <div class="table"><a href="#">user_location</a></div>
            <div class="table"><a href="#">user_type</a></div>
            <div class="table"><a href="#">article</a></div>
        </div>
      </div>
    </div>
</body>
<%@ include file="../common/foot.jsp"%>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start message -->
<c:choose>
    <c:when test="${msg != null}">
	    <div class="divMsg" role="alert">
		    <span><c:out value="${msg.content}" /></span>
	    </div>
    </c:when>
    <c:otherwise>
        <div class="divMsg" role="alert">
            <span></span>
        </div>
    </c:otherwise>
</c:choose>
<!-- end message -->
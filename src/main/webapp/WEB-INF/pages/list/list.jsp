<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="pag" uri="/WEB-INF/tags/paginate.tld"%>

<tag:layout>

    <div id="mainPage">
        <jsp:include page="styles.jsp"/>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div style="margin-left: 15%; margin-right: 15%;">
                <div style="text-align: center">
                    <h2><b><spring:message code="messages.taskManager"/></b></h2>
                    <h4 style="margin-top: -10px; margin-bottom: 50px">FROM SOFTSERVE</h4>
                </div>
                <jsp:include page="taskListView.jsp"/>
                <jsp:include page="modals/editTask.jsp"/>
                <jsp:include page="modals/deleteTask.jsp"/>
                <div style="text-align: center">
                    <c:if test="${not empty tasks}">
                        <pag:paginate max="5" offset="${offset}" count="${count}"
                                      uri="/list" next="&raquo;" previous="&laquo;" />
                    </c:if>
                </div>
            </div>

        </div>

        <jsp:include page="footer.jsp"/>
    </div>
</tag:layout>

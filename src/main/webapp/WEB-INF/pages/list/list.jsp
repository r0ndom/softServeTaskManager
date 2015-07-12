<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:layout>
    <jsp:include page="styles.jsp"/>
    <div id="mainPage">
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div style="margin-left: 15%; margin-right: 15%;">
                <div style="text-align: center">
                    <h2><b>TASK MANAGER</b></h2>
                    <h4 style="margin-top: -10px; margin-bottom: 50px">FROM SOFTSERVE</h4>
                </div>
                <div style="text-align: center" id="lists">
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
</tag:layout>

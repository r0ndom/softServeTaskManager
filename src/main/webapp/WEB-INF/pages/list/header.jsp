<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-inner">
        <div class="container-fluid">
            <form action="/j_spring_security_logout" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button id="submitButton" type="submit" class="navbar-text navbar-right submitButton"
                        style="padding-right: 40px; padding-top: 10px">
                    <b><spring:message code="messages.exit"/></b>
                    <img src="${pageContext.request.contextPath}/resources/img/exit.png"/>
                </button>
            </form>
        </div>
    </div>
</nav>
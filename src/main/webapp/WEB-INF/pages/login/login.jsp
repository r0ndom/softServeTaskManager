<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
    <script>
        function showPasswordLogin() {
            if ($('#password').get(0).type =='password') {
                $('#password').get(0).type='text';
            } else {
                $('#password').get(0).type='password';
            }
        }
    </script>
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }
    </style>
    <div id="wrapper">
        <div class="container">
            <div class="row col-md-6 col-md-offset-4" style="margin-top: 10%">
                <form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST' style="margin-left: 30px">
                    <div class="row">
                        <div class="col-md-4"><h3><spring:message code="messages.signIn"/></h3></div>
                        <div class="col-md-3" style="text-align: right; margin-top: 20px">
                            <h5><a href="/register" style="text-decoration: underline;">Sign Up</a></h5></div>
                    </div>
                    <div class="row">
                        <div class="col-md-7">
                            <c:if test="${not empty error}">
                                <div class="error">${error}</div>
                            </c:if>
                            <c:if test="${not empty msg}">
                                <div class="msg">${msg}</div>
                            </c:if>
                        </div>
                    </div>
                    <div class="row"><div class="col-md-7" style="margin-bottom: 10px;">
                        <input class="col-md-3 form-control" id="username" name="username"
                               placeholder="Email" type="text" style="height: 38px;">
                    </div></div>
                    <div class="row"><div class="col-md-7" style="margin-bottom: 10px;">
                        <input class="col-md-3 form-control" id="password" name="password"
                               placeholder="Password" type="password" style="height: 38px;">
                    </div></div>
                    <div class="row" style="margin-bottom: 5px">
                        <div class="col-md-4">
                            <input type="checkbox" name="showPassword" onchange="showPasswordLogin();">Show Password
                        </div>
                    </div>
                    <div class="row"><div class="col-md-7">
                        <input class="btn btn-primary" style="width: 100%; height: 40px" value="Sign In" type="submit"></div></div>
                </form>
            </div>
        </div>
    </div>
</tag:layout>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tag:layout>
    <style>
        label {
            padding-top: 10px;
        }
    </style>
    <div id="wrapper">
        <div class="container">
            <div class="row col-md-6 col-md-offset-4" style="margin-top: 10%">
                <h3>Sign Up</h3>
                <form:form method="POST" id="register" action="/addNewUser" onsubmit="return validate()">
                    <div class="row">
                        <div class="col-md-2">
                            <label>Email</label>
                        </div>
                        <div class="col-md-6">
                            <form:input id="email" cssClass="form-control" path="email" required="required"/>
                        </div>
                    </div>
                    <p></p>
                    <div class="row">
                        <div class="col-md-2">
                            <label>Password</label>
                        </div>
                        <div class="col-md-6">
                            <form:password id="password" cssClass="form-control" path="password" required="required"/>
                        </div>
                    </div>
                    <p></p>
                    <div class="row">
                        <div class="col-md-2">
                            <label>Confirm password</label>
                        </div>
                        <div class="col-md-6">
                            <input class="form-control" id="confirm" type="password" required="required">
                        </div>
                    </div>
                    <p></p>
                    <label id="tip" style="color: red" hidden="hidden"></label>
                    <p></p>
                    <div class="row"><div class="col-md-8">
                        <input class="btn btn-success" style="width: 100%; height: 40px" value="Sign Up" type="submit"></div></div>
                </form:form>
            </div>
        </div>
    </div>
</tag:layout>

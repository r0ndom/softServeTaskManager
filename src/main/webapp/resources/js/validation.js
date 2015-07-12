function validate() {
    var isValid;
    var email = $("#email").val();
    var ajaxRequest = $.ajax({
        url: "/validate/",
        method: "GET",
        data: {email : email},
        success: function(result) {
            isValid = isUserExist(result);
        }
    });
    $.when(ajaxRequest).done(isValid = checkRegistrationForm(email));
    return isValid;
}

function isUserExist(status) {
    if (status) {
        setTipTextAndShow("User with this email has already exist!");
        return false
    }
}

function checkRegistrationForm(email) {
    var password = $("#password").val();
    var confirm = $("#confirm").val();
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!filter.test(email)) {
        setTipTextAndShow("Please enter valid email!");
        return false;
    }
    if (password == confirm) {
        return true;
    } else {
        setTipTextAndShow("Password and Conform password isn't match!");
        return false;
    }
}

function setTipTextAndShow(text) {
    $("#tip").text(text);
    $("#tip").show();
}
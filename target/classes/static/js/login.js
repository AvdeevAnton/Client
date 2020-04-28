$(document).ready(function () {

    let user = {};

    $('#btnLogin').click(function (name) {
        user.username = $('#txtUsername').val();
        user.password = $('#txtPassword').val();

        let userObj = JSON.stringify(user);
        $.ajax({
            url: "/restUsers/loginToken",
            method: "POST",
            data: userObj,
            contentType: 'application/json; charset=utf-8',
            complete: function (XMLHttpRequest) {
                //var headers = XMLHttpRequest.getAllResponseHeaders();
                let headers = XMLHttpRequest.getResponseHeader('Authorization');
                $.cookie('token',headers);
                document.location.href = 'http://localhost:8091/users/list';
            },
            error: function () {
                alert("хрень");
            }
        });
    });
});


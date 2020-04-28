function getNewUser2(userObj) {
    $.ajax({
        url: "/restUsers/userRest/save",
        method: "POST",
        data: userObj,
        contentType: 'application/json; charset=utf-8',
        headers:{
            'Authorization': $.cookie('token')
        },
        success: function () {
            getAllUsers();
            reset();
        },
        error: function (error) {
            alert(error);
        }
    })
}
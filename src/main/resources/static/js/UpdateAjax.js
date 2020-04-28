
function update2(id) {
    $.ajax({
        url: '/restUsers/userRest/' + id,
        method: 'GET',
        dataType: 'json',
        headers:{
            'Authorization': $.cookie('token')
        },

        success: function (data) {

            $('#name').val(data.name);
            $('#serName').val(data.serName);
            $('#age').val(data.age);
            $('#txtId').val(data.id);
        },
    });
    $('#btnUpdateUser').click(function (data) {
        data.name = $('#name').val();
        data.serName = $('#serName').val();
        data.age = $('#age').val();
        //updateUser(id);
        let userNew = JSON.stringify(data);
        $.ajax({
            url: '/restUsers/userRest/update/' + id,
            method: 'PUT',
            data: userNew,
            contentType: 'application/json; charset=utf-8',
            headers:{
                'Authorization': $.cookie('token')
            },
            success: function () {
            },
            error: function () {
                alert("Ошибка редактирования");
            }
        })

    })
}
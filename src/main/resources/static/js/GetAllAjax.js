function getAllUsers2() {
    $.ajax({
        url: "/restUsers/userRestList/",
        method: "GET",
        dataType: "json",
        headers:{
            'Authorization': $.cookie('token')
        },
        success: function (data) {
            let tableBody = $('#tblUser tbody');
            tableBody.empty();
            $(data).each(function (index, val) {
                tableBody.append('<tr>' +
                    '<td>' + val.name + '</td>' +
                    '<td>' + val.serName + '</td>' +
                    '<td>' + val.age + '</td>' +
                    '<td><button onclick = "update(' + val.id + ')" class="btn btn-primary" data-toggle="modal" data-target="#myModal">\n' +
                    '                                            <i class="fas fa-user-edit ml-2">Edit</button></td>' +
                    '<td><button onclick = "deleteUser(' + val.id + ')" class="btn btn-primary"><i class="fas fa-user-times ml-2"></i>Delete</button></td></tr>');
            })
        },
        error: function (error) {
            alert("Вывод всех пользователей");
        }
    })
}
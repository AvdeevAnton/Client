
function deleteUser2(id) {
    $.ajax({
        url: '/restUsers/userRest/delete/' + id,
        method: 'DELETE',
        headers:{
            'Authorization': $.cookie('token')
        },
        success: function () {
            getAllUsers();
        },
        error: function () {
            alert("Ошибка удаления");
        }
    });
}

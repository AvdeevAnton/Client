$(document).ready(function () {
    $('#myModal').on('show.bs.modal', function (event) {
        const button = $(event.relatedTarget);
        // извлечь информацию из атрибута data-content
        const name = button.data('name');
        const serName = button.data('serName');
        const age = button.data('age');
        // вывести эту информацию в элемент, имеющий id="content"
        const modal = $(this);
        modal.find('#name').val(name);
        modal.find('#serName').val(serName);
        modal.find('#age').val(age);
    });

    let user = {};

    getAllUsers();
    $('#btnAddUser').click(function () {
        user.name = $('#txtName').val();
        user.serName = $('#txtSerName').val();
        user.age = $('#txtAge').val();
        let userId = $('#txtId').val();
        let userObj = JSON.stringify(user);
        getNewUser(userObj);
    })
});

function getNewUser(userObj) {
    getNewUser2(userObj);
}

function getAllUsers() {
    getAllUsers2();
}

function deleteUser(id) {
    deleteUser2(id);
}

function update(id) {
    update2(id);
}

function reset() {
    $('#txtName').val('');
    $('#txtSerName').val('');
    $('#txtAge').val('');
    $('#txtId').val('');
}

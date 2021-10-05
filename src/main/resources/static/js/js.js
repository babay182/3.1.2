$(document).ready(function () {
    console.log("ksdbfjhs")
    $('.eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #id').val(user.id);
            $('.myForm #name').val(user.name);
            $('.myForm #surname').val(user.surname);
            $('.myForm #age').val(user.age);
            $('.myForm #email').val(user.email);
            $('.myForm #roles').val(user.roles);
            var rol = document.getElementById("roles")
            console.log(rol)
            // $('.myForm #roles').empty();
            $('.myForm #editModal').modal();
        });
    });
});
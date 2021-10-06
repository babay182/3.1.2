$(document).ready(function () {

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
            $('.myForm #editModal').modal();
        });
    });

    $('.dBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myDelForm #id').val(user.id);
            $('.myDelForm #name').val(user.name);
            $('.myDelForm #surname').val(user.surname);
            $('.myDelForm #age').val(user.age);
            $('.myDelForm #email').val(user.email);
            $('.myDelForm #roles').val(user.roles);
            $('.myDelForm #deleteModal').modal();
        });
    });
});
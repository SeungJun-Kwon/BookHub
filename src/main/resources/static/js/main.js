$(function () {
    getAllUsers();
});

function getAllUsers() {
    $.get("/users", function(result) {
        let html;
        $.each(result, function(i, v) {
            html += `<tr>\n`;
            html += `<td>${v.userId}</td>\n`
            html += `<td>${v.userName}</td>\n`
            html += `<td>${v.createdAt}</td>\n`
            html += `<td>${v.modifiedAt}</td>\n`
            html += `</tr>\n`
        })

        $("#user-table-body").append(html);
    })
}
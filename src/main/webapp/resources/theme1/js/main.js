function newCategoryDoAjaxPost() {
    var name = $("#category_name").val();
    var description = $("#category_description").val();
    var json = {name: name, description: description};

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "/admin/addNewCategory",
        dataType: 'json',
        data: JSON.stringify(json),

        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function (response) {
            console.log(response);
            display(response)

        }
    })
}
function display(data) {
    var json = "<h4>Ajax Response</h4><pre>"
        + JSON.stringify(data, null, 4) + "</pre>";
    $('#feedback').html(json);
}
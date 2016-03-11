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
            displayCategory(response)

        }
    })
}

function displayProduct(data) {
    var info = "Product :<strong>" +data.name +"</strong> successfully added";
    $('#feedback').html(info);
}


function displayCategory(data) {
    var info = "Category :<strong>" +data.name +"</strong> successfully added";
    $('#feedback').html(info);
}

function newProductDoAjaxPost() {
    var id = $("#product_category").val();
    var name = $("#product_name").val();
    var price = $("#product_price").val();
    var amount = $("#product_amount").val();
    var description = $("#description").val();
    var json = {id: id, name: name, price: price, availableAmount: amount, description: description};

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "/admin/addNewProduct",
        dataType: 'json',
        data: JSON.stringify(json),
        beforeSend: saveMedia(),
        success: function (response) {
            displayProduct(response)

        }
    });
}

function saveMedia() {
    var formData = new FormData();
    formData.append('file', $('input[type=file]')[0].files[0]);
    console.log("form data " + formData);
    $.ajax({
        url : '/imageDisplay',
        data : formData,
        processData : false,
        contentType : false,
        type : 'POST'
    });
}

function putToBucketAjaxPost(id) {
    $.ajax({
        type: "POST",
        url: "/bucket",
        data: "id=" + id,

        success: function (response) {
            $('#feedback').html(response);
        }
    })
}
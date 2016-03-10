<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new category</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script type="text/javascript">
        function doAjaxPost() {
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
            var json = "<h4>Added category</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
        }

    </script>
</head>
<body>

<label for="category_name">Category name : </label>
<input name="name" id="category_name"/></td>

<label for="category_description">Category description : </label>
<input name="description" id="category_description"/>

<input type="button" value="NEW!!! Add Users" onclick="doAjaxPost()">


<div id="feedback"></div>
</body>
</html>
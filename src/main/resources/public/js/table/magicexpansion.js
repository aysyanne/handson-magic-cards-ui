$(document).ready(function() {
    $('.dataTableExpansion').DataTable( {
                "bFilter":false,
                "processing": true,
                "serverSide": true,
                "ajax": "/magicexpansion/data",
                "columns": [
                    {"data":"expansionId"},
                    {"data":"ptBrName"},
                    {"data":"launchDate"},
                    {"data":"expansionCategoryId"},
                    {"data":"promo"},
                    {"data":"legal"},
                    {
                        "data": null,
                        "render": function (data, type, row, meta) {
                            return '<a href="/magicexpansion/update/' + row['expansionId'] + '" class="editor_edit">Edit</a> | <a href="/magicexpansion/delete/' + row['expansionId'] + '" class="editor_remove">Delete</a>';
                        }
                    }
                ]
            });
}
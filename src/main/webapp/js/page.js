function page_turn(url, currentPage) {
    $.ajax({
        url: url + "/" + currentPage,
        data: {},
        dataType: "html",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            $("div.news").html(data);
        },
        error: function () {
            poptip("系统错误");
        }
    });
}
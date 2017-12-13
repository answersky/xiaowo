function apply(tel, name, resource, source) {
    var city = $("#zone").val();
    $.ajax({
        url: "/apply",
        data: {
            username: name,
            tel: tel,
            city: city,
            resource: resource,
            source: source,
            channel: "7"
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            poptip(data);
            //延时2秒消失
            timedMsg();
        },
        error: function () {
            poptip("系统错误");
            timedMsg();
        }
    });
}

//延时执行
function timedMsg() {
    var t = setTimeout("location.reload();", 2000)
}
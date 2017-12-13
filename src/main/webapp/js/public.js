/**
 * Created by zuyu on 2017/12/5
 */

$(function () {
    //默认加载城市
    var city = $("#zone").val();
    var zones = $("#zones").val();
    zones = eval('(' + zones + ')');
    for (var i = 0; i < zones.length; i++) {
        var zone = zones[i]['zone'];
        if (city == zone) {
            $('.curCity').html(city + '>');
        }
    }

    //城市选择
    selectCity();
    function selectCity() {
        $('.curCity').click(function () {
            $('.cityList').toggle();
            $('.cityList ul li').click(function () {
                var city = $(this).html();
                $('.curCity').html(city + '>');
                $('.cityList').hide();
            })
        })
    }

});


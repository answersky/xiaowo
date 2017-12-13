/**
 * Created by zuyu on 2017/12/5
 */

$(function () {

    $(window).resize(function () {
        Banner();
    })
    $(window).load(function () {
        Banner();
    })

    function Banner() {

        // swiper大轮播
        var header = $('#wrap-header').height();
        var h = $(window).height() - header;
        var w = $(window).width();

        $('.swiper-slide ,.swiper-slide div').height(h).width(w);

        var swiper = new Swiper('.swiper-container', {
            loop: true,
            pagination: '.swiper-pagination',
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',

            paginationClickable: true,
            parallax: true,
            centeredSlides: true,
            speed: 600,
            autoplay: 2500,
            autoplayDisableOnInteraction: false,
            onInit: function (swiper) { //Swiper2.x的初始化是onFirstInit
                swiperAnimateCache(swiper); //隐藏动画元素
                swiperAnimate(swiper); //初始化完成开始动画
            },
            onSlideChangeEnd: function (swiper) {
                swiperAnimate(swiper); //每个slide切换结束时也运行当前slide动画
            }

        });


    }

    $("#cusphone").keyup(function () {
        var code = $.trim($(this).val());
        code = code.replace(/[^0-9]/g, "");
        $(this).val(code);
    });

    $("#phoneNumber").keyup(function () {
        var code = $.trim($(this).val());
        code = code.replace(/[^0-9]/g, "");
        $(this).val(code);
    });

    $("#userphone").keyup(function () {
        var code = $.trim($(this).val());
        code = code.replace(/[^0-9]/g, "");
        $(this).val(code);
    });
})

//计算分期额度
function calculate() {
    //获取房屋面积
    var space = $("#housearea").val();
    //地区
    var city = $("#cuscity").val();
    //期数
    var periods = $("#periods").val();
    //电话
    var tel = $("#phoneNumber").val();

    if (space == null || space == '') {
        poptip("请输入房屋面积");
        return false;
    }
    if (city == null || city == '') {
        poptip("请选择房屋所在的城市");
        return false;
    }
    if (periods == null || periods == '') {
        poptip("请选择期数");
        return false;
    }
    if (tel == null || tel == '') {
        poptip("请输入电话");
        return false;
    }
    if (!(/^1[34578]\d{9}$/.test(tel))) {
        poptip("手机号码有误，请重填");
        return false;
    }

    //计算
    var quota = space * city;
    var monthlyRepayment = quota / periods;
    monthlyRepayment = monthlyRepayment.toFixed(2);
    console.log("总额度：" + quota);
    console.log("月还款：" + monthlyRepayment);
    //显示计算结果
    $("#quota").text(quota);
    $("#monthlyRepayment").text(monthlyRepayment);

    //计算完成后全部置空
    $("#housearea").val("");
    $("#cuscity").val("");
    $("#periods").val("");
    $("#phoneNumber").val("");

    //申请
    apply(tel, "nickname", "official_website", "website");
}

//首页banner申请
function applyIndex() {
    var username = $("#cusname").val();
    var tel = $("#cusphone").val();
    if (username == null || username == '') {
        poptip("请输入称呼");
        return false;
    }
    if (tel == null || tel == '') {
        poptip("请输入手机号");
        return false;
    }
    if (!(/^1[34578]\d{9}$/.test(tel))) {
        poptip("手机号码有误，请重填");
        return false;
    }

    apply(tel, username, "official_website", "website");
}

function poptip(content, timeOut) {
    if (!document.getElementById('poptip')) {
        var poptip = document.createElement("div");
        poptip.setAttribute('id', 'poptip');
        document.getElementsByTagName("body")[0].appendChild(poptip);
    }
    $('#poptip').show();
    var para = {
        'content': content,
    };
    var sourceHtml = '<div class="pop">' +
        '<div class="content">' + content + '</div>' +
        '</div>' +
        '<div class="mask"></div>';
    poptip = document.getElementById('poptip');
    poptip.innerHTML = sourceHtml;
    var hidePoptip = function () {
        var poptip = document.getElementById('poptip'),
            content = document.getElementsByClassName('content')[0];
        poptip.innerHTML = '<div class="mask"></div>';
        $('#poptip').hide();
    };
    document.getElementsByClassName('mask')[0].onclick = hidePoptip;

    setTimeout(hidePoptip, (timeOut || 2000));

}
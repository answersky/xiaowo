<!DOCTYPE>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>小窝金服家装分期服务平台</title>
    <meta name="viewport" content="width=750,user-scalable=no,target-densitydpi=device-dpi"/>
    <meta name="description" content="装饰的不仅是你的房，还有你的梦"/>
    <meta name="keywords" content="装修分期、装修贷款、家装分期、装修预算、装修报价"/>
    <link rel="stylesheet" href="../../${res}/css/sz/base.css">
    <link rel="stylesheet" href="../../${res}/css/sz/index.css">
    <link rel="shortcut icon" href="../../${res}/img/xw.ico" type="image/x-icon">
</head>

<body>

<header class="flex header">
    <img src="../../${res}/img/sz/logo-small.png" alt="小窝LOGO"/>
    <a href="tel:4000755020">400-0755-020</a>
</header>
<section class="bg-orange">
    <img src="../../${res}/img/sz/banner.png"/>
    <div class="form-phone align-center">
        <input type="number" class="btn btn-input placeColor" name="phoneNum" id="phoneNum" value=""
               placeholder="输入您的手机号码"/>
        <input type="button" class="btn btn-submit" id="phoneSub" value="免费领取设计方案"/>
    </div>
</section>
<section class="bg-orange">
    <ul class="houseList align-center gray-1">
        <li>
            <dl>
                <dt>—— 现代简约风格 ——</dt>
                <dd class="housePho"><img src="../../${res}/img/sz/photo-1.png" alt="风格照片"/></dd>
                <dd class="align-center"><input type="button" class="btn btn-house" id="" value="领取更多方案"/></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>—— 欧式古典风格 ——</dt>
                <dd class="housePho"><img src="../../${res}/img/sz/photo-2.png" alt="风格照片"/></dd>
                <dd class="align-center"><input type="button" class="btn btn-house" id="" value="领取更多方案"/></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>—— 现代英伦风格 ——</dt>
                <dd class="housePho"><img src="../../${res}/img/sz/photo-3.png" alt="风格照片"/></dd>
                <dd class="align-center"><input type="button" class="btn btn-house" id="" value="领取更多方案"/></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>—— 田园风格 ——</dt>
                <dd class="housePho"><img src="../../${res}/img/sz/photo-4.png" alt="风格照片"/></dd>
                <dd class="align-center"><input type="button" class="btn btn-house" id="" value="领取更多方案"/></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>—— 中式风格 ——</dt>
                <dd class="housePho"><img src="../../${res}/img/sz/photo-5.png" alt="风格照片"/></dd>
                <dd class="align-center"><input type="button" class="btn btn-house" id="" value="领取更多方案"/></dd>
            </dl>
        </li>
    </ul>
</section>

<div id="footer" class="align-center bg-white">
    <img src="../../${res}/img/sz/logo-large.png"/>
    <p class="clr linkList align-center">
        <a href="javascript:;">关于小窝</a>
        <a href="javascript:;">联系我们</a>
        <a href="javascript:;">常见问题</a>
        <a href="javascript:;">免责声明</a>
        <a href="javascript:;">建议与投诉</a>
    </p>
    <p>Copyright © 2015 小窝金服ixiaowo.com 版权所有 粤ICP备14055618号-2</p>
    <p></p>
</div>

</div>

<div id="poptip" style="display: none;">
    <div class="mask">
        <!--	<div class="cnt align-center">
                <h3></h3>
                <h4>领取成功</h4>
                <p>奖品换取方式将以短信形式通知到您，<br>请注意查收！</p>
                <input type="button" class="btn btn-pop " name="" id="" value="确认" />
                <div class="icon-del"></div>
            </div>-->
        <!--<div class="cash align-center">
            <span class="icon-xiaowo"></span>
            <h4>小窝金服</h4>
            <p class="fontsize-6">发了一个红包，金额随机</p>
            <span class="icon-open"></span>
            <div class="icon-del"></div>
        </div>-->
        <!--<div class="cash-open white align-center">
            <span class="icon-xiaowo"></span>
            <h4>小窝金服</h4>
            <div class="cash-detail align-left">
                <h3>恭喜您抽中：</h3>
                <p>价值<span class="fontsize-1 bold">7000</span>元专属设计费用</p>
                <p><span class="fontsize-1 bold">30 </span>万额度低息装修贷款</p>
            </div>
            <input type="number" class="btn btn-inputphone" name="phoneNum" id="phoneNum" value="" placeholder="输入您的手机号码" />
            <input type="button" class="btn btn-pop " name="" id="" value="确认" />
            <div class="icon-del"></div>
        </div>-->

    </div>
</div>
</div>
<script src="../../${res}/js/jquery-1.11.3.min.js"></script>
</body>

</html>
<script>
    $(function () {

        //弹出广告
        setTimeout(popAd, 3000)

        //提交电话
        $('#phoneSub').click(function () {
            submitPhone($('#phoneNum').val())
        })

        //回到顶部
        $(".btn-house").click(function () {
            $('html, body').animate({
                scrollTop: 0
            }, 500);
        });
    })

    //关闭弹窗
    function closePopBox() {
        $('.icon-del').click(function () {
            $('.mask').html('').hide();
        })
    }

    //打开红包
    function cashOpen() {
        var html = ' <div class="cash-open white align-center">' +
                ' <span class="icon-xiaowo"></span>' +
                ' <h4>小窝金服</h4>' +
                ' <div class="cash-detail align-left">' +
                ' <h3>恭喜您抽中：</h3>' +
                ' <p>价值<span class="fontsize-1 bold">7000</span>元专属设计费用</p>' +
                ' <p><span class="fontsize-1 bold">30 </span>万额度低息装修贷款</p>' +
                ' </div>' +
                ' <input type="number" class="btn btn-inputphone" name="phoneNumCash" id="phoneNumCash" value="" placeholder="输入您的手机号码" />' +
                ' <input type="button" class="btn btn-pop " name="confirmCash" id="confirmCash" value="确认" />' +
                ' <div class="icon-del"></div>' +
                ' </div>';
        $('.mask').show().html(html);
        closePopBox();
        $('#confirmCash').click(function () {
            submitPhone($('#phoneNumCash').val(), true)
        })
    }

    //提交电话
    function submitPhone(phoneNum, flag) {
        if (phoneNum == undefined || phoneNum == "") {
            poptip("请输入手机号", 2000, flag);
            return false
        } else if (!(/^1[34578]\d{9}$/.test(phoneNum))) {
            poptip("手机号码有误，请重填", 2000, flag);
            return false;
        } else {
            //提交电话号码到后台
            $.ajax({
                url: "/apply.jspx",
                data: {
                    nickName: "nickname",
                    phone: phoneNum,
                    resource: "WebPromotion",
                    relevanceSource: "jrtt-mobile",
                    importMode: "Other",
                    relevanceSourceId: "22"
                },
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (data) {
                    if (data.msg == "1") {
                        //进件成功提示
                        var content = "[小窝金服家装分期]恭喜您成功领取免费装修设计服务以及30万装修分期额度，为了详细了解您的装修需求，稍后小窝金服客户顾问会联系您，为您免费提供装修咨询及装修分期服务。";
                        $.ajax({
                            url: "/sendMsg1.jspx",
                            method: 'post',
                            data: {
                                phone: phoneNum,
                                content: content
                            },
                            contentType: "application/x-www-form-urlencoded; charset=utf-8",
                            success: function (data) {
                                if (data == "true") {
                                    //进件成功提示
                                    showSuccess();
                                }
                            }
                        });

                    } else if (data.msg == "-5") {

                    } else if (data.msg == "2") {

                    }
                }
            });
        }

        //成功显示
        function showSuccess() {
            var htmlSuccess = '<div class="cnt align-center">' +
                    '<h3></h3>' +
                    '<h4>领取成功</h4>' +
                    '<p>奖品换取方式将以短信形式通知到您，<br>请注意查收！</p>' +
                    '<input type="button" class="btn btn-pop " name="successConfirm" id="successConfirm" value="确认" />' +
                    '<div class="icon-del"></div>' +
                    '</div>';
            $('.mask').show().html(htmlSuccess);
            closePopBox();
            $('#successConfirm').click(function () {
                $('.mask').html('').hide();
            })
        }

    }

    //广告
    function popAd() {
        var htmlAd = '<div class="cash align-center">' +
                '<span class="icon-xiaowo"></span>' +
                '<h4>小窝金服</h4>' +
                '<p class="fontsize-6">发了一个红包，金额随机</p>' +
                '<span class="icon-open"></span>' +
                '<div class="icon-del"></div>' +
                '</div>';
        $('#poptip').show();
        $('.mask').show().html(htmlAd);
        $('.icon-open').click(cashOpen);
        closePopBox();
    }


    function poptip(content, timeOut, flag) {
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
            if (!flag) {
                $('#poptip').hide()
            } else {
                cashOpen()
            }
        };
        document.getElementsByClassName('mask')[0].onclick = hidePoptip;

        setTimeout(hidePoptip, (timeOut || 2000));


    }

</script>
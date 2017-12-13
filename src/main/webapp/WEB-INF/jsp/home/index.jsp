<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>深圳家装分期_装修贷款_家装贷款_信用装修_装修分期_小窝金服-小窝金服</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="keywords" content="深圳家装分期,装修贷款,家装贷款,信用装修,装修分期,小窝金服"/>
    <meta http-equiv="description"
          content="小窝金服家装分期服务平台，以“为客户提供低成本的装修分期服务”为经营理念，为广大家装用户提供低利率、高额度、长期限、纯信用的装修分期产品。小窝金服还与装修公司、家具卖场、电商平台等合作，提供一站式装修分期服务，让你的装修没有资金烦恼，省心入住自己的小窝。"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>
</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->
<!--banner-->
<div class="wrap-container relative">
    <div class="swiper">
        <div class="swiper-container swiper-container-horizontal">
            <div class="swiper-wrapper">
                <c:forEach items="${banners}" var="banner">
                    <a class="swiper-slide" href="${banner.picture.url}" target="_blank">
                        <div style="background: url(${banner.picture.path}) no-repeat center;"></div>
                    </a>
                </c:forEach>
            </div>
            <div class="swiper-pagination swiper-pagination-white swiper-pagination-clickable swiper-pagination-bullets"></div>

        </div>
    </div>
    <div class="bannerForm">
        <h4>申请装修分期</h4>
        <input type="text" class="cusname" name="cusname" id="cusname" placeholder="您的称呼"/>
        <input type="text" class="cusphone" name="cusphone" id="cusphone" placeholder="请输入您的电话方便我们联系" maxlength="11"/>
        <input type="button" class="cusbtn" name="cusbtn" id="cusbtn" value="立即申请" onclick="applyIndex()"/>
    </div>
</div>
<!--banner结束-->

<!--小窝特点-->
<div class="wrap-container">
    <div class="content1">
        <div class="title">
            <h4>专业的装修分期平台</h4>
            <div class="titleline"></div>
        </div>
        <ul class="features">
            <li>
                <dl>
                    <dt class="feature-highvalue"></dt>
                    <dd>
                        <h5>额度高</h5>
                        <span>最高50万</span>
                    </dd>
                </dl>
            </li>
            <li>
                <dl>
                    <dt class="feature-highspeed"></dt>
                    <dd>
                        <h5>获额快</h5>
                        <span>60秒知晓额度</span>
                    </dd>
                </dl>
            </li>
            <li>
                <dl>
                    <dt class="feature-goodser"></dt>
                    <dd>
                        <h5>服务好</h5>
                        <span>VIP顾问一对一</span>
                    </dd>
                </dl>
            </li>
            <li>
                <dl>
                    <dt class="feature-lowrate"></dt>
                    <dd>
                        <h5>费率低</h5>
                        <span>万元日息仅1块9</span>
                    </dd>
                </dl>
            </li>
        </ul>

    </div>
</div>
<!--小窝特点结束-->
<div class=""
     style="background: url(${pageContext.request.contextPath}/img/indexfamily.png) no-repeat center;width: 100%; height: 484px;"></div>
<div class="wrap-container">
    <div class="content2 relative">
        <h4>装修月付 造就美好生活</h4>
        <h5>A股上市企业投资</h5>
        <p class="icon-right">正规可靠</p>
        <p class="icon-right">安全透明</p>
        <div class="indexphonec"></div>
    </div>
</div>
<div class=""
     style="background: url(${pageContext.request.contextPath}/img/indexdisplay.png) no-repeat center;width: 100%; height: 489px;"></div>
<!--首页表单-->
<div class="wrap-container">
    <div class="calulation">
        <h4>一键获取您的分期额度</h4>
        <div class="fl forms">
            <div class="icon-house2">
                <input type="text" name="housearea" id="housearea" value="" placeholder="请输入您的房屋面积"/>
            </div>
            <div class="icon-city">
                <select name="" id="cuscity" class="icon-dropdown" style="color: #8a8a8a;width: 240px;">
                    <option value='' disabled selected style='display:none;'>请选择您的房屋所在城市</option>
                    <option value="4000">深圳南山区</option>
                    <option value="3500">深圳福田区</option>
                    <option value="3500">深圳罗湖区</option>
                    <option value="3000">深圳宝安区</option>
                    <option value="3000">深圳盐田区</option>
                    <option value="3000">深圳龙岗区</option>
                    <option value="3000">深圳龙华新区</option>
                    <option value="2500">深圳坪山新区</option>
                    <option value="2500">深圳光明新区</option>
                    <option value="3000">深圳大鹏新区</option>
                    <option value="1786">惠州</option>
                    <option value="2030">东莞</option>
                    <option value="2591">广州</option>
                    <option value="2000">其他城市</option>
                </select>
            </div>
            <div class="icon-numbers">
                <select name="" id="periods" class="icon-dropdown" style="color: #8a8a8a;width: 240px;">
                    <option value='' disabled selected style='display:none;'>请选择期数</option>
                    <option value="12">12期</option>
                    <option value="24">24期</option>
                    <option value="36">36期</option>
                    <option value="48">48期</option>
                    <option value="60">60期</option>
                </select>
            </div>
            <div class="icon-phone">
                <input type="text" name="phoneNumber" id="phoneNumber" value="" maxlength="11"
                       placeholder="请输入您的电话方便联系"/>
            </div>

        </div>
        <div class="fl">
            <input type="button" class="resBtn" id="getRes" style="cursor: pointer;"
                   onclick="calculate()"/>
        </div>
        <div class="fr calres">
            <p class="firstline">您的预估额度：<span class="red" id="quota">？</span></p>
            <p>您的月还款金额：<span class="red" id="monthlyRepayment">？</span></p>
        </div>
    </div>
</div>
<!--首页表单结束-->
<div class="wrap-container">
    <div class="">
        <div class="title">
            <h4>战略合作伙伴</h4>
            <div class="titleline"></div>
        </div>
        <div class="partners">
            <ul>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-47.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-48.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-49.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-50.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-51.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-52.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-53.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-54.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-55.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-56.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-57.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-58.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-59.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-60.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-61.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-62.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-63.png"/></li>
                <li><img src="${pageContext.request.contextPath}/img/banks/bank-64.png"/></li>
            </ul>
        </div>
    </div>
</div>
<!--底部-->
<%@include file="../common/footer.jsp" %>
<!--底部结束-->
<!--侧边栏-->
<%@include file="../common/fix.jsp" %>
<!--侧边栏结束-->


<!--js部分-->
<%@include file="../common/js_lib.jsp" %>

</body>

</html>

<script>
    scrollCtrl();
    //右边栏显影
    function scrollCtrl(fullHeight) {
        var fullHeight = parseInt($(window).height());
        $(".nav-right").hide();
        $(window).scroll(function (e) {
            var winHeight = $(window).scrollTop();
            if (winHeight > fullHeight) {
                $(".nav-right").show();
            } else {
                $(".nav-right").hide();
            }
        });
    }
</script>
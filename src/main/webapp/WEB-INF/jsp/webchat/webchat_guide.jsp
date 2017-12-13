<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>证券时报网移动产品</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/xw.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/webchat/jquery.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/webchat/jquery-ui.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/webchat/jquery.fullPage.min.js" type="text/javascript"
            charset="utf-8"></script>


    <script>
        $(function () {
            if ($.browser.msie && $.browser.version < 10) {
                $('body').addClass('ltie10');
            }
            $.fn.fullpage({
                slidesColor: ['#F46242', '#F46242', '#F46242', '#F46242', '#F46242'],
                anchors: ['page1', 'page2', 'page3', 'page4', 'page5'],
                menu: '#menu'
            });
        });
    </script>
</head>

<body>
<ul id="menu">
    <li data-menuanchor="page1" class="active"><a href="#page1"></a></li>
    <li data-menuanchor="page2"><a href="#page2"></a></li>
    <li data-menuanchor="page3"><a href="#page3"></a></li>
    <li data-menuanchor="page4"><a href="#page4"></a></li>
    <li data-menuanchor="page5"><a href="#page5"></a></li>
</ul>

<div class="section section1">
    <div class="bg bg1-3"></div>
    <div class="bg1-2">
        <div class="step1"></div>
        <div class="step2"></div>
        <div class="step3"></div>
    </div>
    <a class="logo" href="/">家装分期爱小窝</a>
    <p class="title">家装分期<span>爱小窝</span></p>
    <div class="middle">
        <div class="drop"></div>
    </div>
</div>

<div class="section section2">
    <div class="bg bg1-3"></div>

    <p class="title">快速获知<span>预估额度</span></p>
    <div class="middle">
        <div class="drop"></div>
        <div class="roket"></div>
    </div>
</div>


<div class="section section3">
    <div class="bg bg3-1"></div>
    <div class="bg bg3-3"></div>
    <p class="title">在线申请<span>足不出户</span></p>
    <div class="middle">
        <div class="bg3-2"></div>
        <div class="content">只需输入基本信息<br/>即可网上完成申请流程<br/>一键分期</div>
    </div>
</div>

<div class="section section4">
    <div class="bg bg4-1"></div>
    <p class="title">实时查询<span>申请进度</span></p>
    <div class="middle">
        <div class="bg4-2"></div>
        <div class="cnt cnt1">查看进度信息及时了解到动态</div>
        <div class="cnt cnt2">在线实时查询放款进度</div>
        <div class="cnt cnt3">做好预算计划</div>
    </div>
</div>


<div class="section section5">
    <p class="title">实时查询<span>申请进度</span></p>
    <div class="middle">
        <p class="midtitle">——&nbsp;&nbsp;&nbsp;一站分期&nbsp;&nbsp;&nbsp;——</p>
        <ul class="productList">
            <li class="dec-hard icon-hard"></li>
            <li class="dec-material icon-material"></li>
            <li class="dec-soft icon-soft"></li>
            <li class="dec-furniture icon-furniture"></li>
            <li class="dec-home icon-home"></li>
            <li class="dec-ele icon-ele"></li>
        </ul>
        <a href="#page1">
            <input type="button" class="submit" name="" id="" value="立即体验"/>
        </a>
    </div>
</div>
</body>
</html>
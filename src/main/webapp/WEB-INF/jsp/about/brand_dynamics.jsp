<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>工商银行_装修贷款_低利息_贷款_装修_小窝金服-公司动态-小窝金服</title>
    <meta http-equiv="keywords" content="工商银行,装修贷款,低利息,贷款,装修,小窝金服"/>
    <meta http-equiv="description"
          content="小窝金服隶属于深圳市小窝金融信息服务有限公司，以“为客户提供低成本的装修贷款服务”为经营理念，为广大家装用户提供低费率、高额度、长期限、纯信用的装修贷款产品。小窝金服还与装修公司、家具卖场、电商平台等合作，提供一站式装修贷款服务，让你的装修没有资金烦恼，省心入住自己的小窝。"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>
</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->
<div class="wrap-navabout bg-gray">
    <ul class="nav-aboutus clear">
        <a href="${pageContext.request.contextPath}/brand_bg">
            <li class="icon-line">品牌背景</li>
        </a>
        <a href="${pageContext.request.contextPath}/brand_dynamics">
            <li class="icon-line curnav">品牌动态</li>
        </a>
        <a href="${pageContext.request.contextPath}/contact">
            <li class="icon-line">联系我们</li>
        </a>
        <a href="${pageContext.request.contextPath}/joinUs">
            <li>加入我们</li>
        </a>
    </ul>
</div>


<!--加入我们-->
<div class="wrap-container bg-gray">
    <div class="ixiaowo-news">
        <a <c:if
                test="${brandBanner.picture.url!=null && brandBanner.picture.url!=''}"> href="${brandBanner.picture.url}"</c:if>
                <c:if test="${brandBanner.picture.url==null || brandBanner.picture.url==''}"> href="javascript:void(0)"</c:if>
        >
            <div class="news-banner">
                <img src="${brandBanner.picture.path}" width="1200">
            </div>
        </a>
        <div class="newslist news">
            <%@include file="brand_text_list.jsp" %>
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
<%--分页--%>
<script src="${pageContext.request.contextPath}/js/page.js"></script>
</body>

</html>

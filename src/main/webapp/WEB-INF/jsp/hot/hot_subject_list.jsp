<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>深圳装修贷款_装修贷款优惠-专题活动-小窝金服</title>
    <meta http-equiv="keywords" content="装修贷款,装修贷款优惠"/>
    <meta http-equiv="description"
          content="小窝金服为广大家装用户提供低利率、高额度、长期限、纯信用的装修贷款产品。小窝金服还与装修公司、家居卖场、电商平台等合作，提供一站式装修贷款服务和装修优惠活动资讯，让你的装修没有资金烦恼，省心入驻自己的小窝。"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/subject.css">

</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->
<div class="wrap-container bg-gray">
    <div class="helpcenter news" style="width: 1220px;">
        <%@include file="subject_list_content.jsp" %>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>装修分期攻略_分期攻略_公积金贷款攻略-小窝攻略-小窝金服</title>
    <meta http-equiv="keywords" content="装修分期攻略,分期攻略,公积金贷款攻略"/>
    <meta http-equiv="description" content="小窝金服分期攻略栏目提供装修分期攻略,公积金贷款攻略,等贷款攻略,了解装修分期攻略就到小窝金服"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>

</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->
<div class="wrap-container bg-gray">
    <div class="ixiaowocases news">
        <%@include file="list_content.jsp" %>
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

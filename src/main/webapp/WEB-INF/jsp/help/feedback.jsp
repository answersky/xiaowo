<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>家装分期_装修贷款_家装贷款_意见反馈-小窝金服</title>
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
<div class="wrap-container bg-gray">
    <div class="fdback helpcenter">
        <h4>意见反馈</h4>
        <div>
            <span>*反馈内容</span><textarea class="problems" name="problems" rows="5" cols="10"></textarea><br/>
        </div>

        <div>
            <span>联系电话:</span><input type="text" class="phonenum" name="phonenum" id="phonenum" value=""
                                     placeholder="请输入您的联系电话"/>
        </div>
        <div>
            <span>提交问题:</span><input class="btn-fd" type="button" value="提交" onclick="submitFeedback()"/>
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
    function submitFeedback() {
        var text = $(".problems").val();
        var tel = $("#phonenum").val();
        if (text == null || text == '') {
            poptip("请输入反馈意见");
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
        $.ajax({
            url: "/saveFeedback",
            data: {
                tel: tel,
                content: text
            },
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                poptip("提交成功");
                location.reload();
            },
            error: function () {
                poptip("系统错误");
            }
        });
    }
</script>
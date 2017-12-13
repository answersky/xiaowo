<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>${text.title}-小窝攻略-小窝金服</title>
    <meta http-equiv="keywords" content="装修贷款,小窝金服,家装贷,装修"/>
    <meta http-equiv="description" content="${text.text.remark}"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>

</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->
<div class="wrap-container bg-gray">
    <div class="casedtails bg-gray clear">
        <div class="breadcrumbs">
            <a href="">首页</a>
            <span>&gt;</span>
            <a href="${pageContext.request.contextPath}/${type}">
                <c:if test="${type=='hot_subject'}">专题活动</c:if>
                <c:if test="${type=='decorateStrategy'}">装修攻略</c:if>
                <c:if test="${type=='divideStrategy'}">分期攻略</c:if>
                <c:if test="${type=='brand_dynamics'}">品牌动态</c:if>
            </a>
            <span>&gt;</span>
            <span>${text.title}</span>
        </div>
        <div class="caseleft">
            <div class="article">
                <h4>${text.title}</h4>
                ${text.text.content}
            </div>
            <div class="pageflip">
                <c:if test="${preContent!=null}">
                    <div class="lastpage ellipsis">
                        <span class="bold">上一篇：</span>
                        <a href="${pageContext.request.contextPath}/${type}/detail/${preContent.id}?categoryId=${text.categoryId}">${preContent.title}</a>
                    </div>
                </c:if>
                <c:if test="${nextContent!=null}">
                    <div class="nextpage ellipsis">
                        <span class="bold">下一篇：</span>
                        <a href="${pageContext.request.contextPath}/${type}/detail/${nextContent.id}?categoryId=${text.categoryId}">${nextContent.title}</a>
                    </div>
                </c:if>

            </div>
            <div class="casesmore">
                <h4>相关文章</h4>
                <ul class="clear">
                    <c:if test="${relativeContents!=null && relativeContents.size()>0}">
                        <c:forEach items="${relativeContents}" var="relativeContent">
                            <a href="${pageContext.request.contextPath}/${type}/detail/${relativeContent.id}?categoryId=${text.categoryId}">
                                <li>${relativeContent.title}</li>
                            </a>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>
        </div>

        <%--申请--%>
        <%@include file="detail_apply.jsp" %>

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
    //获取验证码
    function sendCode(e) {
        var phone = $("#userphone").val();
        if (!phone) {
            poptip('手机号不能为空！');
            return;
        }
        if (!(/^1[34578]\d{9}$/.test(phone))) {
            poptip("手机号码有误，请重填");
            return false;
        }
        settime(e);
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/sendCode",
            data: {phone: phone},
            dataType: "json",
            success: function (data) {
                if (data.state == "success") {
                    poptip('发送成功！');
                } else {
                    poptip('验证码已经发送，请勿重复获取！')
                }
            },
            error: function (msg) {
                poptip("未知错误");
            }
        });
    }


    //    短信倒计时
    var countdown = 120;

    function settime(e) {
        if (countdown == 0) {
            $(e).removeAttr("disabled");
            $(e).val("获取验证码");
            $(e).removeAttr("style");
            countdown = 120;
        } else {
            $(e).attr("disabled", true);
            $(e).val("重新发送(" + countdown + ")");
            $(e).css("background-color", "gray");
            countdown--;
            setTimeout(function () {
                settime(e)
            }, 1000)
        }
    }

    //短信验证码校验
    function checkPhoneCode(phone, code) {
        var flag = false;
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/validateSmsCode",
            data: {phone: phone, code: code},
            async: false,//取消异步请求
            dataType: "json",
            success: function (data) {
                if (data.state == "success") {
                    flag = true;
                } else {
                    flag = false;
                }
            },
            error: function (msg) {
                poptip("未知错误");
            }
        });
        return flag;
    }

    function detailApply() {
        var username = $.trim($("#username").val());
        var phone = $.trim($("#userphone").val());
        if (username == undefined || username == "") {
            poptip("请输入姓名");
            return false
        }
        if (phone == undefined || phone == "") {
            poptip("请输入手机号");
            return false
        }
        if (!(/^1[34578]\d{9}$/.test(phone))) {
            poptip("手机号码有误，请重填");
            return false;
        }
        var code = $("#confirmnum").val();
        if (!code || code == "") {
            poptip('请输入验证码！');
            return false;
        }

        if (!checkPhoneCode(phone, code)) {
            poptip("验证码错误！");
            return false;
        }
        apply(phone, username, "official_website", "website");

    }
</script>
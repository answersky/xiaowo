<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="wrap-header">
    <div class="header relative">
        <div class="logo fl">
            <a href="/"><img src="${pageContext.request.contextPath}/img/ixiaowo-logo.png"></a>
        </div>
        <div class="header-right fl">
            <ul class="nav">
                <a href="/">
                    <li <c:if test="${flag=='index'}"> class="curnav"</c:if>>首页</li>
                </a>
                <a href="${pageContext.request.contextPath}/decorate">
                    <li <c:if test="${flag=='decorate'}"> class="curnav"</c:if>>装修分期</li>
                </a>
                <a href="${pageContext.request.contextPath}/problems">
                    <li <c:if test="${flag=='problems'}"> class="curnav"</c:if>>帮助中心</li>
                </a>
                <a href="${pageContext.request.contextPath}/brand_bg">
                    <li <c:if test="${flag=='about_us'}"> class="curnav"</c:if>>关于我们</li>
                </a>
                <%--<a href="">
                    <li>分期模板</li>
                </a>--%>
            </ul>
        </div>
        <%--<div class="city fr ">
            <span class="curCity">深圳></span>
        </div>
        <div class="cityList absolute hide">
            <span class="bold fl">开通城市</span>
            <ul class="fl">
                <c:forEach items="${zones}" var="zone">
                    <li>${zone.zone}</li>
                </c:forEach>
            </ul>
        </div>--%>
    </div>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrap-footer">
    <div class="footer relative">
        <p class="firstline"><span>热门专区：</span> <a href="${pageContext.request.contextPath}/decorateStrategy">装修攻略</a>
            <a href="${pageContext.request.contextPath}/divideStrategy">分期攻略</a>
            <a href="${pageContext.request.contextPath}/hot_subject">专题活动</a></p>
        <p>
            <span>友情链接：</span>
            <c:forEach items="${friendshipLinks}" var="friendshipLink">
                <a href="${friendshipLink.url}" target="_blank">${friendshipLink.word}</a>
            </c:forEach>
        </p>
        <ul class="clear">
            <li><a href="${pageContext.request.contextPath}/brand_bg" style="color: white;">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/problems" style="color: white;">常见问题</a></li>
            <li><a href="${pageContext.request.contextPath}/feedback" style="color: white;">意见反馈</a></li>
            <li><a href="${pageContext.request.contextPath}/contact" style="color: white;">联系我们</a></li>
        </ul>
        <p>Copyright © 2015 小窝金服ixiaowo.com 版权所有 粤ICP备14055618号-2</p>
        <div class="govconfirm">
            <a id="___szfw_logo___" href="https://credit.szfw.org/CX20171031036610081637.html" target="_blank"><img
                    src="http://icon.szfw.org/cert.png" border="0" style="width: 100px;height: 39px;"><!-- a-->
                <script type="text/javascript">
                    (function () {
                        document.getElementById('___szfw_logo___').oncontextmenu = function () {
                            return false;
                        }
                    })();
                </script>

            </a><a href="http://webscan.360.cn/index/checkwebsite/url/www.ixiaowo.com" target="_blank">
            <img border="0" src="${pageContext.request.contextPath}/img/360.png" style="width: 100px;height: 39px;"></a>

            <a target="_blank" href="http://www.miitbeian.gov.cn/">
                <img border="0" src="${pageContext.request.contextPath}/img/jingying.png"
                     style="width: 100px;height: 39px;">
            </a>

            <a target="_blank" href="http://szcert.ebs.org.cn/49a485c7-4004-4a63-be3e-ce2981bf2b41">
                <img border="0" src="${pageContext.request.contextPath}/img/gongsang.png">
            </a>

            <a target="_blank" href="http://www.12377.cn/">
                <img border="0" src="${pageContext.request.contextPath}/img/jubao.png"
                     style="width: 100px;height: 39px;">
            </a>
        </div>
        <div class="focuswechat absolute">

        </div>
    </div>
</div>

<%--隐藏域--%>
<input type="hidden" id="zone" value="${sessionScope.city}">
<input type="hidden" id="zones" value='${zonesJson}'>
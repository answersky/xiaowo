<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="caseright">
    <div class="casebox">
        <h4>预约分期</h4>
        <div class="caseform clear">
            <input type="text" class="" id="username" placeholder="您的称呼"/>
            <input type="text" class="" id="userphone" maxlength="11" placeholder="您的手机号码"/>
            <input type="text" name="" class="casephone" id="confirmnum" value="" placeholder="短信验证码"/>
            <input type="button" name="" class="casebtn" id="getNum" value="发送验证码" onclick="sendCode(this)"/>
            <input type="button" name="" class="casebtn applybtn" id="" value="立即申请" onclick="detailApply()"/>
        </div>

    </div>
    <div class="casebox">
        <h4>热门推荐</h4>
        <ul class="casehot">
            <c:if test="${hotContents!=null && hotContents.size()>0}">
                <c:forEach items="${hotContents}" var="hotContent" varStatus="hot">
                    <a href="${pageContext.request.contextPath}/${type}/detail/${hotContent.id}?categoryId=${hotContent.categoryId}">
                        <li>${hot.index+1}.${hotContent.title}</li>
                    </a>
                </c:forEach>
            </c:if>
        </ul>

    </div>
</div>
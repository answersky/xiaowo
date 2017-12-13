<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="subject-list">
    <c:if test="${texts!=null && texts.size()>0}">
        <c:forEach items="${texts}" var="text">
            <li>
                <a class="subject-list-pic"
                   href="${pageContext.request.contextPath}/${pageUrl}/detail/${text.id}?categoryId=${text.categoryId}"
                   target="_blank">
                    <img src="${text.picture.path}" width="700" height="300" alt="${text.title}">
                </a>
                <div class="subject-info">
                    <h2>
                        <a href="${pageContext.request.contextPath}/${pageUrl}/detail/${text.id}?categoryId=${text.categoryId}"
                           target="_blank">${text.title}</a></h2>
                    <p class="txt">${text.text.remark}</p>
                    <p class="date"><span>活动时间：</span>${text.activeTime}</p>
                    <c:if test="${text.cooperativeBusiness!=null && text.cooperativeBusiness!=''}">
                        <p class="shop"><span>合作商家：</span>${text.cooperativeBusiness}</p>
                    </c:if>
                    <p class="subject-btn"><a href="javascript:void(0)" class="btn btn-orange">立即参与</a></p>
                </div>
            </li>
        </c:forEach>
    </c:if>
</ul>
<div id="pageTag">
    <c:if test="${pages>1}">
        <div class="page gray-2">
                <%--当前页第一页的时候不能点击--%>

            <span class="icons icon-left"
                  <c:if test='${currentPage>1}'>onclick='page_turn("${pageContext.request.contextPath}/${pageUrl}",${currentPage-1})'
                  style="cursor: pointer;" </c:if>>&lt;</span>
            <ul class="fl" id="switch-page">
                <c:forEach begin="1" end="${pages}" var="page">
                    <c:if test="${currentPage==page}">
                        <li class="icons cur-page">${page}</li>
                    </c:if>
                    <c:if test="${currentPage!=page}">
                        <li class="icons" style="cursor: pointer;"
                            onclick='page_turn("${pageContext.request.contextPath}/${pageUrl}",${page})'>${page}</li>
                    </c:if>
                </c:forEach>
            </ul>
            <span class="icons icon-right"
                  <c:if test='${currentPage<pages}'>onclick='page_turn("${pageContext.request.contextPath}/${pageUrl}",${currentPage+1})'
                  style="cursor: pointer;"</c:if>>&gt;</span>
        </div>
    </c:if>
</div>
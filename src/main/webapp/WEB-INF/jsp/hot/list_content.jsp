<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="casesList" id="casesList">
    <c:if test="${texts!=null && texts.size()>0}">
        <c:forEach items="${texts}" var="text">
            <li class="clear">
                <div class="caseImg fl">
                    <c:if test="${text.picture!=null}">
                        <a href="${pageContext.request.contextPath}/${pageUrl}/detail/${text.id}?categoryId=${text.categoryId}"
                           target="_blank">
                            <img src="${text.picture.path}" width="340" height="190">
                        </a>
                    </c:if>
                </div>
                <div class="caseCnt fr">
                    <h4>
                        <a href="${pageContext.request.contextPath}/${pageUrl}/detail/${text.id}?categoryId=${text.categoryId}"
                           target="_blank">${text.title}</a>
                    </h4>
                    <p class="tag"><span class="icon-person">${text.editor}</span><span class="icon-date">
                        <fmt:formatDate value="${text.createTime }"
                                        pattern="yyyy-MM-dd HH:mm:ss"/>
                    </span></p>
                    <p>${text.text.remark}</p>
                    <p class="caselink"><a
                            href="${pageContext.request.contextPath}/${pageUrl}/detail/${text.id}?categoryId=${text.categoryId}"
                            target="_blank">[详细]</a></p>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--此处的c标签必须保留，否则ajax返回的页面数据不能正常循环出来--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul id="newsList">
    <c:if test="${brandTexts!=null && brandTexts.size()>0}">
        <c:forEach items="${brandTexts}" var="brandText" varStatus="brand">
            <li class="clear">
                <a target="_blank"
                   href="${pageContext.request.contextPath}/brand_dynamics/detail/${brandText.id}?categoryId=${brandText.categoryId}"
                   class="fl newstitle">${brand.index+1}、${brandText.title} </a>
                <span class="fr">
                <fmt:formatDate value="${brandText.createTime }"
                                pattern="yyyy-MM-dd"/>
            </span>
            </li>
        </c:forEach>
    </c:if>
</ul>
<div id="pageTag">
    <c:if test="${pages>1}">
        <div class="page gray-2">
                <%--当前页第一页的时候不能点击--%>

            <span class="icons icon-left"
                  <c:if test='${currentPage>1}'>onclick='page_turn("${pageContext.request.contextPath}/findBrandByCurrentPage",${currentPage-1})'
                  style="cursor: pointer;" </c:if>>&lt;</span>
            <ul class="fl" id="switch-page">
                <c:forEach begin="1" end="${pages}" var="page">
                    <c:if test="${currentPage==page}">
                        <li class="icons cur-page">${page}</li>
                    </c:if>
                    <c:if test="${currentPage!=page}">
                        <li class="icons" style="cursor: pointer;"
                            onclick='page_turn("${pageContext.request.contextPath}/findBrandByCurrentPage",${page})'>${page}</li>
                    </c:if>
                </c:forEach>
            </ul>
            <span class="icons icon-right"
                  <c:if test='${currentPage<pages}'>onclick='page_turn("${pageContext.request.contextPath}/findBrandByCurrentPage",${currentPage+1})'
                  style="cursor: pointer;"</c:if>>&gt;</span>
        </div>
    </c:if>
</div>


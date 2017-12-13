<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>工商银行_装修贷款_低利息_贷款_装修_小窝金服加入我们-小窝金服</title>
    <meta http-equiv="keywords" content="工商银行,装修贷款,低利息,贷款,装修,小窝金服"/>
    <meta http-equiv="description"
          content="深圳市小窝金融信息服务有限公司,是与中国工商银行合作的工行家装贷款服务平台，以“为客户提供最有价值的家装低成本金融服务”为经营理念给广大家装用户提供成本低、额度高、期限长、纯信用的家装消费金融产品。为用户提供多家装修公司免费量房、设计、报价、供用户选择,装修工程节点验收、装修工程款担保交易等增值服务，一站式满足用户的装修融资、装修服务等需求，确保用户安心放心的入住自己的小窝。"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>
</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->

<div class="wrap-navabout bg-gray">
    <ul class="nav-aboutus clear">
        <a href="${pageContext.request.contextPath}/brand_bg">
            <li class="icon-line">品牌背景</li>
        </a>
        <a href="${pageContext.request.contextPath}/brand_dynamics">
            <li class="icon-line">品牌动态</li>
        </a>
        <a href="${pageContext.request.contextPath}/contact">
            <li class="icon-line">联系我们</li>
        </a>
        <a href="${pageContext.request.contextPath}/joinUs">
            <li class="curnav">加入我们</li>
        </a>
    </ul>
</div>

<!--加入我们-->
<div class="wrap-container bg-gray">
    <div class="joinus">

        <div class="clear assort" id="type">
            <span class="fl">职位类型：</span>
            <ul class="fl clear">
                <li
                        <c:if test="${type==1 || type==null}">class="selected"</c:if> onclick="findByType(1)" value="1">
                    社招
                </li>
                <li
                        <c:if test="${type==0}">class="selected"</c:if> onclick="findByType(0)" value="0">校招
                </li>
            </ul>
        </div>
        <div class="clear assort" id="zone">
            <span class="fl">工作地点：</span>
            <ul class="fl clear">
                <li
                        <c:if test="${zoneId==null || zoneId==''}">class="selected"</c:if> value=""
                        onclick="findByZone('')">全部
                </li>
            </ul>
            <ul class="fl clear">
                <c:forEach items="${zones}" var="zone">
                    <li
                            <c:if test="${zoneId!=null && zoneId==zone.id}">class="selected"</c:if> value="${zone.id}"
                            onclick="findByZone(${zone.id})">${zone.zone}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="clear assort" id="departmentId">
            <span class="fl">职位部门：</span>
            <ul class="fl clear">
                <li
                        <c:if test="${departmentId==null || departmentId==''}">class="selected"</c:if> value=""
                        onclick="findByDepartment('')">全部
                </li>
            </ul>
            <ul class="fl clear" style="max-width: 630px;">
                <c:forEach items="${departments}" var="department" varStatus="deIndex">
                    <c:if test="${deIndex.index<=5}">
                        <li
                                <c:if test="${departmentId!=null && departmentId==department.id}">class="selected"</c:if>
                                value="${department.id}"
                                onclick="findByDepartment(${department.id})">${department.department}</li>
                    </c:if>
                    <c:if test="${deIndex.index>5}">
                        <li
                                <c:if test="${departmentId!=null && departmentId==department.id}">class="selected"</c:if>
                                value="${department.id}" style="display: none;" class="hide"
                                onclick="findByDepartment(${department.id})">${department.department}</li>
                    </c:if>

                </c:forEach>
            </ul>
            <c:if test="${departments!=null && departments.size()>6}">
                <a class="fl" onclick="showMore(this)">更多></a>
            </c:if>

        </div>
        <ul class="workpositions">
            <li class="bg-gray">
                <div>职位名称</div>
                <div>职位部门</div>
                <div>职位地点</div>
            </li>
            <c:forEach items="${recruits}" var="recruit" varStatus="re">
                <li style="cursor: pointer;" onclick="showMoreInfo(${re.index})">
                    <div>${recruit.position}</div>
                    <div>${recruit.department}</div>
                    <div>${recruit.zone}</div>
                </li>
                <li id="duty${re.index}"
                    style="min-height: 139px;margin-left: 50px;display: none;">
                    <p>岗位职责：</p>
                        ${recruit.duty}
                </li>
                <li id="jobRequirements${re.index}"
                    style="min-height: 250px;margin-left: 50px;display: none;">
                    <p>任职要求：</p>
                        ${recruit.jobRequirements}
                </li>
            </c:forEach>

        </ul>
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
    function showMore(obj) {
        var text = $(obj).text();
        if (text.indexOf("更多") >= 0) {
            $(obj).text("隐藏>");
            $(".hide").each(function () {
                $(this).show();
            })
        } else {
            $(obj).text("更多>");
            $(".hide").each(function () {
                $(this).hide();
            })
        }
    }

    //查看更多招聘信息
    function showMoreInfo(index) {
        if ($("#duty" + index).is(":hidden")) {
            $("#duty" + index).show();
            $("#jobRequirements" + index).show();
        } else {
            $("#duty" + index).hide();
            $("#jobRequirements" + index).hide();
        }
    }

    //筛选
    function findByType(type) {
        //获取其他状态值
        var zoneId = $("#zone li.selected").val();
        if (typeof(zoneId) == 'undefined' || zoneId == 0) {
            zoneId = "";
        }
        var departmentId = $("#departmentId li.selected").val();
        if (typeof(departmentId) == 'undefined' || departmentId == 0) {
            departmentId = "";
        }
        window.location.href = "/joinUs?type=" + type + "&departmentId=" + departmentId + "&zoneId=" + zoneId;
    }

    function findByZone(zoneId) {
        var type = $("#type li.selected").val();
        var departmentId = $("#departmentId li.selected").val();
        if (typeof(departmentId) == 'undefined' || departmentId == 0) {
            departmentId = "";
        }
        window.location.href = "/joinUs?type=" + type + "&departmentId=" + departmentId + "&zoneId=" + zoneId;
    }

    function findByDepartment(departmentId) {
        var type = $("#type li.selected").val();
        var zoneId = $("#zone li.selected").val();
        if (typeof(zoneId) == 'undefined' || zoneId == 0) {
            zoneId = "";
        }
        window.location.href = "/joinUs?type=" + type + "&departmentId=" + departmentId + "&zoneId=" + zoneId;
    }
</script>
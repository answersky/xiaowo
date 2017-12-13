<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>装修分期_家装分期_装修贷款_家装贷款-装修贷款-小窝金服</title>
    <meta http-equiv="keywords" content="装修分期,家装分期,装修贷款,家装贷款"/>
    <meta http-equiv="description"
          content="小窝金服为广大家装用户提供低利率、高额度、长期限、纯信用的装修分期产品。小窝金服还与装修公司、家居卖场、电商平台等合作，提供一站式装修分期服务，让你的装修没有资金烦恼，省心入驻自己的小窝。"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>

</head>

<body>
<!--头部-->
<%@include file="../common/header.jsp" %>
<!--头部结束-->


<div class="decorationBanner"
     style="background: url(${pageContext.request.contextPath}/img/banner-decoration.png) no-repeat center;"></div>

<div class="wrap-container">
    <div class="deco-feature clear">
        <dl class="fl icon-pink-bank">
            <dt>18+</dt>
            <dd>银行金融合作机构</dd>
        </dl>
        <dl class="fl icon-pink-nums">
            <dt>10000+</dt>
            <dd>专业顾问一对一服务</dd>
        </dl>
        <dl class="fl icon-pink-ser">
            <dt>100万+</dt>
            <dd>家庭提供分期服务</dd>
        </dl>
    </div>
</div>
<div class="wrap-container bg-gray">

    <div class="decoration-cal ">
        <div class="clearfix">
            <div class="fl forms-decoration">
                <div class="icon-m2">
                    <input type="text" style="width: 220px;" name="housearea" id="housearea" value=""
                           placeholder="请输入您的房屋面积"/>
                </div>
                <div class="">
                    <select name="" class="icon-dropdown" style="width: 240px;color: #8a8a8a;" id="periods">
                        <option value='' class="gray-3" disabled selected style='display:none'>请选择还款期数</option>
                        <option value="12">12期</option>
                        <option value="24">24期</option>
                        <option value="36">36期</option>
                        <option value="48">48期</option>
                        <option value="60">60期</option>
                    </select>
                </div>
                <div class="">
                    <select name="" id="cuscity" class="icon-dropdown" style="width: 240px;color: #8a8a8a;">
                        <option value='' class="gray-3" disabled selected style='display:none;'>请选择您的房屋所在城市</option>
                        <option value="4000">深圳南山区</option>
                        <option value="3500">深圳福田区</option>
                        <option value="3500">深圳罗湖区</option>
                        <option value="3000">深圳宝安区</option>
                        <option value="3000">深圳盐田区</option>
                        <option value="3000">深圳龙岗区</option>
                        <option value="3000">深圳龙华新区</option>
                        <option value="2500">深圳坪山新区</option>
                        <option value="2500">深圳光明新区</option>
                        <option value="3000">深圳大鹏新区</option>
                        <option value="1786">惠州</option>
                        <option value="2030">东莞</option>
                        <option value="2591">广州</option>
                        <option value="2000">其他城市</option>
                    </select>
                </div>

                <div class="">
                    <input type="text" name="phoneNumber" id="phoneNumber" value="" maxlength="11"
                           placeholder="请输入您的电话方便联系"/>
                </div>

            </div>
            <div class="fl center-cal">
                <div class="">
                    <input type="button" class="resBtn" id="getRes" value="" style="cursor: pointer;"
                           onclick="calculate()"/>
                </div>
            </div>
            <div class="fl center-right">
                <p class="firstline red">您的预估额度：<span id="quota">？</span></p>
                <p class="red">月供低至：<span>1299</span>元</p>
            </div>
        </div>
        <div class="form-hide" style="display: none;">
            <p class="pstyle">月费率低至0.5%<span class="pstyle1" style="">额度明细</span></p>
            <div class="forms-decoration forms-decoration1 clear">
                <div class="icon-millon">
                    <input type="text" style="width: 200px;" name="loan" id="loan" value="" placeholder="请输入您的贷款金额"/>
                </div>
                <div class="">
                    <select name="" class="icon-dropdown" style="width: 240px;color: #8a8a8a;">
                        <option value='' disabled selected style='display:none;'>请选择还款期数</option>
                        <option value="12期">12期</option>
                        <option value="24期">24期</option>
                        <option value="36期">36期</option>
                    </select>
                </div>
                <div class="form-text">月供低至：<span class="red">1299</span>元</div>
                <div class="form-text">总还款金额：<span class="red">1299</span>万元</div>
            </div>
        </div>

    </div>

</div>
<div class="wrap-container bg-gray">
    <div class="infolist">
        <div class="title-deline">办理资料</div>
        <ul class="applyinfo">
            <li class="icon-id">身份资料：身份证、户口本、结婚证</li>
            <li class="icon-house1">房产证明材料：房产证或购房合同</li>
            <li class="icon-nopayinfo">收入证明材料：收入证明、银行收入流水</li>
            <li class="icon-buildhouse">装修证明材料：装修合同及预算</li>
        </ul>
    </div>

    <div class="serprocess">
        <div class="title-deline">服务流程</div>
        <div class="processlist">
            <dl class="icon-onlineapply">
                <dt>在线申请</dt>
                <dd class="gray-3">关注微信/下载APP</dd>
                <dd class="icon-num icon-line">1</dd>
            </dl>
            <dl class="icon-getvalue2">
                <dt>获取额度</dt>
                <dd class="gray-3">获取预授信额度</dd>
                <dd class="icon-num icon-line">2</dd>
            </dl>
            <dl class="icon-submess">
                <dt>提交资料</dt>
                <dd class="gray-3">填写信息/联系客服</dd>
                <dd class="icon-num icon-line">3</dd>
            </dl>
            <dl class="icon-getmoney2">
                <dt>签约放款</dt>
                <dd class="gray-3">顾问陪同面签放款</dd>
                <dd class="icon-num">4</dd>
            </dl>
        </div>
    </div>

    <div class="advantages">
        <div class="title-deline">优势对比</div>
        <div class="advantageslist" style="margin-top:15px;">
            <div class="compares">
                <dl class="comparesAgent">
                    <dt></dt>
                    <dd class="space vss">小窝金服</dd>
                    <dd class="vs vss">其他贷款平台</dd>
                </dl>
                <dl>
                    <dt>门槛<br/>更低</dt>
                    <dd class="space">纯信用/无抵押/ 无担保<br/>免除后顾之忧</dd>
                    <dd class="">不动产质押<br/>财产安全难以保证</dd>
                </dl>
                <dl>
                    <dt>费率<br/>更低</dt>
                    <dd class="space">月费率最低<br/>低至0.5%</dd>
                    <dd class="">月费率一般<br/>在0.8%以上</dd>
                </dl>
                <dl>
                    <dt>额度<br/>更高</dt>
                    <dd class="space">最高可贷50万</dd>
                    <dd class=""><br/>最高可贷30万</dd>
                </dl>
                <dl>
                    <dt>周转<br/>灵活</dt>
                    <dd class="space">最长5年还款期<br/>周转灵活自如</dd>
                    <dd class="">最长3年还款期<br/>资金周转时间紧</dd>
                </dl>
                <dl>
                    <dt>办理<br/>便捷</dt>
                    <dd class="space">足不出户办理<br/>真正省力省心</dd>
                    <dd class="">频繁跑网点补充资料<br/>耗时耗力</dd>
                </dl>

            </div>
        </div>
    </div>


    <div class="goodBusiness">
        <div class="title-deline">优选商家</div>
    </div>
</div>
<div class="wrap-container">
    <div class="frequestions">
        <div class="title-deline">常见问题</div>
        <ul class="questionlist clear">
            <c:forEach items="${problems}" var="problem">
                <li>
                    <p class="qa-qustion ellipsis">${problem.problem}</p>
                    <p class="qa-answer gray-3 ellipsis">${problem.answer}</p>
                </li>
            </c:forEach>

        </ul>
        <p class="morequestions"><a href="${pageContext.request.contextPath}/problems">更多></a></p>
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
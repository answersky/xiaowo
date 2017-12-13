<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>联系我们_小窝金服电话_4000755020-联系我们-小窝金服</title>
    <meta http-equiv="keywords" content="联系我们,小窝金服电话,4000755020"/>
    <meta http-equiv="description"
          content="小窝金服隶属于深圳市小窝金融信息服务有限公司，以“为客户提供低成本的装修贷款服务”为经营理念，为广大家装用户提供低费率、高额度、长期限、纯信用的装修贷款产品。小窝金服还与装修公司、家具卖场、电商平台等合作，提供一站式装修贷款服务，让你的装修没有资金烦恼，省心入住自己的小窝。"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%@include file="../common/lib.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css">
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css"/>
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
            <li class="icon-line curnav">联系我们</li>
        </a>
        <a href="${pageContext.request.contextPath}/joinUs">
            <li>加入我们</li>
        </a>
    </ul>
</div>

<!--加入我们-->
<div class="wrap-container bg-gray">
    <div class="g-contact-cont">
        <div class="w970">
            <div class="about_contact about_box">
                <div class="contact_box">
                    <div class="map_box">
                        <div id="allmap" class="allmap"
                             style="overflow: hidden;z-index: 0; color: rgb(0, 0, 0); text-align: left;">
                            <div style="overflow: visible; position: absolute; z-index: 0; left: 0px; top: 0px; cursor: url(http://api0.map.bdimg.com/images/openhand.cur) 8 8, default;">
                                <div class="BMap_mask" id="mapContext"
                                     style="position: absolute; left: 0px; top: 0px; z-index: 9; overflow: hidden; -webkit-user-select: none; width: 896px; height: 525px;"></div>
                            </div>
                        </div>
                        <div class="address_list fr">
                            <ul class="address_scroll" style="bottom: auto; top: 0px;">
                                <h3 style="padding: 12px 0;text-align: left; background: #fafafa;font-size: 16px;">
                                    深圳市小窝金融信息服务有限公司</h3>
                                <li onclick="clickPoint('深圳总部','深圳市南山区科技路1号桑达科技大厦2A16室');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name">深圳总部</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：400-0755-020</p>
                                        <!-- <p>邮箱：kefu@xiaowodai.com</p> -->
                                        <p name="companyAddress">地址：深圳市南山区科技路1号桑达科技大厦2A16室 </p>
                                        <input type="hidden" value="深圳总部" name="companyName">
                                    </div>
                                </li>
                                <li onclick="clickPoint('上海分公司','上海市闸北区彭江路602号（大宁德必易园）E座208室');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name">上海分公司</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：400-0755-020</p>
                                        <!-- <p>邮箱：</p> -->
                                        <p name="companyAddress">地址：上海市闸北区彭江路602号（大宁德必易园）E座208室 </p>
                                        <input type="hidden" value="上海分公司" name="companyName">
                                    </div>
                                </li>
                                <li onclick="clickPoint('太原分公司','山西省太原市小店区长风街和信商座29层');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name">太原分公司</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：0351-2348080</p>
                                        <!-- <p>邮箱：</p> -->
                                        <p name="companyAddress">地址：山西省太原市小店区长风街和信商座29层 </p>
                                        <input type="hidden" value="太原分公司" name="companyName">
                                    </div>
                                </li>
                                <li onclick="clickPoint('成都分公司','成都市锦江区毕昇路256号中加国际5-12-3');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name">成都分公司</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：400-0755-020</p>
                                        <!-- <p>邮箱：</p> -->
                                        <p name="companyAddress">地址：成都市锦江区毕昇路256号中加国际5-12-3 </p>
                                        <input type="hidden" value="成都分公司" name="companyName">
                                    </div>
                                </li>
                                <li onclick="clickPoint('长春分公司','长春市净月区天富路与新城大街交汇朗天国际写字楼3楼');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name">长春分公司</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：0431-81892150</p>
                                        <!-- <p>邮箱：</p> -->
                                        <p name="companyAddress">地址：长春市净月区天富路与新城大街交汇朗天国际写字楼3楼 </p>
                                        <input type="hidden" value="长春分公司" name="companyName">
                                    </div>
                                </li>
                                <li onclick="clickPoint('南京分公司','南京市建邺区燕山路118号苏宁物流园4号楼305');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name">南京分公司</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：400-0755-020</p>
                                        <!-- <p>邮箱：</p> -->
                                        <p name="companyAddress">地址：南京市建邺区燕山路118号苏宁物流园4号楼305 </p>
                                        <input type="hidden" value="南京分公司" name="companyName">
                                    </div>
                                </li>
                                <li onclick="clickPoint(' 北京分公司','北京市朝阳区广渠路36号首城国际中心B座1154');">
                                    <div class="a_l_ico">
                                        <a href="javascript:void(0);"><img width="66" ,height="66">
                                            <span class="pos_name"> 北京分公司</span></a>
                                    </div>
                                    <div class="a_r_text">
                                        <p>总机：400-0755-020</p>
                                        <!-- <p>邮箱：</p> -->
                                        <p name="companyAddress">地址：北京市朝阳区广渠路36号首城国际中心B座1154 </p>
                                        <input type="hidden" value=" 北京分公司" name="companyName">
                                    </div>
                                </li>
                            </ul>
                            <div class="c_scroll">
                                <div class="c_scroll_bar" style="height: 16.2928%; top:0px; bottom: auto;"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- 商务合作 -->
        <div class="contact-txt">
            <div class="contact-address">
                <h2>客服服务</h2>
                <p>客服电话：400-0755-020（工作时间：周一至周五 9:00-18:00，节假日休息）</p>
                <p>邮箱：kefu@ixiaowo.com</p>
            </div>
            <div class="contact-address">
                <h2>商务合作</h2>
                <p>如果你有广告投放，商务合作的需求，请发送邮件，邮件正文请简要介绍合作需求至：</p>
                <p>邮箱：bd@ixiaowo.com</p>
                <p>我们会在一个工作日内与您联系。</p>
            </div>
            <%--<div class="contact-address">
                <h2>信息追踪</h2>
                <p>获取关于小窝金服的最新信息与资讯</p>
                <ul class="address-info fn-clear">
                    <li>
                        <img src="${pageContext.request.contextPath}/img/xw_qr_fwh.jpg" alt="小窝金服微信服务号">
                        <h5>关注微信服务号</h5>
                        <p>客服顾问随时为你解答疑问</p>
                    </li>
                     <li>
                         <img src="${pageContext.request.contextPath}/img/xw_qr_sina.jpg" alt="小窝金服新浪微博">
                         <h5>关注新浪微博</h5>
                         <p>随时随地掌握小窝金服动态资讯</p>
                     </li>
                </ul>
            </div>--%>
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
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZkOuFFEff1ySXOmSlq8YtTj1"></script>
<script type="text/javascript"
        src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
</body>

</html>
<script>
    // 百度地图API功能
    var map = new BMap.Map("mapContext");
    map.centerAndZoom("深圳", 12)
    map.enableScrollWheelZoom(true);
    var index = 0;
    var myGeo = new BMap.Geocoder();
    var companyAddress = $("p[name='companyAddress']").each(
            function () {
                geocodeSearch($(this).html().replace("地址：", ""), $(this).next().val());
            }
    )

    function geocodeSearch(add, title) {
        myGeo.getPoint(add, function (point) {
            if (point) {
                var address = new BMap.Point(point.lng, point.lat);
                addMarker(address, new BMap.Label(title, {offset: new BMap.Size(20, -10)}));

            }
        }, "中国");
    }

    function addMarker(point, label) {

        var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/fox.gif", new BMap.Size(300, 157));
        var marker = new BMap.Marker(point/* ,{icon:myIcon} */);  // 创建标注
        map.addOverlay(marker);
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画

        //添加查询框
        var searchInfoWindow = new BMapLib.SearchInfoWindow(map, "", {
            title: "", //标题
            panel: "", //检索结果面板
            enableAutoPan: true, //自动平移
            searchTypes: [
                BMAPLIB_TAB_SEARCH,   //周边检索
                BMAPLIB_TAB_TO_HERE,  //到这里去
                BMAPLIB_TAB_FROM_HERE //从这里出发
            ]
        });

        marker.addEventListener("click", function (e) {
            searchInfoWindow.open(marker);
        })

        marker.setLabel(label);
    }


    function clickPoint(name, address) {
        // 百度地图API功能
        var map = new BMap.Map("mapContext");
        if (name.indexOf("深圳") >= 0) {
            map.centerAndZoom("深圳", 12);
        } else {
            var index = name.indexOf("分公司");
            if (index >= 0) {
                name = name.substring(0, index);
            }
            map.centerAndZoom(name, 12);
        }

        map.enableScrollWheelZoom(true);
        var index = 0;
        var myGeo = new BMap.Geocoder();

        myGeo.getPoint(address, function (point) {
            if (point) {
                var address = new BMap.Point(point.lng, point.lat);
                var label = new BMap.Label(name, {offset: new BMap.Size(20, -10)});

                var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/fox.gif", new BMap.Size(300, 157));
                var marker = new BMap.Marker(address);  // 创建标注
                map.addOverlay(marker);
                marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画

                //添加查询框
                var searchInfoWindow = new BMapLib.SearchInfoWindow(map, "", {
                    title: "", //标题
                    panel: "", //检索结果面板
                    enableAutoPan: true, //自动平移
                    searchTypes: [
                        BMAPLIB_TAB_SEARCH,   //周边检索
                        BMAPLIB_TAB_TO_HERE,  //到这里去
                        BMAPLIB_TAB_FROM_HERE //从这里出发
                    ]
                });

                marker.addEventListener("click", function (e) {
                    searchInfoWindow.open(marker);
                })

                marker.setLabel(label);
            }
        }, "中国");

    }
</script>
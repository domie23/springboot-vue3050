<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<style>
</style>
<body>

    <div id="app">

    <div class="news-container">
        <h1 class="title">{{detail.singleSeachName}}</h1>
        <div class="auth-container" v-if="detail.insertTime">
            时间：{{detail.insertTime}}
        </div>

        <div class="content" v-html="myFilters(detail.singleSeachContent)">
        </div>
    </div>    </div>

<script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 组件配置信息 -->
<script src="../../js/config.js"></script>
<!-- 扩展插件配置信息 -->
<script src="../../modules/config.js"></script>
<!-- 工具方法 -->
<script src="../../js/utils.js"></script>

<script>
    Vue.prototype.myFilters= function (msg) {
        if(msg != null){
            return msg.replace(/\n/g, "<br>");
        }else{
            return "";
        }
    };
    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [],
            // 数据详情
            detail: {
                id: 0
            },
            // 商品标题
            title: '',

            storeupFlag: 0,//收藏 [0为收藏 1已收藏]
            //系统推荐
            singleSeachRecommendList: [],
            dataList: [],
            // 当前详情页表
            detailTable: 'singleSeach',
        },
        //  清除定时器
        destroyed: function () {
            // 不知道具体作用
            // window.clearInterval(this.inter);
        },
        methods: {
            jump(url) {
                jump(url)
            }
            //预约
            ,singleSeachYuyue(){
                let _this = this;
                // localStorage.setItem('singleSeachId', _this.detail.id);
                // _this.jump("../singleSeachOrder/add.jsp");

                let data={
                    singleSeachId:_this.detail.id,
                    zhigongId:localStorage.getItem("userid"),
                    singleSeachOrderYesnoTypes:1,
                }
                // 提交数据
                layui.http.requestJson('singleSeachOrder/add', 'post', data, function (res) {
                    if(res.code == 0) {
                        layui.layer.msg('预约成功', {
                            time: 2000,
                            icon: 6
                        }, function () {
                            _this.jump("../singleSeachOrder/list.jsp");
                        });
                    }else{
                        layui.layer.msg(res.msg, {
                            time: 5000,
                            icon: 5
                        });
                    }
                });
            },
        }
    });

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage', 'rate'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var laypage = layui.laypage;
        var rate = layui.rate;//评分

        var limit = 10;

        // 设置数量
        jquery('#buyNumber').val(vue.buyNumber);

        // 数据ID
        var id = http.getParam('id');
        vue.detail.id = id;
        http.request('singleSeach/list', 'get', {
            singleSeachTypes:id
        }, function (res) {
            if(res.code ==0){
                if(res.data.total>0){
                    let data = res.data.list[0];
                    if(data == null){
                        layer.msg('获取一条数据出错', {
                            time: 2000,
                            icon: 5
                        });
                    } else {
                        vue.detail = data;
                        vue.title = vue.detail.singleSeachName;
                        vue.detail.singleSeachContent = vue.detail.singleSeachContent.replace(/<img/g,'<img style="width: 100%;"')
                    }
                }

            }else{
                layer.msg('查询不到数据', {
                    time: 2000,
                    icon: 5
                });
            }
        });



    });





</script>
</body>
</html>

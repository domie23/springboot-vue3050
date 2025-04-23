<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑薪资</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">薪资管理</li>
                        <li class="breadcrumb-item active">编辑薪资</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">薪资信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa zhigong">
                                        <label>职工</label>
                                        <div>
                                            <select style="width: 450px" id="zhigongSelect" name="zhigongSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 zhigong">
                                        <label>职工姓名</label>
                                        <input style="width: 450px" id="zhigongName" name="zhigongName" class="form-control"
                                               placeholder="职工姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 zhigong">
                                        <label>职工手机号</label>
                                        <input style="width: 450px" id="zhigongPhone" name="zhigongPhone" class="form-control"
                                               placeholder="职工手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 zhigong">
                                        <label>职工头像</label>
                                        <img id="zhigongPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="zhigongId" name="zhigongId" type="hidden">
                                    <div class="form-group col-md-6 xinziUuidNumberDiv">
                                        <label>薪资编号</label>
                                        <input style="width: 450px" id="xinziUuidNumber" name="xinziUuidNumber" class="form-control"
                                               placeholder="薪资编号">
                                    </div>
                                    <div class="form-group col-md-6 xinziNameDiv">
                                        <label>标题</label>
                                        <input style="width: 450px" id="xinziName" name="xinziName" class="form-control"
                                               placeholder="标题">
                                    </div>
                                    <div class="form-group col-md-6 xinziMonthDiv">
                                        <label>月份</label>
                                        <input type="month" style="width: 450px" id="xinziMonth" name="xinziMonth" class="form-control"
                                               placeholder="月份">
                                    </div>
                                    <div class="form-group col-md-6 jibenJineDiv">
                                        <label>基本工资</label>
                                        <input style="width: 450px" id="jibenJine" name="jibenJine" class="form-control"
                                               onchange="jibenJineChickValue(this)" placeholder="基本工资">
                                    </div>
                                    <div class="form-group col-md-6 jiangjinJineDiv">
                                        <label>奖金</label>
                                        <input style="width: 450px" id="jiangjinJine" name="jiangjinJine" class="form-control"
                                               onchange="jiangjinJineChickValue(this)" placeholder="奖金">
                                    </div>
                                    <div class="form-group col-md-6 jixiaoJineDiv">
                                        <label>绩效</label>
                                        <input style="width: 450px" id="jixiaoJine" name="jixiaoJine" class="form-control"
                                               onchange="jixiaoJineChickValue(this)" placeholder="绩效">
                                    </div>
                                    <div class="form-group col-md-6 butieJineDiv">
                                        <label>补贴</label>
                                        <input style="width: 450px" id="butieJine" name="butieJine" class="form-control"
                                               onchange="butieJineChickValue(this)" placeholder="补贴">
                                    </div>
                                    <%--<div class="form-group col-md-6 shifaJineDiv">
                                        <label>实发</label>
                                        <input style="width: 450px" id="shifaJine" name="shifaJine" class="form-control"
                                               onchange="shifaJineChickValue(this)" placeholder="实发">
                                    </div>--%>
                                    <div class="form-group  col-md-6 xinziContentDiv">
                                        <label>备注</label>
                                        <input id="xinziContentupload" name="file" type="file">
                                        <script id="xinziContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var xinziContentUe = UE.getEditor('xinziContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="xinziContent" id="xinziContent-input">
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "xinzi";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var zhigongOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#xinziContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('xinziContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '职工'){//当前登录用户不为这个
                if($("#zhigongId") !=null){
                    var zhigongId = $("#zhigongId").val();
                    if(zhigongId == null || zhigongId =='' || zhigongId == 'null'){
                        alert("职工不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("xinzi/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addxinzi');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        <!-- 查询级联表的所有列表 -->
        function zhigongSelect() {
            //填充下拉框选项
            http("zhigong/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    zhigongOptions = res.data.list;
                }
            });
        }

        function zhigongSelectOne(id) {
            http("zhigong/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                zhigongShowImg();
                zhigongShowVideo();
                zhigongDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

        function initializationzhigongSelect() {
            var zhigongSelect = document.getElementById('zhigongSelect');
            if(zhigongSelect != null && zhigongOptions != null  && zhigongOptions.length > 0 ) {
                for (var i = 0; i < zhigongOptions.length; i++) {
                        zhigongSelect.add(new Option(zhigongOptions[i].zhigongName, zhigongOptions[i].id));
                }

                $("#zhigongSelect").change(function(e) {
                        zhigongSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        <!--  级联表的下拉框回显  -->
            var zhigongSelect = document.getElementById("zhigongSelect");
            if(zhigongSelect != null && zhigongOptions != null  && zhigongOptions.length > 0 ) {
                for (var i = 0; i < zhigongOptions.length; i++) {
                    if (zhigongOptions[i].id == ruleForm.zhigongId) {//下拉框value对比,如果一致就赋值汉字
                        zhigongSelect.options[i+1].selected = true;
                        $("#zhigongSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.xinziContent != null && ruleForm.xinziContent != 'null' && ruleForm.xinziContent != '' && $("#xinziContentupload").length>0) {

            var xinziContentUeditor = UE.getEditor('xinziContentEditor');
            xinziContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.xinziContent != null){
                    mes = ''+ ruleForm.xinziContent;
                    // mes = mes.replace(/\n/g, "<br>");
                }
                xinziContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#xinziContentupload").length>0) {
            var xinziContentEditor = UE.getEditor('xinziContentEditor');
            if (xinziContentEditor.hasContents()) {
                $('#xinziContent-input').attr('value', xinziContentEditor.getContent());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function jibenJineChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }
        function jiangjinJineChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }
        function jixiaoJineChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }
        function butieJineChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }
        function shifaJineChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addxinzi');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                zhigongId: "required",
                xinziUuidNumber: "required",
                xinziName: "required",
                xinziMonth: "required",
                jibenJine: "required",
                jiangjinJine: "required",
                jixiaoJine: "required",
                butieJine: "required",
                shifaJine: "required",
                xinziContent: "required",
            },
            messages: {
                zhigongId: "职工不能为空",
                xinziUuidNumber: "薪资编号不能为空",
                xinziName: "标题不能为空",
                xinziMonth: "月份不能为空",
                jibenJine: "基本工资不能为空",
                jiangjinJine: "奖金不能为空",
                jixiaoJine: "绩效不能为空",
                butieJine: "补贴不能为空",
                shifaJine: "实发不能为空",
                xinziContent: "备注不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addxinzi = window.sessionStorage.getItem("addxinzi");
        if (addxinzi != null && addxinzi != "" && addxinzi != "null") {
            //注册表单验证
            $(validform());
            $("#xinziUuidNumber").val(new Date().getTime()+Math.ceil(Math.random()*10));//设置唯一号

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("xinzi/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        zhigongDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#zhigongId").val(ruleForm.zhigongId);
        $("#xinziUuidNumber").val(ruleForm.xinziUuidNumber);
        $("#xinziName").val(ruleForm.xinziName);
        $("#xinziMonth").val(ruleForm.xinziMonth);
        $("#jibenJine").val(ruleForm.jibenJine);
        $("#jiangjinJine").val(ruleForm.jiangjinJine);
        $("#jixiaoJine").val(ruleForm.jixiaoJine);
        $("#butieJine").val(ruleForm.butieJine);
        $("#shifaJine").val(ruleForm.shifaJine);
        $("#xinziContent").val(ruleForm.xinziContent);

    }
    <!--  级联表的数据回显  -->
    function zhigongDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#zhigongId").val(ruleForm.id);

        $("#zhigongName").val(ruleForm.zhigongName);
        $("#zhigongPhone").val(ruleForm.zhigongPhone);
        $("#zhigongIdNumber").val(ruleForm.zhigongIdNumber);
        $("#zhigongEmail").val(ruleForm.zhigongEmail);
        $("#bumenValue").val(ruleForm.bumenValue);
        $("#zhiweiValue").val(ruleForm.zhiweiValue);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        zhigongShowImg();
    }


    <!--  级联表的图片  -->

    function zhigongShowImg() {
        $("#zhigongPhotoImg").attr("src",ruleForm.zhigongPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        zhigongShowVideo();
    }


    <!--  级联表的视频  -->

    function zhigongShowVideo() {
        $("#zhigongPhotoV").attr("src",ruleForm.zhigongPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            zhigongSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationzhigongSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addxinzi');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events:none;width:450px;');
        }
		else if (window.sessionStorage.getItem('role') == '职工') {
            // $(".aaaaaa").remove();
            $(".zhigong").remove();//删除当前用户的信息
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>

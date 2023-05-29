<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>级联查询</title>
</head>
<body>
<div>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>省份</td>
            <td><select id="province">
                <option value="0">请选择</option>
            </select><input type="button" name="" value="load数据" id="btnload"></td>
        </tr>
        <tr>
            <td>城市</td>
            <td><select id="city">
                <option value="0">请选择</option>
            </select></td>
        </tr>
    </table>
</div>
</body>
</html>
<script type="text/javascript" src='./js/jquery-3.4.1.js'></script>
<script>
    //    定义一个处理返回数据函数
    function callback(res) {
        $("#city").empty();
        $.each(res,function (i,n) {
            $("#city").append("<option value='" + n.id + "'>" + n.name + "</option>")

        })
    }
    <%--就是采用这种模式，三级，四级也是，通过选中第1级，显示第2级，选中第2级，显示第3级--%>
    $(function () {
        //$(function ()是页面的dom对象加载成功后执行的函数，在此发起Ajax
        loaddataajax();
        //绑定事件
        $("#btnload").click(function () {
            loaddataajax();
        })
        //    给省份的select绑定一个change事件，当select内容发生变化时触发事件
        //    之所以不用select过滤器，click,是因为点击和selected有先后顺序，相矛盾了
        $("#province").change(function () {
            //获取选中的列表框的值
            var obj = $("#province>option:selected");
            var provinceId = obj.val();
            //    做一个ajax请求，获取省份所有城市信息
            //    4个参数顺序是固定的
            //请求处理成功之后处理callback函数，更具名称去进行调用，至于参数，是jQuery赋给他的
            //指定这个名称，就调这个名称的函数
            $.post("/jquerypro/QueryCityServlet", {proid: provinceId},callback, "json")

        })
    })
    function loaddataajax() {
        $.ajax({
            url: "/jquerypro/QueryProvinceServlet",
            dataType: "json",
            success: function (res) {
                //    清空已存在的子对像
                $("#province").empty();
                //    json数组，使用each函数，i代表索引，n代表一个json对象

                $.each(res, function (i, n) {
                    //给select添加子dom元素
                    $("#province").append("<option value='" + n.id + "'>" + n.name + "</option>");
                })

            }
        })
    }

</script>
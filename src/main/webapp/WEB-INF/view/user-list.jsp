<%--
  Created by IntelliJ IDEA.
  User: 26685
  Date: 2017/5/23
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <%--表头--%>
        <div class="row">
            <div class="col-lg-12">
                <h1>用户列表信息</h1>
            </div>
        </div>
        <%--按钮--%>
        <div class="row">
            <div class="col-lg-4 col-lg-offset-8">
                <button class="btn btn-primary" id="adduser">增加</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
            <div>
                <br>
            </div>
        <%--表格信息--%>
        <div class="row">
            <div class="col-lg-12">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>名字</th>
                            <th>密码</th>
                            <th>所在部门</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody id="content">

                    </tbody>
                </table>
            </div>
        </div>
        <%--分页--%>
        <div class="row">
            <div class="col-lg-8">
                当前共<span id="pages"></span>页，总共<span id="totals"></span>条记录
            </div>
            <div class="col-lg-4">
                <nav aria-label="Page navigation" id="nav">

                </nav>
            </div>
        </div>
    </div>
    <!-- 添加用户 弹出框 -->
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加用户</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="adduserform">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名字</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="name" name="name" placeholder="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">部门名称</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="domainId" name="domainId"></select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="saveuser">保存</button>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript">

        $("#saveuser").click(function () {
            $.post("${ctx}/saveuser",$("#adduserform").serialize(),function (data) {
                alert(data.message);
                $('#myModal').modal("hide");

            });
        });
        $("#adduser").click(function () {
            //查询部门数据
            $.post("${ctx}/depts",{},function (data) {
                $("#domainId").empty();
                $.each(data.result.depts,function (i,v) {
                    $("#domainId").append($("<option></option>").attr("value",v.id).append(v.lable));
                });
            });
            //显示模态框
            $('#myModal').modal({
                backdrop:true
            })
        });
     <%--
     content：
     <c:forEach items="${pageInfo.list}" var="user">
     <tr>
     <td>${user.name }</td>
     <td>${user.password}</td>
     <td>${user.domain.lable}</td>
     <td>
     <button class="btn btn-primary">修改</button>
     <button class="btn btn-danger">删除</button>
     </td>
     </tr>
    </c:forEach>--%>
     $(function () {
         page_info(1);
    });
     function page_info(pageNo) {
         $.post("${ctx}/list",{"pageNo":pageNo},function (data) {
             //console.info(data);
             //添加列表内容
             addContent(data);
             //添加分页内容
             addPageInfo(data);
         });
     }
    function addContent(data) {
        $("tbody").empty();
        $.each(data.result.pageInfo.list,function (i,v) {
            var tr=$("<tr></tr>");
            var name=$("<td></td>").append(v.name);
            var password=$("<td></td>").append(v.password);
            var domainLable=$("<td></td>").append(v.domain.lable);
            var updateBtn=$("<button></button>").addClass("btn btn-primary").append("编辑");
            var deleteBtn=$("<button></button>").addClass("btn btn-danger").append("删除");
            var btn=$("<td></td>").append(updateBtn).append(" ").append(deleteBtn);
            tr.append(name).append(password).append(domainLable).append(btn);
            //$("tbody").append(tr);
            tr.appendTo("tbody");
        });
    }

     <%--<li><a href="${ctx}/list">首页</a></li>
         <c:if test="${pageInfo.hasPreviousPage}">
        <li>
             <a href="${ctx}/list?pageNo=${pageInfo.pageNum-1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
     </c:if>
     <c:forEach items="${pageInfo.navigatepageNums}" var="page">
     <c:if test="${page==pageInfo.pageNum}">
     <li class="active"><a href="${ctx}/list?pageNo=${page}">${page}</a></li>
             </c:if>
             <c:if test="${page!=pageInfo.pageNum}">
             <li><a href="${ctx}/list?pageNo=${page}">${page}</a></li>
             </c:if>
             </c:forEach>
             <c:if test="${pageInfo.hasNextPage}">
             <li>
             <a href="${ctx}/list?pageNo=${pageInfo.pageNum+1}" aria-label="Next">
             <span aria-hidden="true">&raquo;</span>
     </a>
     </li>
     </c:if>
     <li><a href="${ctx}/list?pageNo=${pageInfo.pages}">末页</a></li>--%>
     /*<ul class="pagination">

      </ul>*/
    function addPageInfo(data) {
        var pageInfo=data.result.pageInfo;
        $("#pages").text(pageInfo.pages);
        $("#totals").text(pageInfo.total);
        $("#nav").empty();
        var ul=$("<ul></ul>").addClass("pagination");

        var first=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        first.click(function () {
            page_info(1);
        });
        var prev="";
        if(pageInfo.hasPreviousPage){
            var a=$("<a></a>").attr("href","#").append($("<span></span>").append("&laquo;"));
            prev=$("<li></li>").append(a);
            prev.click(function () {
                page_info(pageInfo.pageNum-1);
            });
        }
        ul.append(first).append(prev);

        $.each(pageInfo.navigatepageNums,function (i,v) {
            var numLi="";
            if(pageInfo.pageNum==v){
                numLi=$("<li></li>").addClass("active").append($("<a></a>").attr("href","#").append(v));
            }else{
                numLi=$("<li></li>").append($("<a></a>").attr("href","#").append(v));
            }
            numLi.click(function () {
                page_info(v);
            });
            ul.append(numLi);
        });

        var next = "";
        if(pageInfo.hasNextPage){
            var a=$("<a></a>").attr("href","#").append($("<span></span>").append("&raquo;"));
            next=$("<li></li>").append(a);
            next.click(function () {
                page_info(pageInfo.pageNum+1);
            });
        }
        var last=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        last.click(function () {
            page_info(pageInfo.pages);
        });
        ul.append(next).append(last).appendTo("#nav");
    }
</script>
</body>
</html>

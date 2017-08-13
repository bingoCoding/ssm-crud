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
                <button class="btn btn-primary">增加</button>
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
                当前共${pageInfo.pages}页，总共${pageInfo.total}条记录
            </div>
            <div class="col-lg-4">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><a href="${ctx}/list">首页</a></li>
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
                        <li><a href="${ctx}/list?pageNo=${pageInfo.pages}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
<script type="text/javascript">

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
        //console.info(data);
        $.post("${ctx}/list",{},function (data) {
            //添加列表内容
            addContent(data);
            //添加分页内容
            addPageInfo(data);
        });
    });
    function addContent(data) {
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
    function addPageInfo(data) {

    }
</script>
</body>
</html>

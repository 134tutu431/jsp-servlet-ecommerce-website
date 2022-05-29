<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/20/2021
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
    <%@include file="../../commom/metaandlink.jsp"%>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Home"> <i class="ion-cube"></i> Unistore</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="Home">Home</a></li>
                <li><a href="Catalog">Catalog</a></li>
                <li><a href="Blog">Blog</a></li>
                <li><a href="Gallery">Gallery</a></li>
                <c:if test="${sessionScope.user.role == 1}">
                    <li><a href="Usermanager">Manager Users</a></li>
                    <li><a href="ManagerProduct">Manager Products</a></li>
                </c:if>
                <c:if test="${sessionScope.user.role == 2}">
                    <li><a href="ManagerProduct">Manager Products</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.username != null}">
                    <li><a href="Userinfor"> <i class="ion-android-person"></i> Hello,${sessionScope.user.name}  </a></li>
                    <li><a href="${pageContext.request.contextPath }/Login?action=logout">Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.username == null}">
                    <li><a href="Login"> <i class="ion-android-person"></i> Login </a></li>
                    <li><a href="${pageContext.request.contextPath }/Signup">Signup</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<hr class="offset-lg">

<div class="container tags">
    <p>Search by tags</p>
    <div class="btn-group" data-toggle="buttons">
        <label class="btn btn-default btn-xs active">
            <input type="radio" name="options" id="option1" checked> All items
        </label>
        <label class="btn btn-default btn-xs">
            <input type="radio" name="options" id="option2"> Newest
        </label>
        <label class="btn btn-default btn-xs">
            <input type="radio" name="options" id="option3"> Popular
        </label>
        <label class="btn btn-default btn-xs">
            <input type="radio" name="options" id="option4"> News
        </label>
        <label class="btn btn-default btn-xs">
            <input type="radio" name="options" id="option5"> Articles
        </label>
        <label class="btn btn-default btn-xs">
            <input type="radio" name="options" id="option6"> Reviews
        </label>
    </div>
</div>
<hr class="offset-sm">

<div class="blog">
    <div class="container">
        <div class="row">
            <c:forEach items="${articles}" var="ari">
                <div class="col-sm-6 col-md-6 item">
                    <div class="body">
                        <a href="${pageContext.request.contextPath }/Article?arid=${ari.id}" class="view"><i class="ion-ios-book-outline"></i></a>
                        <a href="${pageContext.request.contextPath }/Article?arid=${ari.id}">
                            <img src="<c:url value='${ari.image}'/>" title="Apple Devices" alt="Apple Devices">
                        </a>
                        <div class="caption">
                            <h1 class="h3">${ari.title}</h1>
                            <label> ${ari.date}</label>
                            <hr class="offset-sm">
                            <p>
                                    ${ari.noidungtg}
                            </p>
                            <hr class="offset-sm">
                            <a href="${pageContext.request.contextPath }/Article?arid=${ari.id}"> View article <i class="ion-ios-arrow-right"></i> </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <nav>
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true"><i class="ion-ios-arrow-left"></i></span>
                    </a>
                </li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="disabled"><a href="#">..</a></li>
                <li><a href="#">10</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true"><i class="ion-ios-arrow-right"></i></span>
                    </a>
                </li>
            </ul>
        </nav>

    </div>
</div>
<hr class="offset-lg">
<hr class="offset-lg">

<%@ include file="../../commom/footer.jsp"%>
<script src="<c:url value='/WebContent/Js/jquery-latest.min.js'/>"> </script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value='/WebContent/Js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/WebContent/Js/core.js'/>"></script>
<script src="<c:url value='/WebContent/Js/catalog.js'/>"></script>

<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery-ui-1.11.4.js'/>"></script>
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery.ui.touch-punch.js'/>"></script>
</body>
</html>

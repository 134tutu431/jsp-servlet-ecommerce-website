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
    <title>Login</title>
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
                    <li><a href="${pageContext.request.contextPath}/Login?action=logout">Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.username == null}">
                    <li><a href="Login"> <i class="ion-android-person"></i> Login </a></li>
                    <li><a href="${pageContext.request.contextPath}/Signup">Signup</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<hr class="offset-lg hidden-xs">
<hr class="offset-md">

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 md-padding">
            <h1 class="align-center">Returning Customer</h1>
            <br>
            <form class="signin" action="${pageContext.request.contextPath }/Login" method="post">
                <input type="email" name="email" value="${email}" placeholder="E-mail" required="" class="form-control" />
                <br>
                <input type="password" name="password" value="${password}" placeholder="Password" required="" class="form-control" />
                <br>
                <button type="submit"  value="login" class="btn btn-primary">Sign In</button>
                <a href="#forgin-password" data-action="Forgot-Password" class="xs-margin">Password recovery ></a>
                <br><br>
                <p>
                    If you already have an account with us, please login.
                </p>
                <hr class="offset-xs">
                <a href="#facebook" class="btn btn-facebook"> <i class="ion-social-facebook"></i> Login with Facebook </a>
                <hr class="offset-sm">
                <p>
                    Don't have an account? Create one now! <a href="Signup"> Registration > </a>
                </p>
                <div class="text-danger text-center" style="font-size: 30px;">
                    ${error }
                </div>
            </form>
        </div>
    </div>
</div>
<br><br>
<br class="hidden-xs">
<br class="hidden-xs">

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


<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.user.name} - Unistore</title>
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
<hr class="offset-md">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 md-padding">
            <h1 class="align-center">User information</h1>
            <br>
            <form class="join" action="Userinfor" method="post">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12">
                            <label style="font-size: 15px;padding-left: 3px">Name</label>
                            <input type="text" name="name" value="${sessionScope.user.name}" placeholder="Name" required="" class="form-control" /><br>
                        </div>
                        <div class="col-sm-12">
                            <label style="font-size: 15px;padding-left: 3px">Phone Number</label>
                            <input type="text" name="phone" value="${sessionScope.user.phone}" placeholder="Phone" required="" class="form-control" /><br>
                        </div>
                        <div class="col-sm-12">
                            <label style="font-size: 15px;padding-left: 3px">E-Mail</label>
                            <input type="email" name="email" value="${sessionScope.user.email}" placeholder="E-mail" required="" class="form-control" /><br>
                        </div>
                        <div class="col-sm-12">
                            <label style="font-size: 15px;padding-left: 3px">Password</label>
                            <input type="password" name="password" value="" placeholder="Password" required="" class="form-control" /><br>
                        </div>
                        <div class="col-sm-12">
                            <label style="font-size: 15px;padding-left: 3px">Confirm Password</label>
                            <input type="password" name="password-confirm" value="" placeholder="Confirm Password"  class="form-control" /><br>
                        </div>
                    </div>
                </div>
                <br>
                <button value="save" type="submit" class="btn btn-primary">Save information</button>
                <a href="Home" class="xs-margin">Home ></a>
                <br><br>
            </form>
            <br class="hidden-sm hidden-md hidden-lg">
        </div>
        <div class="col-md-12 text-center text-danger" style="font-size: 30px">
                ${notify}
        </div>
    </div>
</div>
<br><br>
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


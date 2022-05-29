<%@ page import="Dao.ProductsDao" %>
<%@ page import="Model.ProductsModel" %>
<%@ page import="java.util.List" %>
<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
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
                    <li><a href="/FINALEXAM_JAVA_war_exploded/Login?action=logout">Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.username == null}">
                    <li><a href="Login"> <i class="ion-android-person"></i> Login </a></li>
                    <li><a href="/FINALEXAM_JAVA_war_exploded/Signup">Signup</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<hr class="offset-lg">

<div class="container tags">
    <div class="btn-group pull-right">
        <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="ion-arrow-down-b"></i> Sorting by ...
        </button>
        <ul class="dropdown-menu">
            <li ><a href="${pageContext.request.contextPath }/Catalogoder?oderby=nameasc"> <i class="ion-arrow-down-c"></i> Name [A-Z]</a></li>
            <li ><a href="${pageContext.request.contextPath }/Catalogoder?oderby=namedesc"> <i class="ion-arrow-up-c"></i> Name [Z-A]</a></li>
            <li ><a href="${pageContext.request.contextPath }/Catalogoder?oderby=priceasc"> <i class="ion-arrow-down-c"></i> Price [Low-High]</a></li>
            <li ><a href="${pageContext.request.contextPath }/Catalogoder?oderby=pricedesc"> <i class="ion-arrow-up-c"></i> Price [High-Low]</a></li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="row">
        <!-- Filter -->
        <div class="col-sm-3 filter">
            <div class="item">
                <div class="title">
                    <a href="" data-action="open" class="down"> <i class="ion-android-arrow-dropdown"></i> Open</a>
                    <a href="${pageContext.request.contextPath }/Catalog" data-action="clear"> <i class="ion-ios-trash-outline"></i> Clear</a>
                    <h1 class="h4">Type</h1>
                </div>
                <div class="controls">
                    <c:forEach items="${listtype}" var="ty">
                        <div class="checkbox-group" data-status="${checked == ty.typeid ? "active" : "inactive"}">
                            <div class="checkbox"><i class="ion-android-done"></i></div>
                            <a href="${pageContext.request.contextPath }/Catalogbyid?typeid=${ty.typeid}" style="text-decoration: none;">
                                <div class="label" style="color: #777777;text-decoration: none;font-size: 14px;font-weight: normal" data-value="Laptops">${ty.type}</div>
                                <input type="checkbox" name="checkbox" value="">
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <br>
            <div class="item">
                <div class="title">
                    <a href="${pageContext.request.contextPath }/Catalog" data-action="clear"> <i class="ion-ios-trash-outline"></i> Clear</a>
                    <h1 class="h4">Manufacturer</h1>
                </div>
                <div class="controls">
                    <c:forEach items="${listmanu}" var="manu">
                        <div class="checkbox-group" data-status="${checkedmanu == manu.manuid ? "active" : "inactive"}">
                            <div class="checkbox"><i class="ion-android-done"></i></div>
                            <a href="${pageContext.request.contextPath }/Catalogbyid?manuid=${manu.manuid}" style="text-decoration: none;">
                                <div class="label" style="color: #777777;text-decoration: none;font-size: 14px;font-weight: normal" data-value="Laptops">${manu.manufacturer}</div>
                                <input type="checkbox" name="checkbox" value="">
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- /// -->
        <!-- Products -->
        <div class="col-sm-9 products">
            <div class="row">
                <c:forEach items="${list}" var="product">
                    <div class="col-sm-6 col-md-4 product" style="height: 350px">
                        <a href="${pageContext.request.contextPath }/Detail?proid=${product.id}" class="favorites" data-favorite="inactive"><i class="ion-ios-heart-outline"></i></a>
                        <a href="${pageContext.request.contextPath }/Detail?proid=${product.id}"><img style="height: 170px" src="<c:url value='${product.image}'/>" alt="HP Chromebook 14"/></a>
                        <div class="content">
                            <h1 class="h4">${product.proname}</h1>
                            <p class="sale">$${product.proprice}</p>
                            <p class="price through">$${product.pricethrough}</p>
                            <label>${product.type}</label>
                            <a href="${pageContext.request.contextPath }/Detail?proid=${product.id}" class="btn btn-link"> Details</a>
                            <button class="btn btn-primary btn-rounded btn-sm"> <i class="ion-bag"></i> Add to cart</button>
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
                        <li class="active"><a href="">1</a></li>
                        <li><a href="">2</a></li>
                        <li><a href="">3</a></li>

                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true"><i class="ion-ios-arrow-right"></i></span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- /// -->
    </div>
</div>
<br><br>

<%@ include file="../../commom/footer.jsp"%>
<script src="<c:url value='/WebContent/Js/jquery-latest.min.js'/>"> </script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery-ui-1.11.4.js'/>"></script>
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery.ui.touch-punch.js'/>"></script>
<script src="<c:url value='/WebContent/Js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/WebContent/Js/core.js'/>"></script>
<script src="<c:url value='/WebContent/Js/carousel.js'/>"></script>
<script src="<c:url value='/WebContent/Js/carousel-recommendation.js'/>"></script>
<script src="<c:url value='/WebContent/Js/catalog.js'/>"></script>
</body>
</html>

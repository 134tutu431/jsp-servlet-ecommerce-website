
<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unistore</title>
    <%@include file="../../commom/metaandlink.jsp"%>
    <jsp:useBean id="carousel" class="Dao.CarouselDao" scope="request"></jsp:useBean>
    <jsp:useBean id="quangcao" class="Dao.QuangCaoDao" scope="request"></jsp:useBean>
    <jsp:useBean id="newproducts" class="Dao.NewProductsDao" scope="request"></jsp:useBean>
    <jsp:useBean id="products" class="Dao.ProductsDao" scope="request"></jsp:useBean>
    <jsp:useBean id="articles" class="Dao.ArticlesDao" scope="request"></jsp:useBean>
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


<header>
    <div class="carousel" data-count="3" data-current="3">
        <!-- <button class="btn btn-control"></button> -->
        <div class="items">
            <div class="item active " data-marker="1">
                <img src="<c:url value='/WebContent/img/carousel/bckg.jpg'/>" alt="Background" class="background"/>
                <div class="content">
                    <div class="outside-content">
                        <div class="inside-content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-8 col-sm-offset-2 align-center">
                                        <img src="<c:url value='/WebContent/img/carousel/surfaces.jpg'/>" alt="Surface Pro"/>
                                    </div>
                                    <div class="col-sm-12 align-center">
                                        <h1>8 Windows Hybrid Laptops</h1>
                                        <p>The laptop comes with an Intel i5 chip and 8GB of RAM.</p>
                                        <a href="<c:url value='/WebContent/views/Catalog.jsp'/>">View surfaces ></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item" data-marker="2">
                <img src="<c:url value='/WebContent/img/carousel/bckg.jpg'/>" alt="Background" class="background"/>
                <div class="content">
                    <div class="outside-content">
                        <div class="inside-content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-12 align-center">
                                        <h1>New amazing laptops</h1>
                                        <p>Provide lightweight and powerull</p>
                                        <a href="Catalog.jsp">More laptops ></a>
                                        <br><br>
                                    </div>
                                    <div class="col-sm-6 col-sm-offset-3 align-center">
                                        <img src="<c:url value='/WebContent/img/carousel/newlaptops.jpg'/>" alt="Laptops"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item" data-marker="3">
                <img src="<c:url value='/WebContent/img/carousel/bckg.jpg'/>" alt="Background" class="background"/>
                <div class="content">
                    <div class="outside-content">
                        <div class="inside-content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-5 col-sm-offset-1 align-center">
                                        <img src="<c:url value='/WebContent/img/carousel/ipadair2.jpg'/>" alt="iPad Air 2" class="hidden-xs hidden-sm"/>
                                        <img src="<c:url value='/WebContent/img/carousel/ipadair2m.jpg'/>" alt="iPad Air 2" class="hidden-md hidden-lg"/>
                                    </div>
                                    <div class="col-sm-4 align-left">
                                        <br class="hidden-xs hidden-sm"><br class="hidden-xs hidden-sm"><br class="hidden-xs hidden-sm">
                                        <br class="hidden-xs hidden-sm"><br class="hidden-xs hidden-sm"><br class="hidden-xs hidden-sm">
                                        <h1>Luxury devices</h1>
                                        <br>

                                        <p>
                                            Luxury watches, business tablets and 3D touch: How Apple plans to stay ahead in mobile.
                                            When it comes to the brand’s latest iPhones, the biggest excitement isn’t focused on the addition of a rose gold coloured device but the new 3D touch sensors.
                                        </p>
                                        <a href="<c:url value='/WebContent/views/Catalog.jsp'/>">View article ></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ul class="markers">
            <c:forEach items="${carousel.carouselModels}" var="i">
                <li data-marker="${i.id}" class="active"><img src="<c:url value='${i.image}'/>" alt="Background"></li>
            </c:forEach>
        </ul>
    </div>
</header>
<br><br>
<div class="container">
    <div class="row">
        <c:forEach items="${quangcao.quangCaoModels}" var="q">
            <div class="col-sm-3 align-center">
                <a href="<c:url value='${q.link}'/>">
                    <img src="<c:url value='${q.image}'/>" alt="Blog" class="image"/>
                </a>
                <br><br>
                <a href="<c:url value='${q.link}'/>">${q.title}</a>
            </div>
        </c:forEach>
    </div>
</div>
<br><br>
<div class="container">
    <h2>NEW PRODUCTS</h2>
    <hr class="offset-md">
    <div class="row products">
        <c:forEach items="${newproducts.newProductsModels}" var="npro">
            <div class="col-sm-6 col-md-4 product ">
                <a href="/FINALEXAM_JAVA_war_exploded/Detail?proid=${npro.id}" class="favorites" data-favorite="inactive"><i class="ion-ios-heart-outline"></i></a>
                <a href="/FINALEXAM_JAVA_war_exploded/Detail?proid=${npro.id}"><img src="<c:url value='${npro.image}'/>" alt="Mi Pad 2/"></a>
                <div class="content">
                    <h1 class="h4">${npro.proname}</h1>
                    <p class="sale">$${npro.proprice}</p>
                    <p class="price through">$${npro.pricethrough}</p>
                    <label>${npro.type}</label>
                    <a href="/FINALEXAM_JAVA_war_exploded/Detail?proid=${npro.id}" class="btn btn-link"> Details</a>
                    <button class="btn btn-primary btn-rounded btn-sm"> <i class="ion-bag"></i> Add to cart</button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container">
    <h2>RECOMMENDATION FOR YOU</h2>
    <hr class="offset-md">
    <div class="row products">
        <c:forEach begin="0" end="3" items="${products.productsModels}" var="pro">
            <div class="col-sm-6 col-md-3 product">
                <a href="/FINALEXAM_JAVA_war_exploded/Detail?proid=${pro.id}" class="favorites" data-favorite="inactive"><i class="ion-ios-heart-outline"></i></a>
                <a href="/FINALEXAM_JAVA_war_exploded/Detail?proid=${pro.id}"><img src="<c:url value='${pro.image}'/>" alt="HP Chromebook 14"/></a>
                <div class="content">
                    <h1 class="h4">${pro.proname}</h1>
                    <p class="sale">$${pro.proprice}</p>
                    <p class="price through">$${pro.pricethrough}</p>
                    <label>${pro.type}</label>
                    <a href="/FINALEXAM_JAVA_war_exploded/Detail?proid=${pro.id}" class="btn btn-link"> Details</a>
                    <button class="btn btn-primary btn-rounded btn-sm"> <i class="ion-bag"></i> Add to cart</button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container">
    <h2>NEW ARTICLES</h2>
    <hr class="offset-md">
    <div class="row blog">
        <c:forEach items="${articles.articlesModelsHome}" var="arti">
            <div class="col-sm-6 col-md-6 item">
                <div class="body">
                    <a href="/FINALEXAM_JAVA_war_exploded/Article?arid=${arti.id}" class="view"><i class="ion-ios-book-outline"></i></a>
                    <a href="/FINALEXAM_JAVA_war_exploded/Article?arid=${arti.id}">
                        <img src="<c:url value='${arti.image}'/>" title="Apple Devices" alt="Apple Devices">
                    </a>
                    <div class="caption">
                        <h1 class="h3">${arti.title}</h1>
                        <label> ${arti.date}</label>
                        <hr class="offset-sm">
                        <p>
                                ${arti.noidungtg}
                        </p>
                        <hr class="offset-sm">
                        <a href="/FINALEXAM_JAVA_war_exploded/Article?arid=${arti.id}"> View article <i class="ion-ios-arrow-right"></i> </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<hr class="offset-lg">
<hr class="offset-lg">
<%@ include file="../../commom/footer.jsp"%>
<script src="<c:url value='/WebContent/Js/jquery-latest.min.js'/>"> </script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery-ui-1.11.4.js'/>"></script>
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery.ui.touch-punch.js'/>"></script>
<script src="<c:url value='/WebContent/Js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/WebContent/Js/core.js'/>"></script>
<script src="<c:url value='/WebContent/Js/carousel.js'/>"></script>
<script src="<c:url value='/WebContent/Js/carousel-recommendation.js'/>"></script>
</body>
</html>

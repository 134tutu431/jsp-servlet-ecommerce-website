<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${chi.title} - Unistore</title>
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
<div class="product">
    <div class="container">
        <div class="row">
                <div class="col-sm-7 col-md-7" style="height: 450px !important;">
                    <div class="carousel product" data-count="5" data-current="1">
                        <div class="items">
                            <div class="item active" data-marker="1">
                                <img src="<c:url value='${chi.image}'/>" alt="ChromeBook 11"/>
                            </div>
                            <div class="item" data-marker="2">
                                <img src="<c:url value='${chi.image1}'/>" alt="ChromeBook 11"/>
                            </div>
                            <div class="item" data-marker="3">
                                <img src="<c:url value='${chi.image2}'/>" alt="ChromeBook 11"/>
                            </div>
                            <div class="item" data-marker="4">
                                <img src="<c:url value='${chi.image3}'/>" alt="ChromeBook 11"/>
                            </div>
                            <div class="item" data-marker="5">
                                <img src="<c:url value='${chi.image4}'/>" alt="ChromeBook 11"/>
                            </div>
                            <div class="item" data-marker="6">
                                <div class="tiles">
                                    <a href="#video" data-gallery="#video" data-source="youtube" data-id="hED0N4CFoqs" data-title="An upscale new Chromebook from HP" data-description="The new HP Chromebook 13 runs a Core M CPU inside a slim aluminum body.">
                                        <img src="<c:url value='/WebContent/img/product/video.jpg'/>" alt="ChromeBook 11">
                                        <div class="overlay"></div>
                                        <div class="content">
                                            <div class="content-outside">
                                                <div class="content-inside">
                                                    <i class="ion-ios-play"></i>
                                                    <h1>Watch video review</h1>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <ul class="markers">
                            <li data-marker="1" class="active"><img src="<c:url value='${chi.image}'/>" alt="Background"/></li>
                            <li data-marker="2"><img src="<c:url value='${chi.image1}'/>" alt="Background"/></li>
                            <li data-marker="3"><img src="<c:url value='${chi.image2}'/>" alt="Background"/></li>
                            <li data-marker="4"><img src="<c:url value='${chi.image3}'/>" alt="Background"/></li>
                            <li data-marker="5"><img src="<c:url value='${chi.image4}'/>" alt="Background"/></li>
                            <li data-marker="6"><img src="<c:url value='/WebContent/img/product/video.jpg'/>" alt="Background"/></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-5 col-md-5" >
                    <img style="height: 70px;width: 70px;margin-top: 30px" src="<c:url value='/WebContent/img/brands/hp.png'/>" alt="HP" class="brand hidden-xs" />
                    <h1>${chi.title}</h1>
                    <p>${chi.card}</p>
                    <p class="price">$${chi.price}</p>
                    <p class="price through">$${chi.pricethrough}</p>
                    <br><br>
                    <button class="btn btn-primary btn-rounded"> <i class="ion-bag"></i> Add to cart</button>
                </div>
        </div>
        <br><br><br>
        <div class="row">
                <div class="col-sm-7">
                    <h1>${chi.title}</h1>
                    <br>
                    <p>
                            ${chi.description}
                    </p>
                    <br>
                    <h2>Product specifications</h2>
                    <br>
                    <div class="row specification">
                        <div class="col-sm-6"> <label>Operating system</label> </div>
                        <div class="col-sm-6"> <p>${chi.operating}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Processor</label> </div>
                        <div class="col-sm-6"> <p>${chi.processor}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Processor technology</label> </div>
                        <div class="col-sm-6"> <p>${chi.technology}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Graphics</label> </div>
                        <div class="col-sm-6"> <p>${chi.graphics}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Memory</label> </div>
                        <div class="col-sm-6"> <p>${chi.memory}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Hard drive</label> </div>
                        <div class="col-sm-6"> <p>${chi.harddrive}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Wireless</label> </div>
                        <div class="col-sm-6"> <p>${chi.wireless}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Power supply</label> </div>
                        <div class="col-sm-6"> <p>${chi.power}</p> </div>
                    </div>

                    <div class="row specification">
                        <div class="col-sm-6"> <label>Battery</label> </div>
                        <div class="col-sm-6"> <p>${chi.battery}</p> </div>
                    </div>
                </div>

            <div class="col-sm-5">
                <div class="comments">
                    <h2 class="h3">What do you think?</h2>
                    <br>
                    <div class="wrapper">
                        <div class="content">
                            <c:forEach items="${listcomment}" var="listcom">
                                <h3>${listcom.name}</h3>
                                <label>${listcom.date}</label>
                                <p>
                                    ${listcom.comment}
                                </p>
                            </c:forEach>
                        </div>
                    </div>
                    <br>
                    <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#Modal-Comment"> <i class="ion-chatbox-working"></i> Add comment </button>
                </div>
                <br><br>
                <div class="talk">
                    <h2 class="h3">Do you have any questions?</h2>
                    <p>Online chat with our manager</p>
                    <button class="btn btn-default btn-sm"> <i class="ion-android-contact"></i> Lat's talk </button>
                </div>
            </div>
        </div>
    </div>
</div>
<br><br>
<section class="products">
    <div class="container">
        <h1 class="h3">Recommendation for you</h1>
        <div class="row">
            <c:forEach begin="0" end="3" items="${products.productsModels}" var="pro">
                <div class="col-sm-6 col-md-3 product">
                    <a href="${pageContext.request.contextPath}/Detail?proid=${pro.id}" class="favorites" data-favorite="inactive"><i class="ion-ios-heart-outline"></i></a>
                    <a href="${pageContext.request.contextPath}/Detail?proid=${pro.id}"><img src="<c:url value='${pro.image}'/>" alt="HP Chromebook 14"/></a>
                    <div class="content">
                        <h1 class="h4">${pro.proname}</h1>
                        <p class="sale">$${pro.proprice}</p>
                        <p class="price through">$${pro.pricethrough}</p>
                        <label>${pro.type}</label>
                        <a href="${pageContext.request.contextPath}/Detail?proid=${pro.id}" class="btn btn-link"> Details</a>
                        <button class="btn btn-primary btn-rounded btn-sm"> <i class="ion-bag"></i> Add to cart</button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<br><br>
<!-- Modal -->
<div class="modal fade" id="Modal-Comment" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header align-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="ion-android-close"></i></span></button>
                <h1 class="h4 modal-title">Add your comment</h1>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form class="join" action="Detail" method="post">
                        <div class="row">
                            <div class="col-sm-12">
                                <textarea name="comment" placeholder="Type here" required="" class="form-control" rows="5"></textarea>
                                <br>
                                <input name="productid" class="hide" value="${productid}">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="name" value="" placeholder="Name" required="" class="form-control" />
                            </div>
                            <div class="col-sm-6">
                                <input type="email" name="email" value="" placeholder="E-mail" required="" class="form-control" />
                            </div>
                            <div class="col-sm-12">
                                <div class="align-center">
                                    <br>
                                    <button type="submit" class="btn btn-primary btn-sm"> <i class="ion-android-send"></i> Send</button>
                                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal"> <i class="ion-android-share"></i> No, thanks </button>
                                    <br><br>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
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

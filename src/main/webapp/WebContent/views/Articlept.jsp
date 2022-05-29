<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${aribyid.title}</title>
    <%@include file="../../commom/metaandlink.jsp"%>
    <jsp:useBean id="carousel" class="Dao.CarouselDao" scope="request"></jsp:useBean>
    <jsp:useBean id="quangcao" class="Dao.QuangCaoDao" scope="request"></jsp:useBean>
    <jsp:useBean id="newproducts" class="Dao.ProductsDao" scope="request"></jsp:useBean>
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

<div class="blog-item">
        <img style="height: 500px" src="<c:url value='${aribyid.imagect}'/>" alt="Apple 3D Touch">
        <div class="container">
            <br>
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                    <h1>${aribyid.title}</h1>
                    <br>
                    <p>
                            ${aribyid.noidung}
                    </p>
                    <br>
                    <button class="btn btn-primary btn-sm facebook"> <i class="ion-social-facebook"></i> Share </button>
                    <button class="btn btn-primary btn-sm twitter"> <i class="ion-social-twitter"></i> Retweet</button>
                    <button class="btn btn-primary btn-sm googleplus"> <i class="ion-social-googleplus"></i> Plus </button>
                    <hr>
                    <div class="comments">
                        <h2 class="h3">What do you think? (#2)</h2>
                        <br>
                        <h3>Anne Hathaway</h3>
                        <label>2 years ago</label>
                        <p>
                            Apple Music brings iTunes music streaming to the UK. But is it worth paying for? In our Apple Music review, we examine the service's features, UK pricing, audio quality and music library
                        </p>


                        <h3>Chris Hemsworth</h3>
                        <label>Today</label>
                        <p>
                            Samsung's Galaxy S7 smartphone is getting serious hype. Here's what it does better than Apple's iPhone 6s.
                        </p>
                        <br>

                        <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#Modal-Comment"> <i class="ion-chatbox-working"></i> Add comment </button>
                    </div>
                </div>
            </div>
        </div>

</div>
<br><br>


<!-- Modal-->
<div class="modal fade" id="Modal-ForgotPassword" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="ion-android-close"></i></span></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <h4 class="modal-title">Forgot Your Password?</h4>
                            <br>

                            <form class="join" action="index.php" method="post">
                                <input type="email" name="email" value="" placeholder="E-mail" required="" class="form-control">
                                <br>

                                <button type="submit" class="btn btn-primary btn-sm">Continue</button>
                                <a href="#Sign-In" data-action="Sign-In">Back &gt;</a>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <br><br>
                            <p>
                                Enter the e-mail address associated with your account. Click submit to have your password e-mailed to you.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="Modal-Gallery" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="ion-android-close"></i></span></button>
                <h4 class="modal-title">Title</h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="Modal-Comment" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header align-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="ion-android-close"></i></span></button>
                <h1 class="h4 modal-title">Add your comment</h1>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form class="join" action="index.php" method="post">
                        <div class="row">
                            <div class="col-sm-12">
                                <textarea name="comment" placeholder="Type here" required="" class="form-control" rows="5"></textarea>
                                <br>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="name" value="" placeholder="Name" required="" class="form-control">
                            </div>
                            <div class="col-sm-6">
                                <input type="email" name="email" value="" placeholder="E-mail" required="" class="form-control">
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
</body>
</html>

<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Manager</title>
    <%@include file="../../commom/metaandlink.jsp" %>
    <jsp:useBean id="carousel" class="Dao.CarouselDao" scope="request"></jsp:useBean>
    <jsp:useBean id="quangcao" class="Dao.QuangCaoDao" scope="request"></jsp:useBean>
    <jsp:useBean id="newproducts" class="Dao.NewProductsDao" scope="request"></jsp:useBean>
    <jsp:useBean id="products" class="Dao.ProductsDao" scope="request"></jsp:useBean>
    <jsp:useBean id="articles" class="Dao.ArticlesDao" scope="request"></jsp:useBean>
    <link rel="stylesheet" href="<c:url value='/WebContent/css/manager.css'/>">
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
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-3">
                    <h2>Products Manager</h2>
                </div>
                <div class="col-sm-9">
                        <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                            class="fas fa-plus-circle"></i>
                        <span>Add New Product</span></a>
                    <div class="btn-group " >
                        <button style="width: 180px;height: 33px;color: black;background: #acacac" type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-sort" style="margin-left: 20px"></i> Sorting by ...
                        </button>
                        <ul class="dropdown-menu" >
                            <li ><a href="${pageContext.request.contextPath}/Productmanageroder?oderby=nameasc"> <i class="ion-arrow-down-c"></i> Name [A-Z]</a></li>
                            <li ><a href="${pageContext.request.contextPath}/Productmanageroder?oderby=namedesc"> <i class="ion-arrow-up-c"></i> Name [Z-A]</a></li>
                            <li ><a href="${pageContext.request.contextPath}/Productmanageroder?oderby=priceasc"> <i class="ion-arrow-down-c"></i> Price [Low-High]</a></li>
                            <li ><a href="${pageContext.request.contextPath}/Productmanageroder?oderby=pricedesc"> <i class="ion-arrow-up-c"></i> Price [High-Low]</a></li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        <form action="Productmanagersearch" class="form-inline" method="post">
            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
            <button style="height: 40px"  class="btn btn-outline-secondary btn-lg my-2 my-sm-0" type="submit">Search</button>
            <label style="margin-left: 535px;font-size: 18px;margin-bottom: 1px">Total Products : </label>
            <input style="color: red;font-size: 20px;width: 100px" class="form-control" type="text" value="${total}" readonly>
        </form>
        <hr>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                </th>
                <th>ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Price Throught</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="pro">
                <tr>
                    <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox${pro.id}" name="options[]" value="${pro.id}">
                                        <label for="checkbox${pro.id}"></label>
                                    </span>
                    </td>
                    <td>${pro.id}</td>
                    <td>${pro.proname}</td>
                    <td>
                        <img style="width: 200px;height: 160px" src="<c:url value='${pro.image}'/>">
                    </td>
                    <td>$${pro.proprice}</td>
                    <td>$${pro.pricethrough}</td>
                    <td>${pro.type}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/EditProduct?proid=${pro.id}" class="edit" data-toggle="modal"><i class="fas fa-edit"
                                                                                         data-toggle="tooltip"
                                                                                         title="Edit"></i></a>
                        <a href="${pageContext.request.contextPath}/DeleteProduct?proid=${pro.id}" class="delete" data-toggle="modal"><i class="fas fa-trash-alt"
                                                                                             data-toggle="tooltip"
                                                                                             title="Delete"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="AddProduct" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Product Name</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Product Price</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Price throught</label>
                        <input name="pricethrought" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Product Image</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label style="padding-right: 20px">Product Type</label>
                        <select style="width: 150px;height: 25px" name="type" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listtype}" var="listty">
                                <option value="${listty.typeid}">${listty.type}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="form-group">
                        <label style="padding-right: 20px">Manufacturer</label>
                        <select style="width: 150px;height: 25px" name="manuid" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listmanu}" var="listma">
                                <option value="${listma.manuid}">${listma.manufacturer}</option>
                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<hr class="offset-lg">
<hr class="offset-lg">
<%@ include file="../../commom/footer.jsp" %>
<script src="<c:url value='/WebContent/Js/jquery-latest.min.js'/>"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery-ui-1.11.4.js'/>"></script>
<script type="text/javascript" src="<c:url value='/WebContent/Js/jquery.ui.touch-punch.js'/>"></script>
<script src="<c:url value='/WebContent/Js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/WebContent/Js/core.js'/>"></script>
<script src="<c:url value='/WebContent/Js/carousel.js'/>"></script>
<script src="<c:url value='/WebContent/Js/manager.js'/>"></script>
<script src="<c:url value='/WebContent/Js/carousel-recommendation.js'/>"></script>
</body>
</html>

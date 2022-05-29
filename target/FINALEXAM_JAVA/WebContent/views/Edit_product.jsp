<%@ include file="/commom/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Products Manager - Edit</title>
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
          <h2 >Products Manager</h2>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="col-md-12" style="border: solid 1px;width: 70%;margin-left: 180px;border-radius:3px;box-shadow: 2px 2px 5px 2px #888; ">
      <form action="SaveProduct" method="post" style="width: 100%;padding: 30px">
        <div class="modal-header">
          <h3 class="modal-title">Edit Product</h3>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>Product ID</label>
            <input value="${pro.id}" readonly name="id" type="text" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Product Name</label>
            <input value="${pro.proname}" name="name" type="text" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Product Price</label>
            <input value="${pro.proprice} " name="price" type="text" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Price throught</label>
            <input value="${pro.pricethrough} " name="pricethrought" type="text" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Product Image</label>
            <input value="${pro.image}" name="image" type="text" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Description</label>
            <textarea style="height: 130px"  name="description" class="form-control" required> ${pro.description}</textarea>
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
          <div class="text-center">
            <a href="Usermanager"><input style="width: 100px"  type="button" class="btn btn-default"  value="Cancel"></a>
            <input style="width: 100px"  type="submit" class="btn btn-success" value="Save">
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

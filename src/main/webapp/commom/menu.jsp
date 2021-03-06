web<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value='/WebContent/views/Home.jsp'/>"> <i class="ion-cube"></i> Unistore</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value='/WebContent/views/Home.jsp'/>">Home</a></li>
                <li><a href="<c:url value='/WebContent/views/Catalog.jsp'/>">Catalog</a></li>
                <li><a href="<c:url value='/WebContent/views/Blog.jsp'/>">Blog</a></li>
                <li><a href="<c:url value='/WebContent/views/Gallery.jsp'/>">Gallery</a></li>
                <li class="dropdown">
                    <a href="./catalog/" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">More <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="./catalog/product.html">Product</a></li>
                        <li><a href="./cart/">Cart</a></li>
                        <li><a href="./checkout/">Checkout</a></li>
                        <li><a href="./faq/">FAQ</a></li>
                        <li><a href="./contacts/">Contacts</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Variations</li>
                        <li><a href="./home">Home</a></li>
                        <li><a href="./blog/item-photo.html">Article Photo</a></li>
                        <li><a href="./blog/item-video.html">Article Video</a></li>
                        <li><a href="./blog/item-review.html">Article Review</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value='/WebContent/views/Login.jsp'/>"> <i class="ion-android-person"></i> Login </a></li>
                <li><a href="<c:url value='/WebContent/views/SignUp.jsp'/>"> Sign Up</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
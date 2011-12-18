<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />


<div class="wrapper">
	
	<div class="col200 categories" style="border-right:1px solid #efefef;">
		<H3>Categories</H3>
		<ul>
			<c:forEach var="category" items="${categories}">
				<li> <a	href="../../web/product/list?categoryId=${category.id}">${category.name}</a></li>
			</c:forEach>
		</ul>
		<H3>Manufacturers</H3>
		<ul>
			<c:forEach var="manufacturer" items="${manufacturers}">
				<li> <a	href="../../web/product/list?manufacturerId=${manufacturer.id}">${manufacturer.name}</a></li>
			</c:forEach>
		</ul>
	</div> 


	<div class="col1">	
		<c:forEach varStatus="x" var="product" items="${products}" >
			<div class="prod-list-item"  style="height:200px;margin:auto;">
				<div style="padding-bottom:10px;border-bottom:1px solid #ccc;">
					<img src="http://dnet.nan21.net/static-demo-resources/MM/products/${product.code}-small.jpg" />
				</div>	
				<div>
				<h4>${product.name} </h4>
				<a
					href="../../web/product/view?id=${product.id}">View product</a>
				</div>
			 
			</div>	
		</c:forEach>
	</div> 

</div>
<jsp:include page="/../footer.jsp" />

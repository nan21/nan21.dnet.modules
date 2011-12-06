<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />


<div class="wrapper">
	
	<div class="col2 categories">
		<ul>
			<c:forEach var="category" items="${categories}">
				<li> <a	href="../../web/product/list?categoryId=${category.id}">${category.name}</a></li>
			</c:forEach>
		</ul>
	</div> 


	<div class="col1">	
		<c:forEach var="product" items="${products}">
			<div class="prod-list-item">
			<h4>${product.name} <a
				href="../../web/product/view?id=${product.id}">View product</a></h4>
			</div>	
		</c:forEach>
	</div> 

</div>
<jsp:include page="/../footer.jsp" />

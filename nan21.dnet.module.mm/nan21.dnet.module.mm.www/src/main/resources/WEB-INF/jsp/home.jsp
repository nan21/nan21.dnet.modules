<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />


<div class="wrapper">
	
	
	<div style="width:100%">	
		<H3>Categories</H3>
		<c:forEach var="category" items="${categories}" >
			<div class="prod-list-item">
				<div style="height:130px;margin:auto;border:1px solid #ccc;">
					<img src="${category.iconUrl}" title="${category.name}" alt="${category.name}"/>
				</div>
				
				<div>
					<h4>${category.name} </h4>
					<a href="../../web/product/list?categoryId=${category.id}">View products</a>
				</div>
			 
			</div>	
		</c:forEach>
		 
	</div> 
 
 
</div>


<div class="wrapper">
	 
	<div style="width:100%; height:50px;"></div>	
	<div style="width:100%">	
	  
		<H3>Manufacturers</H3>
		 
		
		<c:forEach var="manufacturer" items="${manufacturers}" >
			<div style="float:left;padding:20px;">
			 
			<a
				href="../../web/product/list?manufacturerId=${manufacturer.id}"><img src="${manufacturer.iconUrl}" 
			title="${manufacturer.name}" alt="${manufacturer.name}"/></a>
			</div>
			 			 
		</c:forEach>
		 
		
	</div> 
	 
	 
	 	 
 
</div>


<jsp:include page="/../footer.jsp" />

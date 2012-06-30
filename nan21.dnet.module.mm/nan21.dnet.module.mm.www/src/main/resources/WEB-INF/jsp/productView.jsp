<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />

 




<h1 class="product-name">${product.name}</h1>
 
<div class="wrapper">

<div class="col1">

<div >

	<c:choose>
		<c:when test='${product.imageUrl == null || product.imageUrl == ""}'>
	         <img src="${product_image_baseurl}/${product.code}${product_image_suffix}.${product_image_ext}" title="${product.name}" alt="${product.name}"/>
	    </c:when>
	    <c:when test='${product.imageUrl.startsWith("http")}'>
	         <img src="${product.imageUrl}" title="${product.name}" alt="${product.name}"/>
	    </c:when>
	    <c:otherwise>
	        <img src=" ${product_image_baseurl}/${product.imageUrl}" title="${product.name}" alt="${product.name}"/>
	    </c:otherwise>
	</c:choose>
</div>
 
<p class="product-description">${product.notes}</p>

<div>
<h3 class="section-title">Images</h3>
<div id="gallery">
    <ul>
 
		<c:forEach var="attachment" items="${attachments}">
		<c:if test="${attachment.type == 'Product image' }">
		 
			 <li>
				<a href="${attachment.url}" title="${attachment.name} | ${product.name}" >		
		                <img src="${attachment.url}" width="72" height="72" alt="" />		
		            </a>		
		        </li>
		</c:if>	
		</c:forEach>	 
	</ul>
</div>





<h3 class="section-title">Links</h3>
<c:forEach var="attachment" items="${attachments}">
<c:if test="${attachment.type != 'Product image' }">
	<a href="${attachment.url}" >${attachment.name}
	</a> &nbsp;&nbsp;&nbsp;&nbsp;
</c:if>	
</c:forEach>


</div>

</div>



<div class="col2">

<div id="product-storable"><c:if
	test="${product.storable == true}">
	<c:if test="${product.weight != null }">
		<p><label>Weight: ${product.weight}
		${product.weightUomCode}</label></p>
	</c:if>
	<c:if test="${product.volume != null }">
		<p><label>Volume: ${product.volume}
		${product.volumeUomCode}</label></p>
	</c:if>
	<p><label>Dimensions(W x H x D): ${product.dimWidth} x
	${product.dimHeight} x ${product.dimDepth} ${product.dimUomCode }</label></p>
</c:if></div>




<div id="product-attributes"><c:set var="lastType" scope="page"
	value="-"></c:set> <c:forEach var="attribute" items="${attributes}">
	<c:if test="${lastType != attribute.category}">
		<p class="prod-attr-type">${attribute.category}</p>
		<c:set var="lastType" value="${attribute.category}"></c:set>
	</c:if>
	<p class="attr-title">${attribute.title}:</p>
	<p class="attr-value">${attribute.value} ${attribute.uom } &nbsp;</p>

</c:forEach></div>


</div>


</div>
 
<div class="wrapper">
<h3 class="section-title">Categories</h3>
<div class="col200">
<ul>
	<c:forEach var="category" items="${categories}" begin="0"
		end="${categories.size()/3}">
		<li><a href="../../web/product/list?categoryId=${category.id}">${category.name}</a></li>
	</c:forEach>
</ul>
</div>

<div class="col200">
<ul>
	<c:forEach var="category" items="${categories}"
		begin="${ categories.size()/3 + 1}" end="${categories.size()*2/3}">
		<li><a href="../../web/product/list?categoryId=${category.id}">${category.name}</a></li>
	</c:forEach>
</ul>
</div>

<div class="col200">
<ul>
	<c:forEach var="category" items="${categories}"
		begin="${categories.size()*2/3 + 1}">
		<li><a href="../../web/product/list?categoryId=${category.id}">${category.name}</a></li>
	</c:forEach>
</ul>
</div>
</div>

<script type="text/javascript">

    $(function() {
        $('#gallery a').lightBox({        	 
        	overlayOpacity: 0.6,
			imageLoading:			'/nan21.dnet.core.www/resources/jquery-lightbox/images/lightbox-ico-loading.gif',		// (string) Path and the name of the loading icon
			imageBtnPrev:			'/nan21.dnet.core.www/resources/jquery-lightbox/images/lightbox-btn-prev.gif',			// (string) Path and the name of the prev button image
			imageBtnNext:			'/nan21.dnet.core.www/resources/jquery-lightbox/images/lightbox-btn-next.gif',			// (string) Path and the name of the next button image
			imageBtnClose:			'/nan21.dnet.core.www/resources/jquery-lightbox/images/lightbox-btn-close.gif',		// (string) Path and the name of the close btn
			imageBlank:				'/nan21.dnet.core.www/resources/jquery-lightbox/images/lightbox-blank.gif',			// (string) Path and the name of a blank image (one pixel)
        	containerResizeSpeed: 350        	 
           });
    });

    </script>
 
<jsp:include page="/../footer.jsp" />


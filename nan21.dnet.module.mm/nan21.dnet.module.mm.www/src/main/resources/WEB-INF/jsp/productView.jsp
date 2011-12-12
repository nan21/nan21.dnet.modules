<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />


<h1 class="procut-name">${product.name}</h1>
 
<div class="wrapper">

<div class="col1">

<div id="slider"><c:forEach var="attachment"
	items="${attachments}">
	<c:if test="${attachment.type == 'Product image' }">
		<img src="${attachment.url}" alt="${attachment.name}"
			title="${attachment.name}" />
	</c:if>

</c:forEach></div>

<p class="procut-description">${product.notes}</p>

<div>
<h3 class="section-title">Images</h3>

<c:forEach var="attachment" items="${attachments}">
<c:if test="${attachment.type == 'Product image' }">
	<a href="${attachment.url}">${attachment.name}
	</a> &nbsp;&nbsp;&nbsp;&nbsp;
</c:if>	
</c:forEach>

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
	<c:if test="${lastType != attribute.type}">
		<p class="prod-attr-type">${attribute.type}</p>
		<c:set var="lastType" value="${attribute.type}"></c:set>
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


<script>
    $('#slider').nivoSlider({
        effect:'fold', //fold  Specify sets like: 'fold, fade, sliceDown, sliceDownLeft, sliceUp, sliceUpLeft, sliceUpDown, sliceUpDownLeft'
        slices:17,
        animSpeed:100,
        pauseTime:4500,
        startSlide:0, //Set starting Slide (0 index)
        directionNav:true, //Next & Prev
        directionNavHide:false, //Only show on hover
        controlNav:true, //1,2,3...
        controlNavThumbs:false, //Use thumbnails for Control Nav
        controlNavThumbsFromRel:false, //Use image rel for thumbs
        controlNavThumbsSearch: '.jpg', //Replace this with...
        controlNavThumbsReplace: '_thumb.jpg', //...this in thumb Image src
        keyboardNav:true, //Use left & right arrows
        pauseOnHover:true, //Stop animation while hovering
        manualAdvance:false, //Force manual transitions
        captionOpacity:1, //Universal caption opacity
        beforeChange: function(){},
        //afterChange: function(){Cufon.refresh();},
        slideshowEnd: function(){} //Triggers after all slides have been shown
    });
  
</script>
<jsp:include page="/../footer.jsp" />


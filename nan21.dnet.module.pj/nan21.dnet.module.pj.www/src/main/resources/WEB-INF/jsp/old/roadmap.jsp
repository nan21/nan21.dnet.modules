<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />


<div class="wrapper">
	
	<h1 class="project title">${project.name}</h1>
	
	<div class="col150 categories" >
		<ul>
			<li> <a	href="../../web/project/view?id=${project.id}">Summary</a></li>
			<li> <a	href="../../web/project/versions?id=${project.id}">Versions</a></li>
			<li> <a	href="../../web/project/roadmap?id=${project.id}">Road Map</a></li>
			<li> <a	href="../../web/project/changelog?id=${project.id}">Change Log</a></li>
		</ul>
	</div> 
	
	
	<div class="col700 left-border">
 
		<H3>Road Map</H3>
		  
		<div class="prj-list">
		
		<p class="flip">Show/Hide Panel</p>
		<div class="panel">
			<p>Because time is valuable, we deliver quick and easy learning.</p>
			<p>At W3Schools, you can study everything you need to learn, in an accessible and handy format.</p>
		</div>
 

		
		
		
		
	    	<table cellspacing=0 cellpadding=0 >
	        <thead>
	            <tr>
	                <th>Name</th>
	                <th>Description</th> 
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="issue" items="${issues}">
					<tr>
	                <td>                    
	                    <a href="../../web/project/view?id=${project.id}">${version.name}</a>
	                </td>	                
	                <td>
	                    ${version.description}
	                </td>
	                
	            </tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
 
		 
	</div> 
 
 
</div>
 <script type="text/javascript"> 
$(document).ready(function(){
$(".flip").click(function(){
    


    
        $("div.panel").load('http://localhost:8089/nan21.dnet.core.www/pj/div-content.html', function(){
        	$(".panel").slideToggle(300);
        	//alert(11);
            });
      

    
  });
});
</script>
<style type="text/css"> 
div.panel,p.flip
{
margin:0px;
padding:5px;
text-align:center;
background:#e5eecc;
border:solid 1px #c3c3c3;
 
}
div.panel
{
 
display:none;
}
</style>



<jsp:include page="/../footer.jsp" />

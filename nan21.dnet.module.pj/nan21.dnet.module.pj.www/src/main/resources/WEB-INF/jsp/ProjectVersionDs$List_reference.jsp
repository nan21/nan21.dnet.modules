
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th></th>	
				<th>Name</th>	  
				<th>Description</th>	  
				<th>PlanDate</th>	  
				<th>ReleaseDate</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td><p id="version-${ds.id}-trigger" class="expand-open" onClick="javascript:loadFragment( 'version-${ds.id}-issues', '../../../dc/list/IssueDs/List?fixedInVersionId=${ds.id}', 'version-${ds.id}-trigger');">Issues</p></td>
				<td><a href="../../view/ProjectVersionDs/Home?id=${ds.id}" title="${ds.name}">${ds.name}</a></td>       
				<td>${ds.description}</td>  	
				<td><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.planDate}"/></td>  	      	     
				<td><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.releaseDate}"/></td>  	      	     
            </tr>
            <tr>
				<td colspan=5>
					<div id="version-${ds.id}-issues" class="panel" style="background-color:#f3f3f3; border:1px solid #eee"></div>
				</td>  	      	     
            </tr>
             
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>

 <script type="text/javascript"> 
$(document).ready(function(){

<c:forEach var="ds" items="${list}">
	$("#version-${ds.id}-trigger").click(function(){  		 
		var b = true;
		if ( $('div#version-${ds.id}-issues').html() == "") {
			$("div#version-${ds.id}-issues").load('../../../dc/list/IssueDs/List?fixedInVersionId=${ds.id}');
			b=false;
		} else {
		}
		if(b) {
			$("div#version-${ds.id}-issues").slideToggle("fast");
		}	
   		   
	});

</c:forEach>
 

 

});
</script>
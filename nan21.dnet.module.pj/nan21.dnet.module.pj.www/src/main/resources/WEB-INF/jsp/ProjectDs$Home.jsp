
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/../header.jsp" />

<div class="wrapper"> 
	
	 
		
	<div>
	<table width="100%">	
	
		<tr>
			<td>
		
	 	
	 	<jsp:include page="../../../../pj/WEB-INF/jsp/ProjectDs$View.jsp"></jsp:include>
	 	 

			</td>
		</tr>	
	
		<tr>
			<td>
		
	<ul class="tab-vl-menu" >
		
			<li><a href="../../../dc/list/ProjectComponentDs/List?projectId=${ds.id}" title="Components">Components</a></li>
		
			<li><a href="../../../dc/list/ProjectVersionDs/List?projectId=${ds.id}" title="Versions">Versions</a></li>
		
			<li><a href="../../../dc/list/ProjectVersionDs/List?projectId=${ds.id}&hideReleased=true" title="Roadmap">Roadmap</a></li>
		
			<li><a href="../../../dc/list/ProjectVersionDs/List?projectId=${ds.id}&hideDue=true" title="Changelog">Changelog</a></li>
			
	</ul>
	<!-- tabs content pane -->
	<div class="tab-vl-container">
		<div style="display:block"></div>
	</div> 
	<script>
		$(document).ready(function(){
			$("ul.tab-vl-menu").tabs("div.tab-vl-container > div", {effect: 'ajax', history: true});
		});
	</script>

			</td>
		</tr>	
	
	</table>
	</div>

	  
</div>

<jsp:include page="/../footer.jsp" />

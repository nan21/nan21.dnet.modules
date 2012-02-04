<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/../header.jsp" />
 
<h1>Project: ${ds.name}</h1>
 
<div class="wrapper">
	 
  	<div id="content">
		<ul class="tab-vl-menu">
			<li>  <a href="../../../dc/view/ProjectDs/view?id=${ds.id}">Summary</a>  </li>
			<li>  <a href="../../../dc/list/ProjectVersionDs/list?projectId=${ds.id}">Versions</a>  </li>
			<li>  <a	href="../../../dc/list/IssueDs/list?id=${ds.id}">Issues</a>  </li>
		</ul>
		  
		<!-- single pane -->
		<div class="tab-vl-container">
			<div style="display:block"></div>
		</div>
	</div>
</div>
 
<script>
	$(document).ready(function(){
	   	//loadFragment('div#tab_summary', '../../../dc/view/ProjectDs/view?id=${ds.id}');
	});
</script>	 
<script>

$(document).ready(function(){
	$("ul.tab-vl-menu").tabs("div.tab-vl-container > div", {effect: 'ajax', history: true});
});
</script>
<jsp:include page="/../footer.jsp" />


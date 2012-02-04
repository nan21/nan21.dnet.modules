<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	<h3 class="subtitle">Project info</h3>
	<div>
		<table border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td class="label">Project code</td>
				<td>${ds.code}</td>
			</tr>
			<tr>
				<td class="label">Project name</td>
				<td>${ds.name}</td>
			</tr>
			<tr>
				<td class="label">Category</td>
				<td>${ds.type}</td>
			</tr>
			<tr>
				<td class="label">Lead</td>
				<td>${ds.projectLead}</td>
			</tr>
			<tr>
				<td class="label">Description</td>
				<td>${ds.notes}</td>
			</tr>
		</table>		 
	</div> 
 	
 	<div class="spacer30"> </div>
 	
 	<div id="project-view-components"  >
 	
 	</div> 
</div>

<script>
$(document).ready(function(){
	$('#project-view-components').load('../../../dc/list/ProjectComponentDs/list?projectId=${ds.id}');
});
</script>	
		 
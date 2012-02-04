
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 

	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <tbody>
			<tr>
				<td class="label">Project:</td>
				<td class="value"><a href="../../view/ProjectDs/Home?id=${ds.projectId}" title="${ds.project}">${ds.project}</a></td>
			</tr>			
			<tr>
				<td class="label">Description:</td>
				<td class="value">${ds.description}</td>  
			</tr>		
			<tr>
				<td class="label">Assignee:</td>
				<td class="value">${ds.assignee}</td>  
			</tr>		
			<tr>
				<td class="label">AssigneeRole:</td>
				<td class="value">${ds.assigneeRole}</td>  
			</tr>		
			<tr>
				<td class="label">ModifiedAt:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.modifiedAt}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">CreatedBy:</td>
				<td class="value">${ds.createdBy}</td>  
			</tr>		
		</tbody>
		</table>		 
	</div>

</div>


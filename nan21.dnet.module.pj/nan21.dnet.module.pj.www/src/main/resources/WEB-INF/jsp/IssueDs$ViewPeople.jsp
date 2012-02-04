
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 

	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <tbody>
			<tr>
				<td class="label">Assignee:</td>
				<td class="value">${ds.assignee}</td>  
			</tr>		
			<tr>
				<td class="label">ModifiedBy:</td>
				<td class="value">${ds.modifiedBy}</td>  
			</tr>		
			<tr>
				<td class="label">CreatedBy:</td>
				<td class="value">${ds.createdBy}</td>  
			</tr>		
		</tbody>
		</table>		 
	</div>

</div>


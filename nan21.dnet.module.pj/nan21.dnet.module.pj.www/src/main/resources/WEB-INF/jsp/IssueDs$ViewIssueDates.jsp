
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 

	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <tbody>
			<tr>
				<td class="label">CreatedAt:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.createdAt}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">ModifiedAt:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.modifiedAt}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">DueDate:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.dueDate}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">ResolutionDate:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.resolutionDate}"/></td>
			</tr>	  	      	     
		</tbody>
		</table>		 
	</div>

</div>



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
				<td class="label">Code:</td>
				<td class="value">${ds.code}</td>  
			</tr>		
			<tr>
				<td class="label">Type:</td>
				<td class="value">${ds.type}</td>  
			</tr>		
			<tr>
				<td class="label">Status:</td>
				<td class="value">${ds.status}</td>  
			</tr>		
			<tr>
				<td class="label">Priority:</td>
				<td class="value">${ds.priority}</td>  
			</tr>		
			<tr>
				<td class="label">Severity:</td>
				<td class="value">${ds.severity}</td>  
			</tr>		
			<tr>
				<td class="label">Resolution:</td>
				<td class="value">${ds.resolution}</td>  
			</tr>		
		</tbody>
		</table>		 
	</div>

</div>


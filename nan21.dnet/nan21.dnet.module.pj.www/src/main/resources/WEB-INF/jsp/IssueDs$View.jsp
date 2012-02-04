
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	<h3>IssueDs$View</h3>
	<div>
		<table cellspacing=0 cellpadding=0 >
        <tbody>
			<tr>
				<td class="label">Code:</td>
				<td class="value">${ds.code}</td>  
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
				<td class="label">Summary:</td>
				<td class="value">${ds.summary}</td>  
			</tr>		
			<tr>
				<td class="label">Project:</td>
				<td class="value">${ds.project}</td>  
			</tr>		
			<tr>
				<td class="label">ProjectName:</td>
				<td class="value">${ds.projectName}</td>  
			</tr>		
			<tr>
				<td class="label">Description:</td>
				<td class="value">${ds.description}</td>  
			</tr>		
			<tr>
				<td class="label">DueDate:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.dueDate}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">ResolutionDate:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.resolutionDate}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">Type:</td>
				<td class="value">${ds.type}</td>  
			</tr>		
			<tr>
				<td class="label">Resolution:</td>
				<td class="value">${ds.resolution}</td>  
			</tr>		
			<tr>
				<td class="label">Severity:</td>
				<td class="value">${ds.severity}</td>  
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
				<td class="label">ReportedVersion:</td>
				<td class="value">${ds.reportedVersion}</td>  
			</tr>		
			<tr>
				<td class="label">TargetVersion:</td>
				<td class="value">${ds.targetVersion}</td>  
			</tr>		
			<tr>
				<td class="label">FixedInVersion:</td>
				<td class="value">${ds.fixedInVersion}</td>  
			</tr>		
			<tr>
				<td class="label">CreatedAt:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.createdAt}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">ModifiedAt:</td>
				<td class="value"><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.modifiedAt}"/></td>
			</tr>	  	      	     
			<tr>
				<td class="label">CreatedBy:</td>
				<td class="value">${ds.createdBy}</td>  
			</tr>		
			<tr>
				<td class="label">ModifiedBy:</td>
				<td class="value">${ds.modifiedBy}</td>  
			</tr>		
		</tbody>
		</table>		 
	</div>
</div>


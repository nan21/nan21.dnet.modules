
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th>SourceIssue</th>	  
				<th>SourceSummary</th>	  
				<th>LinkType</th>	  
				<th>TargetIssue</th>	  
				<th>TargetSummary</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td><a href="../../view/IssueDs/Home?id=${ds.sourceIssueId}" title="${ds.sourceIssue}">${ds.sourceIssue}</a></td>       
				<td>${ds.sourceSummary}</td>  	
				<td>${ds.linkType}</td>  	
				<td><a href="../../view/IssueDs/Home?id=${ds.targetIssueId}" title="${ds.targetIssue}">${ds.targetIssue}</a></td>       
				<td>${ds.targetSummary}</td>  	
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>


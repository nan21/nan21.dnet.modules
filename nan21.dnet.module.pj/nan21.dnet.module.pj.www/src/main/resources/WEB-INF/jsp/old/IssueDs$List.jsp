
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	<h3>IssueDs$List</h3>
	<div>
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th>Code</th>	  
				<th>Status</th>	  
				<th>Priority</th>	  
				<th>Summary</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td>${ds.code}</td>  	
				<td>${ds.status}</td>  	
				<td>${ds.priority}</td>  	
				<td>${ds.summary}</td>  	
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>


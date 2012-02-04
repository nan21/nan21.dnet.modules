
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	<h3>ProjectDs$List</h3>
	<div>
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th>Code</th>	  
				<th>Name</th>	  
				<th>Type</th>	  
				<th>ProjectLead</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td>${ds.code}</td>  	
				<td>${ds.name}</td>  	
				<td>${ds.type}</td>  	
				<td>${ds.projectLead}</td>  	
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>


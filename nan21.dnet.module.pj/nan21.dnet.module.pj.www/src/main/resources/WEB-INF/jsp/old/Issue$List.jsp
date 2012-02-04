
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	<h3>Issue$List</h3>
	<div>
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th>Code</th>	  
				<th>Summary</th>	  
				<th>Status</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td>${ds.code}</td>  	
				<td>${ds.summary}</td>  	
				<td>${ds.status}</td>  	
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>


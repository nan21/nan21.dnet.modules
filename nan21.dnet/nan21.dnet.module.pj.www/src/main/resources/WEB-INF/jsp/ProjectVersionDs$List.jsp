
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	<h3>ProjectVersionDs$List</h3>
	<div>
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th>Name</th>	  
				<th>Description</th>	  
				<th>PlanDate</th>	  
				<th>ReleaseDate</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td>${ds.name}</td>  	
				<td>${ds.description}</td>  	
				<td><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.planDate}"/></td>  	      	     
				<td><fmt:formatDate  pattern="yyyy-MM-dd" value="${ds.releaseDate}"/></td>  	      	     
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>


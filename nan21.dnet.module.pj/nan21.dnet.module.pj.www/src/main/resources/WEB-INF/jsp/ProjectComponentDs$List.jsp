
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 
	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <thead>
            <tr>
				<th>Name</th>	  
				<th>Description</th>	  
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="ds" items="${list}">
			<tr>
				<td>${ds.name}</td>  	
				<td>${ds.description}</td>  	
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>


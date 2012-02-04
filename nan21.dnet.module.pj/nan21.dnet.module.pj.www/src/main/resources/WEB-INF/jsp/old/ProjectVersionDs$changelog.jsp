<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<div>	 
	<h3>Change Log</h3>
	<p>List of released versions. Click on the row to display issues for that version.</p>
	<div>
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
                <td>                    
                    <a href="../../../dc/view/ProjectDs/ProjectDs$view?id=${ds.id}">${ds.name}</a>
                </td>              
                <td>
                    ${ds.description}
                </td>
            </tr>
			</c:forEach>
		</tbody>
		</table>		 
	</div>
</div>
 
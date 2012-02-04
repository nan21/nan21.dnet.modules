<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/../header.jsp" />


<div class="wrapper">
	
	
	<div style="width:100%">	
		<H3>Projects</H3>
		  
		<div class="prj-list">
	    	<table cellspacing=0 cellpadding=0 >
	        <thead>
	            <tr>
	                <th>Project</th>
	                <th>Code</th>
	                <th>Type</th>
	                <th>Project Lead</th>
	                <th>Description</th> 
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="project" items="${projects}">
					<tr>
	                <td>                    
	                    <a href="../../web/project/view?id=${project.id}">${project.name}</a>
	                </td>
	                <td>
	                    ${project.code}
	                </td>
	                <td>
	                    ${project.type}
	                </td>
	                <td>
	                    ${project.projectLead}
	                </td>
	                <td>
	                    ${project.notes}
	                </td>
	            </tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
 
		 
	</div> 
 
 
</div>
 


<jsp:include page="/../footer.jsp" />

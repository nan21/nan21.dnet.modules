<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/../header.jsp" />


<div class="wrapper">
	
	<h1 class="project title">${project.name}</h1>
	
	<div class="col150 categories" >
		<ul>
			<li> <a	href="../../web/project/view?id=${project.id}">Summary</a></li>
			<li> <a	href="../../web/project/versions?id=${project.id}">Versions</a></li>
			<li> <a	href="../../web/project/roadmap?id=${project.id}">Road Map</a></li>
			<li> <a	href="../../web/project/changelog?id=${project.id}">Change Log</a></li>
		</ul>
	</div> 
	
	
	<div class="col700 left-border">
 
		<H3>Versions</H3>
		  
		<div class="prj-list">
	    	<table cellspacing=0 cellpadding=0 >
	        <thead>
	            <tr>
	                <th>Version</th>
	                <th>Planned for</th>
	                <th>Released</th>	                
	                <th>Description</th> 
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="version" items="${versions}">
					<tr>
	                <td>                    
	                    <a href="../../web/project/view?id=${project.id}">${version.name}</a>
	                </td>
	                <td>	                    
	                    <fmt:formatDate  pattern="yyyy-MM-dd" value="${version.planDate}"/> 
	                </td>
	                <td>
	                   <fmt:formatDate  pattern="yyyy-MM-dd" value="${version.releaseDate}"/> 
	                </td>
	                <td>
	                    ${version.description}
	                </td>
	                
	            </tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
 
		 
	</div> 
 
 
</div>
 


<jsp:include page="/../footer.jsp" />

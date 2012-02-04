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
	
		<h3 class="section-title">Project info</h3>
		<div  class="prj-list">
			<table border=0 cellpadding=0 cellspacing=0>
				<tr>
					<td class="label">Project code</td>
					<td>${project.code}</td>
				</tr>
				<tr>
					<td class="label">Project name</td>
					<td>${project.name}</td>
				</tr>
				<tr>
					<td class="label">Category</td>
					<td>${project.type}</td>
				</tr>
				<tr>
					<td class="label">Lead</td>
					<td>${project.projectLead}</td>
				</tr>
				<tr>
					<td class="label">Description</td>
					<td>${project.notes}</td>
				</tr>
			</table>		 
		</div> 
	
	
		<div class="spacer30"></div>
		 
		<h3 class="section-title">Components</h3>  
		<div  class="prj-list">
			<table border=0 cellpadding=0 cellspacing=0>
				<thead>
		            <tr>
		                <th>Name</th>		                
		                <th>Description</th>		                
		            </tr>
	        	</thead>
	       		<tbody>
					<c:forEach var="component" items="${components}">
					<tr>
						<td> <a	href="">${component.name}</a></td>						 
						<td>${component.description}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	
	
		<div class="spacer30"></div>
		
		<h3 class="section-title">Issues: Updated recently</h3>
		<div  class="prj-list">
			<table border=0 cellpadding=0 cellspacing=0>
				<thead>
		            <tr>
		                <th>Code</th>
		                <th>Summary</th>
		                <th>Updated</th> 	                
		            </tr>
	        	</thead>
	       		<tbody>
					<c:forEach var="updIssue" items="${dueIssues}">
					<tr>
						<td> <a	href="">${updIssue.code}</a></td>
						<td>${updIssue.summary}</td>
						<td><fmt:formatDate  pattern="yyyy-MM-dd" value="${updIssue.modifiedAt}"/></td> 
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		
	
	</div>
	 
</div>

 


 
 
<jsp:include page="/../footer.jsp" />


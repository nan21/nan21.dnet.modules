
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/../header.jsp" />

<div class="wrapper"> 
	<h1 class="pagetitle"><p>Issue: ${ds.code}</p> ${ds.summary}</h1>
	 
		
	<div>
	<table width="100%">	
	
		<tr>
			<td>
		
	<div>
	<table  width="100%">
	<tr>
	
		<td valign="top"  width="50%">
		
	<div>
	<table width="100%">	
	
		<tr>
			<td>
		
	 	<h3 class="subtitle">State</h3>
	 	<jsp:include page="../../../../pj/WEB-INF/jsp/IssueDs$ViewIssueType.jsp"></jsp:include>
	 	 

			</td>
		</tr>	
	
		<tr>
			<td>
		
	 	<h3 class="subtitle">Versions</h3>
	 	<jsp:include page="../../../../pj/WEB-INF/jsp/IssueDs$ViewIssueVersions.jsp"></jsp:include>
	 	 

			</td>
		</tr>	
	
	</table>
	</div>

		</td>
	
		<td valign="top"  width="50%">
		
	<div>
	<table width="100%">	
	
		<tr>
			<td>
		
	 	<h3 class="subtitle">Dates</h3>
	 	<jsp:include page="../../../../pj/WEB-INF/jsp/IssueDs$ViewIssueDates.jsp"></jsp:include>
	 	 

			</td>
		</tr>	
	
		<tr>
			<td>
		
	 	<h3 class="subtitle">People</h3>
	 	<jsp:include page="../../../../pj/WEB-INF/jsp/IssueDs$ViewPeople.jsp"></jsp:include>
	 	 

			</td>
		</tr>	
	
	</table>
	</div>

		</td>
	
	</tr>
	</table>
	</div>

			</td>
		</tr>	
	
		<tr>
			<td>
		
	 	<h3 class="subtitle">Description</h3>
	 	<jsp:include page="../../../../pj/WEB-INF/jsp/IssueDs$ViewDescription.jsp"></jsp:include>
	 	 

			</td>
		</tr>	
	
		<tr>
			<td>
		
	<ul class="tab-ht-menu" >
		
			<li><a href="../../../dc/list/IssueLinkDs/List?sourceIssueId=${ds.id}" title="Links">Links</a></li>
		
			<li><a href="../../../dc/list/IssueTaskDs/List?issueId=${ds.id}" title="Tasks">Tasks</a></li>
			
	</ul>
	<!-- tabs content pane -->
	<div class="tab-ht-container">
		<div style="display:block"></div>
	</div> 
	<script>
		$(document).ready(function(){
			$("ul.tab-ht-menu").tabs("div.tab-ht-container > div", {effect: 'ajax', history: true});
		});
	</script>

			</td>
		</tr>	
	
	</table>
	</div>

	  
</div>

<jsp:include page="/../footer.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<div>	 
	<h3>Road Map</h3>
	<p>List of upcoming versions. Click on the row to display issues for that version.</p>
	<div>
		 <ul>
        	<c:forEach var="ds" items="${list}">
			<li>
                <div>                    
                    <a href="javascript:void();" onclick="javascript:loadFragment('div#roadmap-${ds.id}', '../../../dc/list/IssueDs/list?targetVersionId=${ds.id}')">${ds.name}</a>
                </div>              
                <div>
                    ${ds.description}
                </div>
              
                <div id="roadmap-${ds.id}"></div>
                            
            </li>
			</c:forEach>
		 </ul> 
	</div>
</div>
 
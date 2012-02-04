
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>	 

	
	<div  class="prj-list">
		<table cellspacing=0 cellpadding=0 >
        <tbody>
			<tr>
				<td class="label">ReportedVersion:</td>
				<td class="value"><a href="../../view/ProjectVersionDs/Home?id=${ds.reportedVersionId}" title="${ds.reportedVersion}">${ds.reportedVersion}</a></td>
			</tr>			
			<tr>
				<td class="label">TargetVersion:</td>
				<td class="value"><a href="../../view/ProjectVersionDs/Home?id=${ds.targetVersionId}" title="${ds.targetVersion}">${ds.targetVersion}</a></td>
			</tr>			
			<tr>
				<td class="label">FixedInVersion:</td>
				<td class="value"><a href="../../view/ProjectVersionDs/Home?id=${ds.fixedInVersionId}" title="${ds.fixedInVersion}">${ds.fixedInVersion}</a></td>
			</tr>			
		</tbody>
		</table>		 
	</div>

</div>


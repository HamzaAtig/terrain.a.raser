<#import "spring.ftl" as spring />
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<#include "common.ftl">
	<script src="<@spring.url '/js/springMvcImageTable.js'/>"></script>
	
</head>

<body>

<h1>Result page </h1>

	<#if fileNames??>
		<#list fileNames as file>

			<label>${file}</label>
		</#list>
	</#if>

	<#if results??>
		<#list results as result>

			<label>${result}</label>
		</#list>

	<#else>
		<label>No result found.</label>
	</#if>

	<form:form action="" method="GET">
	<h2 >Spring MVC pagination using data tables<br><br></h2>
	<table width="70%" style="border: 3px;background: rgb(243, 244, 248);"><tr><td>
		<table id="example" class="display" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>Titre d image</th>
	     			<th>description</th>
	     			<th>imgSrc</th>
	     			<th>extention</th>
	            </tr>
	        </thead>       
	    </table>
	    </td></tr></table>
	</form:form>
</body>
</html>
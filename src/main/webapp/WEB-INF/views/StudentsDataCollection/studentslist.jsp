<?xml version="1.0" encoding="UTF-8" standalone="no"?>

<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:s="http://www.springframework.org/tags"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"
	xmlns:input="urn:jsptagdir:/WEB-INF/tags/input" version="2.0">
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<jsp:output omit-xml-declaration="yes" />

	<html>
<head>
<c:url var="urlcss1" value="/css/agentpage.css" />
<link rel="stylesheet" type="text/css" href="${urlcss1}" />

<c:url var="urlcss2" value="/css/common.css" />
<link rel="stylesheet" type="text/css" href="${urlcss2}" />


<!-- Scripts -->
<!-- javascript -->
<s:url value="/js/validation.js" var="js_url_validation" />
<s:url value="/js/jquery-1.10.2.min.js" var="js_url_jquery" />
<s:url value="/js/bootstrap.js" var="js_url_bootstrap" />
<s:url value="/js/bootstrap-datepicker.js"
	var="js_url_bootstrap_datepicker" />
<s:url
	value="/js/locales/bootstrap-datepicker.${fn:substring(plocale, 0, 2)}.js"
	var="js_url_bootstrap_datepicker_locale" />
<s:url value="/js/jquery.validate.min.js" var="js_url_jQueryvalidation" />
<s:url value="/js/landingpage.js" var="js_url_landingpage" />
<s:url value="/js/studentslist.js" var="js_url_studentslist" />


<script type="text/javascript" src="${js_url_validation}">
	<jsp:text/>
</script>
<script type="text/javascript" src="${js_url_jquery}">
	<jsp:text/>
</script>
<script type="text/javascript" src="${js_url_bootstrap}">
	<jsp:text/>
</script>
<script type="text/javascript" src="${js_url_bootstrap_datepicker}">
	<jsp:text/>
</script>
<script type="text/javascript"
	src="${js_url_bootstrap_datepicker_locale}" charset="UTF-8">
	<jsp:text/>
</script>
<script type="text/javascript" src="${js_url_jQueryvalidation}">
	_$tag______
</script>
<script type="text/javascript" src="${js_url_landingpage}">
	<jsp:text/>
</script>
<script type="text/javascript" src="${js_url_studentslist}">
	<jsp:text/>
</script>



<title>Students List..</title>
</head>

<!-- 	<script src="js/landingpage.js"></script>
 -->

<body class="bodyclass">


	<div class="container">
		<form:form id="searchForm" class="form-horizontal"
			modelAttribute="studentslist" cssClass="well form-horizontal"
			method="POST" action="#">

			<fieldset class="col-sm-12 bordure">
				<legend class="legende">All Students</legend>


				<div class="form-group">
					<!-- The field label is defined in the messages file (for i18n) -->
					<label for="Search" class="col-sm-2 control-label">Search</label>
					<div class="col-sm-10">
						<span id="searchError"></span>
						<!-- <form:input id="search" path="studentRollno" class="form-control"
							maxLength="20" />
						<form:errors id="search_error" path="studentRollno"
							cssClass="label label-danger" /> -->
						<button type="submit" class="btn btn-primary btn-lg btn-block">Search</button>

					</div>
				</div>


				<table id="studentslist" class="table table-striped">
					<thead>
						<tr>
							<th>Student ID</th>
							<th>Student Name</th>
							<th>Student Application Id</th>
							<th>Student Roll No</th>
							<th>Student Father Name</th>

							<!-- <s:url var="url_create" value="#" />
							<th><a class="btn btn-info" href="${url_create}"><s:message
										code="create" /></a></th> -->
						</tr>
					</thead>
					<tbody style="overflow-x: auto;">
						<c:forEach items="${studentslist}" var="studentslist">
							<tr>
								<td><li id="studentId"
									data-student-id="${studentslist.studentId}"
									value="${studentslist.studentId}">${studentslist.studentId}</li></td>
								<td><li id="sFirstName" value="${studentslist.sFirstName}">
										${studentslist.sFirstName}</li></td>
								<td><li id="applicationId"
									value="${studentslist.applicationId}">
										${studentslist.applicationId}</li></td>
								<td><li id="studentRollno"
									value="${studentslist.studentRollno}">
										${studentslist.studentRollno}</li></td>
								<td><li id="fatherName" value="${studentslist.fatherName}">
										${studentslist.fatherName}</li></td>

								<s:url var="url_update"
									value="/studentslist/form/${studentslist.studentId}" />
								<!-- <td><a class="btn btn-info" href="${url_update}"><s:message
											code="edit" /></a></td> -->
								<!-- <td><a class="popup meetballs" onclick="meetballs(${studentslist.id});">... -->
								<!-- <td><a class="popup meetballs" >... -->
								<td><a class="meetballs ${studentslist.studentId}"
									data-studentid="${studentslist.studentId}" id="meetballs">...
								</a>
									<div class="${studentslist.studentId}">
										<span class="popup" id="myPopup"
											data-student-id="${studentslist.studentId}">delete</span> <span
											class="popup2" id="myPopup2"
											data-studentedit-id="${studentslist.studentId}">edit</span>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${fn:length(studentslist) gt 4}">
					<div class="pagers">
						<div class="pagination">
							<s:url var="prev" value="/studentlist/${pageNumber-1}" />
							<c:choose>
								<c:when
									test="${pageNumber == 1||pageNumber==0 || pageNumber== -1}">
								</c:when>
								<c:otherwise>
									<a id="prev" href="${prev}" class="prev">Prev</a>
								</c:otherwise>
							</c:choose>

							<c:if test="${pageNumber!= 0}">
								<a href="#">${pageNumber}</a>
							</c:if>

							<s:url var="next" value="/studentlist/${pageNumber+1}" />
							<c:choose>
								<c:when test="${pageNumber==lastPageNumber||pageNumber==0}">
								</c:when>
								<c:otherwise>
									<a id="next" href="${next}" class="next">Next</a>
								</c:otherwise>
							</c:choose>

							<c:if test="${pageNumber!=0}">
								<s:url var="viewAll" value="/studentlist/${0}" />
								<a id="viewAll" href="${viewAll}" class="">View All</a>
							</c:if>
						</div>
					</div>
				</c:if>
			</fieldset>
		</form:form>
	</div>





</body>
	</html>
</jsp:root>
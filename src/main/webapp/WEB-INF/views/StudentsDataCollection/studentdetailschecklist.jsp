<?xml version="1.0" encoding="UTF-8" standalone="no"?>

<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:s="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
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
	<jsp:text/>
</script>
<script type="text/javascript" src="${js_url_landingpage}">
	<jsp:text/>
</script>

<title>student data check page..</title>
</head>

<!-- 	<script src="js/landingpage.js"></script>
 -->

<body class="bodyclass">
	<div>
		<fieldset class="fieldsetter">
			<legend>Check Student Details</legend>


			<form:form id="studentdetailschecklistform" class="formpage"
				modelAttribute="studentsdata" method="POST" action="registerStudent">
				<form:errors path="*" cssClass="" element="div" />
				<c:if test="${mode != 'create'}">
					<!-- Store data in hidden fields in order to be POST even if the field is disabled -->
					<!--  <form:hidden path="patientId" /> -->
				</c:if>

				<!-- Student Id -->
				<div class="cm-1">
					<label for="Student Id" class="cm-2">Student Id</label>
					<div class="cm-3">
						<c:if test="${empty studentsdata.studentId}">
							<form:input for="Student Id" path="studentId"
								class="cm-4 textcontrol" value="No value available"
								disabled="true" />
						</c:if>
						<c:if test="${not empty studentsdata.studentId}">
							<form:input for="Student Id" path="studentId"
								class="cm-4 textcontrol" value="${studentsdata.studentId}"
								disabled="true" />
							<form:hidden path="studentId" />
						</c:if>
					</div>
				</div>

				<!-- First Name -->
				<div class="cm-1">
					<label for="First Name" class="cm-2">First Name</label>
					<div class="cm-3">
						<form:input for="First Name" path="sFirstName"
							class="cm-4 textcontrol" disabled="true"
							value="${studentsdata.sFirstName}" />
						<form:hidden path="sFirstName" />
					</div>
				</div>


				<!-- Last Name -->
				<div class="cm-1">
					<label for="Last Name" class="cm-2">Last Name</label>
					<div class="cm-3">
						<form:input for="Last Name" path="sLastName"
							class="cm-4 textcontrol" disabled="true"
							value="${studentsdata.sLastName}" />
						<form:hidden path="sLastName" />
					</div>
				</div>


				<!-- surname -->
				<div class="cm-1">
					<label for="surname" class="cm-2">surname</label>
					<div class="cm-3">
						<form:input for="surname" path="surname" class="cm-4 textcontrol"
							disabled="true" value="${studentsdata.surname}" />
						<form:hidden path="surname" />
					</div>
				</div>


				<!-- applicationId -->
				<div class="cm-1">
					<label for="applicationId" class="cm-2">Application Id</label>
					<div class="cm-3">
						<form:input for="applicationId" path="applicationId"
							class="cm-4 textcontrol" disabled="true"
							value="${studentsdata.applicationId}" />
						<form:hidden path="applicationId" />
					</div>
				</div>

				<!-- studentStadard -->
				<div class="cm-1">
					<label for="studentStadard" class="cm-2">Student Standard</label>
					<div class="cm-3">
						<form:input for="studentStadard" path="studentStadard"
							class="cm-4 textcontrol" disabled="true"
							value="${studentsdata.studentStadard}" />
						<form:hidden path="studentStadard" />
					</div>
				</div>

				<!-- studentRollno -->
				<div class="cm-1">
					<label for="studentRollno" class="cm-2">Roll No</label>
					<div class="cm-3">
						<form:input for="studentRollno" path="studentRollno"
							class="cm-4 textcontrol" disabled="true"
							value="${studentsdata.studentRollno}" />
						<form:hidden path="studentRollno" />
					</div>
				</div>

				<!-- fatherName -->
				<div class="cm-1">
					<label for="fatherName" class="cm-2">Father Name</label>
					<div class="cm-3">
						<form:input for="fatherName" path="fatherName"
							class="cm-4 textcontrol" disabled="true"
							value="${studentsdata.fatherName}" />
						<form:hidden path="fatherName" />
					</div>
				</div>

				<!-- motherName -->
				<div class="cm-1">
					<label for="motherName" class="cm-2">Mother Name</label>
					<div class="cm-3">
						<label for="motherName" path="motherName" class="cm-4 textcontrol"
							disabled="true"> ${studentsdata.motherName}</label>
						<form:hidden path="motherName" />
					</div>
				</div>

				<c:if test="${not empty studentsdata.confirmationmessage}">
					<SCRIPT type="text/javascript">
						$(document).ready(function() {

							$("#confirm").click(function() {
								$("#confirmationmessage").dialog("open");
							});

							$("#cancelbutton").click(function() {
								$("#confirmationmessage").hide();
							});

						});
					</SCRIPT>
				</c:if>

				<SCRIPT type="text/javascript">
					function _submit() {
						document.getElementById('studentdetailschecklistform')
								.submit();
						alert("submitted successylly");
					}
				</SCRIPT>


				<div for="confirmation message" id="confirmationmessage"
					class="confirmationmsgmodal" role="dialog">
					<span path="confirmationmessage" class="">${studentsdata.confirmationmessage}</span>
					<button type="button" id="confirm" class="cancelbutton"
						onclick="_closemodel()">OK</button>
				</div>

				<!-- ACTION BUTTONS -->
				<div class="actionbuttons">

					<div class="cancel">
						<!-- "CANCEL" button ( HREF link ) -->
						<input type="button" id="cancelconfirmstudentdetails"
							class="cancelbutton" value="Back" />
					</div>

					<div class="submit">
						<c:if test="${empty studentsdata.confirmationmessage}">
							<!-- "SAVE" button ( SUBMIT button ) -->
							<button id="confirm" class="cancelbutton" onclick="_submit()">
								Confirm</button>
						</c:if>
						<c:if test="${not empty studentsdata.confirmationmessage}">
							<!-- "SAVE" button ( SUBMIT button ) -->
							<button id="confirm" class="cancelbutton" onclick="_submit()"
								disabled="true">Confirm</button>
						</c:if>
					</div>
				</div>

			</form:form>
		</fieldset>
	</div>
</body>
	</html>
</jsp:root>


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



<title>agent landing page..</title>
</head>

<!-- 	<script src="js/landingpage.js"></script>
 -->

<body class="bodyclass">
	<div>
		<fieldset class="fieldsetter">
			<legend>Fill Students Details Here</legend>


			<form:form class="formpage" modelAttribute="studentsdata"
				method="POST" action="confirmPage">
				<form:errors path="*" cssClass="" element="div" />
				<c:if test="${mode != 'create'}">
					<!-- Store data in hidden fields in order to be POST even if the field is disabled -->
					<!--  <form:hidden path="patientId" /> -->
				</c:if>

				<!-- Student Id -->
				<div class="cm-1">
					<label for="Student Id" class="cm-2">Student Id</label>
					<div class="">
						<c:if test="${empty studentsdata.studentId}">
							<form:input id="studentId" path="studentId"
								class="textcontrol disabled" maxLength="20"
								value="No value at present" disabled="true" />
						</c:if>
						<c:if test="${not empty studentsdata.studentId}">
							<form:input id="studentId" path="studentId"
								class="textcontrol disabled" maxLength="20"
								value="${studentsdata.studentId}" disabled="true" />
						</c:if>
					</div>
				</div>

				<!-- First Name -->
				<div class="cm-1">
					<label for="First Name" class="cm-2">First Name</label>
					<div class="">
						<form:input id="sFirstName" path="sFirstName"
							class="textcontrol placeholder" maxLength="40"
							placeholder="First Name" required="true" />
						<form:errors id="sFirstName_error" path="sFirstName" cssClass="" />
					</div>
				</div>


				<!-- Last Name -->
				<div class="cm-1">
					<label for="Last Name" class="cm-2">Last Name</label>
					<div class="">
						<form:input id="sLastName" path="sLastName"
							class="textcontrol placeholder" maxLength="40"
							placeholder="Last Name" required="true" />
						<form:errors id="sLastName_error" path="sLastName" cssClass="" />
					</div>
				</div>


				<!-- surname -->
				<div class="cm-1">
					<label for="surname" class="cm-2">surname</label>
					<div class="">
						<div class="">
							<form:input id="surname" path="Surname"
								class="textcontrol placeholder" maxLength="20"
								placeholder="Surname" required="true" />
							<form:errors id="surname_error" path="surname" cssClass="" />
						</div>
					</div>
				</div>


				<!-- applicationId -->
				<div class="cm-1">
					<label for="applicationId" class="cm-2">Application Id</label>
					<div class="">
						<div class="">
							<form:input id="applicationId" path="applicationId"
								class="textcontrol placeholder" maxLength="20"
								placeholder="Application Id" required="true" />
							<form:errors id="applicationId_error" path="applicationId"
								cssClass="" />
						</div>
					</div>
				</div>

				<!-- studentStadard -->
				<div class="cm-1">
					<label for="studentStadard" class="cm-2">Student Standard</label>
					<div class="">
						<div class="">
							<form:input id="studentStadard" path="studentStadard"
								class="textcontrol placeholder" maxLength="4" type="number"
								placeholder="Student Stadard" required="true" />
							<form:errors id="studentStadard_error" path="studentStadard"
								cssClass="" />
						</div>
					</div>
				</div>

				<!-- studentRollno -->
				<div class="cm-1">
					<label for="studentRollno" class="cm-2">Roll No</label>
					<div class="">
						<div class="">
							<form:input id="studentRollno" path="studentRollno"
								class="textcontrol placeholder" maxLength="11"
								placeholder="Student Rollno" required="true" />
							<form:errors id="studentRollno_error" path="studentRollno"
								cssClass="" />
						</div>
					</div>
				</div>

				<!-- fatherName -->
				<div class="cm-1">
					<label for="fatherName" class="cm-2">Father Name</label>
					<div class="">
						<div class="">
							<form:input id="fatherName" path="fatherName"
								class="textcontrol placeholder" maxLength="40"
								placeholder="Father Name" required="true" />
							<form:errors id="fatherName_error" path="fatherName" cssClass="" />
						</div>
					</div>
				</div>

				<!-- motherName -->
				<div class="cm-1">
					<label for="motherName" class="cm-2">Mother Name</label>
					<div class="">
						<div class="">
							<form:input id="motherName" path="motherName"
								class="textcontrol placeholder" maxLength="40"
								placeholder="Mother Name" required="true" />
							<form:errors id="motherName_error" path="motherName" cssClass="" />
						</div>
					</div>
				</div>

				<!-- ACTION BUTTONS -->
				<div class="actionbuttons">

					<div class="cancel">
						<!-- "CANCEL" button ( HREF link ) -->
						<button type="button" id="studentdatafillcancel"
							class="cancelbutton">Cancel</button>
					</div>
					<div class="submit">
						<!-- "SAVE" button ( SUBMIT button ) -->
						<button type="submit" class="cancelbutton">Preview</button>
					</div>
				</div>

			</form:form>
		</fieldset>
	</div>
</body>
	</html>
</jsp:root>


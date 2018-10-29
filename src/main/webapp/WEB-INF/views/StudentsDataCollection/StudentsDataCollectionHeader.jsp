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
	<s:url value="/js/bootstrap-datepicker.js" var="js_url_bootstrap_datepicker" />
	<s:url value="/js/locales/bootstrap-datepicker.${fn:substring(plocale, 0, 2)}.js" var="js_url_bootstrap_datepicker_locale" />
	<s:url value="/js/jquery.validate.min.js" var="js_url_jQueryvalidation" />
	<s:url value="/js/landingpage.js" var="js_url_landingpage" />
	
	
	<script type="text/javascript" src="${js_url_validation}"><jsp:text/></script>
	<script type="text/javascript" src="${js_url_jquery}"><jsp:text/></script>
	<script type="text/javascript" src="${js_url_bootstrap}"><jsp:text/></script>
	<script type="text/javascript" src="${js_url_bootstrap_datepicker}"><jsp:text/></script>
	<script type="text/javascript" src="${js_url_bootstrap_datepicker_locale}" charset="UTF-8"><jsp:text/></script>
	<script type="text/javascript" src="${js_url_jQueryvalidation}"><jsp:text/></script>
	<script type="text/javascript" src="${js_url_landingpage}"><jsp:text/></script>

<title>student data check page..</title>
</head>

<!-- 	<script src="js/landingpage.js"></script>
 -->

<body class="bodyclass">
	
	


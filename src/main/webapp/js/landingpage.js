
window.onload = function(){

//On click of Back button in studentdetailschecklist.jsp
$('#cancelconfirmstudentdetails').click(function() { 
	alert("The paragraph was clicked.");
    document.location = '/agentLandingPage';
});

//on click of Cancel button in agentlandingpage
$('#studentdatafillcancel').click(function() { 
    document.location = '/';
});
};

$(window).on('beforeunload', function () {
    $("input[type=submit], input[type=button]").prop("disabled", "disabled");
});

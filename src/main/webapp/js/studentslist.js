$(document).ready(function() {
	
	var classOfRow = $(this).attr("data-studentid");
	$('.'+classOfRow).hide();

	$('.meetballs').on('click',function(event){
		/*var currentrow = $(this).closest('tr');
		currentrow.find('td:eq(5)').on('click', function(e){
			$(".popup").show(); 
		});*/
			
		var classOfRow = $(this).attr("data-studentid");
		$('.'+classOfRow).show();
		$('.delete').on('click', _handledelete);
		//$('.popup2').on('click', _handledelete);
		$(this).next().toggleClass('hide');
	});
	
	

// document click for closing tool tips
	$(document).on("click",function (event) {
		   if(!$(event.target).is('.popups') && !$(event.target).is('.meetballs')) {
		     $("#myPopup").addClass('hide');
		   }
	});
	
	
//Comment the below code since it is for reference
	/*
	_handleDownloadgrp = function(e) {
		var studentId = $(this).attr("data-student-id");
		var form = document.createElement("form");
		form.method = "GET";
		form.action = '/reports/getStudentReviewReport';
		form.id = "downloadSheet";
		var element1 = document.createElement("input");
		var element2 = document.createElement("input");
		element1.name = "studentId";
		element1.value = studentId;
		form.appendChild(element1);
		element2.name = "type";
		element2.value = "excelSheet";
		form.appendChild(element2);
		document.body.appendChild(form);
		form.submit();
		$('#downloadSheet').hide();
	}*/

//On click of .popup class call delete		
	_handledelete = function(e) {
		var studentId = $(this).attr("data-student-id");
		var form = document.createElement("form");
		form.method = "GET";
		form.action = '/studentslist/form/'+studentId;
		form.id = "deletestudentbypopup";
		var element1 = document.createElement("input");
		var element2 = document.createElement("input");
		element1.name = "studentId";
		element1.value = studentId;
		form.appendChild(element1);
		element2.name = "type";
		element2.value = "excelSheet";
		form.appendChild(element2);
		document.body.appendChild(form);
		form.submit();
		$('#downloadSheet').hide();
	}
	
//On click of .popup2 class call edit page	//handle pop up 2
	_handlepopup2 = function(e) {
		var studentId = $(this).attr("data-student-id");
		var form = document.createElement("form");
		form.method = "GET";
		form.action = '/studentslist/form/'+studentId;
		form.id = "editstudentbypopup";
		var element1 = document.createElement("input");
		var element2 = document.createElement("input");
		element1.name = "studentId";
		element1.value = studentId;
		form.appendChild(element1);
		element2.name = "type";
		element2.value = "excelSheet";
		form.appendChild(element2);
		document.body.appendChild(form);
		form.submit();
		$('#downloadSheet').hide();
	}
	
	_handlepopup = function(e) {
		var studentId = $(this).attr("data-studentedit-id");
		
	}

});






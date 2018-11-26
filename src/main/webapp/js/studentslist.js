$(document).ready(function() {

/*	$('.meetballs').on('click',function(){
		var currentrow = $(this).closest('tr');
		currentrow.find('td:eq(5)').on('click', function(e){
			$(".popup").show(); 
		});
		$('.popup').on('click', _handleDownloadgrp);
	});
	*/
	
	
	
	var table = document.getElementById("studentslist"), rIndex, cIndex;
	// var tablelength = document.getElementById("familyListTable").rows.length;
	// loadListPage

	for (var i = 1; i < table.rows.length; i++) {
		table.rows[i].cells[5].onclick = function(e) {
			var popup = document.getElementById("myPopup");
			popup.classList.toggle("show");
			rIndex = this.parentElement.rowIndex;
			cIndex = this.cellIndex;
			alert(rIndex, cIndex);
		};
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	$(document).on("click",function (event) {
		   if(!$(event.target).is('.popup') && !$(event.target).is('.meetballs')) {
		     $("#myPopup").addClass('hide');
		   }
	});
	
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
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
	}

	_handleDownloadgrp = function(e) {
		var studentId = $(this).attr("data-student-id");
		var form = document.createElement("form");
		form.method = "GET";
		form.action = '/studentslist/form/'+studentId;
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
	}

});






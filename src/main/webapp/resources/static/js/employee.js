/**
 * 
 */
(function($) {
	var report = $('.report');
	var modal = $('#modal');
	/*form.on('submit',function(event){
		form.find('#empid').val($('table tbody td:nth-child(3)').text().trim());
	});
	modal
	.on('shown.bs.modal', function(event){
		console.log($(this));
	})
	.on('click','.yes', function(event){
		event.preventDefault();
	})
	.on('click','.no', function(event){
		console.log($(this));
		event.preventDefault();
	});*/
	report
	.on('click','#add', function(event){
		var target=$(this);
		console.log(target);
		var path = report.find('.table tbody');
		var newRow = $(
				'<tr>'+
				'<td><button id="remove" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Remove</button></td>'+
				'<td><button id="insert" class="btn btn-sm btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Insert</button></td>'+
				'<td><input type="number" name="empID" id="empId"></td>'+
				'<td><input type="text" name="fname"></td>'+
				'<td><input type="text" name="lname"></td>'+
				'<td><input type="number" name="age"></td>'+
				'<td><input type="text" name="address"></td>'+
				'</tr>'
			);
			newRow
				.appendTo(path);
	})

	.on('click','.table tbody #remove',function(event){
		event.preventDefault();
		console.log($(this));
		var id = parseInt($(this).parents('tbody').find('td:nth-child(3)').data('id'));
		$.ajax({
			url: "/spring/deleteEmployee",
			type: 'POST',
			async: true,
			data:{id:id},
			dataType: "text",
		}).done(function(result){
			report.find('.hidden').removeClass('hidden');
			report.find('table tbody tr').addClass('hidden');
	    }).fail(function(){
			alert("Failed to remove.");
		});
	})
	.on('click','.table tbody #insert',function(event){
		event.preventDefault();
		console.log($(this));
		var path = $(this).parents('tbody');
		var id = parseInt(path.find('#empId').val());
		console.log(id);
	
		$.ajax({
			url: "/spring/addEmployee",
			type: 'POST',
			async: true,
			data:{
				id:parseInt(path.find('#empId').val()),
				fname:path.find('td:nth-child(4) input').val(),
				lname:path.find('td:nth-child(5) input').val(),
				age:path.find('td:nth-child(6) input').val(),
				address:path.find('td:nth-child(7) input').val(),
				},
			dataType: "text",
		}).done(function(result){
			console.log(result);
			console.log("success");
			window.open().document.write(result);
	    }).fail(function(){
			alert("Failed to add.");
		});
	})
	
})(jQuery);
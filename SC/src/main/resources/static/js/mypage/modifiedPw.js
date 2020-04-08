const modifiedPw = function() {
	let memberId = $('#memberId').text();
	let oldPw = $('#oldPw').val();
	let newPw = $('#newPw').val();

	const data = {
		memberId : Number(memberId),
		password : oldPw,
		newPassword : newPw
	}

	$.ajax({
		method : 'POST',
		url : '/modifiedPw',
		contentType : 'application/json; charset=utf-8',
		data : JSON.stringify(data)
	}).done(function(xhr, status, data) {
		res = JSON.parse(data.responseText);
		alert(res.msg);
		if (res.code == 1) {
			location.reload();
		}
	});
}
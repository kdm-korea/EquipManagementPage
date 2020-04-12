const postSave = function(){
	let memberId = $('#memberId').text();
	let title = document.getElementById('title').value;
	let contents = document.getElementById('contents').value;
	
	const data = {
		memberId : Number(memberId),
		title : title,
		contents : contents
	}
	
	$.ajax({
		method : 'POST',
		url : '/member/board/post',
		dataType : 'JSON',
		contentType : 'application/json; charset=utf-8',
		data : JSON.stringify(data)
	})
	.done(function(xhr, status, data) {
		if(xhr !== null){
			window.location.href = 'http://localhost:8080/member/board';
		}
	});
}
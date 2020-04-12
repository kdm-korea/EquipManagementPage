const update = function() {
	let boardId = $('#boardId').text();
	let memberId = $('#memberId').text();
	let title = $('#title').val();
	let contents = $('#contents').val();

	const data = {
		boardId : boardId,
		memberId : memberId,
		title : title,
		contents : contents
	}

	$.ajax({
		method : 'PUT',
		url : '/member/board/post/' + boardId,
		dataType : 'JSON',
		contentType : 'application/json; charset=utf-8',
		data : JSON.stringify(data),

		success : function(data, status) {
			alert("완료되었습니다.");
			window.location.href = 'http://localhost:8080/member/board/post/' + data;
		}
	});
}
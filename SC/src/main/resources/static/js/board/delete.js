const del = function(){
	let postId = $('#postId').text();
	
	if(confirm('정말 삭제하시겠습니까?')){
		$.ajax({
			method : 'DELETE',
			url : '/member/board/post/' + postId,
			dataType : 'JSON',
			contentType : 'application/json; charset=utf-8',
			
			success : function(){
				alert('완료되었습니다.');
				window.location.href = 'http://localhost:8080/member/board'
			}
		});
	}else{
		alert('취소되었습니다.');
	}
}
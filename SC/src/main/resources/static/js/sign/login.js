
const login = function(){
	let loginStudentNum = $('#loginStudentNum').val();
	let loginPassword = $('#loginPassword').val();
	
	const data = {
			loginStudentNum : loginStudentNum,
			loginPassword : loginPassword
	}
	
	$.ajax({
		type : 'POST',
		url : '/login',
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		data : JSON.stringify(data),
		
		success : function(data, textStatus){
			if(data.redirect){
				window.location.herf = data.redirect;
			}
			alert(data);
			alert(textStatus);
		}
	})
	.done(function(xhr, status, data){
		console.log(xhr);
		console.log(status);
		console.log(data);
	});
}
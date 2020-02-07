// var token = $("meta[name='_csrf']").attr("content");
// var header = $("meta[name='_csrf_header']").attr("content");
//			
// $.ajax (function() {
// $(document).ajaxSend(function(e, xhr, options) {
// xhr.setRequestHeader(header, token);
// }//,
// success : function(data, status, xhr){
// alert(status);
// },
// error : function(data, status, xhr){
// alert(status);
// },
// complete : function(data, status, xhr){
// alert(status);
// });
// });
var signUp = {
	init : function() {
		var _this = this;

		$('#btn-signup').on('click', function() {
			_this.chkStudentNum();
		});
	},

	chkStudentNum : function() {
		var jsonData = {
			studentNum : $('#studentNum').val()
		};

		$.ajax({
			type : 'POST',
			url : '/idChk',
			dataType : 'json',
			contentType : 'application/json; charset-utf-8',
			data : JSON.stringify(jsonData)
		}).done(function(data, status, jqXHR) {
			
			if(data.message == "Success"){
				signUp.save();
			} else {
				alert('이미 가입한 이력이 있는 학번입니다.');
			}
		}).fail(function() {
			alert('학번을 입력해주세요.');
		});
	},

	
	save : function() {
		var jsonData = {
			name : $('#name').val(),
			studentNum : $('#studentNum').val(),
			phoneNumber : $('#phoneNum').val(),
			password : $('#password').val()
		};

		$.ajax({
			type : 'POST',
			url : '/signup',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(jsonData)
		}).done(function(data, status, jqXHR){
			console.log(data);
			alert('가입이 완료되었습니다.');
			location.reload();
		}).fail(function(error) {
			console.log(JSON.stringify(data));
			alert('정보 확인 바람');
		});
	}
};

signUp.init();
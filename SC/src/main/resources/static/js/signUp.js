//$(function() {
//	var token = $("meta[name='_csrf']").attr("content");
//	var header = $("meta[name='_csrf_header']").attr("content");
//	$(document).ajaxSend(function(e, xhr, options) {
//		if (token && header) {
//			xhr.setRequestHeader(header, token);
//		}
//	});
//});

const signUp = {
	init : function() {
		const _this = this;

		$('#btn-signup').on('click', function() {
			_this.chkStudentNum();
		});
	},

	chkStudentNum : function() {
		const jsonData = {
			studentNum : $('#studentNum').val()
		};

		$.ajax({
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json; charset-utf-8',
			url : '/idChk',
			data : JSON.stringify(jsonData)
		}).done(function(data, status, jqXHR) {

			if (data.message == "Success") {
				signUp.chkSignUpInfo();
			} else {
				alert('이미 가입한 이력이 있는 학번입니다.');
			}
		}).fail(function() {
			alert('학번을 입력해주세요.');
		});
	},

	chkSignUpInfo : function(){
		const data = {
				name : $('#name').val(),
				studentNum : $('#studentNum').val(),
				phoneNumber : $('#phoneNum').val(),
				password : $('#password').val()				
		};
		
		if(data.name === '' || data.studentNum === '' || data.phoneNumber === '' || data.password === ''){
			alert('정보를 입력해 주세요.');
		}
		else{
			signUp.save();
		}
		
	},
	
	save : function() {
		const jsonData = {
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
		}).done(function(data, status, jqXHR) {
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
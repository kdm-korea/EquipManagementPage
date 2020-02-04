var signUp = {
		init : function() {
			var _this = this;
//			var token = $("meta[name='_csrf']").attr("content");
//			var header = $("meta[name='_csrf_header']").attr("content");
//			
//			$.ajax (function() {
//			    $(document).ajaxSend(function(e, xhr, options) {
//			        xhr.setRequestHeader(header, token);
//					alert('뭐하냐 js.');
//			    }//,
//			    success : function(data, status, xhr){
//					alert(status);
//				},
//				error : function(data, status, xhr){
//					alert(status);
//				},
//				complete : function(data, status, xhr){
//					alert(status);
//				});
//		    });
						
			$('#btn-signup').on('click', function () {
				_this.save();
			});
		},
		save : function() {
			var data = {
					name: $('#name').val(),
					studentNum: $('#studentNum').val(),
					phoneNumber: $('#phoneNum').val(),
					password: $('#password').val()
			};
			$.ajax({
				type: 'POST',
				url: '/signup',
				dataType: 'json',
				contentType:'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(){
				alert('가입이 완료되었습니다.');
				location.reload();
			}).fail(function (error){
				alert('정보 확인 바람');
			});
		}
};

signUp.init();
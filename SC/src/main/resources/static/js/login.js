var login = {
		init : function() {
			var _this = this;
//			var token = $("meta[name='_csrf']").attr("content");
//			var header = $("meta[name='_csrf_header']").attr("content");
//			
//			$.ajax (function() {
//			    $(document).ajaxSend(function(e, xhr, options) {
//			        xhr.setRequestHeader(header, token);
//			    });
//			});
			
			$('#btn-login').on('click', function() {
				_this.save();
			});
		},
		save : function() {
			var data = {
					studentNum: $('#loginStudentNum').val()
			};
			$.ajax({
				type: 'POST',
				url: '/login',
				dataType: 'json',
				contentType:'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(){
				alert('로그인 되었습니다.');
				//location.reload();
			}).fail(function (error){
				alert('학번과 비밀번호를 확인해 주세요.');
			});
		}
};

login.init();
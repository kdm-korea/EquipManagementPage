var signUp = {
		init : function() {
			var _this = this;
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
				alert('글이 등록되었습니다.');
				location.reload();
			}).fail(function (error){
				alert('error');
			});
		}
};

signUp.init();
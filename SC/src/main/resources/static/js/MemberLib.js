chkStudentNum : function(element, method) {
		var jsonData = {
			studentNum : $(element).val()
		};

		$.ajax({
			type : 'POST',
			url : '/idChk',
			dataType : 'json',
			contentType : 'application/json; charset-utf-8',
			data : JSON.stringify(jsonData)
		}).done(function(data, status, jqXHR) {
			
			if(data.message == "Success")
//				signUp.save();
				method();
			} else {
				alert('이미 가입한 이력이 있는 학번입니다.');
			}
		}).fail(function() {
			alert('학번을 입력해주세요.');
		});
	}
$('#rentalpclist tbody > tr').click(function() {
	let td = $(this).children();
	let pcNum = td.eq(0).text();
	let memberId = $('#memberId').text();

	returnPc(memberId, pcNum);
});

const returnPc = function(memberId, pcNum) {
	let now = new Date().dateTimeFormatter();
	
	if (confirm('컴퓨터 대여를 종료하시겠습니까?')){
		const data = {
			memberId : Number(memberId),
			pcId : Number(pcNum),
			realReturnTime : now
		}
		console.log(JSON.stringify(data));
		
		$.ajax({
			method : 'POST',
			url : '/member/computer/return',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data)
		})
		.done(function(xhr, status, data){
			res = JSON.parse(data.responseText);
			alert(res.msg);
			if(status === "success"){
				location.reload();
			}
		});
	}
	else{
		alert("취소되었습니다.");
	}
}

Date.prototype.dateTimeFormatter = function() {
    let year = this.getFullYear().toString();
    let month = (this.getMonth() + 1).toString();
    let day = this.getDate().toString();
    let hours = this.getHours().toString();
	let minutes = this.getMinutes().toString();
	let seconds = this.getSeconds().toString();
	
    return  year 
    	+ "-" + (month[1] ? month : "0" + month[0]) 
		+ "-" + (day[1] ? day : "0" + day[0])
		+ "T" + (hours[1] ? hours : "0" + hours[0])
		+ ":" + (minutes[1] ? minutes : "0" + minutes[0])
		+ ":" + (seconds[1] ? seconds : "0" + seconds[0]);
}
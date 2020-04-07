$('#equipList tbody > tr').click(function() {
	let td = $(this).children();
	let equipNum = td.eq(0).text();
	let equipName = td.eq(1).text();
	let memberId = $('#memberId').text();

	rentequip(memberId, equipNum, equipName);
});

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

const rentequip = function(memberId, equipNum, equipName) {
	let now = new Date().dateTimeFormatter();
	
	if (confirm(equipNum + '번의 ' + equipName + '를(을) 정말 빌리시겠습니까?')) {
		const data = {
			memberId : Number(memberId),
			equipId : Number(equipNum),
			reason : "테스트 랜트",
			rentalTime : now,
			predictReturnTime : "2019-01-01T10:12:12"
		}
		$.ajax({
			method : 'POST',
			url : 'equip/rent',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data)
		}).done(function(xhr, status, data) {
			res = JSON.parse(data.responseText);
			alert(res.msg);
			if (status === "success") {
				location.reload();
			}
		});
	} else {
		alert("취소되었습니다.");
	}
}
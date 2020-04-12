$('#rentalequiplist tbody > tr').click(function() {
	let td = $(this).children();

	let equipNum = td.eq(0).text();
	let equipName = td.eq(1).text();
	let memberId = $('#memberId').text();

	returnEuqip(memberId, equipNum, equipName);
});

const returnEuqip = function(memberId, equipNum, equipName) {
	if (confirm(equipNum + '번의 ' + equipName + '를(을) 반납하시겠습니까?')){
		const data = {
			memberId : Number(memberId),
			equipId : Number(equipNum)
		}
		console.log(JSON.stringify(data));
		
		$.ajax({
			method : 'POST',
			url : 'equip/return',
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
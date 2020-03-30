$('#equipList tbody > tr').click(function() {
	let td = $(this).children();

	let equipnum = td.eq(0).text();
	let equipName = td.eq(1).text();

	rentequip(equipnum);
});

const rentequip = function(equipnum, equipName){
	if (confirm(equipnum + '번의 ' + equipName + '를(을) 정말 빌리시겠습니까?')) {
		const data = {
			memberId : 1,
			equipId : Number(equipnum),
			reason : "테스트 랜트",
			rentalTime : "2019-01-01T10:12:12",
			predictReturnTime : "2019-01-01T10:12:12"
		}
		
		console.log(JSON.stringify(data));
		
		$.ajax({
			method : 'POST',
			url : 'equip/rent',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data)
		});
		//error, wrong, success
		alert("완료되었습니다");
		location.reload();
	} else {
		alert("취소되었습니다.");
	}
} 
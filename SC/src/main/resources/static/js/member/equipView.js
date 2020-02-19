
$('#equipPossibleList tr').click(function() {

	let str = "";
	let tdArr = new Array();

	let tr = $(this)
	let td = tr.children();

	alert("tr"+tr.text());

	td.each(function(i) {
		tdArr.push(td.eq(i).text());
	});

	alert("tdArr"+tdArr.text());
});

$('#postlist tbody > tr').click(function() {

	let td = $(this).children();

	let postId = td.eq(0).text();
	view(postId);
});

const view = function(postId) {
	window.location.href = window.location.href + '/post/' + postId
}
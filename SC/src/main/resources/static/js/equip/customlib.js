/**
 * 
 */
const send = function(method, url, data) {
	$.ajax({
		method : method,
		url : url,
		contentType : 'application/json; charset=utf-8',
		body : JSON.stringofy(data);
	});
}

const send = function(method, url) {
	$.ajax({
		method : method,
		url : url,
		contentType : 'application/json; charset=utf-8',
	});
}
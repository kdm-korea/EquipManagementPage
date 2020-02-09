const nameCheck = RegExp(/^[가-힣]{2,4}/);

const studentNumCheck = RegExp(/[0-9]{10}$/);

const phoneNumCheck = RegExp(/[0-9]{10,11}$/);

function passwordDoubleCheck(pw1, pw2) {
	if (pw1 === pw2) {
		true;
	} else {
		false;
	}
}

function isEmpty(obj) {
	return (obj === '') ? true : false;
}

function ruleCheck(element, rule, msgStr, msgElement) {
	if (rule.test(element.value)) {
		msgElement.innerHTML = '';
		return true;
	} else {
		msgElement.innerHTML = msgStr + '을(를) 확인해주세요.';
		element.value = '';
		element.focus();
		return false;
	}
}

function chkSignUserName() {
	ruleCheck(document.getElementById('name'), nameCheck, '이름', document
			.getElementById('signInNameChk'));
}

function chkSignStudentNum() {
	ruleCheck(document.getElementById('studentNum'), studentNumCheck, '학번',
			document.getElementById('signInStudentNumChk'));
}

function chkSignPhoneNum() {
	ruleCheck(document.getElementById('phoneNum'), studentNumCheck, '전화번호',
			document.getElementById('signInPhoneNumChk'));
}

function chkNullSignPw() {
	var pw = document.getElementById('password');
	var descriptMsg = document.getElementById('signInPasswordChk');

	if (!isEmpty(pw.value)) {
		descriptMsg.innerHTML = '';
	} else {
		descriptMsg.innerHTML = "* 비밀번호를 입력해주세요.";
		pw.focus();
	}
}

function chkComparePw() {
	var pw = document.getElementById('password');
	var pwChk = document.getElementById('passwordChk');
	var descriptMsg = document.getElementById('signInPasswordCompareChk');

	if (pw.value === pwChk.value) {
		descriptMsg.innerHTML = '';
	} else {
		descriptMsg.innerHTML = "* 비밀번호가 서로 다릅니다.";
	}
}
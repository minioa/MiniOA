function hideObject(elementId) {
	if (document.getElementById(elementId))
		document.getElementById(elementId).style.display = 'none';
}
function showObject(elementId) {
	if (document.getElementById(elementId))
		document.getElementById(elementId).style.display = 'block';
}
function selectAll() {
	for ( var i = 0; i < document.forms.length; i++) {
		for ( var j = 0; j < document.forms[i].elements.length; j++) {
			var e = document.forms[i].elements[j];
			if (e.type == 'checkbox')
				e.checked = true;
		}
	}
}
function selectNone() {
	for ( var i = 0; i < document.forms.length; i++) {
		for ( var j = 0; j < document.forms[i].elements.length; j++) {
			var e = document.forms[i].elements[j];
			if (e.type == 'checkbox')
				e.checked = false;
		}
	}
}
function setFocus(num,tc){
	for(a=1; a<=tc; a++){
		document.getElementById('pic' + a).className = 'normal';
	}
	document.getElementById('pic' + num).className = 'normal on';
}

function reload(elementId){
	if(navigator.appName.indexOf("Microsoft")>-1){
		if(document.getElementById(elementId))
			document.getElementById(elementId).fireEvent('onclick');
	}else{
		var evt = document.createEvent('HTMLEvents');
		evt.initEvent('click', false, false);
		if(document.getElementById(elementId))
			document.getElementById(elementId).dispatchEvent(evt);
	}
}
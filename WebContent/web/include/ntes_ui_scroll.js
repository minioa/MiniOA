(function(window, undefined){
	
	var $ = window.NTES || {};
	if (!$.ui) {
		$.ui = {};
	}
	
	var scrollMode = {
		forward : function(lpf) {
			var t = this, pos = t._bPos - lpf;
			pos = (pos > 0 ? pos : 0);
			t._setPos(pos);
			(pos == 0 && t.stop());
		},
		backward : function(lpf) {
			var t = this, pos = t._bPos + lpf;
			pos = (pos < t._bRange ? pos : t._bRange);
			t._setPos(pos);
			(pos == t._bRange && t.stop());
		}
	};
	
	$.ui.Scroll = function(body, axis, handle) {
		if (!arguments.length) {
			return;
		}
		
		var t = this;
		t.constructor = arguments.callee;
		
		t._axis = axis == 'y' ? 'y' : 'x';
		t._fix = t._axis == 'x' ? {
			pos: 'left',
			offsetSize: 'offsetWidth',
			pageAxis: 'pageX',
			offsetPos: 'offsetLeft',
			scrollPos: 'scrollLeft'
		} :	{
			pos: 'top',
			offsetSize: 'offsetHeight',
			pageAxis: 'pageY',
			offsetPos: 'offsetTop',
			scrollPos: 'scrollTop'
		};
		
		t.fps = 13;
		t.lpf = 10;
		t.speed = 40;
		if ($.browser.msie) {
			t.speed = 20;
		}
		t._body = body;
		t._bCnt = body.parentNode;
		t._bPos = 0;
		t._bRange = Math.max(0, t._body[t._fix.offsetSize] - t._bCnt[t._fix.offsetSize]);
			
		if(handle !== undefined){
			t._handle = handle;
			t._hCnt = handle.parentNode;
			t._hPos = 0;
			t._hRange = Math.max(0, t._hCnt[t._fix.offsetSize] - t._handle[t._fix.offsetSize]);
			
			t.bhRate = t._hRange ? t._bRange / t._hRange : 0;
			
			var mouse = new $.ui.Mouse(t._handle);
			mouse.mouseStart = t._mouseStart.bind(t);
			mouse.mouseDrag = t._mouseDrag.bind(t);
			mouse.mouseStop = t._mouseStop.bind(t);
			$(t._hCnt).addEvent('click', t._mouseClick.bind(t));
		}
	};
	
	$.ui.Scroll.prototype = {
		start: function(toward, length) {
			var t = this;
			if(t._timer == undefined){
				toward = toward == 'forward' ? 'forward' : 'backward';
				t._move = scrollMode[toward];
				var params = {
					length : isNaN(length) ? -1 : parseInt(length)
				};
				t._timer = setInterval(t._scroll.bind(t, params), t.fps);
				t.onStart && t.onStart();
			}
		},
		stop: function() {
			var t = this;
			if (t._timer !== undefined) {
				clearTimeout(t._timer);
				t._timer = undefined;
				t.onStop && t.onStop();
			}
			return this;
		},
		scrollTo: function(length){
			var t = this, distance = length - t._bPos;
			distance < 0 ? t.stop().start('forward', -1 * distance) : t.stop().start('backward', distance);
		},
		_scroll: function(params) {
			var t = this, lpf = t.lpf;
			if (params.length !== 0) {
				if (params.length > 0) {
					lpf = Math.min(t.lpf * Math.ceil(params.length / t.speed), params.length);
					params.length -= lpf;
				}
				t._move(lpf);
			} else {
				t.stop();
			}
		},
		_setPos: function(pos){
			var t = this;
			t._bPos = pos;
			t._bCnt[t._fix.scrollPos] = t._bPos;
			if(t._handle){
				t._hPos = t.bhRate ? pos / t.bhRate : 0;
				t._handle.addCss(t._fix.pos + ':' + t._hPos + 'px');
			}
		},
		_mouseStart: function(event){
			var t = this;
			t._diffPos = event[t._fix.pageAxis] - t._handle[t._fix.offsetPos];
			return true;
		},
		_mouseDrag: function(event){
			var t = this, pos = Math.max(0, Math.min(event[t._fix.pageAxis] - t._diffPos, t._hRange));
			t._setPos(pos * t.bhRate);
			return false;
		},
		_mouseStop: function(event){
			return false;
		},
		_mouseClick: function(event){
			var t = this, cnt = t._hCnt, cPos = cnt[t._fix.offsetPos];
        	while(cnt.offsetParent){
            	cnt = cnt.offsetParent;
            	cPos += cnt[t._fix.offsetPos];
            }
			t.scrollTo((event[t._fix.pageAxis] - t._handle[t._fix.offsetSize] / 2 - cPos) * t.bhRate);
		}
	};
	
	$.ui.Mouse = function(element) {
		var t = this;
		element = $(element);
		element.addEvent('mousedown', t._mouseDown.bind(t)).addEvent('click', function(event) {
			if(t._preventClickEvent) {
				t._preventClickEvent = false;
				event.cancelBubble = true;
				return false;
			}
		});
		
		if ($.browser.msie) {
			this._mouseUnselectable = element.attr('unselectable');
			element.attr('unselectable', 'on');
		}
		this.started = false;
	};
	$.ui.Mouse.prototype = {
		_mouseDown: function(event) {
			var t = this;
			t._mouseStarted && t._mouseUp(event);
			t._mouseDownEvent = event;
			var btnIsLeft = (event.which == 1);
			if (!btnIsLeft || !this.mouseCapture(event)) {
				return true;
			}
			if (t._mouseDistanceMet(event)) {
				t._mouseStarted = (t.mouseStart(event) !== false);
				if (!t._mouseStarted) {
					event.preventDefault();
					return true;
				}
			}
			t._mouseMoveDelegate = t._mouseMove.bind(t);
			t._mouseUpDelegate = t._mouseUp.bind(t);
			$(document).addEvent('mousemove', t._mouseMoveDelegate).addEvent('mouseup', t._mouseUpDelegate);
			event.preventDefault();
			return true;
		},
		_mouseMove: function(event) {
			var t = this;
			if ($.browser.msie && !event.button) {
				return t._mouseUp(event);
			}
			if (t._mouseStarted) {
				t.mouseDrag(event);
				return event.preventDefault();
			}
			if (t._mouseDistanceMet(event)) {
				t._mouseStarted = t.mouseStart(t._mouseDownEvent, event) !== false;
				t._mouseStarted ? t.mouseDrag(event) : t._mouseUp(event);
			}
			return !t._mouseStarted;
		},
		_mouseUp: function(event) {
			var t = this;
			$(document).removeEvent('mousemove', t._mouseMoveDelegate).removeEvent('mouseup', t._mouseUpDelegate);
			if (t._mouseStarted) {
				t._mouseStarted = false;
				t._preventClickEvent = (event.target == t._mouseDownEvent.target);
				t.mouseStop(event);
			}
			return false;
		},
		_mouseDistanceMet: function(event) {
			var t = this;
			return Math.max(Math.abs(t._mouseDownEvent.pageX - event.pageX), Math.abs(t._mouseDownEvent.pageY - event.pageY)) >= 1;
		},
		mouseStart: function(event) {},
		mouseDrag: function(event) {},
		mouseStop: function(event) {},
		mouseCapture: function(event) { return true; }
	};
})(window);
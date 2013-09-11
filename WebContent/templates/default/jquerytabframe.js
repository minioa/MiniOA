function addTab(frametext){
                var tabCounter = window.parent.wincount;
                $j('#container-1 ul').tabsAdd('#tab'+tabCounter,frametext);
								var frameset =window.parent.document.getElementById("frameset02");
								showTab(frameset, frameset.children.length-2);
            }
            
            function showTab(frameset, tabIndex){
                /*设定当前选中的frame*/
                for(var i=0; i < frameset.children.length; i++){
                	$j('#container-1 ul li').eq(i).removeAttr('class');
                }
                $j('#container-1 ul li').eq(tabIndex).attr('class','ui-tabs-selected');
            }
            
            function closeEventHandler(){
                var li = $j(this).parent();
                var tabIndex = $j('a',li).attr('href').substring(4);
                var index = $j('#container-1 li').index(li.get(0));
                var pnlId = $j('a',li).attr('href');
                
                pnlId = pnlId.substring(pnlId.lastIndexOf('#'),pnlId.length);
                pnlId = $j(pnlId);
                if(li.get(0).interval){
                    window.clearInterval(li.get(0).interval);
                }
                $j('#container-1 ul').tabsRemove(index+1);
                /*remove frame*/
                if(window.parent.hidemenu==0)
									window.parent.framesetcols = "200";
								else
									window.parent.framesetcols = "0";

                var frameset =window.parent.document.getElementById("frameset02");
                var j = 0;
                for(var i=1; i < frameset.children.length; i++){
                	var frame = frameset.children[i];
                	if(frame.name=='tab'+tabIndex){
                		frameset.removeChild(frame);
                		j=i;
                	}
                }
                for(var i=1; i < frameset.children.length; i++){
                	if(i == j-1)
                		window.parent.framesetcols = window.parent.framesetcols + ",*";
                	else
                		window.parent.framesetcols = window.parent.framesetcols + ",0";
                }
								showTab(frameset, j -2);
								window.parent.tabIndex = j -2;
                window.parent.document.all.frameset02.cols = window.parent.framesetcols;
                pnlId.remove();
            }


            function addEventHandler(lnk,pnl){
                var li = $j(lnk).parent();
                var closeButton = $j('img',li);
                var isHighlight = li.attr('class');
                closeButton.attr('src',isHighlight ? 'close_highlight.png':'close.png');
                $j('<img src="close.gif" class="ui-tabs-button" />')
                    .appendTo(li)
                    .hover(function(){
                            var img = $j(this);
                            img.attr('src','close_hover2.png');
                        },
                        function(){
                            var img = $j(this);
                            img.attr('src','close.png');
                        }
                    )
                    .click(closeEventHandler);
            }
        
            function clickEventHandler(lnk,pnl,prePnl){
                var li = $j(lnk).parent().get(0);
                var tabIndex = $j('a',li).attr('href').substring(4);
                window.parent.tabIndex = tabIndex;
                if(window.parent.hidemenu==0)
									window.parent.framesetcols = "200";
								else
									window.parent.framesetcols = "0";
                var frameset =window.parent.document.getElementById("frameset02");
                for(var i=1; i < frameset.children.length; i++){
                	var frame = frameset.children[i];
                	frame.name=='tab'+tabIndex ? window.parent.framesetcols = window.parent.framesetcols + ",*" : window.parent.framesetcols = window.parent.framesetcols + ",0";
                }
                window.parent.document.all.frameset02.cols = window.parent.framesetcols;
            }
            
            $j(function() {
                $j('#container-1 ul').tabs({add:addEventHandler,click:clickEventHandler});                
            });
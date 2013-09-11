/*
 * Tabs 3 - New Wave Tabs
 *
 * Copyright (c) 2007 Klaus Hartl (stilbuero.de)
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 */
var $j = jQuery.noConflict();
(function($j) {

    // if the UI scope is not availalable, add it
    $j.ui = $j.ui || {};

    // tabs initialization
    $j.fn.tabs = function(initial, options) {
        if (initial && initial.constructor == Object) { // shift arguments
            options = initial;
            initial = null;
        }
        options = options || {};

        initial = initial && initial.constructor == Number && --initial || 0;

        return this.each(function() {
            new $j.ui.tabs(this, $j.extend(options, { initial: initial }));
        });
    };

    // other chainable tabs methods
    $j.each(['Add', 'Remove', 'Enable', 'Disable', 'Click', 'Load', 'Href'], function(i, method) {
        $j.fn['tabs' + method] = function() {
            var args = arguments;
            return this.each(function() {
                var instance = $j.ui.tabs.getInstance(this);
                instance[method.toLowerCase()].apply(instance, args);
            });
        };
    });
    $j.fn.tabsSelected = function() {
        var selected = -1;
        if (this[0]) {
            var instance = $j.ui.tabs.getInstance(this[0]),
                $jlis = $j('li', this);
            selected = $jlis.index( $jlis.filter('.' + instance.options.selectedClass)[0] );
        }
        return selected >= 0 ? ++selected : -1;
    };

    // tabs class
    $j.ui.tabs = function(el, options) {

        this.source = el;

        this.options = $j.extend({

            // basic setup
            initial: 0,
            event: 'click',
            disabled: [],
            cookie: null, // pass options object as expected by cookie plugin: { expires: 7, path: '/', domain: 'jquery.com', secure: true }
            // TODO bookmarkable: $j.ajaxHistory ? true : false,
            unselected: false,
            unselect: options.unselected ? true : false,

            // Ajax
            spinner: 'Loading&#8230;',
            cache: false,
            idPrefix: 'ui-tabs-',
            ajaxOptions: {},

            // animations
            /*fxFade: null,
            fxSlide: null,
            fxShow: null,
            fxHide: null,*/
            fxSpeed: 'normal',
            /*fxShowSpeed: null,
            fxHideSpeed: null,*/

            // callbacks
            add: function() {},
            remove: function() {},
            enable: function() {},
            disable: function() {},
            click: function() {},
            hide: function() {},
            show: function() {},
            load: function() {},
            
            // templates
            tabTemplate: '<li><a href="#{href}"><span>#{text}</span></a></li>',
            panelTemplate: '<div></div>',

            // CSS classes
            navClass: 'ui-tabs-nav',
            selectedClass: 'ui-tabs-selected',
            unselectClass: 'ui-tabs-unselect',
            disabledClass: 'ui-tabs-disabled',
            panelClass: 'ui-tabs-panel',
            hideClass: 'ui-tabs-hide',
            loadingClass: 'ui-tabs-loading'

        }, options);

        this.options.event += '.ui-tabs'; // namespace event
        this.options.cookie = $j.cookie && $j.cookie.constructor == Function && this.options.cookie;

        // save instance for later
        $j.data(el, $j.ui.tabs.INSTANCE_KEY, this);
        
        // create tabs
        this.tabify(true);
    };

    // static
    $j.ui.tabs.INSTANCE_KEY = 'ui_tabs_instance';
    $j.ui.tabs.getInstance = function(el) {
        return $j.data(el, $j.ui.tabs.INSTANCE_KEY);
    };

    // instance methods
    $j.extend($j.ui.tabs.prototype, {
        tabId: function(a) {
            return a.title ? a.title.replace(/\s/g, '_')
                : this.options.idPrefix + $j.data(a);
        },
        tabify: function(init) {

            this.$jlis = $j('li:has(a[href])', this.source);
            this.$jtabs = this.$jlis.map(function() { return $j('a', this)[0] });
            this.$jpanels = $j([]);
            
            var self = this, o = this.options;
            
            this.$jtabs.each(function(i, a) {
                // inline tab
                if (a.hash && a.hash.replace('#', '')) { // Safari 2 reports '#' for an empty hash
                    self.$jpanels = self.$jpanels.add(a.hash);
                }
                // remote tab
                else if ($j(a).attr('href') != '#') { // prevent loading the page itself if href is just "#"
                    $j.data(a, 'href', a.href);
                    var id = self.tabId(a);
                    a.href = '#' + id;
                    self.$jpanels = self.$jpanels.add(
                        $j('#' + id)[0] || $j(o.panelTemplate).attr('id', id).addClass(o.panelClass)
                            .insertAfter( self.$jpanels[i - 1] || self.source )
                    );
                }
                // invalid tab href
                else {
                    o.disabled.push(i + 1);
                }
            });

            if (init) {

                // attach necessary classes for styling if not present
                $j(this.source).hasClass(o.navClass) || $j(this.source).addClass(o.navClass);
                this.$jpanels.each(function() {
                    var $jthis = $j(this);
                    $jthis.hasClass(o.panelClass) || $jthis.addClass(o.panelClass);
                });
                
                // disabled tabs
                for (var i = 0, position; position = o.disabled[i]; i++) {
                    this.disable(position);
                }
                
                // Try to retrieve initial tab:
                // 1. from fragment identifier in url if present
                // 2. from cookie
                // 3. from selected class attribute on <li>
                // 4. otherwise use given initial argument
                // 5. check if tab is disabled
                this.$jtabs.each(function(i, a) {
                    if (location.hash) {
                        if (a.hash == location.hash) {
                            o.initial = i;
                            // prevent page scroll to fragment
                            //if (($j.browser.msie || $j.browser.opera) && !o.remote) {
                            if ($j.browser.msie || $j.browser.opera) {
                                var $jtoShow = $j(location.hash), toShowId = $jtoShow.attr('id');
                                $jtoShow.attr('id', '');
                                setTimeout(function() {
                                    $jtoShow.attr('id', toShowId); // restore id
                                }, 500);
                            }
                            scrollTo(0, 0);
                            return false; // break
                        }
                    } else if (o.cookie) {
                        o.initial = parseInt($j.cookie( $j.ui.tabs.INSTANCE_KEY + $j.data(self.source) )) || 0;
                        return false; // break
                    } else if ( self.$jlis.eq(i).hasClass(o.selectedClass) ) {
                        o.initial = i;
                        return false; // break
                    }
                });
                var n = this.$jlis.length;
                while (this.$jlis.eq(o.initial).hasClass(o.disabledClass) && n) {
                    o.initial = ++o.initial < this.$jlis.length ? o.initial : 0;
                    n--;
                }
                if (!n) { // all tabs disabled, set option unselected to true
                    o.unselected = o.unselect = true;
                }

                // highlight selected tab
                this.$jpanels.addClass(o.hideClass);
                this.$jlis.removeClass(o.selectedClass);
                if (!o.unselected) {
                    this.$jpanels.eq(o.initial).show().removeClass(o.hideClass); // use show and remove class to show in any case no matter how it has been hidden before
                    this.$jlis.eq(o.initial).addClass(o.selectedClass);
                }

                // load if remote tab
                var href = !o.unselected && $j.data(this.$jtabs[o.initial], 'href');
                if (href) {
                    this.load(o.initial + 1, href);
                }
                
                // disable click if event is configured to something else
                if (!/^click/.test(o.event)) {
                    this.$jtabs.bind('click', function(e) { e.preventDefault(); });
                }

            }

            // setup animations
            var showAnim = {}, showSpeed = o.fxShowSpeed || o.fxSpeed,
                hideAnim = {}, hideSpeed = o.fxHideSpeed || o.fxSpeed;
            if (o.fxSlide || o.fxFade) {
                if (o.fxSlide) {
                    showAnim['height'] = 'show';
                    hideAnim['height'] = 'hide';
                }
                if (o.fxFade) {
                    showAnim['opacity'] = 'show';
                    hideAnim['opacity'] = 'hide';
                }
            } else {
                if (o.fxShow) {
                    showAnim = o.fxShow;
                } else { // use some kind of animation to prevent browser scrolling to the tab
                    showAnim['min-width'] = 0; // avoid opacity, causes flicker in Firefox
                    showSpeed = 1; // as little as 1 is sufficient
                }
                if (o.fxHide) {
                    hideAnim = o.fxHide;
                } else { // use some kind of animation to prevent browser scrolling to the tab
                    hideAnim['min-width'] = 0; // avoid opacity, causes flicker in Firefox
                    hideSpeed = 1; // as little as 1 is sufficient
                }
            }

            // reset some styles to maintain print style sheets etc.
            var resetCSS = { display: '', overflow: '', height: '' };
            if (!$j.browser.msie) { // not in IE to prevent ClearType font issue
                resetCSS['opacity'] = '';
            }

            // Hide a tab, animation prevents browser scrolling to fragment,
            // $jshow is optional.
            function hideTab(clicked, $jhide, $jshow) {
                $jhide.animate(hideAnim, hideSpeed, function() { //
                    $jhide.addClass(o.hideClass).css(resetCSS); // maintain flexible height and accessibility in print etc.
                    if ($j.browser.msie && hideAnim['opacity']) {
                        $jhide[0].style.filter = '';
                    }
                    o.hide(clicked, $jhide[0], $jshow && $jshow[0] || null);
                    if ($jshow) {
                        showTab(clicked, $jshow, $jhide);
                    }
                });
            }

            // Show a tab, animation prevents browser scrolling to fragment,
            // $jhide is optional
            function showTab(clicked, $jshow, $jhide) {
                if (!(o.fxSlide || o.fxFade || o.fxShow)) {
                    $jshow.css('display', 'block'); // prevent occasionally occuring flicker in Firefox cause by gap between showing and hiding the tab panels
                }
                $jshow.animate(showAnim, showSpeed, function() {
                    $jshow.removeClass(o.hideClass).css(resetCSS); // maintain flexible height and accessibility in print etc.
                    if ($j.browser.msie && showAnim['opacity']) {
                        $jshow[0].style.filter = '';
                    }
                    o.show(clicked, $jshow[0], $jhide && $jhide[0] || null);
                });
            }

            // switch a tab
            function switchTab(clicked, $jli, $jhide, $jshow) {
                /*if (o.bookmarkable && trueClick) { // add to history only if true click occured, not a triggered click
                    $j.ajaxHistory.update(clicked.hash);
                }*/
                $jli.addClass(o.selectedClass)
                    .siblings().removeClass(o.selectedClass);
                hideTab(clicked, $jhide, $jshow);
            }

            // attach tab event handler, unbind to avoid duplicates from former tabifying...
            this.$jtabs.unbind(o.event).bind(o.event, function() {

                //var trueClick = e.clientX; // add to history only if true click occured, not a triggered click
                var $jli = $j(this).parents('li:eq(0)'),
                    $jhide = self.$jpanels.filter(':visible'),
                    $jshow = $j(this.hash);

                // If tab is already selected and not unselectable or tab disabled or click callback returns false stop here.
                // Check if click handler returns false last so that it is not executed for a disabled tab!
                if (($jli.hasClass(o.selectedClass) && !o.unselect) || $jli.hasClass(o.disabledClass)
                    || o.click(this, $jshow[0], $jhide[0]) === false) {
                    this.blur();
                    return false;
                }
                
                if (o.cookie) {
                    $j.cookie($j.ui.tabs.INSTANCE_KEY + $j.data(self.source), self.$jtabs.index(this), o.cookie);
                }
                    
                // if tab may be closed
                if (o.unselect) {
                    if ($jli.hasClass(o.selectedClass)) {
                        $jli.removeClass(o.selectedClass);
                        self.$jpanels.stop();
                        hideTab(this, $jhide);
                        this.blur();
                        return false;
                    } else if (!$jhide.length) {
                        self.$jpanels.stop();
                        if ($j.data(this, 'href')) { // remote tab
                            var a = this;
                            self.load(self.$jtabs.index(this) + 1, $j.data(this, 'href'), function() {
                                $jli.addClass(o.selectedClass).addClass(o.unselectClass);
                                showTab(a, $jshow);
                            });
                        } else {
                            $jli.addClass(o.selectedClass).addClass(o.unselectClass);
                            showTab(this, $jshow);
                        }
                        this.blur();
                        return false;
                    }
                }

                // stop possibly running animations
                self.$jpanels.stop();

                // show new tab
                if ($jshow.length) {

                    // prevent scrollbar scrolling to 0 and than back in IE7, happens only if bookmarking/history is enabled
                    /*if ($j.browser.msie && o.bookmarkable) {
                        var showId = this.hash.replace('#', '');
                        $jshow.attr('id', '');
                        setTimeout(function() {
                            $jshow.attr('id', showId); // restore id
                        }, 0);
                    }*/

                    if ($j.data(this, 'href')) { // remote tab
                        var a = this;
                        self.load(self.$jtabs.index(this) + 1, $j.data(this, 'href'), function() {
                            switchTab(a, $jli, $jhide, $jshow);
                        });
                    } else {
                        switchTab(this, $jli, $jhide, $jshow);
                    }

                    // Set scrollbar to saved position - need to use timeout with 0 to prevent browser scroll to target of hash
                    /*var scrollX = window.pageXOffset || document.documentElement && document.documentElement.scrollLeft || document.body.scrollLeft || 0;
                    var scrollY = window.pageYOffset || document.documentElement && document.documentElement.scrollTop || document.body.scrollTop || 0;
                    setTimeout(function() {
                        scrollTo(scrollX, scrollY);
                    }, 0);*/

                } else {
                    throw 'jQuery UI Tabs: Mismatching fragment identifier.';
                }

                // Prevent IE from keeping other link focussed when using the back button
                // and remove dotted border from clicked link. This is controlled in modern
                // browsers via CSS, also blur removes focus from address bar in Firefox
                // which can become a usability and annoying problem with tabsRotate.
                if ($j.browser.msie) {
                    this.blur(); 
                }

                //return o.bookmarkable && !!trueClick; // convert trueClick == undefined to Boolean required in IE
                return false;

            });

        },
        add: function(url, text, position) {
            if (url && text) {
                position = position || this.$jtabs.length; // append by default  
                
                var o = this.options,
                    $jli = $j(o.tabTemplate.replace(/#\{href\}/, url).replace(/#\{text\}/, text));
                
                var id = url.indexOf('#') == 0 ? url.replace('#', '') : this.tabId( $j('a:first-child', $jli)[0] );
                
                // try to find an existing element before creating a new one
                var $jpanel = $j('#' + id);
                $jpanel = $jpanel.length && $jpanel
                    || $j(o.panelTemplate).attr('id', id).addClass(o.panelClass).addClass(o.hideClass);
                if (position >= this.$jlis.length) {
                    $jli.appendTo(this.source);
                    $jpanel.appendTo(this.source.parentNode);
                } else {
                    $jli.insertBefore(this.$jlis[position - 1]);
                    $jpanel.insertBefore(this.$jpanels[position - 1]);
                }
                
                this.tabify();
                
                if (this.$jtabs.length == 1) {
                     $jli.addClass(o.selectedClass);
                     $jpanel.removeClass(o.hideClass);
                     var href = $j.data(this.$jtabs[0], 'href');
                     if (href) {
                         this.load(position + 1, href);
                     }
                }
                o.add(this.$jtabs[position], this.$jpanels[position]); // callback
            } else {
                throw 'jQuery UI Tabs: Not enough arguments to add tab.';
            }
        },
        remove: function(position) {
            if (position && position.constructor == Number) {                
                var o = this.options, $jli = this.$jlis.eq(position - 1).remove(),
                    $jpanel = this.$jpanels.eq(position - 1).remove();
                    
                // If selected tab was removed focus tab to the right or
                // tab to the left if last tab was removed.
                if ($jli.hasClass(o.selectedClass) && this.$jtabs.length > 1) {
                    this.click(position + (position < this.$jtabs.length ? 1 : -1));
                }
                this.tabify();
                o.remove($jli.end()[0], $jpanel[0]); // callback
            }
        },
        enable: function(position) {
            var o = this.options, $jli = this.$jlis.eq(position - 1);
            $jli.removeClass(o.disabledClass);
            if ($j.browser.safari) { // fix disappearing tab (that used opacity indicating disabling) after enabling in Safari 2...
                $jli.css('display', 'inline-block');
                setTimeout(function() {
                    $jli.css('display', 'block')
                }, 0)
            }
            o.enable(this.$jtabs[position - 1], this.$jpanels[position - 1]); // callback
        },
        disable: function(position) {
            var o = this.options;      
            this.$jlis.eq(position - 1).addClass(o.disabledClass);
            o.disable(this.$jtabs[position - 1], this.$jpanels[position - 1]); // callback
        },
        click: function(position) {
            this.$jtabs.eq(position - 1).trigger(this.options.event);
        },
        load: function(position, url, callback) {
            var self = this, o = this.options,
                $ja = this.$jtabs.eq(position - 1), a = $ja[0], $jspan = $j('span', a);
            
            // shift arguments
            if (url && url.constructor == Function) {
                callback = url;
                url = null;
            }

            // set new URL or get existing
            if (url) {
                $j.data(a, 'href', url);
            } else {
                url = $j.data(a, 'href');
            }

            // load
            if (o.spinner) {
                $j.data(a, 'title', $jspan.html());
                $jspan.html('<em>' + o.spinner + '</em>');
            }
            var finish = function() {
                self.$jtabs.filter('.' + o.loadingClass).each(function() {
                    $j(this).removeClass(o.loadingClass);
                    if (o.spinner) {
                        $j('span', this).html( $j.data(this, 'title') );
                    }
                });
                self.xhr = null;
            };
            var ajaxOptions = $j.extend(o.ajaxOptions, {
                url: url,
                success: function(r) {
                    $j(a.hash).html(r);
                    finish();
                    // This callback is required because the switch has to take 
                    // place after loading has completed.
                    if (callback && callback.constructor == Function) {
                        callback();
                    }
                    if (o.cache) {
                        $j.removeData(a, 'href'); // if loaded once do not load them again
                    }
                    o.load(self.$jtabs[position - 1], self.$jpanels[position - 1]); // callback
                }
            });
            if (this.xhr) {
                // terminate pending requests from other tabs and restore title
                this.xhr.abort();
                finish();
            }
            $ja.addClass(o.loadingClass);
            setTimeout(function() { // timeout is again required in IE, "wait" for id being restored
                self.xhr = $j.ajax(ajaxOptions);
            }, 0);
            
        },
        href: function(position, href) {
            $j.data(this.$jtabs.eq(position - 1)[0], 'href', href);
        }
    });

})(jQuery);

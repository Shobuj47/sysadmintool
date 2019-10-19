<style>
/* Global
/ -------------------------------------------------- */
html {
  position: relative;
  min-height: 100%;
}
/* Dash Navbar Top = dnt
/ -------------------------------------------------- */
.dash-navbar-top {
  margin-bottom: 0;
  min-height: 61px;
  padding-top: 0;
  padding-bottom: 0;
  border-radius: 0;
  line-height: 1;
}
.dash-navbar-top .nb-btn-toggle {
  position: absolute;
  left: 16px;
  top: 13.5px;
  font-size: 21px;
  background-color: rgba(0, 0, 0, 0);
  border-width: 0;
  color: #d3d1dd;
  outline: 0;
}
@media (min-width: 768px) {
  .dash-navbar-top.nb-visible .nb-btn-toggle {
    display: none;
  }
}

.dash-navbar-top .navbar-toggle {
  border-width: 0;
  font-size: 24px;
  color: #d3d1dd;
  padding: 0 10px;
  margin-top: 14px;
  margin-right: 15px;
}
.dash-navbar-top .navbar-toggle:hover,
.dash-navbar-top .navbar-toggle:focus {
  background-color: transpardnt;
}


/* Dash Navbar Left = nb
/ -------------------------------------------------- */
.dash-navbar-left {
  position: absolute;
  background-color: #2A2D35;
  width: 250px;
  top: 0;
  bottom: 0;
  overflow-y: auto;
  z-index: 999;
  padding-top: 5px;
  -webkit-transition: left 300ms;
  -o-transition: left 300ms;
  transition: left 300ms;
}
.navbar-brand{
  display: block;
  background: orange;
  width: 100%;
  color: #FFF;
  text-transform: uppercase;
  padding: 0 20px;
  margin:-10px 0 30px 0;
  height: 65px;
  line-height: 65px;
}
.navbar-brand:hover{
  color: #FFF;
}
.navbar .form-inline{
  margin-top: 12px;
}
.navbar .btn{
  background: orange;
  color: #FFF;
}
@media (max-width: 767px) {
  .dash-navbar-left.nb-visible {
    left: -250px;
  }
  .dash-navbar-left.nb-visible.nb-show {
    left: 0;
  }
}
.dash-navbar-left.nb-hidden {
  left: -250px;
}
.dash-navbar-left.nb-hidden.nb-show {
  left: 0;
}
.dash-navbar-left .nb-nav-title {
  text-transform: uppercase;
  color: #7f799c;
  border-bottom: 1px solid rgba(255,152,0,0.1);
  padding: 10px 25px;
  font-size: 11px;
  letter-spacing: 1px;
}
.dash-navbar-left .nb-nav {
  padding-left: 0;
  list-style: none;
}
.dash-navbar-left .nb-nav ul {
  padding-left: 0;
  list-style: none;
}
.dash-navbar-left .nb-nav li {
  position: relative;
}
.dash-navbar-left .nb-nav li a {
  display: block;
  outline: 0;
  padding: 8px 25px 7px;
  font-size: 13px;
  color: #b7b4c7;
}
.dash-navbar-left .nb-nav li a:hover,
.dash-navbar-left .nb-nav li a:focus {
  color: #eeeeee;
  text-decoration: none;
  background-color: rgba(255,152,0,0.1);
  -webkit-box-shadow: inset 3px 0 0 orange;
  box-shadow: inset 3px 0 0 orange;
}
.dash-navbar-left .nb-nav li a:hover .badge,
.dash-navbar-left .nb-nav li a:focus .badge {
  color: #EEE;
}
.dash-navbar-left .nb-nav li a > .nb-link-icon {
  padding-right: 8px;
}
.dash-navbar-left .nb-nav li a > .nb-btn-sub-collapse {
  position: absolute;
  right: 25px;
  top: 10px;
}
.dash-navbar-left .nb-nav li a > .badge {
  position: absolute;
  right: 24px;
  top: 6px;
  padding: 3px 10px;
  color: #a7a9ac;
  background-color: transparent;
  border: 1px solid #4f4a65;
}
.dash-navbar-left .nb-nav li a.collapsed .nb-btn-sub-collapse {
  -webkit-transform: rotate(180deg);
  -ms-transform: rotate(180deg);
  -o-transform: rotate(180deg);
  transform: rotate(180deg);
}
.dash-navbar-left .nb-nav li.active > a {
  background-color: rgba(255,152,0,0.1);
  -webkit-box-shadow: inset 3px 0 0 orange;
  box-shadow: inset 3px 0 0 orange;
}
.dash-navbar-left .nb-nav li .nb-sub-one {
  background-color: #15141b;
}
.dash-navbar-left .nb-nav li .nb-sub-one li {
  border-top: 1px solid #1c1b24;
}
.dash-navbar-left .nb-nav li .nb-sub-one li a {
  display: block;
  color: #a7a9ac;
}
.dash-navbar-left .nb-nav li .nb-sub-one li a:hover,
.dash-navbar-left .nb-nav li .nb-sub-one li a:focus {
  color: #eeeeee;
  background-color: #1c1b24;
  -webkit-box-shadow: inset 3px 0 0 #1c1b24;
  box-shadow: inset 3px 0 0 #1c1b24;
}
.dash-navbar-left .nb-nav li .nb-sub-one li a > .nb-link-icon {
  padding-right: 8px;
}
.dash-navbar-left .nb-nav li .nb-sub-one li a > .badge {
  color: #a7a9ac;
  background-color: transparent;
  border: 1px solid #211f2a;
}
.dash-navbar-left .nb-nav li .nb-sub-one li.active > a {
  background-color: #1c1b24;
  -webkit-box-shadow: inset 3px 0 0 #1c1b24;
  box-shadow: inset 3px 0 0 #1c1b24;
}
.dash-navbar-left .nb-nav li .nb-sub-two {
  background-color: #211f2a;
}
.dash-navbar-left .nb-nav li .nb-sub-two li {
  border-top-color: 1px solid #282533;
}
.dash-navbar-left .nb-nav li .nb-sub-two li a {
  color: #a7a9ac;
}
.dash-navbar-left .nb-nav li .nb-sub-two li a:hover,
.dash-navbar-left .nb-nav li .nb-sub-two li a:focus {
  color: #eeeeee;
  background-color: #282533;
  -webkit-box-shadow: inset 3px 0 0 #282533;
  box-shadow: inset 3px 0 0 #282533;
}
.dash-navbar-left .nb-nav li .nb-sub-two li a > .badge {
  color: #a7a9ac;
  background-color: transparent;
  border: 1px solid #211f2a;
}
.dash-navbar-left .nb-nav li .nb-sub-two li.active > a {
  background-color: #1c1b24;
  -webkit-box-shadow: inset 3px 0 0 #1c1b24;
  box-shadow: inset 3px 0 0 #1c1b24;
}
/* Content wrap
/ -------------------------------------------------- */
.content-wrap {
  position: relative;
}
.content-wrap.nb-visible {
  margin-left: 250px;
}
@media (max-width: 767px) {
  .content-wrap.nb-visible {
    margin-left: 0;
    -webkit-transition: all 300ms;
    -o-transition: all 300ms;
    transition: all 300ms;
  }
  .content-wrap.nb-visible.nb-push {
    -webkit-transform: translate(250px, 0);
    -ms-transform: translate(250px, 0);
    -o-transform: translate(250px, 0);
    transform: translate(250px, 0);
  }
}
.content-wrap.nb-hidden {
  margin-left: 0;
  -webkit-transition: all 300ms;
  -o-transition: all 300ms;
  transition: all 300ms;
}
.content-wrap.nb-hidden.nb-push {
  margin-left: 250px;
}
@media (max-width: 767px) {
  .content-wrap.nb-hidden.nb-push {
    margin-left: 0;
    -webkit-transform: translate(250px, 0);
    -ms-transform: translate(250px, 0);
    -o-transform: translate(250px, 0);
    transform: translate(250px, 0);
  }
}
.content-wrap.content-opacity.nb-overlay,
.content-wrap.content-opacity.nb-push {
  opacity: 0.3;
  filter: alpha(opacity=30);
}
</style>

<script>
(function(){
	  "use strict";

	  // Navbar left
	  // -------------------------------------------------

	  	// Variables
			  var nb                = $(".dash-navbar-left"),
						nbBtnToggle       = $(".nb-btn-toggle"),
						nbBtnCollapse     = $(".nb-btn-collapse"),
						contentWrap        = $(".content-wrap"),
						contentWrapEffect  = contentWrap.data("effect"),
						windowHeight       = $(window).height() - 61,
						windowWidth        = $(window).width() < 767;

			// Functions
				function cwShowOverflow() {
					if ( windowWidth ) {
							contentWrap.css({
							height : windowHeight ,
							overflow : 'hidden'
						});
						$( 'html, body' ).css( 'overflow', 'hidden' );
					}
				}

				function cwHideOverflow() {
					if ( windowWidth ) {
						contentWrap.css({
							height : 'auto' ,
							overflow : 'auto'
						});
						$( 'html, body' ).css( 'overflow', 'auto' );
					}
				}

				function nbShow() {
					nb.addClass("nb-show").removeClass("nb-hide");
					contentWrap.addClass(contentWrapEffect);
					cwShowOverflow();
					nbBtnToggle.find("span").removeClass("fa-bars").addClass("fa-arrow-left");
				}

				function nbHide() {
					nb.removeClass("nb-show").addClass("nb-hide");
					contentWrap.removeClass(contentWrapEffect);
					cwHideOverflow();
					nbBtnToggle.find("span").removeClass("fa-arrow-left").addClass("fa-bars");
				}

			// Toggle the edge navbar left
				nb.addClass("nb-hide");
				nbBtnToggle.click( function() {
					if( nb.hasClass("nb-hide") ) {
						nbShow();
					} else {
						nbHide();
					}
				});

			// Collapse the dash navbar left subnav
				nbBtnCollapse.click( function(e) {
					e.preventDefault();
					if( nb.hasClass("nb-collapsed") ) {
						nb.removeClass("nb-collapsed");
						contentWrap.removeClass("nb-collapsed");
						$(this).find(".nb-link-icon").removeClass("fa-arrow-right").addClass("fa-arrow-left");
					} else {
						nb.addClass("nb-collapsed");
						contentWrap.addClass("nb-collapsed");
						$(this).find(".nb-link-icon").removeClass("fa-arrow-left").addClass("fa-arrow-right");
					}
				});

			// Close left navbar when top navbar opens
				$( '.navbar-toggle' ).click( function() {
					if ( $( this ).hasClass( 'collapsed' ) ) {
						nbHide();
					}
				});

			// Close top navbar when left navbar opens
				nbBtnToggle.click( function() {
					$( '.navbar-toggle' ).addClass( 'collapsed' );
					$( '.navbar-collapse' ).removeClass( 'in' );
				});

			// Code credit: https://tr.im/CZzf4
				function isMobile() {
				  try { document.createEvent("TouchEvent"); return true; }
				  catch(e){ return false; }
				}

			// Swipe the navbar
				if ( isMobile() == true ) {
					$(window).swipe( {
				    swipeRight:function() {
							nbShow();
							$( '.navbar-collapse' ).removeClass( 'in' );
				    },
				    swipeLeft:function() {
							nbHide();
				    },
				    threshold: 75
				  });
				}

			// Collapse navbar on content click
				$( '.content-wrap' ).click( function() {
					nbHide();
				});

			// Auto collapse other opens subnavs
		  	/*$(".nb-nav > li > a").click( function() {
		  		$( document ).find( 'ul .in' ).collapse( 'hide' );
		  	});*/

	})();
</script>




  <!-- Dash Navbar Top -->
  <nav class="navbar navbar-light bg-faded navbar-static-top dash-navbar-top nb-visible">
  <button class="nb-btn-toggle">
          <span class="fa fa-bars"></span>
  </button>
</nav>

    <!-- Dash Navbar Left -->
    <div class="dash-navbar-left nb-visible">
      <a class="navbar-brand" href="#">Menu</a>



      <p class="nb-nav-title">Administration</p>
      <ul class="nb-nav">
        <li>
          <a class="collapsed" data-toggle="collapse" href="#collapseStatistics" aria-expanded="false" aria-controls="collapseStatistics">
            <span class="glyphicon glyphicon-stats nb-link-icon"></span>
            <span class="nb-link-text">User Management</span>
            <span class="fa fa-angle-up nb-btn-sub-collapse"></span>
          </a>
          <!-- Dropdown level one -->
          <ul class="nb-sub-one collapse" id="collapseStatistics">
            <li>
              <a href="#">
                <span class="fa fa-clock-o nb-link-icon"></span>
                <span class="nb-link-text">Daily</span>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="fa fa-history nb-link-icon"></span>
                <span class="nb-link-text">Annual</span>
              </a>
            </li>
          </ul>
        </li>
        <li class="active">
          <a href="#">
            <span class="glyphicon glyphicon-folder-open nb-link-icon"></span>
            <span class="nb-link-text">Role Management</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="glyphicon glyphicon-comment nb-link-icon"></span>
            <span class="nb-link-text">User Role Management</span>
            <span class="badge">4</span>
          </a>
        </li>
        <li>
          <a class="collapsed" data-toggle="collapse" href="#collapseLevelOne" aria-expanded="false" aria-controls="collapseLevelOne">
            <span class="fa fa-sort-amount-desc nb-link-icon"></span>
            <span class="nb-link-text">Server Permission</span>
            <span class="fa fa-angle-up nb-btn-sub-collapse"></span>
          </a>
          <!-- Dropdown level one -->
          <ul class="nb-sub-one collapse" id="collapseLevelOne">
            <li>
              <a href="#">
                <span class="fa fa-slack nb-link-icon"></span>
                <span class="nb-link-text">LMS Permission</span>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="fa fa-slack nb-link-icon"></span>
                <span class="nb-link-text">PAM Permission</span>
              </a>
            </li>
            <li>
              <a class="collapsed" data-toggle="collapse" href="#collapseLevelTwo" aria-expanded="false" aria-controls="collapseLevelTwo">
                <span class="fa fa-level-down nb-link-icon"></span>
                <span class="nb-link-text">Dropdown level 2</span>
                <span class="fa fa-angle-up nb-btn-sub-collapse"></span>
              </a>
              <!-- Dropdown level two -->
              <ul class="nb-sub-two collapse" id="collapseLevelTwo">
                <li>
                  <a href="#">
                    <span class="fa fa-wifi nb-link-icon"></span>
                    <span class="nb-link-text">Level 2</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <span class="fa fa-wifi nb-link-icon"></span>
                    <span class="nb-link-text">Level 2</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <span class="fa fa-wifi nb-link-icon"></span>
                    <span class="nb-link-text">Level 2</span>
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="#">
                <span class="fa fa-slack nb-link-icon"></span>
                <span class="nb-link-text">Level 1</span>
              </a>
            </li>
          </ul>
        </li>
      </ul>
      <p class="nb-nav-title">Management</p>
      <ul class="nb-nav">
        <li>
          <a href="#">
            <span class="fa fa-image nb-link-icon"></span>
            <span class="nb-link-text">LMS Management</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="fa fa-video-camera nb-link-icon"></span>
            <span class="nb-link-text">PAM Management</span>
          </a>
        </li>
      </ul>
    </div> <!-- /.dash-navbar-left -->


    <div class="content-wrap nb-visible" data-effect="nb-push">
      <div class="container-fluid">
        <div class="row">
         <!-- Your content here -->
         <div class="dummy-div" style="height:1500px;">

         </div>
         <!-- End of your content -->
        </div>
      </div>
    </div> <!-- /.content-wrap -->
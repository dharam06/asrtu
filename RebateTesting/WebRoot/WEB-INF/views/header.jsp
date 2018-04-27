       <header id="navigation" class="navbar-inverse navbar-fixed-top animated-header">
            <div class="container">
                <div class="navbar-header">
                		
                    <!-- responsive nav button -->
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
                    </button>
					<!-- /responsive nav button -->
					
					<!-- logo -->
					<h1 class="navbar-brand">
					<a href="#body">ASRTU</a></h1>
					
					<!-- /logo -->
					
                </div>
                
                <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
					<c:out value="${message}" />&nbsp; - &nbsp;<c:out value="${userName}"/><a href="SignOut.html">&nbsp;|&nbsp; Log Out</a>
		</div>
				<!-- main nav -->
                <nav class="collapse navbar-collapse navbar-right" role="navigation">
                
                    <ul id="nav" class="nav navbar-nav">
                     <li><a href="#body"></a></li>
                    </ul>
                </nav>
				<!-- /main nav -->
            </div>
        </header>


	<?php
		session_start();

		if(isset($_SESSION['userID']))
			$userID = $_SESSION['userID'];
		else
			$userID = "";

		if(isset($_SESSION['flogin']))
			$fLogin = $_SESSION['flogin'];
		else
			$fLogin = 1;

		if(isset($_SESSION['islogin']))
			$isLogin = $_SESSION['islogin'];
		else
			$isLogin = 0;

		if(isset($_SESSION['userName']))
			$userName = $_SESSION['userName'];
		else
			$userName = "";

		if(isset($_SESSION['mIdx']))
			$mIdx = $_SESSION['mIdx'];
		else
			$mIdx = -1;

		if(isset($_SESSION['level']))
			$level = $_SESSION['level'];
		else
			$level = 0;


	?>
	<!-- ##### Header Area Start ##### -->
    <header class="header-area">

        <!-- Navbar Area -->
        <div class="mag-main-menu" id="sticker">
            <div class="classy-nav-container breakpoint-off">
                <!-- Menu -->
                <nav class="classy-navbar justify-content-between" id="magNav">

                    <!-- Nav brand -->
                    <a href="index.php" class="nav-brand"><img src="img/core-img/logo.png" alt=""></a>



                    <!-- Nav Content -->
                    <div class="nav-content d-flex align-items-center">
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                                <ul>
                                    <li class="active"><a href="index.php">Home</a></li>
                                    <li><a href="#">Notice</a></li>
                                    <!--<li><a href="#">Programs</a>
                                        <ul class="dropdown">
                                            <li><a href="keywordmaster.php">KeywordMaster</a></li>
                                        </ul>
                                    </li>-->
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Contact</a></li>
                                </ul>
                            </div>
                            <!-- Nav End -->
                        </div>
						<!-- Navbar Toggler -->
						<div class="classy-navbar-toggler">
							<span class="navbarToggler"><span></span><span></span><span></span></span>
						</div>
                        <div class="top-meta-data d-flex align-items-center">
                            <!-- 로그인 -->
							<?php
								if($fLogin == 0 && $isLogin == 1){
									echo "<ul class='nav navbar-right top-nav'>
											<li class='dropdown'>
												<a href='#' class='dropdown-toggle' data-toggle='dropdown'><i class='fa fa-user'></i> ".$userName."님 환영합니다! <b class='caret'></b></a>
												<ul class='dropdown-menu'>
													<li>
														<a href='mypage'><i class='fa fa-fw fa-user'></i> 마이 페이지</a>
													</li>
													<li class='divider'></li>
													<li>
														<a href='logout.php'><i class='fa fa-fw fa-power-off'></i> 로그아웃</a>
													</li>
												</ul>
											</li>
										</ul>";
								}else{
									echo "<a href='login.php' class='login-btn'>
										<i class='fa fa-user' aria-hidden='true'></i>로그인</a>";
								}
							?>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->
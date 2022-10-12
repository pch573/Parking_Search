<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>SPL - System of Parking Lot 주차장 관리 시스템</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="spinner">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
    </div>

    <?php include 'header.php';?>

    <!-- ##### Breadcrumb Area Start ##### -->
    <section class="breadcrumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/40.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content">
                        <h2>Login</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Login Area Start ##### -->
    <div class="mag-login-area py-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-6">
                    <div class="login-content bg-white p-30 box-shadow">
                        <!-- Section Title -->
                        <div class="section-heading">
                            <h5>로그인</h5>
                        </div>

                        <form action="libs/loginproc.php" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" id="userid" name="userid" placeholder="아이디">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="userpw" name="userpw" placeholder="패스워드">
                            </div>
                            <div class="form-group">
                                <div class="custom-control custom-checkbox mr-sm-2">
                                    <!--<input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                    <label class="custom-control-label" for="customControlAutosizing">Remember me</label>-->
									<div class="row">
										<div class="col-6 col-lg-6">
											<a href="register.php">회원가입</a>
										</div>
										<div class="col-6 col-lg-6 pull-right">
											<a href="findaccount.php">ID / 비밀번호 찾기</a>
										</div>
									</div>                                    
                                </div>
                            </div>
                            <button type="submit" class="btn mag-btn mt-30">로그인</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Login Area End ##### -->

    <?php include 'footer.php';?>

    <!-- ##### All Javascript Script ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
</body>

</html>
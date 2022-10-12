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

	<script>
		function register(){
			var username = document.getElementById("username").value;
			var userid = document.getElementById("userid").value;
			var userpw = document.getElementById("userpw").value;
			var userpwchk = document.getElementById("userpwchk").value;
			var useremail = document.getElementById("useremail").value;
			var userph = document.getElementById("userph").value;
			if(username == ""){
				alert('이름을 입력해주세요.');
				return;
			}
			if(userid == ""){
				alert('아이디를 입력해주세요.');
				return;
			}
			if(userpw == ""){
				alert('비밀번호를 입력해주세요.');
				return;
			}
			if(useremail == ""){
				alert('이메일 주소를 입력해주세요.');
				return;
			}
			if(userph == ""){
				alert('전화번호를 입력해주세요.');
				return;
			}
			if(userpwchk != userpw){
				alert('비밀번호 확인이 일치하지 않습니다.');
				return;
			}

			$.ajax({
				url: "libs/registerproc.php",
				type: "post",
				data: "username=" + username + "&userid=" + userid + "&userpw=" + userpw + "&useremail=" + useremail + "&userph=" + userph,
			}).done(function(data) {
					alert(data);
					if(data.indexOf("성공"))
						location.replace("login.php");
			});
		}
	</script>
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
                        <h2>Register</h2>
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
                            <h5>회원가입</h5>
                        </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="username" name="username" placeholder="이름">
                            </div>
				            <div class="form-group">
                                <input type="text" class="form-control" id="userid" name="userid" placeholder="아이디">
                            </div>
							<div class="form-group">
                                <input type="password" class="form-control" id="userpw" name="userpw" placeholder="비밀번호">
                            </div>
							<div class="form-group">
                                <input type="password" class="form-control" id="userpwchk" name="userpwchk" placeholder="비밀번호 확인">
                            </div>
							<div class="form-group">
                                <input type="text" class="form-control" id="useremail" name="useremail" placeholder="이메일 주소">
                            </div>
							<div class="form-group">
                                <input type="text" class="form-control" id="userph" name="userph" placeholder="전화번호">
                            </div>

                            <button type="submit" class="btn mag-btn mt-30" onclick="register()">회원가입</button>
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
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Mag - Video &amp; Magazine HTML Template</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

	<script>
		function findid(){
			var idname = document.getElementById("idname").value;
			var idph = document.getElementById("idph").value;
			if(idname == ""){
				alert('이름을 입력해주세요.');
				return;
			}
			if(idph == ""){
				alert('전화번호를 입력해주세요.');
				return;
			}
			

			$.ajax({
				url: "findaccountproc.php",
				type: "post",
				data: "mode=0&username=" + idname + "&userph=" + idph,
			}).done(function(data) {
					alert(data);
					//if(data.indexOf("성공"))
						//location.replace("login.php");
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
                        <h2>ID / PW 찾기</h2>
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
                <div class="col-lg-6" style="padding-bottom: 20px">
                    <div class="login-content bg-white p-30 box-shadow">
                        <!-- Section Title -->
                        <div class="section-heading">
                            <h5>PW 찾기</h5>
                        </div>
						<div class="form-group">
							<input type="text" class="form-control" id="changepw" name="changepw" placeholder="변경할 비밀번호 입력">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="changepwchk" name="changepwchk" placeholder="변경할 비밀번호 확인">
						</div>
						
						<button type="submit" class="btn mag-btn mt-30" onclick="findid()">ID 찾기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="mag-login-area py-5">
        <div class="container">
            <div class="row justify-content-center">

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
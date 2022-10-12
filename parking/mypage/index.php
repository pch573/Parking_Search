<?php
	session_start();
	header("Content-Type: text/html; charset=UTF-8");
	include '../libs/dbConnect.php';

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

	if(isset($_SESSION['userPH']))
		$userPH = $_SESSION['userPH'];
	else
		$userPH = "";

	if(isset($_SESSION['userEMail']))
		$userEMail = $_SESSION['userEMail'];
	else
		$userEMail = "";

	if(isset($_SESSION['mIdx']))
		$mIdx = $_SESSION['mIdx'];
	else
		$mIdx = -1;

	if(isset($_SESSION['level']))
		$level = $_SESSION['level'];
	else
		$level = 0;
	if($fLogin == 1 || $isLogin == 0){
		echo "<script>location.href='../index.php';</script>";
	}else{
	header("Content-Type: text/html; charset=UTF-8");

?>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SPL - 마이페이지</title>



    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

	<script>
		function change_data(){
			var ph = document.getElementById("uPH").value;
			var email = document.getElementById("uEMail").value;
			var nowpw = document.getElementById("nPW").value;
			var changepw = document.getElementById("cPW").value;
			var changepwchk = document.getElementById("cPW2").value;
			if(nowpw == ""){
				alert('현재 비밀번호를 입력해주세요.');
				return;
			}
			if(changepw != changepwchk){
				alert('비밀번호 확인이 일치하지 않습니다.');
				return;
			}
			$.ajax({
				url: "changeproc.php",
				type: "post",
				data: "nPW=" + nowpw + "&uPH=" + ph + "&uEMail=" + email + "&cPW=" + changepw,
			}).done(function(data) {
					alert(data);
			});
		}
	</script>
</head>


<body>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../index.php">SPL</a>
				<a class="navbar-brand" href="index.php"><font size = "2pt">마이페이지</font></a>

            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <?=$userName?> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="../logout.php"><i class="fa fa-fw fa-power-off"></i>로그아웃</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
					<?php
						include 'menuitems.php';
					?>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <small>마이페이지 메인</small>
                        </h1>
                        <!--<ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>-->
                    </div>
                </div>


				<div class="row">
					<div class="col-lg-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-long-arrow-right"></i>
										유저 정보 수정
									</h3>
								</div>
								<div class="panel-body">
									* 표시된 항목은 필수 항목입니다.
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">이름</span>
										<input class="form-control" value="<?=$userName?>" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc" disabled>
									</div>
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">회원 아이디</span>
										<input class="form-control" value="<?=$userID?>" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc" disabled>
									</div>
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">전화번호</span>
										<input id="uPH" class="form-control" name="uPH" value="<?=$userPH?>" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
									</div>
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">회원 이메일</span>
										<input id="uEMail" class="form-control" name="uEMail" value="<?=$userEMail?>" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
									</div>
									<div cl
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">현재 비밀번호*</span>
										<input id="nPW" class="form-control" type="password" name="nPW" placeholder="현재 비밀번호" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
									</div>
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">비밀번호 변경</span>
										<input id="cPW" class="form-control" type="password" name="cPW" placeholder="변경할 비밀번호" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
									</div>
									<div class="input-group">
										<span class="input-group-addon" style="height: auto">비밀번호 확인</span>
										<input id="cPW2" class="form-control" type="password" name="cPW2" placeholder="변경할 비밀번호 확인" style="height: 30px; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
									</div>
									<button class="btn btn-success" style="width: 100%; margin-top: 10px" onclick="change_data()">개인 정보 수정</button>
								</div>
							</div>
					</div>
                </div>
			</div>
                <!-- /.row -->











            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <!--<script src="js/plugins/morris/morris-index-data.js"></script>-->

    <!-- Flot Charts JavaScript -->
    <!--[if lte IE 8]><script src="js/excanvas.min.js"></script><![endif]-->
    <!--<script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="js/plugins/flot/flot-data.js"></script>-->

    <!--<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="/css/jquery-ui.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>-->


</body>

</html>
<?php
	}
?>
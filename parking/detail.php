<?php
	session_start();
	include 'libs/dbConnect.php';
	header("Content-Type: text/html; charset=UTF-8");
	$mAgent = array("iPhone","iPod","Android","Blackberry", 
	"Opera Mini", "Windows ce", "Nokia", "sony" );
	$isMobile = false;
	for($i=0; $i<sizeof($mAgent); $i++){
		if(stripos( $_SERVER['HTTP_USER_AGENT'], $mAgent[$i] )){
			$isMobile = true;
			break;
		}
	}
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

	if(isset($_SESSION['name']))
		$name = $_SESSION['name'];
	else
		$name = "";

	if(isset($_SESSION['mIdx']))
		$mIdx = $_SESSION['mIdx'];
	else
		$mIdx = -1;

	if(isset($_SESSION['level']))
		$level = $_SESSION['level'];
	else
		$level = 0;

	if($fLogin == 1 || $isLogin == 0){
		echo "<script>location.href='login.php';</script>";
		die();
	}

	$detailNo = $_REQUEST['no'];
	$sql = "SELECT * FROM PARKING_LOT_INFO WHERE `pliNo` = '$detailNo'";
	$ret = mysql_query($sql);

	while($row = mysql_fetch_array($ret)){
		$pNo = $row['pliNo'];
		$pName = $row['pliName'];
		$pCnt = $row['pliCnt'];
		$pDay = $row['pliDay'];
		if($pDay == 0)
			$pDay = "요일제 미시행";
		else
			$pDay = "요일제 시행";
		$pEtc = $row['pliEtc'];
		$pManageName = $row['pliManageName'];
		$pPH = $row['pliPH'];
		$pLAT = $row['pliLAT'];
		$pLON = $row['pliLON'];
		$pDate = $row['pliDate'];
		$pLandAddr = $row['pliLandAddr'];
		$pRoadAddr = $row['pliRoadAddr'];
		$pIsFree = $row['pliIsFree'];
		if($pIsFree == 0)
			$pIsFree = "유료";
		else
			$pIsFree = "무료";
		$pDefaultTime = $row['pliDefaultTime'];
		$pDefaultFee = $row['pliDefaultFee'];
		$pAddTime = $row['pliAddTime'];
		$pAddFee = $row['pliAddFee'];
		$pDayFee = $row['pliDayFee'];
		$pMonthFee = $row['pliMonthFee'];
		$pPayType = $row['pliPayType'];
		$pDOW = $row['pliDOW'];
		$pWDStart = $row['pliWDStart'];
		$pWDEnd = $row['pliWDEnd'];
		$pSatStart = $row['pliSatStart'];
		$pSatEnd = $row['pliSatEnd'];
		$pHolStart = $row['pliHolStart'];
		$pHolEnd = $row['pliHolEnd'];

	}
	//echo $userID.$fLogin.$isLogin.$name.$mIdx.$level;
?>

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
    <link rel="stylesheet" href="css/kakaomap.css">
	<!-- Custom Fonts -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link href="mypage/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
    <section class="breadcrumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/49.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content">
                        <h2>세부사항</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="mag-breadcrumb py-5">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">상세 정보</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Post Details Area Start ##### -->
    <section class="post-details-area">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Post Details Content Area -->
                <div class="col-12 col-xl-8">
                    <div class="post-details-content bg-white mb-30 p-30 box-shadow">
                        <div class="blog-thumb mb-30">
                            <div class="map_wrap">
								<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div> 
								<!-- 지도타입 컨트롤 div 입니다 -->
								<div class="custom_typecontrol radius_border" style="box-sizing: unset">
									<span id="btnRoadmap" class="km_selected_btn" style="box-sizing: unset" onclick="setMapType('roadmap')">지도</span>
									<span id="btnSkyview" class="km_btn" style="box-sizing: unset" onclick="setMapType('skyview')">스카이뷰</span>
								</div>
								<!-- 지도 확대, 축소 컨트롤 div 입니다 -->
								<div class="custom_zoomcontrol radius_border"> 
									<span onclick="zoomIn()"><img src="http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_plus.png" style="box-sizing: unset" alt="확대"></span>  
									<span onclick="zoomOut()"><img src="http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_minus.png" style="box-sizing: unset" alt="축소"></span>
								</div>
							</div>
                        </div>
                        <div class="blog-content">
                            <div class="post-meta">
                                최근 수정일 : <?=$pDate?>
                            </div>
                            <h4 class="post-title"><?=$pName?></h4>

                            <p>고유 관리번호 : <?=$pNo?></p>
							<p>주차 구획 수 : <?=$pCnt?></p>
							<p>차량 부제 시행 구분 : <?=$pDay?></p>
							<p>관리 기관명 : <?=$pManageName?></p>
							<p>전화번호 : <?=$pPH?></p>
							<p>도로명 주소 : <?=$pLandAddr?></p>
							<p>지번 주소 : <?=$pRoadAddr?></p>
							<blockquote>
								<h6 class="quote-text">요금 정보 <br></h6>
								<p>유/무료 구분 : <?=$pIsFree?></p>
								<p>기본 <?=$pDefaultTime?>분에 <?=$pDefaultFee?>원</p>
								<p>추가 <?=$pAddTime?>분당 <?=$pAddFee?>원</p>
								<p>1일 주차권 요금 : <?=$pDayFee?></p>
								<p>1달 주차권 요금 : <?=$pMonthFee?></p>
								<p>결제 유형 : <?=$pPayType?></p>
							</blockquote>
							<blockquote>
								<h6 class="quote-text">운영 시간 정보 <br></h6>
								<p>운영 요일 : <?=$pDOW?></p>
								<p>평일 운영 시간 : <?=$pWDStart?> ~ <?=$pWDEnd?></p>
								<p>토요일 운영 시간 : <?=$pSatStart?> ~ <?=$pSatEnd?></p>
								<p>공휴일 운영 시간 : <?=$pHolStart?> ~ <?=$pHolEnd?></p>
							</blockquote>
							<p>기타 사항 : <?=$pEtc?></p>
                            <blockquote>
                                <h6 class="quote-text">잘못된 정보가 있을 수 있습니다.<br>방문하시기 전 담당 기관을 통해 다시 한 번 확인하시기 바랍니다.</h6>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Post Details Area End ##### -->

    <?php include 'footer.php';?>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### All Javascript Script ##### -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=66f37cbd41f3641f8ac1973ac2127886"></script>
	<script>
		var map_lat = <?=$pLAT?>;
		var map_lon = <?=$pLON?>;

	</script>
	<script>
	var iwContent = '<div style="padding:5px; text-align: center"><?=$pName?></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new daum.maps.LatLng(map_lat, map_lon); //인포윈도우 표시 위치입니다
	</script>
    <script src="js/kakaomap.js"></script>
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
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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
	<!-- Custom Fonts -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link href="mypage/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
	<script src="js/datatables.js"></script>
	<link rel="stylesheet" type="text/css" href="css/datatables.css">
	<script>
		$(function(){
			$('#result').DataTable( {
			responsive: true
			} );
		});
	</script>
	<script>
		function refresh(){
			var d1 = "";
			var d2 = "";
			var d3 = "";
			var subquery = "";



			var addr = document.getElementById("pAddr").value;
			var pname = document.getElementById("pName").value;
			var date1 = document.getElementById("chkDate1").checked;
			var date2 = document.getElementById("chkDate2").checked;
			var date3 = document.getElementById("chkDate3").checked;

			if(date1) d1="평일";
			if(date2) d2="토요일";
			if(date3) d3="공휴일";
			
			var isFree0 = document.getElementById("isFree0").checked;
			var isFree1 = document.getElementById("isFree1").checked;
			var isFree2 = document.getElementById("isFree2").checked;
			if (isFree0)
				//유료
				subquery=" AND `pliIsFree` = 0";
			else if(isFree1)
				//무료
				subquery=" AND `pliIsFree` = 1";
			else if(isFree2)
				//모두
				subquery="";

			var param = { "pAddr": addr, "pName": pname , "d1": d1, "d2": d2, "d3": d3, "subquery": subquery};
			$('#result').DataTable({
				//'createdRow': function(row, data, dataIndex){
				//	$(row).attr('onclick','detail(\'' + data[0] + '\')');
				//},
				'columnDefs': [
					{
						'targets': 1,
						'createdCell':  function (td, cellData, rowData, row, col) {
							$(td).attr('onclick','detail(\'' + rowData[0] + '\')'); 
						}
					},
					{
						'targets': 2,
						'createdCell':  function (td, cellData, rowData, row, col) {
							$(td).attr('onclick','detail(\'' + rowData[0] + '\')'); 
						}
					},
					{
						'targets': 3,
						'createdCell':  function (td, cellData, rowData, row, col) {
							$(td).attr('onclick','detail(\'' + rowData[0] + '\')'); 
						}
					},
					{
						'targets': 4,
						'createdCell':  function (td, cellData, rowData, row, col) {
							$(td).attr('onclick','detail(\'' + rowData[0] + '\')'); 
						}
					}
				],
				"responsive": true,
				"processing": true,
				"serverSide": false,
				"bDestroy": true,
				ajax: {
					type : "post",
					url : "libs/get_result.php",
					data : param,
					dataType : "JSON"
				}
			});
		}
	</script>
	<style>
	table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}
	</style>
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

    <!-- ##### Hero Area Start ##### -->
    <div class="hero-area owl-carousel height: 300px">
        <!-- Single Blog Post -->
        <div class="hero-blog-post bg-img bg-overlay" style="background-image: url(img/bg-img/1.jpg); height: 300px">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <!-- Post Contetnt -->
                        <div class="post-content text-center">
                            <div class="post-meta" data-animation="fadeInUp" data-delay="100ms">
                                <a href="#">2019.06.16 ~ 06.29</a>
                                <a href="#">먹거리</a>
                            </div>
                            <a href="#" class="post-title" data-animation="fadeInUp" data-delay="300ms">경복궁 시식공감</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Single Blog Post -->
        <div class="hero-blog-post bg-img bg-overlay" style="background-image: url(img/bg-img/2.jpg); height: 300px">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <!-- Post Contetnt -->
                        <div class="post-content text-center">
                            <div class="post-meta" data-animation="fadeInUp" data-delay="100ms">
                                <a href="#">2019.06.21 ~ 06.23</a>
                                <a href="#">먹거리</a>
                            </div>
                            <a href="#" class="post-title" data-animation="fadeInUp" data-delay="300ms">고창 복분자와 수박축제</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Single Blog Post -->
        <div class="hero-blog-post bg-img bg-overlay" style="background-image: url(img/bg-img/3.jpg); height: 300px">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <!-- Post Contetnt -->
                        <div class="post-content text-center">
                            <div class="post-meta" data-animation="fadeInUp" data-delay="100ms">
                                <a href="#">2019.05.31 ~ 06.16</a>
                                <a href="#">먹거리</a>
                            </div>
                            <a href="#" class="post-title" data-animation="fadeInUp" data-delay="300ms">부산 센텀 맥주 축제</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Hero Area End ##### -->

    <!-- ##### Mag Posts Area Start ##### -->
    <section class="mag-posts-area d-flex flex-wrap">

        <!-- >>>>>>>>>>>>>>>>>>>>
         Post Left Sidebar Area
        <<<<<<<<<<<<<<<<<<<<< -->
        <div class="post-sidebar-area left-sidebar mt-30 mb-30 bg-white box-shadow">
            <!-- Sidebar Widget -->
            <div class="single-sidebar-widget p-30">
                <!-- Section Title -->
                <div class="section-heading">
                    <h4>이런 여행지는 어떠세요?</h4>
                </div>

                <!-- Single Blog Post -->
                <div class="single-blog-post d-flex">
                    <div class="post-thumbnail">
                        <img src="img/ad-img/1.jpg" style="width: 100%; height: 100%" alt="">
                    </div>
                    <div class="post-content">
                        <a href="#" class="post-title">호서대학교 중앙잔디</a>
                        <div class="post-meta d-flex justify-content-between">
                            넓게 펼처진 포근한 잔디에서 놀고싶다면?
                        </div>
                    </div>
                </div>

                <!-- Single Blog Post -->
                <div class="single-blog-post d-flex">
                    <div class="post-thumbnail">
                        <img src="img/ad-img/2.jpg" style="width: 100%; height: 100%" alt="">
                    </div>
                    <div class="post-content">
                        <a href="#" class="post-title">온양온천</a>
                        <div class="post-meta d-flex justify-content-between">
                            현재 50% 할인중!
                        </div>
                    </div>
                </div>

                <!-- Single Blog Post -->
                <div class="single-blog-post d-flex">
                    <div class="post-thumbnail">
                        <img src="img/ad-img/3.jpg" style="width: 100%; height: 100%" alt="">
                    </div>
                    <div class="post-content">
                        <a href="#" class="post-title">경복궁</a>
                        <div class="post-meta d-flex justify-content-between">
                            조선의 궁궐에 당도한 것을 환영하오, 낯선이여
                        </div>
                    </div>
                </div>

                <!-- Single Blog Post -->
                <div class="single-blog-post d-flex">
                    <div class="post-thumbnail">
                        <img src="img/ad-img/4.jpg" style="width: 100%; height: 100%" alt="">
                    </div>
                    <div class="post-content">
                        <a href="#" class="post-title">롯데월드</a>
                        <div class="post-meta d-flex justify-content-between">
                            환상의 나라로 오세요! 즐거운 축제가 열리는곳~
                        </div>
                    </div>
                </div>

                <!-- Single Blog Post -->
                <div class="single-blog-post d-flex">
                    <div class="post-thumbnail">
                        <img src="img/ad-img/5.jpg" style="width: 100%; height: 100%" alt="">
                    </div>
                    <div class="post-content">
                        <a href="#" class="post-title">세출호</a>
                        <div class="post-meta d-flex justify-content-between">
                            넓은 호수와 방문시 각종 피부병을 덤으로!
                        </div>
                    </div>
                </div>
            </div>

            <!-- Sidebar Widget
            <div class="single-sidebar-widget">
                <a href="#" class="add-img"><img src="img/bg-img/add.png" alt=""></a>
            </div>-->
        </div>

        <!-- >>>>>>>>>>>>>>>>>>>>
             Main Posts Area
        <<<<<<<<<<<<<<<<<<<<< -->
        <div class="mag-posts-content mt-30 mb-30 p-30 box-shadow">
            <!-- Trending Now Posts Area -->
            <div class="trending-now-posts mb-30">
                <!-- Section Title -->
                <div class="section-heading">
                    <h5>주차장 검색 시스템</h5>
                </div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel-body" style="padding: 0px">

							<div class="input-group">
								<span class="input-group-addon" style="height: auto; width: 30%">지역</span>
								<input id="pAddr" class="form-control" name="pAddr" placeholder="ex ) 강남구, 서초구" style="height: 30px;width: 70%; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
							</div>

							<div class="input-group">
								<span class="input-group-addon" style="height: auto; width: 30%">이용 요일</span>
								<span class="input-group" style="width: 70%; border: 1px solid #ccc">
									<form>
										<label class="radio-inline" style="padding-left: 0px">
											<input type="checkbox" name="chkDate1" id="chkDate1" style="display: unset; position: unset;" checked>평일
										</label>
										<label class="radio-inline" style="padding-left: 0px">
											<input type="checkbox" name="chkDate2" id="chkDate2" style="display: unset; position: unset;" checked>토요일
										</label>
										<label class="radio-inline" style="padding-left: 0px">
											<input type="checkbox" name="chkDate3" id="chkDate3" style="display: unset; position: unset;" checked>공휴일
										</label>
									</form>
								</span>
							</div>

							<div class="input-group">
								<span class="input-group-addon" style="height: auto; width: 30%">요금 정보</span>
								<span class="input-group" style="width: 70%; border: 1px solid #ccc">	
									<form>
										<label class="radio-inline">
											<input type="radio" name="isFree" id="isFree2" style="display: unset; position: unset" checked>모두
										</label>
										<label class="radio-inline">
											<input type="radio" name="isFree" id="isFree0" style="display: unset; position: unset">유료
										</label>
										<label class="radio-inline">
											<input type="radio" name="isFree" id="isFree1" style="display: unset; position: unset">무료
										</label>
									</form>
								</span>
							</div>

							<div class="input-group">
								<span class="input-group-addon" style="height: auto; width: 30%">주차장 명</span>
								<input id="pName" class="form-control" name="pName" placeholder="주차장 명 입력" style="height: 30px;width: 70%; padding: 3.75px 7.5px 3.75px 7.5px; border: 1px solid #ccc">
							</div>

							<div style="padding-top: 10px">
								<button class="btn mag-btn" style="width: 100%; margin-bottom: 20px" onclick="refresh()">검색</button>
								<div class="row">
									<div class="col-12" style="min-width: 250px; overflow:auto">
										<table id='result' class='display nowrap dataTable collapsed dtr-inline'>
											<thead>
												<tr>
													<th>번호</th>
													<th>주차장명</th>
													<th>주소</th>
													<th>유/무료</th>
													<th>1시간 요금</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
            </div>
        </div>

        <!-- >>>>>>>>>>>>>>>>>>>>
         Post Right Sidebar Area
        <<<<<<<<<<<<<<<<<<<<< -->
        <div class="post-sidebar-area right-sidebar mt-30 mb-30 box-shadow">
            <!-- Sidebar Widget -->
            <div class="single-sidebar-widget p-30">
                <!-- Section Title -->
                <div class="section-heading">
                    <h5>공지사항</h5>
                </div>

                <!-- Catagory Widget -->
                <ul class="catagory-widgets">
					<li><a href="#"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i>호서대학교 고라니 출현 주의<br>2019-06-02</span></a></li>
                    <li><a href="#"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i>해안로 주차장 출입통제안내<br>2019-05-27</span></a></li>
					<li><a href="#"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i>유성구청뒤 구획수 변경안내<br>2019-05-25</span></a></li>
					<li><a href="#"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i>서비스 점검 안내<br>2019-05-24</span></a></li>
					<li><a href="#"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i>해운대 일대 협조 요청문<br>2019-05-20</span></a></li>
                </ul>
            </div>

            <!-- Sidebar Widget
            <div class="single-sidebar-widget">
                <a href="#" class="add-img"><img src="img/bg-img/add2.png" alt=""></a>
            </div>-->
        </div>
    </section>
    <!-- ##### Mag Posts Area End ##### -->

    <?php include 'footer.php';?>
    <!-- ##### All Javascript Script ##### -->
		<script type="text/javascript">
		function detail(no) {
			location.href="detail.php?no=" + no;
		}
	</script>
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
<?php
	session_start();
	include '../libs/dbConnect.php';
	
	$mIdx = $_SESSION['mIdx'];
	
	$ph = $_REQUEST['uPH'];
    $eMail = $_REQUEST['uEMail'];
    $nPW = $_REQUEST['nPW'];
    $cPW = $_REQUEST['cPW'];
	
	$sql = "SELECT * FROM MEMBER WHERE mIdx = $mIdx";
	$ret = mysql_query($sql);
	$row = mysql_fetch_array($ret);
	
	if(md5($nPW) != $row['mPW']){
		echo "입력하신 비밀번호가 일치하지 않습니다.";
		die();
	}
	if($cPW == "")
		$sql = "UPDATE `MEMBER` SET `mPH`='$ph', `mEMail`='$eMail' WHERE `mIdx` = $mIdx";
	else
		$sql = "UPDATE `MEMBER` SET `mPH`='$ph', `mEMail`='$eMail', `mPW`=md5('$cPW') WHERE `mIdx` = $mIdx";

	$ret = mysql_query($sql);
	if($ret){
		echo "회원 정보 수정에 성공하였습니다.";
		$_SESSION['userPH'] = $ph;
		$_SESSION['userEMail'] = $eMail;
	}else{
		echo "회원 정보 수정에 실패하였습니다.";
	}
?>
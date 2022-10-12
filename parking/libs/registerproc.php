<?php
	header("Content-Type: text/html; charset=UTF-8");
	include 'dbConnect.php';
	$tablename="MEMBER";

	$id=$_REQUEST['userid'];
	$pw=$_REQUEST['userpw'];
	$name=$_REQUEST['username'];
	$email=$_REQUEST['useremail'];
	$ph=$_REQUEST['userph'];
	
	$sql = "INSERT INTO `MEMBER`(`mID`,`mPW`,`mName`,`mEMail`,`mPH`) VALUES('$id',md5('$pw'),'$name','$email','$ph')";
	$ret = mysql_query($sql);
	if($ret)
		echo "회원가입에 성공하였습니다.\n 로그인을 시도해주세요.";
	else
		echo "회원가입에 실패하였습니다.";
?>
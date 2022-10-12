<?php
	header("Content-Type: text/html; charset=UTF-8");
	include 'dbConnect.php';
	$tablename="MEMBER";

	$id=$_REQUEST['userid'];
	$pw=$_REQUEST['userpw'];

	$sql="SELECT * FROM $tablename WHERE `mID`='$id' AND `mPW`= md5('$pw')";
	$ret = mysql_query($sql);
	$cnt = mysql_num_rows($ret);
	$row=mysql_fetch_array($ret);
	
	if($cnt<1){
		$_SESSION['flogin'] = 1;
		$_SESSION['islogin'] = 0;
		$_SESSION['userID'] = "";
		$_SESSION['userName'] = "";
		$_SESSION['userPH'] = "";
		$_SESSION['userEMail'] = "";
        $_SESSION['mIdx'] = "";
        $_SESSION['level'] = "";
	}else{
		$_SESSION['flogin'] = 0;
		$_SESSION['islogin'] = 1;
		$_SESSION['userID'] = $row['mID'];
		$_SESSION['userName'] = $row['mName'];
		$_SESSION['userPH'] = $row['mPH'];
		$_SESSION['userEMail'] = $row['mEMail'];
        $_SESSION['mIdx'] = $row['mIdx'];
        $_SESSION['level'] = $row['mLevel'];
	}
	echo "<script>location.href='../index.php';</script>";
?>
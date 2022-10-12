<?php
	session_start();
	include 'dbConnect.php';

	$mode = $_REQUEST['mode'];
	$name = $_REQUEST['username'];
    $ph = $_REQUEST['userph'];
    $userid = $_REQUEST['userid'];

	function genTmpPwd($length){  
		$characters  = "0123456789";  
		$characters .= "abcdefghijklmnopqrstuvwxyz";  
		$characters .= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		$string_generated = "";  

		$nmr_loops = $length;

		while ($nmr_loops--){  
			$string_generated .= $characters[mt_rand(0, strlen($characters) - 1)];  
		}  

		return $string_generated;  
	}


	if($mode==0){
		//ID 찾기
		$sql = "SELECT * FROM MEMBER WHERE mName = '$name' AND mPH = '$ph'";
		$ret = mysql_query($sql);
		$idlist="";
		while($row = mysql_fetch_array($ret)){
			$idlist .= $row['mID']."\n(회원 가입 일 : ".$row['mJoinDate'].") \n";
		}
		echo "찾으시는 ID의 결과입니다. \n----------------------\n $idlist";
	}else{
		$temppw = genTmpPwd(8);
		
		$sql = "SELECT * FROM MEMBER WHERE mName = '$name' AND mPH = '$ph' AND mID = '$userid'";
		$ret = mysql_query($sql);
		$cnt = mysql_num_rows($ret);
		if($cnt >= 1){
			$sql = "UPDATE `MEMBER` SET `mPW`=md5('$temppw') WHERE mName = '$name' AND mPH = '$ph' AND mID = '$userid'";
			$ret = mysql_query($sql);
			if($ret){
				echo $temppw;
			}else{
				echo "Failed2";
			}
		}else{
			echo "Failed1";
		}

		//PW 찾기
	}

?>
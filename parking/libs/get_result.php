<?php
	header('Content-type: text/html; charset=UTF-8');
	include 'func.php';
	include 'dbConnect.php';
	$pAddr = $_REQUEST['pAddr'];
	$pName = $_REQUEST['pName'];
	$DOW1 = $_REQUEST['d1'];
	$DOW2 = $_REQUEST['d2'];
	$DOW3 = $_REQUEST['d3'];
	$subquery = $_REQUEST['subquery'];
	$sql = "SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%$pAddr%' OR `pliRoadAddr` LIKE '%$pAddr%') AND `pliName` LIKE '%$pName%' AND (`pliDOW` LIKE '%$DOW1%' AND `pliDOW` LIKE '%$DOW2%' AND pliDOW LIKE '%$DOW3%')$subquery";
	$ret = mysql_query($sql);
	while($row = mysql_fetch_array($ret)){
		$pno = $row['pliNo'];
		$pname = $row['pliName'];
		$paddr = $row['pliLandAddr'];
		if($paddr=='' || $paddr==null)
			$paddr = $row['pliRoadAddr'];
		$pisFree = $row['pliIsFree'];
		if($pisFree == 0){
			$pisFree = "유료";
		}else{
			$pisFree = "무료";
		}
		$pDefaultFee = $row['pliDefaultFee'];
		$pDefaultTime = $row['pliDefaultTime'];
		$pAddTime = $row['pliAddTime'];
		$pAddFee = $row['pliAddFee'];
		if($pAddTime*$pAddFee == 0){
			if($pDefaultFee != 0 && $pDefaultTime != 0){
				$pFee = (60/$pDefaultTime) * $pDefaultFee;
			}else{
				$pFee = $pDefaultFee;
			}
		}else{
			$pFee = $pDefaultFee + (60-$pDefaultTime)/$pAddTime*$pAddFee;
		}
		$dataArr = array($pno, $pname, $paddr, $pisFree, $pFee);
		
		if ($data2 == null)
			$data2 = array($dataArr);
		else
			array_push($data2,$dataArr);

		$data = array('data' => $data2);
	}
		echo json_encode($data);
	
?>
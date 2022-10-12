<?php
	function mSplit($Str, $Delimiter,$Range){
		$sTemp = explode($Delimiter,$Str);
		$sResult = $sTemp[$Range];
		return $sResult; 
	}

	function getTimestamp(){
		return round(microtime(true) * 1000);
	}

	function generateSignature($timestamp,$secretKey){
		$sign = $timestamp.".GET./keywordstool";
		$signature = hash_hmac('sha256', $sign, $secretKey, true);
		return base64_encode($signature);
	}
?>
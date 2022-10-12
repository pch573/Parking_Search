
<?php
	error_reporting(E_ALL^ E_WARNING); 
	$sql="SELECT * FROM MYPAGE_MENU";
	$ret = mysql_query($sql);
	$cnt = mysql_num_rows($ret);

	while($row=mysql_fetch_array($ret)){
		if($level >= $row['mmLevel']){
			?>
			<li>
				<a href="<?=$row['mmLink']?>"><i class="<?=$row['mmIcon']?>"></i> <?=$row['mmName']?> </a>
			</li>
			<?php
		}
	}
?>
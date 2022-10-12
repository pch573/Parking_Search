				<?php
					$sql="SELECT * FROM DashBoard";
					$ret=mysql_query($sql);
					while($row=mysql_fetch_array($ret,MYSQL_BOTH)){
						if($userlevel >= $row[Level]){
							if($row[hasSubItems]==0)
							{
							?>
						<li>
							<a href="<?=$row[Link]?>"><i class="<?=$row[Icon]?>"></i> <?=$row[Title]?> </a>
						</li>
							<?php
							}else{
								?>
						<li>
							<a href="javascript:;" data-toggle="collapse" data-target="#subitems<?=$row[No]?>"><i class="<?=$row[Icon]?>"></i> <?=$row[Title]?> <i class="fa fa-fw fa-caret-down"></i></a>
							<ul id="subitems<?=$row[No]?>" class="collapse">
							<?php
								$sql2="SELECT DS.Title, DS.Link, DS.Level FROM DashBoard DB, DashBoard_Subitems DS WHERE DS.dId = DB.No AND DS.dId = ".$row[No];
								$ret2=mysql_query($sql2);
								while($row2=mysql_fetch_array($ret2,MYSQL_BOTH)){
									if($userlevel >= $row2[Level]){
							?>
								<li>
									<a href="<?=$row2[Link]?>"><?=$row2[Title]?></a>
								</li>
							<?php
									}
								}
							?>
							</ul>
						</li>
				<?php
							}
						}
				}
				?>
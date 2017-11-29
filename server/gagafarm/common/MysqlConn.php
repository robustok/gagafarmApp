<?php
$db=@new mysqli('localhost','root','','gagafarm');
if(mysqli_connect_errno())
{
	echo "数据库连接失败！<br>\n";
	echo mysqli_connect_error();
	exit;
}
//mysql_set_charset('utf8',$db);
//echo "数据库连接成功！<br>\n";
?>
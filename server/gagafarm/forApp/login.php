<?php
require_once('../common/MysqlConn.php');
$userName=trim(htmlspecialchars($_POST['userName'],ENT_COMPAT,"UTF-8"));
$password=trim(htmlspecialchars($_POST['password'],ENT_COMPAT,"UTF-8"));
$User = '';
$sql="Select * from user where userName='".$userName."' and password='".$password."'";
//echo "sql:". $sql;
$result=$db->query($sql);
if($result){
	$row=mysqli_fetch_assoc($result);
	$User["userName"] = $row['userName'];
	$User["password"] = $row['password'];
	echo json_encode($User);
	
}
else
	echo json_encode($User);
?>
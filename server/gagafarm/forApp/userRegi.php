<?php
require_once('../common/mysqlconn.php');
$userName=trim(htmlspecialchars($_POST['userName'],ENT_COMPAT,"UTF-8"));
$password=trim(htmlspecialchars($_POST['password'],ENT_COMPAT,"UTF-8"));
//$email=trim(htmlspecialchars($_POST['email'],ENT_COMPAT,"UTF-8"));
//$mobilePhone=trim(htmlspecialchars($_POST['mobilePhone'],ENT_COMPAT,"UTF-8"));
//$telephone=trim(htmlspecialchars($_POST['telephone'],ENT_COMPAT,"UTF-8"));
//$qq=trim(htmlspecialchars($_POST['qq'],ENT_COMPAT,"UTF-8"));
//$msn=trim(htmlspecialchars($_POST['msn'],ENT_COMPAT,"UTF-8"));
$email="56@qq.com";
$mobilePhone="1110";
$telephone="134424";
$qq="2334qq";
$msn="1342msn";
$isAdmin=0;
date_default_timezone_set('Etc/GMT-8'); 
$lastVisit=date('Y-m-d H:i');//echo $lastVisit;
$sql="insert into user (userName,password,isAdmin,email,mobilePhone,telephone,qq,msn,lastVisit ) values('$userName','$password',$isAdmin,'$email','$mobilePhone','$telephone','$qq','$msn','$lastVisit') ";
//echo $sql;
$result=$db->query($sql);
if($result){
	$response["success"] = 1;
	$response["message"]="恭喜，注册成功。";
	echo  json_encode($response);
}
else{
	$response["success"] = 0;
	$response["message"]="对不起，注册不成功。";
	echo  json_encode($response);
	
}
?>

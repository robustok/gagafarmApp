<?php
session_start(); 
getCode(4,60,20); 
 
function getCode($num,$w,$h) { 
    $code = ""; 
    for ($i = 0; $i < $num; $i++) { 
        $code .= rand(0, 9); 
    } 
    //4λ��֤��Ҳ������rand(1000,9999)ֱ������ 
    //�����ɵ���֤��д��session������֤ʱ�� 
    $_SESSION["valiNum"] = $code; 
    //����ͼƬ��������ɫֵ 
    header("Content-type: image/PNG;"); //
    $im = imagecreate($w, $h); 
    $black = imagecolorallocate($im, 0, 0, 0); 
    $gray = imagecolorallocate($im, 200, 200, 200); 
    $bgcolor = imagecolorallocate($im, 255, 255, 255); 
    //��䱳�� 
    imagefill($im, 0, 0, $gray); 
 
    //���߿� 
    imagerectangle($im, 0, 0, $w-1, $h-1, $black); 
 
    //��������������ߣ���������� 
    $style = array ($black,$black,$black,$black,$black, 
        $gray,$gray,$gray,$gray,$gray 
    ); 
    imagesetstyle($im, $style); 
    $y1 = rand(0, $h); 
    $y2 = rand(0, $h); 
    $y3 = rand(0, $h); 
    $y4 = rand(0, $h); 
    imageline($im, 0, $y1, $w, $y3, IMG_COLOR_STYLED); 
    imageline($im, 0, $y2, $w, $y4, IMG_COLOR_STYLED); 
 
    //�ڻ�����������ɴ����ڵ㣬���������; 
    for ($i = 0; $i < 80; $i++) { 
        imagesetpixel($im, rand(0, $w), rand(0, $h), $black); 
    } 
    //�����������ʾ�ڻ�����,�ַ���ˮƽ����λ�ö���һ��������Χ������� 
    $strx = rand(3, 8); 
    for ($i = 0; $i < $num; $i++) { 
        $strpos = rand(1, 6); 
        imagestring($im, 5, $strx, $strpos, substr($code, $i, 1), $black); 
        $strx += rand(8, 12); 
    } 
    Imagepng($im);//���ͼƬ 
    Imagedestroy($im);//�ͷ�ͼƬ��ռ�ڴ� 
} 
?>
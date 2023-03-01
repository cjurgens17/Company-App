<?php

if(isset($_POST['contact_btn'])){
        $name=$_POST['user_name'];
        $email=$_POST['user_email'];
        $subject=$_POST['user_subject'];
        $msg=$_POST['user_msg'];
        $to="ctest6092@gmail.com";
        $header="from:$email";
        if(mail($to,$subject,$msg,$header)){
            $msg1="Message submitted
            successfully";

        }
}
?>
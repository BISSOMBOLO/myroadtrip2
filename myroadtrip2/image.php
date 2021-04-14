<?php
set_include_path("./source");
require_once("Routeur.php");
$imageStor=new ImageStorageMysql();
$userStor=new UserStorageMysql();
$routeur = new Routeur();
$routeur->main($imageStor,$userStor);
 ?>

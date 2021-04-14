<?php
require_once("view/Vue.php");
require_once("control/Controleur.php");
require_once("Model/Image.php");
require_once("Model/ImageStorage.php");
require_once("Model/ImageStorageIpl.php");
require_once("Model/ImageStorageFile.php");
require_once("Model/ImageStorageMysql.php");
require_once("FileStore.php");
require_once("Model/ImageBuilder.php");
require_once("Model/User.php");
require_once("Model/UserBuilder.php");
require_once("Model/UserStorageMysql.php");

class Routeur
{
  function __construct(){}

  public function main(ImageStorage $imageStor, UserStorageMysql $userStor){
    session_start();
    $feedback = key_exists('feedback', $_SESSION) ? $_SESSION['feedback'] :"";
		$_SESSION['feedback'] = "";
    $state=key_exists("connected",$_SESSION);
    $vue = new Vue("","","",$this,$feedback,$state);
    $controleur=new Controleur($vue,$imageStor,$userStor);
    if(key_exists("id", $_GET))
    {
      if (key_exists("action", $_GET))
      {
        if($_GET["action"]=="supprimer" )
        {
          $controleur->AskImageDeletion($_GET['id']);
        }
        elseif ($_GET["action"]=='modifier') {
          $controleur->editImage($_GET["id"]);
        }
        elseif ($_GET["action"]=='saveModif') {
          $controleur->saveEditImage($_GET["id"],$_POST,$_FILES['photo']);
        }
      }
      else
        $controleur->ShowInformation($_GET["id"]);
    }
    elseif (key_exists("liste", $_GET)) {
      $controleur->showImageListe();
    }
    elseif (key_exists("userListe",$_GET)) {
      $controleur->showUserImageListe();
    }
    elseif (key_exists("action", $_GET))
    {
      if($_GET["action"]=='nouveau')
      {

        $controleur->newImage();
      }
      elseif ($_GET["action"]=='sauver' )
      {
        $controleur->saveNewImage($_POST,$_FILES['photo']);
      }
      elseif ($_GET["action"]=='delete')
      {
        $controleur->deleteImage($_POST["id"]);
      }
      elseif ($_GET["action"]=="login") {
        $controleur->makeConnexionPage();
      }
      elseif ($_GET["action"]=="creerUser") {
        $controleur->NewUser();
      }
      elseif ($_GET["action"]=="SauverUser") {
        $controleur->saveNewUser($_POST);
      }
      elseif ($_GET['action']=='connecte') {
        $controleur->connected($_POST);
      }

      elseif ($_GET['action']=="deconnexion") {
        $controleur->disconnecte();
      }
      elseif ($_GET['action']=="apropos") {
        $controleur->makeApropoPage();
      }

    }
    $vue->render();
  }
  //url de la page d'acceuil
  public function getAcceuilUrl(){
    return "image.php?";
  }

  //url affichage d'une image
  public function getImageUrl($id){
    return "image.php?id=$id";
  }

  //affichage de la liste des images
  public function getImageListe()
  {
    return "image.php?liste";
  }

  //affichage de la liste des images d'un utilistateur
  public function getUserImageListe()
  {
    return "image.php?userListe";
  }
  //url creation d'une nouvelle image
  public function getCreateNewUrl()
  {
    return "image.php?action=nouveau";
  }

  //url enregistrement d'une nouvelle image
  public function getSaveNewUrl()
  {
    return "image.php?action=sauver";
  }

  //confimation de la Suppression
  public function getConfirmeDelationUrl($id)
  {
    return "image.php?id=$id&amp;action=supprimer";
  }

  //Suppression d'une image
  public function getDelationUrl()
  {
    return "image.php?action=delete";
  }

  //modifier une image
  public function getEditUrl($id)
  {
    return "image.php?id=$id&amp;action=modifier";
  }

  //enregistrement des modifs
  public function getUpdateSaveUrl($id)
  {
    return "image.php?id=$id&amp;action=saveModif";
  }

  public function getLoginUrl()
  {
    return "image.php?action=login";
  }

  public function getSigInUrl()
  {
    return "image.php?action=creerUser";
  }

  public function getSaveNewUserUrl()
  {
    return "image.php?action=SauverUser";
  }

  public function getConnectedUrl(){
    return "image.php?action=connecte";
  }

  public function getConnectedSuccessUrl(){
    return "image.php?action=connected";
  }
  public function getDisconnectedUrl(){
    return "image.php?action=deconnexion";
  }
  public function getAproposUrl(){
    return "image.php?action=apropos";
  }

  //POSTredirect
  public function POSTredirect($url, $feedback)
  {
    $_SESSION["feedback"]=$feedback;
    header("Location: ".htmlspecialchars_decode($url), true, 303);
		die;
  }
}
?>

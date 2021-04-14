<?php
/**
 *
 */
class UserBuilder
{
  private $data;
  private $erreur;
  function __construct($data=null)
  {
    if($data==null)
    {
      $data = array('nom'=>"",'prenom'=>"",'mail'=>"",'password'=>"",);
    }
    $this->data = $data;
    $this->erreur =array('nom'=>"",'prenom'=>"",'mail'=>"","password"=>"");
  }
  public function getData(){return $this->data;}
  public function getErreur(){return $this->erreur;}

  public function createUser( array $data)
  {
    $password = $data['password'];
    $password = password_hash($password, PASSWORD_BCRYPT);
    $user = new User($data["nom"],$data["prenom"],$data["mail"],$password);
    return $user;
  }

  public function isValid()
  {
    $valid=true;
    if(key_exists("nom",$this->data) && key_exists("prenom",$this->data)
       && key_exists("mail",$this->data) && key_exists("password",$this->data))
    {
      $this->erreur=array('nom'=>"",'prenom'=>"",'mail'=>"",);
      if($this->data["nom"]=="")
      {
        $this->erreur["titre"]="champs non renseigné";
        $valid=false;
      }
      if($this->data["prenom"]=="")
      {
        $this->erreur["prenom"]="champs non renseigné";
        $valid=false;
      }
      if($this->data["mail"]=="")
      {
        $this->erreur["mail"]="champs non renseigné";
        $valid=false;
      }
      if($this->data["password"]=="")
      {
        $this->erreur["password"]="champs non renseigné";
        $valid=false;
      }
    }
    else {
      $valid=false;
    }
    return $valid;
  }
}
 ?>

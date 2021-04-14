<?php
/**
 *
 */
class User
{
  private $nom;
  private $prenom;
  private $mail;
  private $password;

  function __construct($nom,$prenom,$mail,$password)
  {
 
    $this->nom = $nom;
    $this->prenom = $prenom;
    $this->mail = $mail;
    $this->password = $password;;
  }

    //accesseurs
    public function getNom(){return $this->nom;}
    public function getPrenom(){return $this->prenom;}
    public function getMail(){return $this->mail;}
    public function getPassword(){return $this->password;}


    //mutateur
    public function setNom($nom){ $this->nom=$nom;}
    public function setPrenom($prenom){$this->prenom=$prenom;}
    public function setMail($mail){$this->mal=$mail;}
    public function setPassword($password){$this->password = $password;}

}

 ?>

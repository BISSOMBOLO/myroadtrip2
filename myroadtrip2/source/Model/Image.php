<?php
/**
 *
 */
class Image
{
  private $titre;
  private $date_prise;
  private $description;
  private $lieu;
  private $pays;
  private $user_mail;
  private $photo;
  function __construct($titre,$date_prise,$description,$lieu,$pays,$user_mail,$photo)
  {
    $this->titre = $titre;
    $this->date_prise = $date_prise;
    $this->description = $description;
    $this->lieu=$lieu;
    $this->pays = $pays;
    $this->user_mail = $user_mail;
    $this->photo = $photo;
  }

  //accesseurs
  public function getTitre(){return $this->titre;}
  public function getDate(){return $this->date_prise;}
  public function getDescription(){return $this->description;}
  public function getLieu(){return $this->lieu;}
  public function getPays(){return $this->pays;}
  public function getUserMAil(){return $this->user_mail;}
  public function getPhoto(){return $this->photo;}

  //mutateur
  public function setTitre($titre){$this->titre=$titre;}
  public function setDate($date_prise){$this->date_prise=$date_prise;}
  public function setDescription($description){$this->description=$description;}
  public function setLieu($lieu){$this->lieu=$lieu;}
  public function setPays($pays){ $this->pays=$pays;}
  public function setUserMAil($user_mail){ $this->user_mail = $user_mail;}
  public function setPhoto($photo){ $this->photo = $photo;}
}

 ?>

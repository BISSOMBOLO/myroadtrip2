<?php
/**
 *
 */
class ImageBuilder
{
  private $data;
  private $erreur;
  private $photo;
  function __construct($data=null)
  {
    if($data==null)
    {
      $data = array("titre"=>"","date_prise"=>"","description"=>"","lieu"=>"","pays"=>"",'user_mail'=>"",'photo'=>"",);
    }
    $this->data = $data;
    $this->erreur =array('titre'=>"",'description'=>"",'lieu'=>"",'photo'=>"",);
    $this->photo="";
  }
  public function getData(){return $this->data;}
  public function getErreur(){return $this->erreur;}

  public function CreateImage( array $data,$mail)
  {
    $image = new Image($data["titre"],$data["date_prise"],$data["description"]
                    ,$data["lieu"],$data["pays"],$mail,$this->photo);

    return $image;
  }


  public function update($image)
  {
    if (key_exists("titre",$this->data)){
      $image->setTitre($this->data["titre"]);
    }
    if (key_exists("date_prise",$this->data)){
      $image->setDate($this->data["date_prise"]);
    }
    if (key_exists("description",$this->data)){
      $image->setDescription($this->data["description"]);
    }
    if (key_exists("lieu",$this->data)){
      $image->setLieu($this->data["lieu"]);
    }
    if (key_exists("pays",$this->data)){
      $image->setPays($this->data["pays"]);
    }
    if ($this->photo!=="")
    {
      $image->setPhoto($this->photo);
    }
  }



  public function isValid($file)
  {
    $valid=true;
    if(key_exists("titre",$this->data) && key_exists("date_prise",$this->data)
       && key_exists("description",$this->data) &&key_exists( "lieu",$this->data)
       && key_exists("pays",$this->data))
    {
      $this->erreur=array('titre'=>"",'description'=>"",'lieu'=>"",);
      if($this->data["titre"]=="")
      {
        $this->erreur["titre"]="champs non renseigné";
        $valid=false;
      }
      if($this->data["description"]=="")
      {
        $this->erreur["description"]="champs non renseigné";
        $valid=false;
      }
      if($this->data["lieu"]=="")
      {
        $this->erreur["lieu"]="champs non renseigné";
        $valid=false;
      }
      if($this->data["pays"]=="")
      {
        $this->data["pays"]="Inconnu";
      }
      if(!$this->imageValide($file))
      {
        $valid=false;
      }
    }
    else {
      $valid=false;
    }
    return $valid;
  }

  public function imageValide(array $file)
  {

    $MAX_TAILLE=1024*1024*2;
    $extention_autorises = array('jpg'=>'photo/jpg','jpeg'=>'photo/jpeg','png'=>'photo/png');
    if($file['name']==="")
    {
      return true;
    }
    if ($file['error'] == 0)
    {
        $name = $file['name'];
        $extention = pathinfo($name, PATHINFO_EXTENSION);
        $typeFichier = $file['type'];
        $taille = $file['size'];
        if (!key_exists($extention, $extention_autorises))
        {
          $this->erreur['photo']="ce format n'est pas pris en compte";
          return false;
        }
        //verification de la taille de l'image
        if ($taille > $MAX_TAILLE)
        {
          $this->erreur['photo']="la taille d l'image de doit de passé 2Mo";
          return false;
        }

        //verification du type MIME
        if (in_array($typeFichier, $extention_autorises))
        {
          $name = 'photo'.$this->imageName().'.'.$extention;
          $target_path = getcwd(). DIRECTORY_SEPARATOR .'upload'. DIRECTORY_SEPARATOR . $name;
          move_uploaded_file($file["tmp_name"], $target_path);
          $this->photo='upload'. DIRECTORY_SEPARATOR . $name;
          return true;
        }
        else
        {
          $this->erreur['photo']='telecharment de fichier echoué';
          return false;
        }
        $this->erreur="Erreur".$file['erreur'];
        return false;
      }

    }

    private function imageName(){
     return (new DateTime())->format('Y-m-H-i-s');
   }
}
 ?>

<?php
/* Construit une nouvelle instance, qui s'enregistrera
* dans le fichier donné en paramètre. */
/**
 *
 */
class ImageStorageFile implements ImageStorage
{
  private $db;
  private $nextId;
  public function __construct($file) {
  $this->filestore = new FileStore($file);
  if (file_exists($file)) {
    /* le fichier existe : on récupère notre tableau
     * et notre nextId, qui y ont été stockés */
    $storedData = $this->filestore->loadData();
    $this->db = $storedData['db'];
    $this->nextId = $storedData['nextId'];
  } else {
    /* le fichier n'existe pas, on crée une «base» vide */
    $this->db = array();
    $this->nextId = 1;
  }
  }
  /* Enregistre la base dans le fichier avant de détruire l'instance. */
  public function __destruct() {
  $dataToBeStored = array('db' => $this->db, 'nextId' => $this->nextId);
  $this->filestore->saveData($dataToBeStored);
  }


  public function reinit(){
    $this->db=array(
      '1' => new Image("Trip1","2018-12-10","image de montagne","Caen","France","",""),
      '2' => new Image("Trip2","2011-04-15","image de palapala","Yaounde","Cameroun","",""),
      '3' => new Image("Trip3","2017-03-18","image de riviere","Brazzaville","Congo","",""),
      );
  $this->nextId = 4;
  }

  public function read($id)
  {
    if(key_exists($id,$this->db))
      {
        return $this->db[$id];
      }
    else
      {
        return null;
      }
    }

  public function readAll()
  {
    return $this->db;
  }

  public function createImage(Image $image)
  {
    $id = $this->nextId;
    $this->db[$id]=$image;
    $this->nextId+=1;
    return $id;
  }


  public function delete($id)
  {
    unset($this->db[$id]);
  }


  public function modifier(Image $image,$id){
    if(key_exists($id, $this->db))
    {
      $this->bd[$id]=$image;
      return true;
    }
    return false;

  }
}
 ?>

<?php
/**
 *
 */
class ImageStorageIpl implements ImageStorage
{
  private $images;
  function __construct()
  {
    $this->images = array(
      '1' => new Image("Trip1","2018-12-10","image de montagne","Caen","France","",""),
      '2' => new Image("Trip2","2011-04-15","image de palapala","Yaounde","Cameroun","",""),
      '3' => new Image("Trip3","2017-03-18","image de riviere","Brazzaville","Congo","",""),
  );
  }
  public function read($id){
    if(key_exists($id,$this->images))
      {
        return $this->images[$id];
      }
    else
      {
        return null;
      }
    }

  public function readAll()
  {
    return $this->images;
  }
  public function createImage(Image $images)
  {}
  public function delete($id){}
  public function modifier(Image $images,$id){}
}


 ?>

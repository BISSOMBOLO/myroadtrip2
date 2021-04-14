<?php
/**
 *
 */
class ImageStorageMysql implements ImageStorage
{
  private $bd;
  function __construct()
  {
    $dsn='mysql:host=mysql.info.unicaen.fr;port=3306;dbname=21911856_bd';
    $this->bd = new PDO($dsn,"21911856","AeghoozaevahQua5");
    $this->bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  }


  public function read($id)
  {
    try{
          $rq= 'select * from image where id = '.$id.';';
          $stmt= $this->bd->prepare($rq);
          $stmt->execute();
          $stmt->setFetchMode(PDO::FETCH_OBJ);
          if(($resultat=$stmt->fetch())!==false)
          {
            $image = new Image($resultat->titre,$resultat->date_prise,$resultat->description
                            ,$resultat->lieu,$resultat->pays,$resultat->mail_user,$resultat->photo);
            return ($image);
          }
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
  }


  public function readAll()
  {
    try{
          $rq= 'select * from image ;';
          $stmt= $this->bd->prepare($rq);
          $stmt->execute();
          $stmt->setFetchMode(PDO::FETCH_OBJ);
          $data = array();
          while(($resultat=$stmt->fetch())!==false)
          {
            $data[$resultat->id] = new Image($resultat->titre,$resultat->date_prise,$resultat->description
                            ,$resultat->lieu,$resultat->pays,$resultat->mail_user,$resultat->photo);
          }
          return $data;
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
  }
  public function readUserImage($mail)
  {
    try{
          $rq= 'select * from image where mail_user = "'.$mail.'";';
          $stmt= $this->bd->prepare($rq);
          $stmt->execute();
          $stmt->setFetchMode(PDO::FETCH_OBJ);
          $data = array();
          while(($resultat=$stmt->fetch())!==false)
          {
            $data[$resultat->id] = new Image($resultat->titre,$resultat->date_prise,$resultat->description
                            ,$resultat->lieu,$resultat->pays,$resultat->mail_user,$resultat->photo);
          }
          return $data;
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
  }
  public function createImage(Image $image)
  {
    try{
          $rq = 'insert into image(titre,date_prise,description,lieu,pays,mail_user,photo)
                values(:titre,:date_prise,:description,:lieu,:pays,:mail_user,:photo)';
          $stmt= $this->bd->prepare($rq);
          $stmt->bindParam(':titre',$image->getTitre());
          $stmt->bindParam(':date_prise',$image->getDate());
          $stmt->bindParam(':description',$image->getDescription());
          $stmt->bindParam(':lieu',$image->getLieu());
          $stmt->bindParam(':pays',$image->getPays());
          $stmt->bindParam(':mail_user',$image->getUserMAil());
          $stmt->bindParam(':photo',$image->getPhoto());
          $stmt->execute();
          $id = $this->bd->lastInsertId();
          $data = $stmt->setFetchMode(PDO::FETCH_OBJ);

          return $id;
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
  }


  public function delete($id)
  {
    try{
          $rq= 'delete from image where id = '.$id.';';
          $stmt= $this->bd->prepare($rq);
          $stmt->execute();
          $stmt->setFetchMode(PDO::FETCH_OBJ);
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
  }


  public function modifier(Image $image,$id)
  {
    try{
          $rq = 'UPDATE image SET id=:id, titre =:titre, date_prise=:date_prise,
                description=:description,lieu=:lieu,pays= :pays
                ,photo=:photo WHERE id ='.$id.';';
          $stmt= $this->bd->prepare($rq);
          $stmt->bindParam(':id',$id);
          $stmt->bindParam(':titre',$image->getTitre());
          $stmt->bindParam(':date_prise',$image->getDate());
          $stmt->bindParam(':description',$image->getDescription());
          $stmt->bindParam(':lieu',$image->getLieu());
          $stmt->bindParam(':pays',$image->getPays());
          $stmt->bindParam(':photo',$image->getPhoto());
          $stmt->execute();
          $data=$stmt->setFetchMode(PDO::FETCH_OBJ);
          return true;
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
    return false;
  }
}
 ?>

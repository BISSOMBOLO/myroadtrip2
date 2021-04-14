<?php
/**
 *
 */
class UserStorageMysql
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
          $rq= 'select * from users where mail = "'.$id.'";';
          $stmt= $this->bd->prepare($rq);
          $stmt->execute();
          $stmt->setFetchMode(PDO::FETCH_OBJ);
          if(($resultat=$stmt->fetch())!==false)
          {
            $user = new User($resultat->nom,$resultat->prenom
                            ,$resultat->mail,$resultat->password);
            return ($user);
          }
          else {
            return null;
          }
        }
      catch(Exception $e)
      {
        echo $e->getMessage();
      }
  }

  public function createUser(User $user)
  {
    try{
          $id=1;
          $rq = 'insert into users(nom,prenom,mail,password)
                values(:nom,:prenom,:mail,:password)';
          $stmt= $this->bd->prepare($rq);
          $stmt->bindParam(':nom',$user->getNom());
          $stmt->bindParam(':prenom',$user->getPrenom());
          $stmt->bindParam(':mail',$user->getMail());
          $stmt->bindParam(':password',$user->getPassword());
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

}



 ?>

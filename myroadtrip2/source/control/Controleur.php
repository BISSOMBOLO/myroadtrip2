<?php

/**
 *
 */
class Controleur
{
  private $vue;
  private $imageStorage;
  private $userStor;
  private $currentImageBuilder;
  private $currentUserBuilder;
  /*
  ***************CONSTRUCTEUR******************
  */
  function __construct(Vue $vue, ImageStorage $imageStorage, UserStorageMysql $userStor)
  {
    $this->vue = $vue;
    $this->imageStorage = $imageStorage;
    $this->userStor = $userStor;
    $this->currentImageBuilder = key_exists('currentImageBuilder', $_SESSION) ?
      $_SESSION['currentImageBuilder'] : null;

    $this->currentImageEditBuilder = key_exists('currentImageEditBuilder', $_SESSION) ?
      $_SESSION['currentImageEditBuilder'] : array();

    $this->currentUserBuilder = key_exists('currentUserBuilder', $_SESSION) ?
      $_SESSION['currentUserBuilder'] : null;
  }

  /*
  ***************DESTRUCTEUR******************
  */
  public function __destruct()
  {
    $_SESSION['currentImageBuilder'] = $this->currentImageBuilder;

    $_SESSION['$currentUserBuilder'] = $this->currentUserBuilder;
  }

  /*
  ***************AFFICHAGE D'UNE IMAGE******************
  */
  public function ShowInformation($id)
  {
    if ($id) {
      $image = $this->imageStorage->read($id);
      if ($image != null) {
        $this->vue->makeImagePage($image, $id);
      }
    } else {
      $this->vue->makeAcceuilpage();
    }
  }

  /*
  *******AFFICHAGE DE LA LISTE DES IMAGES***********
  */
  public function showImageListe()
  {
    $this->vue->makeImageListePage($this->imageStorage->readAll());
  }


  public function showUserImageListe()
  {

    $mail = key_exists('connected', $_SESSION) ? $_SESSION['connected']->getMail() : null;
    if ($mail) {
      $this->vue->makeImageListePage($this->ImageStorage->readUserImage($mail));
    } else {
      $this->vue->displayNotConnected();
    }
  }
  /*
  ***************CREATION D'IMAGE******************
  */
  public function newImage()
  {
    if ($this->currentImageBuilder === null) {
      $this->currentImageBuilder = new ImageBuilder();
    }
    if (key_exists('connected', $_SESSION)) {
      $this->vue->makeImageCreationPage($this->currentImageBuilder);
    } else {
      $this->vue->displayNotConnected();
    }
  }

  /*
  ********ENREGISTREMENT D'UNE IMAGE AJOUTÉE************
  */
  public function saveNewImage(array $data, $file)
  {
    $this->currentImageBuilder = new ImageBuilder($data);
    if ($this->currentImageBuilder->isValid($file)) {
      $image = $this->currentImageBuilder->createImage($data, $_SESSION['connected']->getMail());
      $id = $this->imageStorage->createImage($image);
      $this->currentImageBuilder = null;
      $this->vue->displayImageCreationSuccess($id);
    } else {
      $this->vue->displayImageCreationfaild();
    }
  }

  /*************************************************
  /  CONFIRMATION DE SUPRESSION D'UNE IMAGE
  /**************************************************/
  public function AskImageDeletion($id)
  {
    $ok = $this->imageStorage->read($id);
    if ($ok !== null) {
      $image = $this->imageStorage->read($id);
      $this->vue->makeImageDelationPage($id, $image);
    } else {
      $this->vue->makeAcceuilpage();
    }
  }

  /***********************************
  /    SUPRESSION D'UNE IMAGE
   ************************************/
  public function deleteImage($id)
  {
    if (key_exists('connected', $_SESSION)) {
      $user = $_SESSION['connected'];
      $image = $this->imageStorage->read($id);
      if ($image->getUserMAil() === $user->getMail()) {
        $this->imageStorage->delete($id);
        $this->vue->displayImageDeleted();
      } else {
        $this->vue->displayCantDelete($id);
      }
    } else {
      $this->vue->displayNotConnected();
    }
  }

  /***********************************
  /    MODIFICATION D'UNE IMAGE
   ************************************/
  public function editImage($id)
  {
    if (key_exists('connected', $_SESSION)) {
      $user = $_SESSION['connected'];
      $image = $this->imageStorage->read($id);
      if ($image !== null) {
        if ($image->getUserMAil() == $user->getMail()) {
          $data = array(
            "titre" => $image->getTitre(), "date_prise" => $image->getDate(),
            "description" => $image->getDescription(), "lieu" => $image->getLieu(),
            "pays" => $image->getPays(),
          );
          $this->vue->makeImageUpdatePage(new ImageBuilder($data), $id);
        } else {
          $this->vue->displayCantEdit($id);
        }
      } else {
        $this->vue->makeImageCreationPage(new ImageBuilder());
      }
    } else {
      $this->vue->displayNotConnected();
    }
  }

  /*************************************************
  /    ENREGISTREMENT DE LA MODIFICATION D'UNE IMAGE
   **************************************************/
  public function saveEditImage($id, array $data, $file)
  {
    $image = $this->imageStorage->read($id);
    if ($image == null) {
      $this->vue->makeAcceuilpage;
    } else {
      $builder = new ImageBuilder($data);
      if ($builder->isValid($file)) {
        $builder->update($image);
        $ok = $this->imageStorage->modifier($image, $id);
        if ($ok) {
          $this->vue->displayImageEdited($id);
        }
      } else {
        $this->vue->displayImageEditionFailed($id);
      }
    }
  }


  /***********************************
    /    CREATION D'UN UTILISATEUR
   ************************************/
  public function newUser()
  {
    if ($this->currentUserBuilder === null) {
      $this->currentUserBuilder = new UserBuilder();
    }
    $this->vue->makeSigInPage($this->currentUserBuilder);
  }


  /*****************************************
    /    ENREGISTREMENT DU NOUVEL UTILISATEUR
   ******************************************/
  public function saveNewUser(array $data)
  {
    $this->currentUserBuilder = new UserBuilder($data);
    if ($this->currentUserBuilder->isValid()) {
      $user = $this->currentUserBuilder->createUser($data);
      $id = $this->userStor->createUser($user);
      $this->currentUserBuilder = null;
      $this->vue->displayUserCreationSuccess();
    } else {
      $this->vue->displayUserCreationFaild();
    }
  }

  /***********************************
    /    CONNEXION
   ************************************/
  public function connected($data)
  {
    $user = $this->userStor->read($data['login']);
    if ($user === null) {
      $this->vue->displayLoginFaild();
    } else {
      if (password_verify($data['password'], $user->getPassword())) {
        $_SESSION['connected'] = $user;
        $this->vue->setState(false);
        $this->vue->displayConnected($user);
      } else {
        $this->vue->displayLoginFaild();
      }
    }
  }

  /***********************************
    /    DECONNEXION
   ************************************/
  public function disconnecte()
  {
    unset($_SESSION['connected']);
    $this->vue->displayeDisconnectedPage();
  }

  /***********************************
    /    AFFICHAGE PAGE DE CONNEXION
   ************************************/
  public function makeConnexionPage()
  {
    $this->vue->makeLoginPage();
  }

  /***********************************
    /    AFFICHAGE DE LA PAGE D'INSCRIPTION
   ************************************/
  public function makeSigInPage()
  {
    $this->vue->makeSigInPage($this->currentUserBuilder);
  }

  public function makeApropoPage()
  {
    $this->vue->makeApropoPage();
  }
}

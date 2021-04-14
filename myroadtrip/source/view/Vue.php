<?php
class Vue
{
  private $titre;
  private $contenu;
  private $menu;
  private $routeur;
  private $feedback;
  private $state;
  private $apropos;
  function __construct($titre, $contenu, $menu, $routeur, $feedback, $state)
  {
    $this->titre = $titre;
    $this->contenu = $contenu;
    $this->menu = $menu;
    $this->routeur = $routeur;
    $this->feedback = $feedback;
    $this->state = $state;
    $this->apropos = "";
  }

  public function setState($state)
  {
    $this->state = $state;
  }
  public function render()
  {
    if ($this->titre == null and $this->contenu == null and $this->menu == null) {
      $this->makeAcceuilpage();
    }
    $titre = $this->titre;
    $contenu = $this->contenu;
    $menu = $this->menu;
    $feedback = $this->feedback;
    $apropos = $this->apropos;
    include("squelette.php");
  }

  //La fonction de creation de la page d'acceuil
  public function makeAcceuilpage()
  {
    $this->titre = "Acceuil";
    $this->contenu = "Bienvenue sur le site MyRoadTrip";
    $this->menu = $this->getMenu();
  }

  public function makeImagePage(Image $image, $id)
  {
    $this->titre = $image->getTitre();
    $this->contenu = $this->getContenu($image, $id);
    $this->menu = $this->getMenu();
    $this->apropos = '<a href="' . $this->routeur->getAproposUrl() . '">Apropos</a>';
  }

  public function makeImageListePage(array $images)
  {
    $this->titre = "My RoadTrip";
    $this->menu = $this->getMenu();
    $this->contenu = "<ul class = \"liste_image\">";
    foreach ($images as $id => $image) {
      $this->contenu .= '<li><a href = "' . $this->routeur->getImageUrl($id) . '">
          <div class = liste>
              <p>
               Titre: ' . $image->getTitre() . '<br>pays: ' . $image->getPays() . '<br>date_prise: ' . $image->getDate() . '</p>
              <img src="' . $image->getPhoto() . '" alt="insere_image">
            </div></a></li>';
    }
    $this->contenu .= "</ul>";
    $this->apropos = '<a href="' . $this->routeur->getAproposUrl() . '">Apropos</a>';
  }

  public function makeImageCreationPage(ImageBuilder $imageBuilder)
  {

    $this->titre = 'Ajout d\'une nouvelle image';
    $this->contenu = '<form method="post" action ="' . $this->routeur->getSaveNewUrl() . '" enctype="multipart/form-data">';
    $this->contenu .= $this->getImageForm($imageBuilder);
    $this->contenu .= '<input type ="submit" value= "Ajouter"></form>';
    $this->menu = $this->getMenu();
    $this->apropos = '<a href="' . $this->routeur->getAproposUrl() . '">Apropos</a>';
  }

  public function makeImageDelationPage($id, Image $image)
  {
    $titre = $image->getTitre();
    $this->titre = "Suppression de $titre";
    $this->menu = $this->getMenu();
    $this->apropos = '<a href="' . $this->routeur->getAproposUrl() . '">Apropos</a>';
    $this->contenu = '<h2> Vous êtes sur le point de supprimer ' . $titre . '</h2>'
      . '<p>Êtes-vous sûr de bien vouloir supprimer' . $titre . '?</p>'
      . '<form method = "post" action ="' . $this->routeur->getDelationUrl() . '">'
      . '<input type="hidden" name = "id" value = ' . $id . '>'
      . '<input type = "submit" value = Confirmer> </form>';
  }


  public function makeImageUpdatePage(ImageBuilder $imageBuilder, $id)
  {
    $this->titre = 'Modification d\'image "' . $imageBuilder->getData()["titre"] . '"';
    $this->contenu = '<form method="post" action ="' . $this->routeur->getUpdateSaveUrl($id) . '" enctype="multipart/form-data">';
    $this->contenu .= $this->getImageForm($imageBuilder);
    $this->contenu .= '<input type ="submit" value= Modifier </input> </form>';
    $this->menu = $this->getMenu();
    $this->apropos = '<a href=' . $this->routeur->getAproposUrl() . '>Apropos</a>';
  }

  public function makeLoginPage()
  {

    $this->titre = "Connexion";
    $this->contenu = $this->makeAuthenticationForm();
    $this->menu = $this->getMenu();
  }

  public function makeSigInPage(UserBuilder $userBuilder)
  {
    $this->titre = "Inscription";
    $this->contenu = $this->getSigInForm($userBuilder);
    $this->menu = $this->getMenu();
    $this->apropos = '<a href="' . $this->routeur->getAproposUrl() . '">Apropos</a>';
  }

  //les methode display avec POSTredirect

  public function displayImageCreationSuccess($id)
  {
    $feedback = "Image créé avec succés!";
    $this->routeur->POSTredirect($this->routeur->getImageUrl($id), $feedback);
  }

  public function displayImageCreationfaild()
  {
    $feedback = "Image non créé! Renseignez tout les champs";
    $this->routeur->POSTredirect($this->routeur->getCreateNewUrl(), $feedback);
  }

  public function displayImageDeleted()
  {
    $feedback = "L\'image a été supprimée!";
    $this->routeur->POSTredirect($this->routeur->getImageListe(), $feedback);
  }

  public function displayImageEditionFailed($id)
  {
    $feedback = "Image non modifié! Remplisser bien le formulaire";
    $this->routeur->POSTredirect($this->routeur->getEditUrl($id), $feedback);
  }

  public function displayImageEdited($id)
  {
    $feedback = "Image modifié avec succès";
    $this->routeur->POSTredirect($this->routeur->getImageUrl($id), $feedback);
  }

  public function displayUserCreationSuccess()
  {
    $feedback = "votre compte a été crée! Connecter vous!";
    $this->routeur->POSTredirect($this->routeur->getLoginUrl(), $feedback);
  }
  public function displayUserCreationFaild()
  {
    $feedback = "Erreur renseignez bien les Champs";
    $this->routeur->POSTredirect($this->routeur->getSigInUrl(), $feedback);
  }

  public function displayNotConnected()
  {
    $feedback = "Veuillez d'abord vous connecter!";
    $this->routeur->POSTredirect($this->routeur->getLoginUrl(), $feedback);
  }

  public function displayConnected($user)
  {
    $feedback = 'Bonjour ' . $user->getPrenom() . ' ' . $user->getNom() . '!';
    $this->routeur->POSTredirect($this->routeur->getAcceuilUrl(), $feedback);
  }

  public function displayLoginFaild()
  {
    $feedback = "Login ou mot de passe incorrecte";
    $this->routeur->POSTredirect($this->routeur->getLoginUrl(), $feedback);
  }

  public function displayeDisconnectedPage()
  {
    $feedback = "Vous êtes deconnecté!";
    $this->routeur->POSTredirect($this->routeur->getAcceuilUrl(), $feedback);
  }

  public function displayCantEdit($id)
  {
    $feedback = "Vous ne pouvez pas modifier une image ajoutée par quelqu'un";
    $this->routeur->POSTredirect($this->routeur->getImageUrl($id), $feedback);
  }

  public function displayCantDelete($id)
  {
    $feedback = "Vous ne pouvez supprimer que vos images";
    $this->routeur->POSTredirect($this->routeur->getImageUrl($id), $feedback);
  }
  ////////////GENERATION DE CODE HTML//////////////////
  public function getMenu()
  {
    return '<ul>
        <li><a href="' . $this->routeur->getAcceuilUrl("") . '">Acceuil</a></li>
        <li><a href ="'.$this->routeur->getAproposUrl() . '">Apropos</a></li>
        <li><a href="' . $this->routeur->getImageListe() . '">Liste des RoadTrips</a></li>
        <li><a href="' . $this->routeur->getCreateNewUrl() . '">Ajouter une image</a></li>
        <li><a href="' . $this->routeur->getUserImageListe() . '">Mes RoadTrip</a></li>
        <li class = "auth">' . $this->con_discon() . '</li>
        </ul>';
  }

  public function getContenu($image, $id)
  {
    return  '<img src = "' . htmlspecialchars($image->getPhoto(), ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') . '" alt ="image">'
      . '<p>' . htmlspecialchars($image->getDescription(), ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') . '</p>'
      . '<ul><li>Date de prise:' . htmlspecialchars($image->getDate(), ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') . '</li>'
      . '<li>Lieu:' . htmlspecialchars($image->getLieu(), ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') . '</li>'
      . '<li>Pays:' . htmlspecialchars($image->getPays(), ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') . '</li></ul>'
      . '<ul><li class="valid"><a href = "' . $this->routeur->getConfirmeDelationUrl($id) . '">Supprimer</a></li>'
      . '<li class="valid"><a href ="' . $this->routeur->getEditUrl($id) . '">Modifier</a></li></ul>';
  }

  public function getImageForm($imageBuilder)
  {
    $data = $imageBuilder->getData();
    $erreur = $imageBuilder->getErreur();
    $titre = key_exists("titre", $data) ? htmlspecialchars($data["titre"], ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') : "";
    $date_prise = key_exists("date_prise", $data) ? htmlspecialchars($data["date_prise"], ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') : "";
    $pays = key_exists("pays", $data) ? htmlspecialchars($data["pays"], ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') : "";
    $lieu = key_exists("lieu", $data) ? htmlspecialchars($data["lieu"], ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') : "";
    $description = key_exists("description", $data) ? htmlspecialchars($data["description"], ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') : "";
    $user_mail = key_exists("mail_user", $data) ? htmlspecialchars($data["mail_user"], ENT_QUOTES | ENT_SUBSTITUTE | ENT_HTML5, 'UTF-8') : "";
    return '<label><span class = "label">Titre: </span><input type ="text" name = "titre" value="' . $titre . '"></label><span class ="erreur">' . $erreur["titre"] . '</span><br/>'
      . '<label><span class = "label">Date de prise: </span><input type ="date" name = "date_prise"></label><br/>'
      . '<label><span class = "label">Pays: </span><input type ="text" name = "pays" value="' . $pays . '"></label><br/>'
      . '<label><span class = "label">Lieu: </span><input type ="text" name = "lieu" value="' . $lieu . '"></label><span class ="erreur">' . $erreur["lieu"] . '</span><br/>'
      . '<label><span class = "label" >Description: </span><textarea name = "description">"' . $description . '"</textarea></label><span class ="erreur">' . $erreur["description"] . '</span><br/>'
      . '<input type ="hidden" name = "mail_user" value="' . $user_mail . '">'
      . '<label><span class = "label">Affiche:</span><input type="file" name="photo" ></label><span class = "erreur">' . $erreur["photo"] . '</span><br>';
  }

  public function makeAuthenticationForm()
  {
    return '<form method="post" action ="' . $this->routeur->getConnectedUrl() . '">'
      . '<label><span class = label>Login: </span><input type = "text" name = "login"></label><br>'
      . '<label><span class = label>Password: </span><input type = "password" name = "password"></label><br>'
      . '<input type ="submit" value= Connexion/> </form>'
      . '<a href ="' . $this->routeur->getSigInUrl() . '">S\'inscrire</a>';
  }

  public function getSigInForm($userBuilder)
  {
    $data = $userBuilder->getData();
    $erreur = $userBuilder->getErreur();
    return '<form method="post" action ="' . $this->routeur->getSaveNewUserUrl() . '">'
      . '<label><span class = label>Nom: </span><input type = "text" name = "nom" value=' . $data["nom"] . '></label><span class ="erreur">' . $erreur["nom"] . '</span><br>'
      . '<label><span class = label>Prenom: </span><input type = "text" name = "prenom" value=' . $data["prenom"] . '></label><span class ="erreur">' . $erreur["prenom"] . '</span><br>'
      . '<label><span class = label>Mail: </span><input type = "text" name = "mail" value=' . $data["mail"] . '></label><span class ="erreur">' . $erreur["mail"] . '</span><br>'
      . '<label><span class = label>Password: </span><input type = "password" name = "password"><span class ="erreur">' . $erreur["password"] . '</span</label><br>'
      . '<input type ="submit" value= Creer </input> </form>';
  }

  public function con_discon()
  {
    $choix = $this->state ? "Deconnexion" : "Connexion";
    if ($choix === "Connexion")
      return '<a href ="' . $this->routeur->getLoginUrl() . '">' . $choix . '</a>';
    else
      return '<a href ="' . $this->routeur->getDisconnectedUrl() . '">' . $choix . '</a>';
  }


  //a Propos
  public function makeApropoPage()
  {
    $this->titre = "Apropos";
    $this->contenu = '<strong> La team MyRoad Trip2 <br> <br>LOUA Boniface <br>
                     KABA Sidiki <br>
                     BAMBA Alassane <br>
                      BISSOMBOLO Siega <br>
                    </strong><br>'
      . '<p>Notre projet porte sur My Road Trip .<br> Un site qui permet de partager ses esperiences de voyage. <br>
                    Pour ajouter,modifier ou supprimer une expérience de voyage, l\'utilisateur doit se connecter.<br>
                    Toutes les methodes  du Mvcr et crud vue au premier semestre ont été reprises et adaptées a notre sujet <br>
                    En ce qui est du css nous n\'avons pas fait grand chose et nous n\'avons pas pu bien gerer l\'ajout des images
                     <br><br>  
                     <strong> Voici la repartition des tâches : <br><br></strong> 
                      <strong>LOUA Boniface </strong> et <strong>BISSOMBOLO Siega  <br></strong>  ont géré  le controleur et la vue <br>
                     <strong>KABA Sidiki</strong> et <strong> BAMBA Alassane <br></strong>  ont géré la partie model et routeur<br>
                     <br>
                    </p>';
     $this->menu =  $this->getMenu();
  }
}

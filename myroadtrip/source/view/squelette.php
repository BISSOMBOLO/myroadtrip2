<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
  <link rel="stylesheet" href="skin/style.css" />
    <title><?php echo $titre; ?></title>
  </head>
  <body>

    <header>
      <nav class ="menu" >
        <?php
            echo $menu;
         ?>
      </nav>
    </header>

    <main>
      <div class="feedback"><?php echo "$feedback"; ?></div>
        <h1> <?php echo $titre; ?> </h1>
          <?php echo $contenu; ?>
    </main>

    <footer>
      <?php echo $apropos; ?> 
    </footer>

  </body>
</html>

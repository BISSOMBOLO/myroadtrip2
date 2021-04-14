<?php
/**
 *
 */
interface ImageStorage
{
  public function read($id);
  public function readAll();
  public function createImage(Image $image);
  public function delete($id);
  public function modifier(Image $image,$id);
}

 ?>

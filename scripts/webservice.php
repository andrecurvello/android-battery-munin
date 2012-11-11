<?php

$value = $_GET["value"];
$fp = fopen('../value.txt', 'w');
fwrite($fp, $value);
fclose($fp);

?>

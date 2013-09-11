set d=%date:~0,10%
set d=%d:-=%
set d=%d: =0%
"E:\Program Files\MySQL\MySQL Workbench CE 5.2.34.2\mysqldump" -u root -ppassword -R -c --default-character-set=utf8 --complete-insert --add-drop-table oa > oa%d%.sql
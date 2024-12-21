set /p id=Enter Time: 
set /a id=id*60

echo %id%
java -jar "D:\Personal\Airtel\airtel test.jar" 0
timeout %id%
java -jar "D:\Personal\Airtel\airtel test.jar" 1
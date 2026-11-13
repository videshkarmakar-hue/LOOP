$source = 'C:\Users\vides\.gradle\room-schemas\LOOP-app\com.junkfood.foxin.database.AppDatabase'
$dest = 'C:\Users\vides\.gradle\room-schemas\LOOP-app\com.junkfood.loop.database.AppDatabase'
if (Test-Path $dest) {
    Remove-Item $dest -Recurse -Force
}
Copy-Item $source -Destination $dest -Recurse
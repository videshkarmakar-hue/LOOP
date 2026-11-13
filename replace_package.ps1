$files = Get-ChildItem 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src\main\java' -Filter '*.kt' -Recurse
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $newContent = $content -replace 'com\.junkfood\.foxin', 'com.junkfood.loop'
    Set-Content $file.FullName -Value $newContent
}
$files = Get-ChildItem 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src' -Filter '*.kt' -Recurse
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $newContent = $content -replace 'com\.junkfood\.loop', 'com.videshkarmakar.loop'
    if ($content -ne $newContent) {
        Set-Content $file.FullName -Value $newContent
    }
}
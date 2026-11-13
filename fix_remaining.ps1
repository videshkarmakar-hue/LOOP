$files = Get-ChildItem 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src' -Filter '*.kt' -Recurse
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $newContent = $content -replace 'FoXin built-in WebView', 'LOOP built-in WebView' -replace 'Supporting My Project \u201CFoXin\u201D', 'Supporting My Project \u201CLOOP\u201D'
    if ($content -ne $newContent) {
        Set-Content $file.FullName -Value $newContent
    }
}
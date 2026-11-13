$files = Get-ChildItem 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src' -Filter '*.kt' -Recurse
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $newContent = $content `
        -replace '"FoXin"', '"LOOP"' `
        -replace '"FoXin app icon"', '"LOOP app icon"' `
        -replace '"FoXin App Icon"', '"LOOP App Icon"' `
        -replace '"Thanks for Supporting My Project \u201CFoXin\u201D"', '"Thanks for Supporting My Project \u201CLOOP\u201D"' `
        -replace '"FoXin - Every Day, Every Download, Every Content."', '"LOOP - Every Day, Every Download, Every Content."' `
        -replace '© 2026 FoXin', '© 2026 LOOP' `
        -replace 'Meet the developer behind FoXin', 'Meet the developer behind LOOP' `
        -replace '"FoXin built-in WebView"', '"LOOP built-in WebView"' `
        -replace '\.FoXin', '.LOOP' `
        -replace 'REPO = "FoXin"', 'REPO = "LOOP"' `
        -replace 'Centered FoXin Brand Title', 'Centered LOOP Brand Title' `
        -replace 'FoXin Brand Name', 'LOOP Brand Name' `
        -replace 'Display face reserved for the "FoXin" wordmark', 'Display face reserved for the "LOOP" wordmark'
    if ($content -ne $newContent) {
        Set-Content $file.FullName -Value $newContent
    }
}
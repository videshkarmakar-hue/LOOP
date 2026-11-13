$files = Get-ChildItem 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src' -Filter '*.kt' -Recurse
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $newContent = $content `
        -replace 'FoXinDialog', 'LoopDialog' `
        -replace 'FoXinSearchBar', 'LoopSearchBar' `
        -replace 'FoXinBottomNavigation', 'LoopBottomNavigation' `
        -replace 'FoXinModalBottomSheet', 'LoopModalBottomSheet' `
        -replace 'FoXinModalBottomSheetM2', 'LoopModalBottomSheetM2' `
        -replace 'FoXinModalBottomSheetM3', 'LoopModalBottomSheetM3' `
        -replace 'FoXinTextField', 'LoopTextField' `
        -replace 'FoXinAutoFocusTextField', 'LoopAutoFocusTextField' `
        -replace 'FoXinDialogButtonVariant', 'LoopDialogButtonVariant' `
        -replace 'FoXinDialogVariant', 'LoopDialogVariant'
    if ($content -ne $newContent) {
        Set-Content $file.FullName -Value $newContent
    }
}
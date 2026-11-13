$content = Get-Content 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src\main\java\com\videshkarmakar\loop\ui\page\settings\about\AboutPage.kt' -Raw
$newContent = $content -replace 'AsyncImage\(\s*model = "https://cdn\.phototourl\.com/member/2026-09-29-e7a4ad16-b9c3-4498-b8a9-3386957917a8\.png",\s*contentDescription = "LOOP app icon",\s*modifier = Modifier\s*\.\s*size\(80\.dp\)\s*\.\s*clip\(RoundedCornerShape\(16\.dp\)\)\s*\)', 'Image(
                painter = painterResource(id = R.drawable.ic_about_app_icon),
                contentDescription = "LOOP app icon",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(16.dp))
            )' -replace 'import coil\.compose\.AsyncImage', 'import androidx.compose.foundation.Image' -replace 'import androidx\.compose\.ui\.res\.painterResource', 'import androidx.compose.ui.res.painterResource'
if ($content -ne $newContent) {
    Set-Content 'D:\Android App\Source Code\Seal-1.13.1 - Copy\Seal-1.13.1\app\src\main\java\com\videshkarmakar\loop\ui\page\settings\about\AboutPage.kt' -Value $newContent
    Write-Host "Updated"
} else {
    Write-Host "No changes"
}
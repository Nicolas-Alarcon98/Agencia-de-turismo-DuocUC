# Genera el archivo ejecutable llanquihuetour.jar.
# Uso: ejecutar "powershell -ExecutionPolicy Bypass -File build.ps1" desde esta carpeta.

$ErrorActionPreference = "Stop"

$raiz = Split-Path -Parent $MyInvocation.MyCommand.Path
$codigo = Join-Path $raiz "src"
$salida = Join-Path $raiz "out\production\LlanquihueTourApp"
$jar = Join-Path $raiz "llanquihuetour.jar"

if (Test-Path $salida) {
    Remove-Item $salida -Recurse -Force
}
New-Item -ItemType Directory -Path $salida -Force | Out-Null

$archivos = Get-ChildItem -Path $codigo -Recurse -Filter "*.java" | ForEach-Object { $_.FullName }

& javac -encoding UTF-8 -d $salida $archivos
if ($LASTEXITCODE -ne 0) {
    throw "La compilacion fallo."
}

& jar --create --file $jar --main-class app.Main -C $salida .
if ($LASTEXITCODE -ne 0) {
    throw "No se pudo generar el archivo jar."
}

Write-Host "Listo: $jar"
Write-Host "Para ejecutarlo: java -jar llanquihuetour.jar"

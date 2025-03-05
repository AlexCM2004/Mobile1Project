# Mobile1Project

## Estándar de Codificación para Kotlin
### 1. Nombres de Variables y Constantes
- Todos los nombres deben estar en inglés.
- Usar camelCase para variables.
- Usar SCREAMING_SNAKE_CASE para constantes.
### 2. Nombres de Funciones
- Usar camelCase.
- El nombre debe describir claramente su propósito.
- Si la función realiza una acción, el nombre debe iniciar con un verbo.
### 3. Nombres de Clases
- Usar PascalCase.
- Evitar abreviaciones y utilizar nombres descriptivos.
### 4. Naming Conventions para Arquitectura MVVM
- Vistas terminan con View.
- Modelos terminan con Model.
- ViewModels terminan con ViewModel.
### 5. Uso de Tipos de Datos
- Evitar tipos primitivos innecesarios y utilizar los adecuados.
- Preferir val sobre var si el valor no cambia.
### 6. Formato y Estilo de Código
- Usar el formateador de código de Android Studio para mantener un código limpio.
- Atajo para formatear código:
  - Windows/Linux: Ctrl + Alt + L
  - macOS: Cmd + Option + L
### 7. Comentarios y Documentación
- Usar // para comentarios cortos.
- Usar /** ... */ para documentar funciones y clases.
### 8. Organización del Código
- Declarar variables antes de las funciones.
- Agrupar funciones relacionadas.
### 9. Nombres para Assets de Imágenes
- Usar nombres en inglés.
- Solo minúsculas y guiones bajos (_).
- No usar espacios, caracteres especiales ni mayúsculas.
#### ✅ Ejemplo de nombres correctos:
- icon_profile.png
- bg_splash_screen.jpg
- btn_login_pressed.png
- banner_home.png
- ic_settings.xml
#### ❌ Ejemplo de nombres incorrectos:
- IconProfile.png (No usar mayúsculas)
- BG-SPLASH.JPG (No usar guiones medios)
- button login.png (No usar espacios)
- SettingsIcon.xml (No usar PascalCase)
#### Convenciones recomendadas según tipo de imagen:
| Prefijo | Uso | Ejemplo |
| ------- | --- | ------- |
| ic_	| Íconos |	ic_home.png, ic_settings.xml |
| bg_	| Fondos | bg_splash_screen.jpg |
| btn_ |	Botones |	btn_login_pressed.png |
| banner_ |	Banners	| banner_home.png |

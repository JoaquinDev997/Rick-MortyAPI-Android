# Rick & Morty - Android App

Aplicación móvil desarrollada en Kotlin que consume la API oficial de Rick and Morty para mostrar personajes.

## Capturas

<div align="center">
  <img width="33%" src="https://github.com/user-attachments/assets/359a1d49-ae20-450f-9dc0-3f4abb681e4e" />
  &nbsp;&nbsp;&nbsp;
  <img width="33%" src="https://github.com/user-attachments/assets/9539e811-abb8-4b64-9c1a-acf08fac3b70" />
</div>

---

## Características
- Catálogo de personajes con imágenes
- Búsqueda en tiempo real
- Detalle de personaje
- Navegación con Compose
- Manejo de estados (loading, success, error)

## Tecnologías
- Kotlin
- Jetpack Compose
- Retrofit + Gson
- Picasso
- StateFlow
- MVVM + Repository Pattern

## Estructura
- `ui`: pantallas y componentes
- `viewmodel`: lógica de UI
- `repository`: acceso a datos
- `network`: configuración API
- `model`: data classes

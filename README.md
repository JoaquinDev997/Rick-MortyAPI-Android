# Rick & Morty - Android App

Aplicación móvil desarrollada en Kotlin que consume la API oficial de Rick and Morty para ofrecer un catálogo interactivo de los personajes de la serie.

## Características Principales
- **Catálogo Completo:** Visualización de personajes con imágenes y datos de estado.
- **Búsqueda en Tiempo Real:** Barra de búsqueda integrada que filtra personajes directamente desde la API mientras escribes.
- **Detalle del Personaje:** Vista expandida para cada personaje con información detallada (Género, Especie, Estado) y soporte para scroll vertical en modo horizontal.
- **Arquitectura Robusta:** Implementación de patrón MVVM (Model-View-ViewModel) para una separación clara de responsabilidades.
- **Navegación Fluida:** Sistema de navegación moderno mediante Compose Navigation.

## Tecnologías y Librerías
- **UI:** Jetpack Compose (Interfaz declarativa y moderna).
- **Red:** Retrofit + Gson (Gestión de peticiones API REST).
- **Imágenes:** Picasso (Carga inteligente y eficiente de imágenes).
- **Estado:** StateFlow (Manejo reactivo de estados de carga, éxito y error).
- **Arquitectura:** MVVM + Repository Pattern.

## Estructura del Proyecto
- `ui`: Contiene las pantallas (Screens) y componentes visuales.
- `viewmodel`: Gestiona la lógica de presentación y los estados de la UI.
- `repository`: Capa intermedia que abstrae el origen de los datos.
- `network`: Configuración del cliente Retrofit y servicios de API.
- `model`: Clases de datos que representan los objetos de la serie.

# Navigation Componente

El componente Navigation sirve para gestionar la navegación entre fragments en una arquitectura *
*Single Activity**.

Cada actividad que tenga el proyecto deberá tener un **grafo de navegación**. Un grafo de navegación es
el diagrama de las pantallas orígenes y las pantallas destinos de cada uno de los fragmentos.

## Añadir librería

### Paso 1

Para usar el componente hay que añadir las siguientes librerías al build.gradle a nivel de proyecto.
**Cuidado** que no estamos haciendo referencia al gradle a nivel de app (módulo) sino al de nivel de
proyecto.

```
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}
```

**Nota:** La librería que hay que añadir es la última.

Ahora, hay que añadir las siguientes librerías en build.gradle a nivel de app (módulo)

```
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}
```

**Nota**: hay que añadir la última línea, este bloque se encuentra al inicio del fichero
build.gradle.kts

Por último, añadimos las dependencias:

```
dependencies {
    ...
    //Navigation Component
    val nav_version = "2.7.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
}
```

### Paso 2

Una vez añadida las librerías, vamos a crear el grafo de navegación. Para ello hacemos:
- Botón derecho sobre la carpeta res/
- Seleccionamos la opción **Android Resource File**.
- Ponemos como nombre nav_graph.
- En ``type resources`` seleccionamos **navigation**.
- En ``directory name`` seleccionamos **navigation**.

Ahora en la carpeta res, tenemos una carpeta navigation con un fichero llamado nav_graph.xml
# Navigation Componente

El componente Navigation sirve para gestionar la navegación entre fragments en una arquitectura *
*Single Activity**.

Cada actividad que tenga el proyecto deberá tener un **grafo de navegación**. Un grafo de navegación
es
el diagrama de las pantallas orígenes y las pantallas destinos de cada uno de los fragmentos.

## Añadir librería

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

## Grafo de Navegacion

Una vez añadida las librerías, vamos a crear el grafo de navegación. Para ello hacemos:

- Botón derecho sobre la carpeta res/
- Seleccionamos la opción **Android Resource File**.
- Ponemos como nombre nav_graph.
- En ``type resources`` seleccionamos **navigation**.
- En ``directory name`` seleccionamos **navigation**.

Ahora en la carpeta res, tenemos una carpeta navigation con un fichero llamado nav_graph.xml

```
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_graph">


</navigation>
```

**Nota**: Hay que añadirle un id como se puede ver en el código.

## Añadir Destinos

En este fichero ``nav_graph.xml`` hay que añadir los fragments a los que deseamos navegar. Estos
fragmentos son destinos que podemos cargar.

```
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_graph">

    <fragment
        android:id="@+id/fragment_list"
        android:name="com.iesam.utnavigation.features.list.presentation.SubjectListFragment"
        tools:layout="@layout/fragment_subject_list">

    </fragment>

    <fragment
        android:id="@+id/fragment_detail"
        android:name="com.iesam.utnavigation.features.detail.presentation.SubjectDetailFragment"
        tools:layout="@layout/fragment_subject_detail">

    </fragment>

</navigation>
```

En cada uno de los fragmentos añadiremos:

- **id**: Un ID único, puede llamarse igual que el fragmento.
- **name**: ruta del fragmento.
- **layout**: la vista asignada al fragmento.

Ahora, debemos escoger qué fragmento será el que se cargue cuando se inicie la actividad, para ello
usaremos el atributo: **app:startDestination** y pondremos el id del fragmento que queramos que se
cargue al inicio.

```
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_graph"
    app:startDestination="@id/fragment_list">
    
    <fragment
        android:id="@+id/fragment_list"
        android:name="com.iesam.utnavigation.features.list.presentation.SubjectListFragment"
        tools:layout="@layout/fragment_subject_list">

    </fragment>
    
</navigation>  
```

## Navegar de un fragment a otro fragment

Para poder navegar de un fragmento a otro hay que crear acciones. Estas acciones se definen en el
fragmento origen.

```
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_graph"
    app:startDestination="@id/fragment_list">

    <fragment
        android:id="@+id/fragment_list"
        android:name="com.iesam.utnavigation.features.list.presentation.SubjectListFragment"
        android:label="@string/fragment_list_title"
        tools:layout="@layout/fragment_subject_list">

        <action
            android:id="@+id/action_from_fragment_list_to_fragment_detail"
            app:destination="@id/fragment_detail" />

    </fragment>

    <fragment
        android:id="@+id/fragment_detail"
        android:name="com.iesam.utnavigation.features.detail.presentation.SubjectDetailFragment"
        tools:layout="@layout/fragment_subject_detail">

    </fragment>

</navigation>
```

En el ejemplo se ha definido una acción en el fragmento origen: ``fragment_list`` para poder navegar
al fragment destino: ``fragment_detail``.

Esta acción debe tener (al menos):

- id: identificador de la acción. El formato que seguiremos es: action_from_xxxxxx_to_yyyyyy donde x
  es el id del fragmento origen e yyyyyy es el id del fragmento destino.
- destination: id del fragmento destino.

Nota: Si queremos añadir animaciones en la navegación de los fragmentos se añadirían aquí:

```
<action
    android:id="@+id/action_from_fragment_list_to_fragment_detail"
    app:destination="@id/fragment_detail"
    app:enterAnim="@anim/slide_in_right"
    app:exitAnim="@anim/slide_out_left" />
```

**Nota**: los ficheros ```@anim/slide_in_right``` y ```@anim/slide_out_left``` son ficheros externos
que deben ser añadidos por el programador. Se puede meter cualquier tipo de animación.

## Asignar el grafo a la vista de la Activity

Una vez tenemos el grafo desarrollado, tenemos que asignar el grafo creado a la actividad. Recuerda
que cada activity debe tener un grafo. Esto lo asignaremos en el layout del activity, en el
componente **FragmentContainerView**. Ejemplo:

Fichero: ``activity_main.xml``

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  tools:context=".MainActivity">

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragment_container"
        
        android:name="androidx.navigation.fragment.NavHostFragment"
        app:defaultNavHost="true"
        app:navGraph="@navigation/nav_graph"
        
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
         />

</androidx.constraintlayout.widget.ConstraintLayout>
```

En el **FragmentContainerView** se añade:

- android:name="androidx.navigation.fragment.NavHostFragment"
- app:navGraph="@navigation/nav_graph" (se asigna el grafo creado)
- app:defaultNavHost="true" (puede tener más de un grafo, así que uno de ellos debe ser el de por
  defecto).

## Navegación entre fragmentos

Para navegar de un fragmento a otro, usaremos el siguiente código:

**En un Fragment:**

```
findNavController().navigate(
    SubjectListFragmentDirections.actionFromFragmentListToFragmentDetail()
)
```

- **findNavController()**: hay que acceder al NavController para realizar la navegación. En un
  Fragment
  se accede con findNavController().
- **navigate()**: es el método que me permite establecer el destino.
- **SubjectListFragmentDirections**: Esta clase la crea Android. Se forma con: *
  *NombreDelFragmentoDirections**.
- **actionFromFragmentListToFragmentDetail**: Este método es un action creado por nosotros. Es el
  nombre
  del ID con CamelCase. action_from_fragment_list_to_fragment_detail ->
  actionFromFragmentListToFragmentDetail.

Un ejemplo asignado a un botón:

```
button.setOnClickListener{
    findNavController().navigate(
        SubjectListFragmentDirections.actionFromFragmentListToFragmentDetail()
    )
}
```

Para navegar a la **pantalla anterior** debemos usar:

```
findNavController().navigateUp()
```

Es el método que llamamos cuando pulsamos el botón atrás en una Toolbar:

```
detailToolbar.setNavigationOnClickListener {
    findNavController().navigateUp()
}
```

## Parámetros en la navegación

Para pasar parámetros de un fragment a otro usaremos el componente navigation con safe args, es
decir, con argumentos seguros.


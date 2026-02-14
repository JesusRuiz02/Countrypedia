package com.jesusruiz.countrypedia.views.curriculum.jobExperience

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExperienceView(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text("Experiencia relevante",
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
            style = MaterialTheme.typography.titleMedium)
        val megacableExperience: List<String> = listOf(
            "Desarrollé una herramienta en Python que automatiza la extracción y procesamiento de reportes de performance, con Pandas reduciendo el tiempo de análisis manual en un 300%",
            "Gestión de Infraestructura :Administración de equipos de video y monitoreo de infraestructura crítica para el servicio xView",
            "Gestión de CDN: Supervisión y optimización de flujos de contenido en la CDN de xV iew, asegurando la disponibilidad del servicio para usuarios a gran escala."
        )
        val smartWashExperience: List<String> = listOf(
            "Desarrollé una aplicación completa para gestionar horarios de lavandería en edificios residenciales. cree un schedule procedural con un layout desde cero",
            "Implementé autenticación, sistema de reservas con validación de solapamientos, panel administrativo y automatizaciones mediante Cloud Functions(reinicio semanal, actualización de estatus por hora) y Firebase Login",
            "Arquitectura MVVM con Hilt, Jetpack Compose y Firestore."
        )
        val noteAppExperience: List<String> = listOf(
            "Desarrollé una aplicación de notas con persistencia local usando Room(SQLite) y arquitectura MVVM",
            "Permite crear, editar y eliminar notas - contactos con una interfaz moderna en Jetpack Compose",
        )
        val gameAppExperience: List<String> = listOf(
            "Implementé SDK google play services",
            "Desarrollo y programación de Gameplay en Unity",
            "Encargado de la publicación del juego en la Playstore"
        )

        ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = "Ing de video e Investigación JR. Megacable ",
            date = "may 2025 - actual", jobDescription = megacableExperience )
        ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = "Laundry Schedule Manager",
            date = "nov 2025 - en 2026", jobDescription = smartWashExperience )
        ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = "Jetpack Compose App Note",
            date = "sept 2025 - oct 2026", jobDescription = noteAppExperience )
        ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = "Gun&Run juego HiperCasual - Publicado en PlayStore",
            date = "", jobDescription = gameAppExperience )
    }
}
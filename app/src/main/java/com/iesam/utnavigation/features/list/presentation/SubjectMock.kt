package com.iesam.utnavigation.features.list.presentation

import com.iesam.utnavigation.features.list.domain.Subject

class SubjectMock {

    companion object {
        fun getMocks(): List<Subject> = arrayListOf(
            Subject(
                "0373",
                "Lenguajes de marcas y sistemas de gestión de información",
                "Desarrollo con Html",
                "https://dam.sitehub.es/api-curso/subjects/subject_lm.jpeg"
            ),
            Subject(
                "0483",
                "Sistemas Informáticos",
                "Montaje de Ordenadores",
                "https://dam.sitehub.es/api-curso/subjects/subject_si.jpeg"
            ),
            Subject(
                "0484",
                "Bases de Datos",
                "Almacenamiento estructurado de datos",
                "https://dam.sitehub.es/api-curso/subjects/subject_db.jpeg"
            ),
            Subject(
                "0485",
                "Programación",
                "Creación de aplicaciones",
                "https://dam.sitehub.es/api-curso/subjects/subject_p.jpeg"
            ),
            Subject(
                "0487",
                "Entornos de Desarrollo",
                "Diseño de programas",
                "https://dam.sitehub.es/api-curso/subjects/subject_ed.jpeg"
            ),
            Subject(
                "0493",
                "Formación y Orientación Laboral",
                "Formación para el mundo laboral",
                "https://dam.sitehub.es/api-curso/subjects/subject_fol.jpeg"
            ),
            Subject(
                "0486",
                "Acceso a Datos",
                "Gestión de la información en dispositivos Android",
                "https://dam.sitehub.es/api-curso/subjects/subject_aad.jpeg"
            ),
            Subject(
                "0488",
                "Desarrollo de Interfaces",
                "Diseño de UI",
                "https://dam.sitehub.es/api-curso/subjects/subject_ui.jpeg"
            ),
            Subject(
                "0489",
                "Programación Multimedia y Dispositivos Móviles",
                "Desarrollo de aplicaciones para dispositivos móviles Android",
                "https://dam.sitehub.es/api-curso/subjects/subject_pmdm.jpeg"
            ),
            Subject(
                "0490",
                "Programación de Servicios y Procesos",
                "Procesos y servicios en aplicaciones para dispositivos Android",
                "https://dam.sitehub.es/api-curso/subjects/subject_psp.jpeg"
            ),
            Subject(
                "0491",
                "Sistema de Gestión Empresarial",
                "CRM, ERP, empresariales",
                "https://dam.sitehub.es/api-curso/subjects/subject_erp.jpeg"
            ),
            Subject(
                "0494",
                "Empresa e iniciativa innovadora",
                "Formación para el autoempleo.",
                "https://dam.sitehub.es/api-curso/subjects/subject_eei.jpeg"
            ),
        )
    }
}
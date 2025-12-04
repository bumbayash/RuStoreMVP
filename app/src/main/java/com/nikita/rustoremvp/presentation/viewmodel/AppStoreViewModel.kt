package com.nikita.rustoremvp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.nikita.rustoremvp.R
import com.nikita.rustoremvp.data.models.App
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppStoreViewModel : ViewModel() {

    private val _apps = MutableStateFlow<List<App>>(listOf(
        // 1. СберБанк Онлайн
        App(
            id = "1",
            name = "СберБанк Онлайн",
            developer = "Сбербанк России",
            icon = R.drawable.ic_sber,  // временная иконка
            category = "Финансы",
            ageRating = "6+",
            shortDescription = "Мобильный банк для всех финансовых операций",
            fullDescription = "Удобное приложение для управления счетами, картами, вкладами и кредитами. Возможность быстрых переводов, оплаты услуг и отслеживания финансов.",
            screenshots = listOf(
                R.drawable.ic_sber,
                R.drawable.ic_sber
            )
        ),

        // 2. Госуслуги
        App(
            id = "2",
            name = "Госуслуги",
            developer = "Минцифры России",
            icon = R.drawable.ic_gosuslugi,  // временная иконка
            category = "Государственные",
            ageRating = "0+",
            shortDescription = "Государственные услуги в вашем телефоне",
            fullDescription = "Официальное приложение портала государственных услуг. Подача заявлений на документы, запись к врачу, оплата штрафов и налогов.",
            screenshots = listOf(
                R.drawable.ic_gosuslugi,
                R.drawable.ic_gosuslugi
            )
        ),

        // 3. Яндекс Метро (новое приложение)
        App(
            id = "3",
            name = "Яндекс Метро",
            developer = "Яндекс",
            icon = R.drawable.ic_yandex_metro,  // временная иконка
            category = "Транспорт",
            ageRating = "0+",
            shortDescription = "Карта метро и расчет маршрутов",
            fullDescription = "Интерактивная карта метро с актуальной информацией о станциях и переходах. Расчет оптимального маршрута и времени в пути.",
            screenshots = listOf(
                R.drawable.ic_yandex_metro,
                R.drawable.ic_yandex_metro,
                R.drawable.ic_yandex_metro
            )
        )
    ))

    val apps: StateFlow<List<App>> = _apps.asStateFlow()
}
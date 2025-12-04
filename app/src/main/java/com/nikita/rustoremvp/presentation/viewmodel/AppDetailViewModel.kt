package com.nikita.rustoremvp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.SavedStateHandle
import com.nikita.rustoremvp.R
import com.nikita.rustoremvp.data.models.App
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val appId: String = savedStateHandle["appId"] ?: ""

    private val _app = MutableStateFlow<App?>(null)
    val app: StateFlow<App?> = _app.asStateFlow()

    init {
        loadApp()
    }

    private fun loadApp() {
        viewModelScope.launch {
            // Временные данные для каждого приложения
            _app.value = when (appId) {
                "1" -> App(
                    id = "1",
                    name = "СберБанк Онлайн",
                    developer = "Сбербанк России",
                    icon = R.drawable.ic_sber,
                    category = "Финансы",
                    ageRating = "6+",
                    shortDescription = "Мобильный банк для всех финансовых операций",
                    fullDescription = "Удобное приложение для управления счетами, картами, вкладами и кредитами. Возможность быстрых переводов, оплаты услуг и отслеживания финансов. Безопасность на высшем уровне с технологией SecureCode.",
                    screenshots = listOf(
                        R.drawable.ic_sber,
                        R.drawable.ic_sber,
                        R.drawable.ic_sber
                    )
                )
                "2" -> App(
                    id = "2",
                    name = "Госуслуги",
                    developer = "Минцифры России",
                    icon = R.drawable.ic_gosuslugi,
                    category = "Государственные",
                    ageRating = "0+",
                    shortDescription = "Государственные услуги в вашем телефоне",
                    fullDescription = "Официальное приложение портала государственных услуг. Подача заявлений на паспорт, водительские права, регистрацию. Запись к врачу, оплата штрафов ГИБДД, налогов и пошлин.",
                    screenshots = listOf(
                        R.drawable.ic_gosuslugi,
                        R.drawable.ic_gosuslugi
                    )
                )
                "3" -> App(
                    id = "3",
                    name = "Яндекс Метро",
                    developer = "Яндекс",
                    icon = R.drawable.ic_yandex_metro,
                    category = "Транспорт",
                    ageRating = "0+",
                    shortDescription = "Карта метро и расчет маршрутов",
                    fullDescription = "Интерактивная карта метро с актуальной информацией о станциях и переходах. Расчет оптимального маршрута и времени в пути. Работает офлайн после загрузки карты.",
                    screenshots = listOf(
                        R.drawable.ic_yandex_metro,
                        R.drawable.ic_yandex_metro,
                        R.drawable.ic_yandex_metro,
                        R.drawable.ic_yandex_metro
                    )
                )
                else -> null
            }
        }
    }
}
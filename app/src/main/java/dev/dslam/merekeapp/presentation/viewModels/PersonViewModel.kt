package dev.dslam.merekeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.models.Person

class PersonViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _state = MutableLiveData<PersonState>()
    val state: LiveData<PersonState> get() = _state

    fun dispatch(personAction: PersonAction) {
        when (personAction) {
            is PersonAction.SavePerson -> savePerson(person = personAction.person)
        }
    }

    private fun savePerson(person: Person) {
        appRepository.savePerson(person)
        _state.value = PersonState.PersonSaved
    }
}

sealed class PersonAction {
    data class SavePerson(val person: Person) : PersonAction()
}

sealed class PersonState {
    object PersonSaved: PersonState()
}
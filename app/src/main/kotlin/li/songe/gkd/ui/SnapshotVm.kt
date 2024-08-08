package li.songe.gkd.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import li.songe.gkd.db.DbSet
import li.songe.gkd.ui.component.UploadOptions
import li.songe.gkd.util.IMPORT_BASE_URL
import javax.inject.Inject


@HiltViewModel
class SnapshotVm @Inject constructor() : ViewModel() {
    val snapshotsState = DbSet.snapshotDao.query()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val uploadOptions = UploadOptions(
        scope = viewModelScope,
        showHref = { IMPORT_BASE_URL + it.id }
    )
}
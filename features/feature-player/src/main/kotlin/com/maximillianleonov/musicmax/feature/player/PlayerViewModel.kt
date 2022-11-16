/*
 * Copyright 2022 Maximillian Leonov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maximillianleonov.musicmax.feature.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximillianleonov.musicmax.core.media.common.MediaConstants.DEFAULT_POSITION_MS
import com.maximillianleonov.musicmax.core.media.service.MusicServiceConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val musicServiceConnection: MusicServiceConnection
) : ViewModel() {
    val musicState = musicServiceConnection.musicState
    val timePassed = musicServiceConnection.timePassed.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = DEFAULT_POSITION_MS
    )

    fun skipPrevious() = musicServiceConnection.skipPrevious()
    fun play() = musicServiceConnection.play()
    fun pause() = musicServiceConnection.pause()
    fun skipNext() = musicServiceConnection.skipNext()
}

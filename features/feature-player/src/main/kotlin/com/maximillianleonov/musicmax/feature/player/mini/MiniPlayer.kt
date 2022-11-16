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

package com.maximillianleonov.musicmax.feature.player.mini

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maximillianleonov.musicmax.core.designsystem.theme.spacing
import com.maximillianleonov.musicmax.core.media.service.common.MusicState
import com.maximillianleonov.musicmax.feature.player.PlayerViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MiniPlayer(
    modifier: Modifier = Modifier,
    viewModel: PlayerViewModel = hiltViewModel()
) {
    val musicState by viewModel.musicState.collectAsStateWithLifecycle()
    val timePassed by viewModel.timePassed.collectAsStateWithLifecycle()

    MiniPlayer(
        modifier = modifier,
        musicState = musicState,
        timePassed = timePassed,
        onMediaButtonSkipPreviousClick = viewModel::skipPrevious,
        onMediaButtonPlayClick = viewModel::play,
        onMediaButtonPauseClick = viewModel::pause,
        onMediaButtonSkipNextClick = viewModel::skipNext,
    )
}

@Composable
private fun MiniPlayer(
    musicState: MusicState,
    timePassed: Long,
    onMediaButtonSkipPreviousClick: () -> Unit,
    onMediaButtonPlayClick: () -> Unit,
    onMediaButtonPauseClick: () -> Unit,
    onMediaButtonSkipNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.extraSmall)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
            ) {
                MiniPlayerArtworkImage(
                    artworkUri = musicState.currentSong.artworkUri,
                    contentDescription = musicState.currentSong.title
                )
                MiniPlayerTitleArtist(
                    title = musicState.currentSong.title,
                    artist = musicState.currentSong.artist
                )
            }
            MiniPlayerMediaButtons(
                playWhenReady = musicState.playWhenReady,
                onSkipPreviousClick = onMediaButtonSkipPreviousClick,
                onPlayClick = onMediaButtonPlayClick,
                onPauseClick = onMediaButtonPauseClick,
                onSkipNextClick = onMediaButtonSkipNextClick
            )
        }
        MiniPlayerTimeProgress(
            playbackState = musicState.playbackState,
            timePassed = timePassed,
            duration = musicState.duration
        )
    }
}

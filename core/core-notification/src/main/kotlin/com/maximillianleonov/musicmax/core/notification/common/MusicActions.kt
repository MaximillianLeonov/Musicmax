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

package com.maximillianleonov.musicmax.core.notification.common

import android.content.Context
import androidx.media3.common.Player
import androidx.media3.session.CommandButton
import androidx.media3.session.MediaNotification
import androidx.media3.session.MediaSession
import com.google.common.collect.ImmutableList
import com.maximillianleonov.musicmax.core.notification.util.asNotificationAction
import com.maximillianleonov.musicmax.core.media.common.R as mediaCommonR

internal object MusicActions {
    internal fun getRepeatShuffleAction(
        mediaSession: MediaSession,
        customLayout: ImmutableList<CommandButton>,
        actionFactory: MediaNotification.ActionFactory
    ) = actionFactory.createCustomActionFromCustomCommandButton(mediaSession, customLayout.first())

    internal fun getSkipPreviousAction(
        context: Context,
        mediaSession: MediaSession,
        actionFactory: MediaNotification.ActionFactory
    ) = MusicAction(
        iconResource = mediaCommonR.drawable.ic_skip_previous,
        titleResource = mediaCommonR.string.skip_previous,
        command = Player.COMMAND_SEEK_TO_PREVIOUS
    ).asNotificationAction(context, mediaSession, actionFactory)

    internal fun getPlayPauseAction(
        context: Context,
        mediaSession: MediaSession,
        actionFactory: MediaNotification.ActionFactory,
        playWhenReady: Boolean
    ) = MusicAction(
        iconResource = if (playWhenReady) mediaCommonR.drawable.ic_pause else mediaCommonR.drawable.ic_play,
        titleResource = if (playWhenReady) mediaCommonR.string.pause else mediaCommonR.string.play,
        command = Player.COMMAND_PLAY_PAUSE
    ).asNotificationAction(context, mediaSession, actionFactory)

    internal fun getSkipNextAction(
        context: Context,
        mediaSession: MediaSession,
        actionFactory: MediaNotification.ActionFactory
    ) = MusicAction(
        iconResource = mediaCommonR.drawable.ic_skip_next,
        titleResource = mediaCommonR.string.skip_next,
        command = Player.COMMAND_SEEK_TO_NEXT
    ).asNotificationAction(context, mediaSession, actionFactory)
}

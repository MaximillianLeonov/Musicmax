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

package com.maximillianleonov.musicmax.core.data.repository

import com.maximillianleonov.musicmax.core.data.util.Constants
import com.maximillianleonov.musicmax.core.data.util.MusicmaxVersionProvider
import com.maximillianleonov.musicmax.core.datastore.PreferencesDataStoreDataSource
import com.maximillianleonov.musicmax.core.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val preferencesDataStoreDataSource: PreferencesDataStoreDataSource,
    versionProvider: MusicmaxVersionProvider
) : SettingsRepository {
    override val repoUrl = Constants.Urls.MUSICMAX_REPO_URL
    override val privacyPolicyUrl = Constants.Urls.PRIVACY_POLICY_URL
    override val version = versionProvider.version

    override fun getPlayingQueueIndex(): Flow<Int> =
        preferencesDataStoreDataSource.getPlayingQueueIndex()

    override suspend fun setPlayingQueueIndex(index: Int) {
        preferencesDataStoreDataSource.setPlayingQueueIndex(index)
    }
}

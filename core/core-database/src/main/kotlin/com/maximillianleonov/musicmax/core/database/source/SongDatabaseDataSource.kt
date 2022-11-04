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

package com.maximillianleonov.musicmax.core.database.source

import com.maximillianleonov.musicmax.core.database.dao.SongDao
import com.maximillianleonov.musicmax.core.database.model.SongEntity
import javax.inject.Inject

class SongDatabaseDataSource @Inject constructor(private val songDao: SongDao) {
    fun getAll() = songDao.getAll()
    suspend fun insertAll(songs: List<SongEntity>) = songDao.insertAll(songs)
    suspend fun deleteAll() = songDao.deleteAll()
    suspend fun deleteAndInsertAll(songs: List<SongEntity>) = songDao.deleteAndInsertAll(songs)
}

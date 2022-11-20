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

package com.maximillianleonov.musicmax.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maximillianleonov.musicmax.core.database.util.Constants

@Entity(tableName = Constants.Tables.SONGS)
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.Fields.ID)
    val id: Int = 0,

    @ColumnInfo(name = Constants.Fields.MEDIA_ID)
    val mediaId: String,

    @ColumnInfo(name = Constants.Fields.ARTIST_ID)
    val artistId: Long,

    @ColumnInfo(name = Constants.Fields.ALBUM_ID)
    val albumId: Long,

    @ColumnInfo(name = Constants.Fields.MEDIA_URI)
    val mediaUri: String,

    @ColumnInfo(name = Constants.Fields.ARTWORK_URI)
    val artworkUri: String,

    @ColumnInfo(name = Constants.Fields.TITLE)
    val title: String,

    @ColumnInfo(name = Constants.Fields.ARTIST)
    val artist: String
)

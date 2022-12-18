package kz.temir.sometestproject.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<TaskDbo>>

    @Insert
    fun insert(taskDbo: TaskDbo)

    @Delete
    fun delete(taskDbo: TaskDbo)
}

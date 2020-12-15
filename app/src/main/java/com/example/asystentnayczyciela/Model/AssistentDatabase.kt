package com.example.asystentnayczyciela.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class, Teacher::class, Course::class, Participant::class, Grade::class], version = 5, exportSchema = false)
abstract class AssistentDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun teacherDao(): TeacherDao
    abstract fun courseDao(): CourseDao
    abstract fun participantDao(): ParticipantDao
    abstract fun gradeDao(): GradeDao

    companion object{
        @Volatile
        private var INSTANCE: AssistentDatabase? = null

        fun getDatabase(context: Context):AssistentDatabase{
            val tempInstance = INSTANCE

            if(tempInstance != null)
            {
                return tempInstance
            }
            else
            {
                synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AssistentDatabase::class.java,
                        "myDatabase"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }

}
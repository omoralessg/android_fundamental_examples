package com.example.androidfundamental.viewmodelexample
import java.util.*

class Task(
    val id: Long,
    var summary: String,
    var description: String,
    var done: Boolean
) {
    class TaskBuilder {
        private var id: Long = 0
        private var summary = ""
        private var description = ""
        private var done = false
        private var dueDate: Date? = null
        fun setId(id: Long): TaskBuilder {
            this.id = id
            return this
        }

        fun setSummary(summary: String): TaskBuilder {
            this.summary = summary
            return this
        }

        fun setDescription(description: String): TaskBuilder {
            this.description = description
            return this
        }

        fun setDone(done: Boolean): TaskBuilder {
            this.done = done
            return this
        }

        fun setDueDate(dueDate: Date): TaskBuilder {
            this.dueDate = Date(dueDate.time)
            return this
        }

        fun build(): Task {
            return Task(id, summary, description, done)
        }
    }

    override fun toString(): String {
        return "Task{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}'
    }

    companion object {
        fun builder(): TaskBuilder {
            return TaskBuilder()
        }
    }
}
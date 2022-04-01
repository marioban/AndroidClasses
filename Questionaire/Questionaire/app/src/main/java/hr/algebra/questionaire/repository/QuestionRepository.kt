package hr.algebra.questionaire.repository

import hr.algebra.questionaire.model.Question

object QuestionRepository {

    private val questions= listOf(
         Question("Capital of Croatia?","Zagreb"),
         Question("Capital of Srbia?","Beograd"),
         Question("Capital of BiH?","Sarajevo")
    )

    operator fun get(index:Int)
        = if (index in questions.indices) questions[index] else null

}
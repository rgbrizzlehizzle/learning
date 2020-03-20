"userId" to "1234"

class Person(val firstName: String, val lastName: String) {
  private val interests: MutableList<String> = mutableListOf()

  infix fun addInterest(interest: String) = interests.add(interest)

  fun printName() = println("$firstName $lastName")
}

fun main(args: Array<String>) {
  val nate = Person("Nate", "Ebel")
  nate addInterest "Kotlin"
}


